package cn.lyx.web.Controller;

import cn.lyx.Service.Imply.PermissionServiceImply;
import cn.lyx.daomain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionServiceImply imply;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<Permission> permissions=imply.findAll();
        modelAndView.setViewName("permission-list");
        modelAndView.addObject("permissionList",permissions);
        return modelAndView;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Permission permission=imply.findById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("permission",permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }
    @RequestMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(String username,String url){
        imply.save(username,url);
        return "redirect:findAll";
    }
}
