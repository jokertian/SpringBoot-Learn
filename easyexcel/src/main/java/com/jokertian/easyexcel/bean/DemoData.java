package com.jokertian.easyexcel.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.converters.date.DateDateConverter;
import com.alibaba.excel.converters.date.DateStringConverter;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author 田朋朋
 * @date 2022/7/2 15:27
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DemoData {
    private String string;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(converter = DateStringConverter.class)
    @DateTimeFormat("yyyy年DD月dd日")
    private Date date;
    private Double doubleData;
}