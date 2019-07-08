package cn.lyx.dao;

import cn.lyx.daomain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product")
    public List<Product> findAll();

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
    @Select("select * from product where id=#{id}")
    Product findById (String id);
}
