package com.mark.springboot.controller;


import com.mark.springboot.http.R;
import com.mark.springboot.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class create {
    @Autowired
    CreateService createService;

    /**
     * 获取库下面所有表的表名和表的注释
     * @return
     */
    @RequestMapping("/tablesToWord")
    public R tablesToWord(String dataName) {
        createService.getTableInfo(dataName);
        return R.ok();
    }

    /**
     * 获取某张表下面的字段名，字段类型，是否为null, 约束, 字段说明，
     * @param dataName
     * @return
     */
    @RequestMapping("/tableFieldsToWord")
    public R tableFieldsToWord(String dataName) {
        createService.getTableFields(dataName);
        return R.ok();
    }
}
