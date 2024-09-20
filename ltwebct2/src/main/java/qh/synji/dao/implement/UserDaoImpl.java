package qh.synji.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qh.synji.configs.DBConnectMySQL;
import qh.synji.dao.IUserDao;
import qh.synji.models.UserModel;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel findByUserName(String username) {

		String sql = "Select * from users where username = ?";
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username); // truyền tham số
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedate(rs.getDate("createdate"));
				return user;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "Select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImage(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "Insert into users(username, password, email,  fullname, image, roleid, phone, createdate) values (?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImage());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedate());

			ps.executeUpdate();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {

			IUserDao userDao = new UserDaoImpl();

			System.out.println(userDao.findByUserName("hungnq"));

			UserDaoImpl userDaoImp = new UserDaoImpl();
			userDaoImp.insert(new UserModel(2, "thuvth", "thuvth@gmail.com", "123", "Võ Thị Hoài Thu", "", 201,
					"0946683544", java.sql.Date.valueOf("2024-09-16")));
			List<UserModel> list = userDaoImp.findAll();
			for (UserModel user : list) {
				System.out.println(user);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [user] where email = ?";
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}
