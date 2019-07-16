package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderForm {
    private Integer orderid;

    private String clientid;

    private Date orderdate;

    private Integer quantity;

    private String commont;

    private int pageNum;

}