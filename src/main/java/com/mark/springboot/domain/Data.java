package com.mark.springboot.domain;

import java.util.List;

public class Data {

    private List<List<TableFields>> fieldList;
    private List<Tables> tables;

    public List<List<TableFields>> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<List<TableFields>> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
    }
}
