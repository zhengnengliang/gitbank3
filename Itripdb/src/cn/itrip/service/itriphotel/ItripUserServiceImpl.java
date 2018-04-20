package cn.itrip.service.itriphotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.dao.itriphotel.ItripUserMapper;

@Service("itripUserService")
public class ItripUserServiceImpl implements ItripUserService{
	
	@Autowired
	private ItripUserMapper itripUserMapper;
	@Override
	public ItripUser login(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		ItripUser itripUser = null;
		try {
			itripUser = itripUserMapper.getLoginUser(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 匹配密码
		/*if (null != user) {
			if (!user.getUserPassword().equals(userPassword))
				user = null;
		}*/
		return itripUser;
	}
	
	@Override
	public int addItripUser(ItripUser itripUser) {
		// TODO Auto-generated method stub
		int i = itripUserMapper.addItripUser(itripUser);
		return i;
	}
	
	/*@Override
	public int addItripUser(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		int i= itripUserMapper.addItripUser(userCode, userPassword);
		return i;
	}*/

}
