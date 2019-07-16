package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.newtest.Order;
import com.example.demo.mapper.newtest.OrderMapper;
import com.example.demo.mapper.newtest.OrderPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoSearchService implements IfDemoSearchService{
    @Autowired
    private JdbcTemplate jdbcTmplt;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderPageMapper orderPageMapper;

    @Override
    public List<Order> getAll() {
        String sql = "SELECT orderId, clientId, orderDate, quantity,commont FROM newtest.order";
        List<Order> list = this.jdbcTmplt.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        return list;
    }
    @Override
    public Order getSearch(Integer orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }
    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }
    @Override
    public int update(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }
    @Override
    public Page<Order> selectOrderPage(int page, int pageSize) {
        try {
            Page<Order> p = new Page<>(page, pageSize);
            p.setRecords(orderPageMapper.selectPageData(p));
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
