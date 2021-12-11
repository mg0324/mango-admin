package com.github.mg0324.madmin.core.util;

import java.util.UUID;

public class IdUtil {

    public static String genUUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
