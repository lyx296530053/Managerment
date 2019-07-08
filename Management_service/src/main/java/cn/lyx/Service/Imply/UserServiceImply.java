package cn.lyx.Service.Imply;

import cn.lyx.Service.IUserService;
import cn.lyx.dao.IUserDao;
import cn.lyx.daomain.Role;
import cn.lyx.daomain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImply implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String id) {
        return userDao.findUserByIdAndAllRole(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUserName(s);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public void addRoleToUser(String userId, String[] roleId) {
        for (String s : roleId) {
            userDao.addRoleToUser(userId, s);
        }
    }
}
