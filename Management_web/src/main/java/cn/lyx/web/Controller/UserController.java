package cn.lyx.web.Controller;

import cn.lyx.Service.IUserService;
import cn.lyx.Service.Imply.UserServiceImply;
import cn.lyx.daomain.Role;
import cn.lyx.daomain.UserInfo;
import cn.lyx.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImply userServiceImply;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<UserInfo> userList = userServiceImply.findAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
    @RequestMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(UserInfo userInfo){
        userInfo.setId(UuidUtil.getUuid());
        userServiceImply.save(userInfo);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView=new ModelAndView();
        UserInfo userInfo=userServiceImply.findById(id);
        modelAndView.setViewName("user-show");
        modelAndView.addObject("user",userInfo);
        return modelAndView;
    }
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView modelAndView=new ModelAndView();
        UserInfo byId = userServiceImply.findById(id);
        List<Role> roles=userServiceImply.findUserByIdAndAllRole(id);
        modelAndView.addObject("user",byId);
        modelAndView.setViewName("user-role-add");
        modelAndView.addObject("roleList",roles);
        return modelAndView;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,
                                @RequestParam(name = "ids",required = true) String[] roleId){
        userServiceImply.addRoleToUser(userId,roleId);
        return "redirect:findAll";
    }
}
