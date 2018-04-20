package service;

import java.util.List;

import entity.Newuser;

public interface NewUserService {
	/**
	 * µÇÂ¼
	 * @param newuser
	 * @return
	 */
	public  List<Newuser>  register (String name ,String  pwd);
}
