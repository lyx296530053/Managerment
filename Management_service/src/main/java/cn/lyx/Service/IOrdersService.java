package cn.lyx.Service;

import cn.lyx.daomain.Order;

import java.util.List;

public interface IOrdersService {

    Order findById(String i);

    List<Order> findAll(int pags,int size);

}
