package com.example.exc_demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import lombok.extern.slf4j.Slf4j;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


@Slf4j
public class Demo {
    public static void main(String[] args) {
        String path = Demo.class.getClassLoader().getResource("").getPath();
        String fileName =path +"新建 XLSX 工作表.xlsx";
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                log.info("读取到一条数据{}", demoData);
            }
        })).sheet().doRead();
    }
}
