package com.github.mg0324.madmin.core.bean;

import lombok.Data;

import java.util.List;

@Data
public class ResultList<T> extends Result {
    private List<T> rows;
}
