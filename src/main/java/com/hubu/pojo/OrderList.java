package com.hubu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderlist")
public class OrderList {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "orderId")
    private String orderId;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "cost")
    private double cost;

    @Column(name = "marketId")
    private String marketId;
}
