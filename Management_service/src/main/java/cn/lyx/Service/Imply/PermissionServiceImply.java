package cn.lyx.Service.Imply;

import cn.lyx.Service.IPermissionService;
import cn.lyx.dao.IPermissionDao;
import cn.lyx.daomain.Permission;
import cn.lyx.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImply implements IPermissionService {
    @Autowired
    IPermissionDao permissionDao;
    @Override
    public List<cn.lyx.daomain.Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public cn.lyx.daomain.Permission findById(String id) {
        return permissionDao.findByIdd(id);
    }

    @Override
    public void save(String username, String url) {
        Permission permission=new Permission();
        permission.setId(UuidUtil.getUuid());
        permission.setPermissionName(username);
        permission.setUrl(url);
        permissionDao.save(permission);
    }
}
