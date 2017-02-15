package com.diplom.service.clustering;

import com.diplom.domain.KYF;
import org.apache.commons.math3.ml.clustering.Cluster;

import java.util.List;

/**
 * Created by Igor on 14.02.2017.
 */
public interface ClusteringService {
    List<? extends Cluster<ClusterableRow>> doClustering(List<List<KYF>> kyfMatrix,
                                                         String clusteringAlgorithmName,
                                                         String distanceMeasureAlgorithmName);
}
