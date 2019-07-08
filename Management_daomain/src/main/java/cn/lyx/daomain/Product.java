package cn.lyx.daomain;

import java.io.Serializable;
import java.util.Date;

public class Product  implements Serializable {
    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称 private String cityName;
    private String cityName;
    private Date departureTime; //
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus == 1) {
            return productStatusStr = "开启";
        } else {
            return productStatusStr = "关闭";
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public void setProductStatusStr(String productStatusStr) {

        this.productStatusStr = productStatusStr;
    }
}
