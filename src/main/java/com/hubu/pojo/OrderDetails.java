package com.hubu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
public class OrderDetails {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id")
    private int id;

    @Column(name = "bookId")
    private String bookId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "number")
    private int number;
}
