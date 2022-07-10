package com.jokertian.easypoi;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.jokertian.easyexcel.bean.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class EasyExcelApplicationTests {

    @Test
    void contextLoads() {
        String fileName = "E:\\Administrator\\Desktop\\a.xlsx";
        PageReadListener.BATCH_COUNT = 1000;
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
    }

}