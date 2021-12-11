package com.github.mg0324.madmin.core.base;

import com.github.mg0324.madmin.core.bean.Result;
import com.github.mg0324.madmin.core.bean.ResultUtil;
import com.github.mg0324.validator.util.ValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected ResultUtil resultUtil;

    protected Map<String,Object> getParamMap(){
        Map<String,Object> result = new HashMap<>();
        Map<String,String[]> pm = request.getParameterMap();
        for(String key : pm.keySet()){
            Object val = pm.get(key);
            if(val instanceof String[]){
                if(((String[]) val).length == 1) {
                    result.put(key, ((String[]) val)[0]);
                }else{
                    result.put(key,val);
                }
            }
        }
        return result;
    }

    protected String getPara(String key){
       return request.getParameter(key);
    }

    protected Result validate(Object obj){
        List<String> vList = ValidUtil.validateAll(obj,true);
        if(vList != null && vList.size()>0){
            return resultUtil.error(vList.get(0));
        }
        return null;
    }
}
