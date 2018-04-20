package cn.smbms.service.role;

import java.sql.Connection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import cn.smbms.MyBatisUtil;
import cn.smbms.dao.BaseDao;
import cn.smbms.dao.role.RoleDao;
import cn.smbms.pojo.Role;
@Service("RoleService")
public class RoleServiceImpl implements RoleService{
	@Resource 
	private RoleDao roleDao;

	



	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	/*	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}
	*/
	@Override
	
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		List<Role> roleList = null;
		try {
			roleList=roleDao.getRoleList();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally{
				}
		return roleList;
	
	}
}
