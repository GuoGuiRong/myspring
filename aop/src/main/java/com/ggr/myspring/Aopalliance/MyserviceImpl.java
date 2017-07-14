package com.ggr.myspring.Aopalliance;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyserviceImpl implements Myservice{
    public int update() {
        System.out.println("更新成功|");
        return 1;
    }

    public void add() {
        System.out.println("添加成功");
    }

    public void find() {
        System.out.println("查询成功");
    }

    public int delete() {
        System.out.println("删除成功");
        return 0;
    }
}
