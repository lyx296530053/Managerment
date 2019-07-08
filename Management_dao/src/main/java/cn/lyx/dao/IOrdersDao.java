package cn.lyx.dao;

import cn.lyx.daomain.Member;
import cn.lyx.daomain.Order;
import cn.lyx.daomain.Product;
import org.apache.ibatis.annotations.*;

import javax.tools.JavaCompiler;
import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders where id=#{i}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.lyx.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class, one = @One(select = "cn.lyx.dao.IMemberDao.findById")),
            @Result(property = "travellers",column ="id" ,javaType =java.util.List.class,many = @Many(select = "cn.lyx.dao.ITraverllerDao.findByOrdersId"))
    })
    Order findById(String i);
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.lyx.dao.IProductDao.findById")),
    })
    List<Order> findAll();
}
