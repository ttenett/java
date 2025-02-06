package com.kkpp_food.Congcong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/detail/{idx}")
    public String detail() {
        return "detail";
    }


    public String update() {
        return "update";
    }


}
