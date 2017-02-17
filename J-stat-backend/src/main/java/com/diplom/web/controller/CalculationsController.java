package com.diplom.web.controller;

import com.diplom.repository.TableRepository;
import com.diplom.service.StatDataService;
import com.diplom.service.clustering.ClusteringService;
import com.diplom.service.dto.TableAsStringDto;
import com.diplom.web.dto.ClusteredTableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Igor_Kravchenko on 2/15/17.
 */
@Controller
public class CalculationsController {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private StatDataService statDataService;

    @Autowired
    private ClusteringService clusteringService;

    @RequestMapping("/table")
    @ResponseBody
    @CrossOrigin
    ClusteredTableDto doClustering(@RequestParam("id") String tableId,
                                   @RequestParam("clusteringAlgorithm") String clusteringAlgorithm,
                                   @RequestParam("distanceMeasure") String distanceMeasure) {
        TableAsStringDto statForTable = statDataService.getStatForTable(tableId);
        clusteringService.doClustering(statForTable.)
    }

}
