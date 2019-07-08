package cn.lyx.web.Controller;

import cn.lyx.Service.Imply.ProductServiceImply;
import cn.lyx.daomain.Product;
import cn.lyx.utils.UuidUtil;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource(name = "productServiceImply")
    private ProductServiceImply iProductService;

    @RequestMapping("/findAll")
    //@RolesAllowed("")
    //@Secured("")
    //@PreAuthorize("hasRole)
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = iProductService.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
        modelAndView.addObject("productList", all);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(Product product) {
        String uuid = UuidUtil.getUuid();
        product.setId(uuid);
        iProductService.save(product);
        return "redirect:findAll";
    }
}
