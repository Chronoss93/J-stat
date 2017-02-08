package com.diplom.service.clustering;

import com.diplom.domain.KYF;
import com.diplom.domain.Row;
import org.apache.commons.math3.ml.clustering.Clusterable;

import java.util.List;

/**
 * Created by Igor_Kravchenko on 2/1/17.
 */
public class KyfRowWrapper implements Clusterable {

    private double[] points;
    private List<KYF> kyfList;

    private KyfRowWrapper(){
    }

    public static KyfRowWrapper createKyfRowWrapper(List<KYF> kyfs){
        KyfRowWrapper kyfRowWrapper = new KyfRowWrapper();
        double[] points = getCoordinates(kyfs);
        kyfRowWrapper.setPoints(points);
        kyfRowWrapper.setKyfList(kyfs);
        return kyfRowWrapper;
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
}
