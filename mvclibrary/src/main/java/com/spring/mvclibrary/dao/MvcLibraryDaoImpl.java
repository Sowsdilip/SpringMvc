package com.spring.mvclibrary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.spring.mvclibrary.db.DataBaseManager;
import com.spring.mvclibrary.model.Book;
import com.spring.mvclibrary.model.Entity;
import com.spring.mvclibrary.model.User;

@Repository
public class MvcLibraryDaoImpl extends DataBaseManager implements MvcLibraryDao {

	public ArrayList<Book> loadBooksFromDb() {

		ArrayList<Book> books = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select * from books";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b1 = new Book(rs.getString("bname"), rs.getLong("quantity"));
				books.add(b1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return books;

	}

	@Override
	public void insertBookToDb(Book book) {

		loadDriver();
		Connection con = getConnection();
		String sql = "insert into books(bname,quantity) values (?,?)";
		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, book.getName());
			ps.setLong(2, book.getQuantity());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closePreparedStatement(ps);
		closeConnection(con);
	}

	@Override
	public void insertUserIntoDB(User user) {
		loadDriver();
		Connection con = getConnection();
		String sql = "insert into users(uname) value (?)";
		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, user.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closePreparedStatement(ps);
		closeConnection(con);
	}

	@Override
	public ArrayList<User> loadUsersFromDb() {

		ArrayList<User> users = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select uname from users";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u1 = new User(rs.getString("uname"));
				users.add(u1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return users;

	}

	@Override
	public ArrayList<String> loadUserBooksFromDb(String uname) {

		ArrayList<String> books = new ArrayList<>();
		loadDriver();
		Connection con = getConnection();
		String sql = "select bname from userbooks where uname=?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				books.add(rs.getString("bname"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return books;
	}

	public boolean updateBookQuanity(String check, String bname) {
		boolean result = true;
		Book b1 = checkIfBookAvailable(bname);
		if (b1 != null) {
			loadDriver();
			Connection con = getConnection();
			String sql = "update books set quantity=? where bname=?";
			PreparedStatement ps = getPreparedStatement(con, sql);

			try {
				if (check.equals("increment"))
					ps.setLong(1, (b1.getQuantity() + 1));
				else if (check.equals("decrement"))
					ps.setLong(1, (b1.getQuantity() - 1));
				// System.out.println(b1.getQuantity());
				ps.setString(2, b1.getName());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			closeConnection(con);
			closePreparedStatement(ps);
		} else
			result = false;
		return result;
	}

	@Override
	public boolean updateUserBooks(String check, String uname, String bname) {

		ArrayList<String> books = loadUserBooksFromDb(uname);
		boolean result = true;
		if (books.size() < 4) {
			loadDriver();
			Connection con = getConnection();
			String sql = null;
			if (check.equals("insert"))
				sql = "insert into userbooks values (?,?)";
			else if (check.equals("delete"))
				sql = "delete from userbooks where uname=? && bname= ?";
            PreparedStatement ps = getPreparedStatement(con, sql);
			try {
				ps.setString(1, uname);
				ps.setString(2, bname);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(con);
			closePreparedStatement(ps);
		} else
			result = false;
		return result;

	}

	public Book checkIfBookAvailable(String bname) {
		Book b1 = new Book();
		loadDriver();
		Connection con = getConnection();
		String sql = "select * from books where bname=?";

		PreparedStatement ps = getPreparedStatement(con, sql);

		try {
			ps.setString(1, bname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b1 = new Book(rs.getString("bname"), rs.getLong("quantity"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection(con);
		closePreparedStatement(ps);

		return b1;

	}

}
