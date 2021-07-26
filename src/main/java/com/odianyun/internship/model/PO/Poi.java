package com.odianyun.internship.model.PO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wxj
 * @date 2021/7/23 - 12:51
 */
//@Document//指定表名
public class Poi implements Serializable {
    private static final long serialVersionUID = 4006165897521621894L;
    @Id //id为主键
    private String id;
    @Indexed //name变成主键  配合Document的使用
    private String name;

    public String getName( ) {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }
//@Field("star_super") Field指定字段的名称
    private BigDecimal star;

    private Integer commentNum;

    private String detail;

    private String address;

    private Double point;

    private String picture;

    public Double getPoint( ) {
        return point;
    }

    public void setPoint(Double point) {
        this.point=point;
    }

    public String getPicture( ) {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture=picture;
    }

    public String getId( ) {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public Integer getCommentNum( ) {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum=commentNum;
    }

    public String getDetail( ) {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail=detail;
    }

    public String getAddress( ) {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public BigDecimal getStar( ) {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star=star;
    }
}
