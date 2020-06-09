package dao;

import model.ManagerSignup;

public interface  ManagerDaointerface
	{
		int signUp(ManagerSignup mlogin);
		boolean login(ManagerSignup login);
	}
