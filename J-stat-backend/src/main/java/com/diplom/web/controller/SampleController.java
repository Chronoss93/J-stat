package com.diplom.web.controller;

import com.diplom.repository.TableRepository;
import com.diplom.service.CsvDataHandler;
import com.diplom.service.StatDataService;
import com.diplom.service.dto.TableAsStringDto;
import com.diplom.web.controller.trash.Hero;
import com.diplom.web.controller.trash.MyDro;
import com.diplom.web.dto.OneTableWebDto;
import com.diplom.web.dto.TablesWebDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class SampleController {
    @Autowired
    private CsvDataHandler csvDataHandler;
    @Autowired
    private StatDataService statDataService;
    @Autowired
    private TableRepository tableRepository;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/table")
    @ResponseBody
    @CrossOrigin
    OneTableWebDto getTable(@RequestParam("id") String tableId) {
        TableAsStringDto tableAsStringDto = statDataService.getStatForTable(tableId);
        return new OneTableWebDto(tableAsStringDto);
    }

    @RequestMapping("/tables")
    @ResponseBody
    @CrossOrigin
    TablesWebDto getTables() {
        return new TablesWebDto(statDataService.getAllTables());
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