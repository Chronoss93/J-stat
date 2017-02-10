package com.diplom.service.clustering;

import com.diplom.domain.KYF;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor_Kravchenko on 2/1/17.
 */
@Service
public class ClusteringService {

    public List<CentroidCluster<ClusterableRow>> doClustering(List<List<KYF>> kyfMatrix) {
        List<ClusterableRow> clusterInput = new ArrayList<>();
        for (List<KYF> kyfRow : kyfMatrix) {
            clusterInput.add(wrapKyfs(kyfRow));
        }

        KMeansPlusPlusClusterer<ClusterableRow> clusterer = new KMeansPlusPlusClusterer<ClusterableRow>(2, 10000);
        List<CentroidCluster<ClusterableRow>> clusterResults = clusterer.cluster(clusterInput);
        return clusterResults;
    }

    private ClusterableRow wrapKyfs(List<KYF> kyfs) {
        return ClusterableRow.createWrappedRow(kyfs);

    }

}
