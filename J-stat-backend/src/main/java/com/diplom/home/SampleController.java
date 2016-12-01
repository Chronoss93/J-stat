package com.diplom.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/getStat")
    @ResponseBody
    @CrossOrigin
    RealDTO getStat() {
        StatDTO statDTO = new StatDTO();
        statDTO.setKyf(new String[][]{
                {
                        "10", "20", "30", "40"
                },
                {
                        "10", "20", "30", "41"
                },
                {
                        "100", "200", "300", "410"
                },
                {
                        "101", "200", "300", "410"
                },
                {
                        "1000", "2000", "3000", "4100"
                },
        });
        statDTO.setRowHeaders(new String[]{"UK", "USA", "UKR", "POL", "IND"});
        statDTO.setColumnHeaders(new String[]{"co2", "gdp", "ppl", "army"});

        return new RealDTO(statDTO);
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
    String handleFileUpload(@RequestParam("file") MultipartFile file/*, HttpSession session*/){
//        if (file.isEmpty())
//            throw new UploadException("UP_01", "Failed to upload because the file is empty.");
        try {
            String text = org.apache.commons.io.IOUtils.toString(file.getInputStream());
            System.out.println(text);
//            StatisticViewDto dto = dataConverter.parseMessage(text);
//            session.setAttribute("statisticView", dto);
//            return new ModelAndView("data_overview").addObject("statisticView", dto);
        } catch (Exception e) {
//            throw new UploadException("UP_02", "Failed to process csv. Wrong format");
        }
        return "Success";
    }

}