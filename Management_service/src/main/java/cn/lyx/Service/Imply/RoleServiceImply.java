package cn.lyx.Service.Imply;

import cn.lyx.Service.IRoleService;
import cn.lyx.dao.IRoleDao;
import cn.lyx.daomain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImply implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return iRoleDao.findByIds(id);
    }
}
