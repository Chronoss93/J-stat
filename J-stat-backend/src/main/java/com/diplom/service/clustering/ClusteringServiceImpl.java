package com.diplom.service.clustering;

import com.diplom.domain.KYF;
import org.apache.commons.math3.ml.clustering.*;
import org.apache.commons.math3.ml.clustering.evaluation.SumOfClusterVariances;
import org.apache.commons.math3.ml.distance.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Igor_Kravchenko on 2/1/17.
 */
@Service
public class ClusteringServiceImpl implements ClusteringService {

    private final Map<String, DistanceMeasure> distanceMeasureAlgorithms = new HashMap<String, DistanceMeasure>() {{
        put("EuclideanDistance", new EuclideanDistance());
        put("ChebyshevDistance", new ChebyshevDistance());
        put("CanberraDistance", new CanberraDistance());
        put("EarthMoversDistance", new EarthMoversDistance());
        put("ManhattanDistance", new ManhattanDistance());
    }};

    @Override
    public List<? extends Cluster<ClusterableRow>> doClustering(List<List<KYF>> kyfMatrix,
                                                                String clusteringAlgorithmName,
                                                                String distanceMeasureAlgorithmName) {

        List<ClusterableRow> clusterInput = wrapMatrixIntoClusterableRows(kyfMatrix);
        Clusterer<ClusterableRow> clusterer = getConfiguredClusteringAlgorithm(clusteringAlgorithmName, distanceMeasureAlgorithmName);
        return clusterer.cluster(clusterInput);
    }

    private List<ClusterableRow> wrapMatrixIntoClusterableRows(List<List<KYF>> kyfMatrix) {
        List<ClusterableRow> clusterInput = new ArrayList<>();
        for (List<KYF> kyfRow : kyfMatrix) {
            clusterInput.add(wrapKyfRow(kyfRow));
        }
        return clusterInput;
    }

    private ClusterableRow wrapKyfRow(List<KYF> kyfs) {
        return ClusterableRow.createWrappedRow(kyfs);

    }

    private Clusterer<ClusterableRow> getConfiguredClusteringAlgorithm(String clusteringAlgorithmName, String distanceMeasureAlgorithmName) {
        DistanceMeasure distanceMeasure = distanceMeasureAlgorithms.get(distanceMeasureAlgorithmName);
        return getClustererInstance(clusteringAlgorithmName, distanceMeasure);
    }

    //todo configure clustering parameters
    public Clusterer<ClusterableRow> getClustererInstance(String clusteringAlgorithmName, DistanceMeasure distanceMeasure) {
        switch (clusteringAlgorithmName) {
            case "KMeans":
                return new KMeansPlusPlusClusterer<>(3, 100000000, distanceMeasure);
            case "FuzzyKMeans":
                return new FuzzyKMeansClusterer<>(1, 1, 10000, distanceMeasure);
            case "MultiKMeans":
                return new MultiKMeansPlusPlusClusterer<>(
                        new KMeansPlusPlusClusterer<>(3, 10000, distanceMeasure),
                        10000000, new SumOfClusterVariances<>(distanceMeasure));
            case "DBSCAN":
                return new DBSCANClusterer<>(1, 10000, distanceMeasure);
            default:
                return new KMeansPlusPlusClusterer<>(1, 10000, distanceMeasure);
        }
    }
}
