package cn.lyx.Service.Imply;

import cn.lyx.Service.ILogService;
import cn.lyx.dao.ILogDao;
import cn.lyx.daomain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class LogServiceImply implements ILogService {
    @Autowired
    ILogDao iLogDao;
    @Override
    public void save(SysLog sysLog) {
        iLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return iLogDao.findAll();
    }
}
