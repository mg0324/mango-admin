package com.github.mg0324.madmin.core.bean;

import lombok.Data;

@Data
public class Result implements java.io.Serializable{
    private int state;
    private String msg;
}
