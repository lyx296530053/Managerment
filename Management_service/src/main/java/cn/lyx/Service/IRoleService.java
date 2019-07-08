package cn.lyx.Service;

import cn.lyx.daomain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String id);
}
