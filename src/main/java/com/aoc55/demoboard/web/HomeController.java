package com.aoc55.demoboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller r
 * Created by aoc55.soft@gmail.com
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String goBoard(){
        return "redirect:board";
    }

}
