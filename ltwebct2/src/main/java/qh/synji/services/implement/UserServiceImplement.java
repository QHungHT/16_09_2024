package qh.synji.services.implement;

import qh.synji.dao.IUserDao;
import qh.synji.dao.implement.UserDaoImplement;
import qh.synji.models.UserModel;
import qh.synji.services.IUserService;

public class UserServiceImplement implements IUserService {
	
	IUserDao userDao = new UserDaoImplement();

	@Override
	public UserModel findbyUserModel(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findbyUserModel(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public static void main(String[] args) {

		try {

			IUserService userService = new UserServiceImplement();
			System.out.println(userService.login("hungnq","123"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
