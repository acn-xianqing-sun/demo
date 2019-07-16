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

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DemoUpdateController {

    @Autowired
    private DemoSearchService searchService;

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String init(@ModelAttribute Order orderFrom,Model model, HttpServletRequest request){
        System.out.println("HelloController.update.init");
        String orderId = request.getParameter("orderId");
        Order ret = searchService.getSearch(Integer.parseInt(orderId));
        model.addAttribute("order", ret);
        return "demoUpdate";
    }
    @RequestMapping(value = "/updateData",method = RequestMethod.POST)
    public String update(@ModelAttribute Order orderFrom, Model model){
        System.out.println("HelloController.update.updateData");
        if (orderFrom.getOrderid()!=null){
            try{
                if (searchService.update(orderFrom)>0){
                    model.addAttribute("message","Update is successful!!!");
                }else{
                    model.addAttribute("message","Update is failure!!!");
                }}catch (Exception e){
                model.addAttribute("message","Update is failure!!!");
            }
        }else{
            model.addAttribute("message","Update is failure!!!");
        }
        return "demoUpdate";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}