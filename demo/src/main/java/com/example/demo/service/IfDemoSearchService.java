package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.newtest.Order;

import java.util.List;

public interface IfDemoSearchService {
    public List<Order> getAll();

    public Order getSearch(Integer orderid);

    public int insert(Order order);

    public int update(Order order);

    public Page<Order> selectOrderPage(int page, int pageSize);
}
