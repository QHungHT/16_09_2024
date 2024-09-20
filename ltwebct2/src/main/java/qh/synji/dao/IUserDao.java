package qh.synji.dao;

import java.util.List;

import qh.synji.models.UserModel;

public interface IUserDao {
	//Khai báo các hàm và thủ tục -> thực thi ở implement
	List<UserModel> findAll();
	UserModel findByUserName(String username);
	void insert(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
}
