package com.mark.springboot.util;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.mark.springboot.dao.QueryMapper;
import com.mark.springboot.domain.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateToWordUtil {

    @Autowired
    QueryMapper queryMapper;

    /**
     * 将某个库的表清单变成word
     *
     * @param dataName
     * @param tables
     */
    public void tablesToWord(String dataName, List<Tables> tables, String filePath) {// 创建word文档,并设置纸张的大小
        Document document = new Document(PageSize.A4);
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream(new File(filePath, dataName+"_tables_" + System.currentTimeMillis() + ".doc")));
            document.open();

            String pheae = "dataName:" + dataName;

            Paragraph p = new Paragraph(pheae, new Font(Font.NORMAL, 24, Font.BOLDITALIC, new Color(0, 0, 0)));

            p.setAlignment(1);

            document.add(p);

            Table table = new Table(2);//6列

            table.setBorderWidth(1);

// table.setBorderColor(Color.BLACK);

            table.setPadding(0);

            table.setSpacing(0);

            /*
             * 添加表头的元素，并设置表头背景的颜色
             */
            Color chade = new Color(176, 196, 222);

            Cell cell = new Cell("表名称");// 单元格

            cell.setBackgroundColor(chade);

            table.addCell(cell);

            cell = new Cell("说明");// 单元格

            cell.setBackgroundColor(chade);

            table.addCell(cell);

            table.endHeaders();// 表头结束
            // 表格的主体
            for (int k = 0; k < tables.size(); k++) {
                String table_name = tables.get(k).getName();
                String table_comment = tables.get(k).getComment();

                table.addCell(table_name);

                table.addCell(table_comment);
            }

            //生成表格
            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tableFieldsToWord(String dataName, String tableName, String filePath) {
        Document document = new Document(PageSize.A4);

        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdir();
            }

            // 创建word文档
            RtfWriter2.getInstance(document, new FileOutputStream(new File(filePath, dataName+ "_fieldTable_" + System.currentTimeMillis() + ".doc")));
            document.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
