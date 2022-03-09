package com.hubu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "market")
public class Market {

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id")
    private int id;

    @Column(name = "marketId")
    private String marketId;

    @Column(name = "bookId")
    private String bookId;

    @Column(name = "number")
    private int number;
}
