package com.study.board.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //mariadb 에 들어있는 내용과 동일하게 작성

    private String title;

    private String content;

    private String filename;

    private String filepath;

    private String writer;

    private Date DATE;

}
