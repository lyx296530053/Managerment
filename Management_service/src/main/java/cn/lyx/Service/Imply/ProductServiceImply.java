package cn.lyx.Service.Imply;

import cn.lyx.Service.IProductService;
import cn.lyx.dao.IProductDao;
import cn.lyx.daomain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class ProductServiceImply implements IProductService {
    @Autowired
    private IProductDao dao;
    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }
}
