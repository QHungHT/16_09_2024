package qh.synji.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import qh.synji.configs.DBConnectMySQL;
import qh.synji.dao.ICategoryDao;
import qh.synji.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public List<CategoryModel> findAll() {
		String sql= "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			new DBConnectMySQL();
			conn = DBConnectMySQL.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);

			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryModel findById(int id) {
		String sql= "Select * from categories where categoryid=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);      //chú ý các câu query có tham số
			rs = ps.executeQuery();
			CategoryModel category = new CategoryModel();
			while(rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoryModel findByName(String name) {
		String sql= "Select * from categories where categoryname=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);     //chú ý các câu query có tham số
			rs = ps.executeQuery();
			CategoryModel category = new CategoryModel();
			while(rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(CategoryModel category) {
		String sql= "Insert into categories (categoryname,images,status) value(?,?,?)";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(CategoryModel category) {
		String sql= "Update categories set categoryname=?,images=?,status=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void delete(int id) {
		String sql= "Delete from categories where categoryid=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

	public void updateStatus(int id, int status) {
		String sql= "Update categories set status=? where categoryid=?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectMySQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	public static void main(String[] args) {
		
	}
}
