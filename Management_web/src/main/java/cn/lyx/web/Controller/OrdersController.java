package cn.lyx.web.Controller;

import cn.lyx.Service.Imply.OrdersServiceImply;
import cn.lyx.Service.Imply.ProductServiceImply;
import cn.lyx.daomain.Order;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Resource(name = "ordersServiceImply")
    private OrdersServiceImply ordersServiceImply;
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
       Order order= ordersServiceImply.findById(id);
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("orders",order);
       modelAndView.setViewName("orders-show");
       return modelAndView;
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "page",required =true,defaultValue = "4") int pags,@RequestParam(value = "pageSize",required = true,defaultValue = "4") int size){
       List<Order> orders1= ordersServiceImply.findAll(pags,size);
        PageInfo<Order> orders = new PageInfo<>(orders1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders-list");
        modelAndView.addObject("ordersList",orders);
        return modelAndView;
    }
}
