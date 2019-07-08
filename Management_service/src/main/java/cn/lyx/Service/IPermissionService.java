package cn.lyx.Service;

import cn.lyx.daomain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    Permission findById(String id);

    void save(String username, String url);
}
