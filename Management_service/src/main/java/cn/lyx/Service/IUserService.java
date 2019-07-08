package cn.lyx.Service;

import cn.lyx.daomain.Role;
import cn.lyx.daomain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findUserByIdAndAllRole(String id);

    void addRoleToUser(String userId, String[] roleId);
}
