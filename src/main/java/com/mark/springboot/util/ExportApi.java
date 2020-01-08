package com.mark.springboot.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.style.RtfParagraphStyle;
import com.mark.springboot.domain.InterfaceInfo;
import com.mark.springboot.domain.Property;
import com.mark.springboot.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ExportApi {

    private static Logger logger = LoggerFactory.getLogger(ExportApi.class);


    /**
     * 读取api文件
     *
     * @param fileName api文件
     * @return api的stringBuilder
     * @throws IOException
     */
    public StringBuilder readFile(String fileName) throws IOException {
        logger.info("开始读取文件{}", fileName);
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = fileInputStream.read(buf)) != -1) {
            stringBuilder.append(new String(buf, 0, len));
        }
        logger.info("读取文件{}完毕", fileName);
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
        logger.info("开始生成api文档");
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
        Font font = new Font();
        font.setSize(10.5f);
        font.setFamily("宋体");
        // 设置 api 名称
        Paragraph nameParagraph = new Paragraph(interfaceInfo.getName(), RtfParagraphStyle.STYLE_HEADING_1);
        nameParagraph.setSpacingAfter(10);
        document.add(nameParagraph);
        // 接口描述
        Paragraph descriptionParagraph = new Paragraph(interfaceInfo.getDescription(), font);
        descriptionParagraph.setIndentationLeft(20);
        document.add(descriptionParagraph);
        logger.info("接口描述：{}", interfaceInfo.getDescription());
        // 接口号
        List<Property> requestProperties = interfaceInfo.getRequestProperties();
        List<Property> apiProperty = requestProperties.stream().filter(e -> "api".equals(e.getName())).collect(Collectors.toList());
        String api = apiProperty.get(0).getValue();
        Paragraph apiParagraph = new Paragraph("接口号：" + api, font);
        apiParagraph.setIndentationLeft(20);
        document.add(apiParagraph);
        logger.info("接口号：{}", api);
        // 接口URL
        String url = interfaceInfo.getUrl();
        Paragraph urlParagraph = new Paragraph("接口URL：" + url, font);
        urlParagraph.setIndentationLeft(20);
        document.add(urlParagraph);
        logger.info("接口URL：{}", url);
        // 输入
        font.setStyle(Font.BOLD);
        Paragraph inputParagraph = new Paragraph("输入：", font);
        inputParagraph.setIndentationLeft(20);
        document.add(inputParagraph);
        logger.info("开始生成参数字段表格");
        // 参数列表
        Table requestTable = createTableHead(4, new String[]{"参数", "类型", "字段长度", "描述"});
        for (Property property : requestProperties) {
            depth(property, requestTable, true);
        }
        document.add(requestTable);
        logger.info("开始生成输入实例");
        logger.info("生成输入实例结束");
        logger.info("生成参数字段表格完成");
        Paragraph outputParagraph = new Paragraph("输出：", font);
        outputParagraph.setIndentationLeft(20);
        document.add(outputParagraph);
        logger.info("开始生成响应字段表格");
        //响应列表
        Table responseTable = createTableHead(3, new String[]{"参数", "类型", "描述"});
        for (Property property : interfaceInfo.getResponseProperties()) {
            depth(property, responseTable, false);
        }
        document.add(responseTable);
        logger.info("生成响应字段表格完毕");
        //
        logger.info("开始生成输出实例");
        logger.info("生成输出实例结束");
        document.close();
        logger.info("开始生成api文档完毕");
    }


    /**
     * 生成表头
     *
     * @param cols  列数
     * @param heads 头部
     * @throws BadElementException
     */
    public Table createTableHead(int cols, String[] heads) throws BadElementException {
        // 生成表格
        Table table = new Table(cols);//4列
        table.setWidth(100);
        table.setBorderWidth(1);
        table.setPadding(10);
        table.setSpacing(0);
        //添加表头的元素，并设置表头背景的颜色
        Color chade = new Color(191, 191, 191);
        for (String head : heads) {
            Cell cell = new Cell(head);// 单元格
            cell.setBackgroundColor(chade);
            cell.setHorizontalAlignment(1);
            table.addCell(cell);
        }
        table.endHeaders();// 表头结束
        return table;
    }

    /**
     * 生成表格
     *
     * @return
     */
    public void depth(Property property, Table table, boolean isRequest) {
        Integer depth = property.getDepth();

        Cell cell = new Cell(space(depth - 1) + property.getName());// 单元格
        table.addCell(cell);

        cell = new Cell(property.getType());// 单元格
        cell.setHorizontalAlignment(1);
        table.addCell(cell);

        if (isRequest) {
            cell = new Cell("");// 单元格
            cell.setHorizontalAlignment(1);
            table.addCell(cell);
        }

        cell = new Cell(property.getDescription());// 单元格
        table.addCell(cell);

        List<Property> children = property.getChildren();
        if (!children.isEmpty()) {
            for (Property p : children) {
                depth(p, table, isRequest);
            }
        }
    }

    /**
     * 添加缩进
     *
     * @param count 深度
     * @return
     */
    public String space(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        while (count > 0) {
            stringBuilder.append("  ");
            count--;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try {
            ExportApi exportApi = new ExportApi();
            // 读取api的json文件
            StringBuilder stringBuilder = exportApi.readFile("C:\\Users\\wcc\\Desktop\\api.json");
            // 将 json 形式的接口数据转换成 Result 对象
            ObjectMapper mapper = new ObjectMapper();
            Result result = mapper.readValue(stringBuilder.toString(), Result.class);
            // 获取接口信息
            InterfaceInfo interfaceInfo = result.getData();
            // 导出Api
            String fileName = "api";
            String path = "C:\\Users\\wcc\\Desktop";
            exportApi.apiToWord(interfaceInfo, fileName, path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式化json字符串
     * @param s
     * @return
     */
    public static String jsonFormart(String s) {
        int level = 0;
        //存放格式化的json字符串
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int index = 0; index < s.length(); index++){//将字符串中的字符逐个按行输出
            //获取s中的每个字符
            char c = s.charAt(index);
//          System.out.println(s.charAt(index));

            //level大于0并且jsonForMatStr中的最后一个字符为\n,jsonForMatStr加入\t
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
//                System.out.println("123"+jsonForMatStr);
            }
            //遇到"{"和"["要增加空格和换行，遇到"}"和"]"要减少空格，以对应，遇到","要换行
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }


    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

}
