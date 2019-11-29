package com.mark.springboot.service;

import com.mark.springboot.dao.QueryMapper;
import com.mark.springboot.domain.Tables;
import com.mark.springboot.util.DateToWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateService {

    @Autowired
    QueryMapper queryMapper;

    @Autowired
    DateToWordUtil dateToWordUtil;

    @Value("${filePath}")
    private String filePath;

    /**
     * 将某个库的表整理成清单转成word
     */
    public void getTableInfo(String dataName) {
        List<Tables> tables = queryMapper.getAllTables(dataName);//库名
        dateToWordUtil.tablesToWord(dataName, tables, filePath);
    }

    /**
     * 将某库下的所有的表属性转成word
     * @param dataName
     */
    public void getTableFields(String dataName){
        List<Tables> tables = queryMapper.getAllTables(dataName);
        dateToWordUtil.tableFieldsToWord(dataName, tables, filePath);
    }




}
