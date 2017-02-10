package com.diplom.service.clustering;

import com.diplom.domain.KYF;
import org.apache.commons.math3.ml.clustering.Clusterable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor_Kravchenko on 2/1/17.
 */
public class ClusterableRow implements Clusterable {

    private double[] points;
    private List<KYF> kyfList;

    private ClusterableRow(){
    }

    public static ClusterableRow createWrappedRow(List<KYF> kyfs){
        ClusterableRow clusterableRow = new ClusterableRow();
        double[] points = getCoordinates(kyfs);
        clusterableRow.setPoints(points);
        clusterableRow.setKyfList(kyfs);
        return clusterableRow;
    }
    private static double[] getCoordinates(List<KYF> kyfs) {
        return kyfs.stream().mapToDouble(kyf -> Double.parseDouble(kyf.getValue())).toArray();
    }

     @Override
    public double[] getPoint() {
        return points;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    public List<KYF> getKyfList() {
        return kyfList;
    }

    public void setKyfList(List<KYF> kyfList) {
        this.kyfList = kyfList;
    }

    @Override
    public String toString() {
        return "ClusterableRow{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
