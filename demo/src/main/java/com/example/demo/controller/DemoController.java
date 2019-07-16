package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.newtest.Order;
import com.example.demo.form.OrderForm;
import com.example.demo.service.DemoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoSearchService searchService;

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Order> init() {
        return searchService.getAll();
    }

    @RequestMapping(value = "/searchPage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public IPage<Order> searchPage(@RequestBody OrderForm orderFrom) {
        System.out.println("HelloController.searchPage");
        List<Order> ret = null;
        int page = orderFrom.getPageNum();
        int pageSize = 3;
        return (IPage<Order>) searchService.selectOrderPage(page, pageSize);
    }


//    @RequestMapping("/init")
//    public String init(@ModelAttribute OrderForm orderFrom, Model model) {
//        System.out.println("HelloController.init");
//        //model.addAttribute("hello", "testtestest");
//        model.addAttribute("current", 1);
//        model.addAttribute("pages", 1);
//        model.addAttribute("hello", "123456789");
//        return "demoSearch";
//    }
//
//    @RequestMapping("/return")
//    public String returnBefore(Model model) {
//        System.out.println("HelloController.return");
//        model.addAttribute("current", 1);
//        model.addAttribute("pages", 1);
//        return "demoSearch";
//    }
//
//    @RequestMapping("/insert")
//    public String search(@ModelAttribute OrderForm orderFrom, Model model) {
//        System.out.println("HelloController.insert");
//        return "demoInsert";
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public String search3(@ModelAttribute OrderForm orderFrom, Model model) {
//        System.out.println("HelloController.search by button");
//        List<Order> ret = null;
//        if (orderFrom.getOrderid() != null) {
//            Order ord = searchService.getSearch(orderFrom.getOrderid());
//            if (ord != null && ord.getOrderid() != null) {
//                ret = new ArrayList();
//                ret.add(ord);
//            }
//        } else {
//            ret = searchService.getAll();
//        }
//        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
//        if (ret != null && ret.size() > 0) {
//            for (Order order : ret) {
//                Map<String, Object> student = new HashMap<String, Object>() {{
//                    put("orderId", order.getOrderid());
//                    put("clientId", order.getClientid());
//                    put("orderDate", order.getOrderdate());
//                    put("quantity", order.getQuantity());
//                    put("comment", order.getCommont());
//                }};
//                resultList.add(student);
//            }
//        }
//        model.addAttribute("current", 1);
//        model.addAttribute("pages", 5);
//        model.addAttribute("resultList", resultList);
//        return "demoSearch";
//    }
//
//    @RequestMapping(value = "/searchPage", method = RequestMethod.GET)
//    public String searchPage(@ModelAttribute OrderForm orderFrom, Model model, HttpServletRequest request) {
//        System.out.println("HelloController.searchPage");
//        List<Order> ret = null;
//        int page = 1;
//        String pageFrom = request.getParameter("page");
//        if (pageFrom != null) {
//            page = Integer.parseInt(pageFrom);
//        }
//        int pageSize = 3;
//        if (orderFrom.getOrderid() != null) {
//            Order ord = searchService.getSearch(orderFrom.getOrderid());
//            if (ord != null && ord.getOrderid() != null) {
//                ret = new ArrayList();
//                ret.add(ord);
//            }
//        } else {
//            IPage<Order> iPage = (IPage<Order>) searchService.selectOrderPage(page, pageSize);
//            model.addAttribute("resultList", iPage.getRecords());
//            List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
//            if (iPage.getRecords() != null && iPage.getRecords().size() > 0) {
//                for (Order order : iPage.getRecords()) {
//                    Map<String, Object> data = new HashMap<String, Object>() {{
//                        put("orderId", order.getOrderid());
//                        put("clientId", order.getClientid());
//                        put("orderDate", order.getOrderdate());
//                        put("quantity", order.getQuantity());
//                        put("comment", order.getCommont());
//                    }};
//                    resultList.add(data);
//                }
//            }
//            model.addAttribute("resultList", resultList);
//            model.addAttribute("current", page);
//            model.addAttribute("pages", 5);
//        }
//
//        return "demoSearch";
//    }
}