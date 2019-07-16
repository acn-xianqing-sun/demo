package com.example.demo.mapper.newtest;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.newtest.Order;

import java.util.List;

public interface OrderPageMapper {
    List<Order> selectPageData(Page page);
}