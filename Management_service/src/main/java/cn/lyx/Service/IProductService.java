package cn.lyx.Service;

import cn.lyx.daomain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();

    void save(Product product);
}
