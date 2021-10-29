package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PDFView")
public class PDFViewer {

    @RequestMapping("/web/viewer")
    public String index(){
        return "PDFView/web/viewer";
    }
}
