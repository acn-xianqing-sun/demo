package com.example.demo.controller;

import com.example.demo.entity.newtest.Order;
import com.example.demo.service.DemoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DemoInsertController {

    @Autowired
    private DemoSearchService searchService;

    @RequestMapping(value = "/insertData", method= RequestMethod.POST)
    public String insert(@ModelAttribute Order orderFrom, Model model){
        System.out.println("HelloController.insertData");
        if (orderFrom.getOrderid()!=null){
            try{

            if (searchService.insert(orderFrom)>0){
                model.addAttribute("message","Insert is successful!!!");
            }else{
                model.addAttribute("message","Insert is failure!!!");
            }}catch (Exception e){
                model.addAttribute("message","Insert is failure!!!");
            }
        }
        return "demoInsert";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}