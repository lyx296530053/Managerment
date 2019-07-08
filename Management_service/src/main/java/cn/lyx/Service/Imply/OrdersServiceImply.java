package cn.lyx.Service.Imply;

import cn.lyx.Service.IOrdersService;
import cn.lyx.dao.IOrdersDao;
import cn.lyx.daomain.Order;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImply implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public Order findById(String i) {
        return iOrdersDao.findById(i);
    }

    @Override
    public List<Order> findAll(int pags,int size) {
        PageHelper.startPage(pags,size);
        return iOrdersDao.findAll();
    }
}
