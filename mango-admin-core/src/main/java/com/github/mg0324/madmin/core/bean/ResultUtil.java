package com.github.mg0324.madmin.core.bean;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultUtil<T> {

    public Result error(String msg){
        Result result = new Result();
        result.setState(0);
        result.setMsg(msg);
        return result;
    }

    public ResultObject error2obj(T obj,String msg){
        ResultObject result = new ResultObject();
        result.setState(0);
        result.setMsg(msg);
        result.setRow(obj);
        return result;
    }

    public ResultList<T> error2list(List<T> list,String msg){
        ResultList result = new ResultList();
        result.setState(0);
        result.setMsg(msg);
        result.setRows(list);
        return result;
    }

    public Result success(String msg){
        Result result = new Result();
        result.setState(1);
        result.setMsg(msg);
        return result;
    }

    public ResultObject<T> success2obj(T obj,String msg){
        ResultObject<T> result = new ResultObject<T>();
        result.setState(1);
        result.setMsg(msg);
        result.setRow(obj);
        return result;
    }

    public ResultList<T> success2list(List<T> list,String msg){
        ResultList<T> result = new ResultList<T>();
        result.setState(1);
        result.setMsg(msg);
        result.setRows(list);
        return result;
    }

    public ResultPage success2page(PageInfo<T> thePage, String msg){
        ResultPage<T> result = new ResultPage<T>();
        result.setState(1);
        result.setMsg(msg);
        result.setRows(thePage.getList());
        result.setPage(thePage.getPageNum());
        result.setRecords(thePage.getTotal());
        result.setSize(thePage.getSize());
        result.setTotal(thePage.getPages());
        return result;
    }
}
