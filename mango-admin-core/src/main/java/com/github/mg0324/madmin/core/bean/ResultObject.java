package com.github.mg0324.madmin.core.bean;

import lombok.Data;

@Data
public class ResultObject<T> extends Result {
    private T row;
}
