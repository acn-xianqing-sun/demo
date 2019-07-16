package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.newtest.Order;
import com.example.demo.mapper.newtest.OrderMapper;
import com.example.demo.mapper.newtest.OrderPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoUserDao {
    @Autowired
    private JdbcTemplate jdbcTmplt;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderPageMapper orderPageMapper;

    public List<Order> getAll() {
        String sql = "SELECT orderId, clientId, orderDate, quantity,commont FROM newtest.order";
        List<Order> list = this.jdbcTmplt.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
        return list;
    }
    public Order getSearch(Integer orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }
    public int insert(Order order) {
        return orderMapper.insert(order);
    }
    public int update(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }

    public List<Order> selectPageData(Page<Order> page) {
        return orderPageMapper.selectPageData(page);
    }
}
