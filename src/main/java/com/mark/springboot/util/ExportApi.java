package com.mark.springboot.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfParagraphStyle;
import com.mark.springboot.domain.InterfaceInfo;
import com.mark.springboot.domain.Property;
import com.mark.springboot.domain.Result;

import java.io.*;
import java.util.List;

public class ExportApi {


    /**
     * 读取api文件
     *
     * @param path api文件路径
     * @return api的stringBuilder
     * @throws IOException
     */
    public StringBuilder readFile(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = fileInputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, len));
        }
        return stringBuilder;
    }

    /**
     * 导出Api
     *
     * @param interfaceInfo api信息
     * @param fileName      导出的api文档名称
     * @param path          导出路径
     */
    public void apiToWord(InterfaceInfo interfaceInfo, String fileName, String path) throws FileNotFoundException, DocumentException {
        // 创建一个文档，里面每一页的大小为A4
        Document document = new Document(PageSize.A4);
        // 创建word文档
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        RtfWriter2.getInstance(document, new FileOutputStream(new File(path, fileName + ".doc")));
        // 打开文档
        document.open();
        // 设置 api 名称
        document.add(new Paragraph(interfaceInfo.getName(), RtfParagraphStyle.STYLE_HEADING_1));
        // 接口描述
        document.add(new Paragraph(interfaceInfo.getDescription()));
        // 接口号
        List<Property> requestProperties = interfaceInfo.getRequestProperties();

        document.add(new Paragraph(interfaceInfo.getDescription()));
        document.close();
        System.out.println("DONE!");
    }


    public static void main(String[] args) {
        try {
            ExportApi exportApi = new ExportApi();
            // 读取api的json文件
            StringBuilder stringBuilder = exportApi.readFile("C:\\Users\\Administrator\\Desktop\\api.json");
            // 将 json 形式的接口数据转换成 Result 对象
            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(stringBuilder.toString(), Result.class);
            // 获取接口信息
            InterfaceInfo interfaceInfo = result.getData();
            // 导出Api
            String fileName = "api";
            String path = "C:\\Users\\Administrator\\Desktop";
            exportApi.apiToWord(interfaceInfo, fileName, path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
