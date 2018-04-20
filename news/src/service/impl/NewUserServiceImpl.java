package service.impl;

import java.util.List;

import dao.NewuserDao;
import dao.impl.NewuserDaoImpl;
import service.NewUserService;
import entity.Newuser;

public class NewUserServiceImpl implements NewUserService {
	public List<Newuser> register(String name, String pwd) {
		Newuser newuser = new Newuser();
		NewuserDao ewuser = new NewuserDaoImpl();
		List<Newuser> list = ewuser.query("uName", name, null, -1, "null");
		if (list.size() > 0) {
			Newuser newuser1 = list.get(0);
			if (newuser1.getuPwd().equals(pwd)) {
				return list;
			}

		}
		return null;
	}

}
