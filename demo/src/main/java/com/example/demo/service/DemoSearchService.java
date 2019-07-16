package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.DemoUserDao;
import com.example.demo.entity.newtest.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoSearchService {
    @Autowired
    private DemoUserDao dao;


    public List<Order> getAll() {
        return dao.getAll();
    }

    public Order getSearch(Integer orderid) {
        return dao.getSearch(orderid);
    }
    public int insert(Order order) {
        return dao.insert(order);
    }
    public int update(Order order) {
        return dao.update(order);
    }
    public Page<Order> selectOrderPage(int page, int pageSize ) {
//        return dao.selectPageData(page);
        try {
            Page<Order> p = new Page<>(page, pageSize);
            p.setRecords(dao.selectPageData(p));
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
