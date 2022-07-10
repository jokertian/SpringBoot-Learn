package com.jokertian.easyexcel.bean;

import java.util.List;

/**
 * @author 田朋朋
 * @date 2022/7/2 15:30
 */
public class DemoDAO {

    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}