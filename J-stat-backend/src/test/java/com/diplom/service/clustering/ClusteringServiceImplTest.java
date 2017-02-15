package com.diplom.service.clustering;

import com.diplom.JStatBackendApplication;
import com.diplom.domain.KYF;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor_Kravchenko on 2/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JStatBackendApplication.class)
@SpringBootTest
public class ClusteringServiceImplTest {

    @Autowired
    private ClusteringServiceImpl clusteringService;

    @Test
    public void shouldCluster() throws Exception {
        List<List<KYF>> kyfMatrix = generateKyfMatrix();

        List<? extends Cluster<ClusterableRow>> clusterResults;

        System.out.println("Start Multi KMeans");
        clusterResults = clusteringService.doClustering(kyfMatrix, "MultiKMeans", "EuclideanDistance");
        printClusteringResult(clusterResults);

        System.out.println("Start Simple");
        clusterResults = clusteringService.doClustering(kyfMatrix, "KMeans", "EuclideanDistance");
        printClusteringResult(clusterResults);
    }

    private void printClusteringResult(List<? extends Cluster<ClusterableRow>> clusterResults) {
        for (int i = 0; i < clusterResults.size(); i++) {
            System.out.println("Cluster " + i);
            for (ClusterableRow clusterableRow : clusterResults.get(i).getPoints())
                System.out.println(clusterableRow);
        }
    }

    public List<List<KYF>> generateKyfMatrix() {
        List<List<KYF>> result = new ArrayList<>();
        result.add(generateRow("10", "10", "10", "100"));
        result.add(generateRow("11", "11", "8", "100"));
        result.add(generateRow("10", "9", "10", "100"));
        result.add(generateRow("11", "8", "9", "101"));
        result.add(generateRow("150", "150", "150", "200"));
        result.add(generateRow("151", "151", "151", "100"));
        return result;
    }
//
//    private List<ClusterableRow> wrappedRowsList() {
//        List<ClusterableRow> result = new ArrayList<>();
//        result.add(generateWrappedRow("10","10","10","100"));
//        result.add(generateWrappedRow("11","11","8","100"));
//        result.add(generateWrappedRow("10","9","10","100"));
//        result.add(generateWrappedRow("11","8","9","101"));
//        result.add(generateWrappedRow("150","150","150","200"));
//        result.add(generateWrappedRow("151","151","151","100"));
//        return result;
//    }

//    private ClusterableRow generateWrappedRow(String ... values) {
//        List<KYF> row1 = generateRow(values);
//        return ClusterableRow.createWrappedRow(row1);
//    }

    private List<KYF> generateRow(String... values) {
        List<KYF> kyfs = new ArrayList<>();
        for (String value : values) {
            KYF kyf = new KYF();
            kyf.setValue(value);
            kyfs.add(kyf);
        }
        return kyfs;
    }

}