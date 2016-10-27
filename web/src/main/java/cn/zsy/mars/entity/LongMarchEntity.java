package cn.zsy.mars.entity;


import cn.zsy.mars.utils.OrderItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LongMarchEntity {

    private long id = -1;
    private int userId = -1;      //用户id
    private int userType = -1;     //用户类型（1：教师；2：家长）
    private String areaAbb;        //地市
    private Date createTime;  //创建时间
    private String content;   //评论内容

    /////////////////构建VO///////////////////////////////////////////
    private Date createTime1; //创建时间 -- 开始时间
    private Date createTime2; //创建时间 -- 结束时间
    private List<OrderItem> orderList = new ArrayList<OrderItem>(); // 排序控制;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getAreaAbb() {
        return areaAbb;
    }

    public void setAreaAbb(String areaAbb) {
        this.areaAbb = areaAbb;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }

    public Date getCreateTime2() {
        return createTime2;
    }

    public void setCreateTime2(Date createTime2) {
        this.createTime2 = createTime2;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }
}
