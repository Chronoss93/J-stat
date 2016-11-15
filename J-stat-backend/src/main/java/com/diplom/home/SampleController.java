package com.diplom.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

        RealDTO realDto = new RealDTO();
        realDto.setStatDto(statDTO);
        return realDto;
    }

    @RequestMapping("/heroes")
    @ResponseBody
    @CrossOrigin
    MyDro heroes() {
        return new MyDro(new Hero[]{new Hero(1, "Igor"), new Hero(2, "Slava")});
    }

}