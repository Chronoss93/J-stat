package com.diplom.web.controller;

import com.diplom.home.Hero;
import com.diplom.home.MyDro;
import com.diplom.repository.TableRepository;
import com.diplom.service.CsvDataHandler;
import com.diplom.service.StatDataService;
import com.diplom.service.dto.OneTableDto;
import com.diplom.web.controller.dto.StatDto;
import com.diplom.web.controller.dto.TableArrayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class SampleController {
    @Autowired
    CsvDataHandler csvDataHandler;
    @Autowired
    StatDataService statDataService;
    @Autowired
    TableRepository tableRepository;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/table")
    @ResponseBody
    @CrossOrigin
    StatDto getTable(@RequestParam("id") String tableId) {
        return new StatDto(statDataService.getStatForTable(tableId));
    }

    @RequestMapping("/tables")
    @ResponseBody
    @CrossOrigin
    TableArrayDto getTables() {
        return new TableArrayDto(new OneTableDto[]{
                statDataService.getStatForTable("table_1"),
                statDataService.getStatForTable("TABLE_2")
        });
    }

    @RequestMapping("/heroes")
    @ResponseBody
    @CrossOrigin
    MyDro heroes() {
        return new MyDro(new Hero[]{new Hero(1, "Igor"), new Hero(2, "Slava")});
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    String handleFileUpload(@RequestParam("file") MultipartFile file/*, HttpSession session*/) {
        try {
            String text = org.apache.commons.io.IOUtils.toString(file.getInputStream());
            System.out.println(text);
            csvDataHandler.handleMessage(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Success";
    }

}