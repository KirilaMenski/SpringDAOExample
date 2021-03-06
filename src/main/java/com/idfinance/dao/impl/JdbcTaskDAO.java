package com.idfinance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.idfinance.dao.TaskDAO;
import com.idfinance.model.Task;

public class JdbcTaskDAO implements TaskDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createTask(Task task) {
		String query = "INSERT INTO task (name, description, action) VALUES (?, ?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, task.getName());
			ps.setString(2, task.getDescription());
			ps.setString(3, task.getAction());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void deleteTask(Task task) {
		String query = "DELETE FROM task WHERE id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, task.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public List<Task> getAllTask() {
		String query = "SELECT * FROM task";
		Connection conn = null;
		List<Task> tasks = new ArrayList<Task>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Task task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("action"));
				tasks.add(task);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

		return tasks;
	}

	public Task getTaskById(int id) {
		String sql = "SELECT * FROM task WHERE id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Task task = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				task = new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("action"));
			}
			rs.close();
			ps.close();
			return task;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
