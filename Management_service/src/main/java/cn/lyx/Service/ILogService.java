package cn.lyx.Service;

import cn.lyx.daomain.SysLog;

import java.util.List;

public interface ILogService {
    void save(SysLog sysLog);

    List<SysLog> findAll();

}
