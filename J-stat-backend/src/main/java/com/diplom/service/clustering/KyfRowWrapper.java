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

    public KyfRowWrapper(List<KYF> kyfs) {
        kyfList = kyfs;
        points = getOneRowOfKyf(kyfs);
    }

     @Override
    public double[] getPoint() {
        return points;
    }

    private double[] getOneRowOfKyf(List<KYF> kyfs) {
        return kyfs.stream().mapToDouble(kyf -> Double.parseDouble(kyf.getValue())).toArray();
    }
}
