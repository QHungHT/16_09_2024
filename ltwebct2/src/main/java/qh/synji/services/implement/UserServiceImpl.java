package qh.synji.services.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import qh.synji.configs.DBConnectMySQL;
import qh.synji.dao.IUserDao;
import qh.synji.dao.implement.UserDaoImpl;
import qh.synji.models.UserModel;
import qh.synji.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public static void main(String[] args) {

		try {

			IUserService userService = new UserServiceImpl();
			System.out.println(userService.login("hungnq", "123"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(0, username, email, password, fullname, null, 5, phone, date));
		return true;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void update(UserModel user) {
        String query = "UPDATE users SET password = ? WHERE username = ?";
        try (Connection conn = DBConnectMySQL.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getPassword());  
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Password updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
}
