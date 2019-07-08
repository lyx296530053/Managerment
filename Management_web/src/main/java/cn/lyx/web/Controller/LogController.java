package cn.lyx.web.Controller;

import cn.lyx.Service.Imply.LogServiceImply;
import cn.lyx.daomain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class LogController {
    @Autowired
    LogServiceImply logServiceImply;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<SysLog> logs=logServiceImply.findAll();
        modelAndView.setViewName("syslog-list");
        modelAndView.addObject("sysLogs",logs);
        return modelAndView;
    }
}
