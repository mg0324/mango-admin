package com.github.mg0324.madmin.core.bean;

import lombok.Data;

import java.util.List;

@Data
public class ResultPage<T> extends Result {
    private List<T> rows;
    private long page;
    private long total;
    private long records;
    private long size;
}
