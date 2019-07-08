package cn.lyx.web.Controller;

import cn.lyx.Service.Imply.RoleServiceImply;
import cn.lyx.daomain.Role;
import cn.lyx.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImply iRoleServiceImply;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = iRoleServiceImply.findAll();
        modelAndView.setViewName("role-list");
        modelAndView.addObject("roleList", roleList);
        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/save")
    public String save(Role role) {
        role.setId(UuidUtil.getUuid());
        iRoleServiceImply.save(role);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Role role=iRoleServiceImply.findById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-show");
        return  modelAndView;
    }

}
