package cn.lyx.dao;

import cn.lyx.daomain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraverllerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrdersId(String orderId);
}
