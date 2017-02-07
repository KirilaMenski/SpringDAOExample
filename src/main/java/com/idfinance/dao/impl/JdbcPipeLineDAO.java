package com.idfinance.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.idfinance.dao.PipeLineDAO;
import com.idfinance.model.Pipeline;
import com.idfinance.model.Task;

public class JdbcPipeLineDAO implements PipeLineDAO {
	
	private DataSource dataSource;

	public void createPipeLine(Pipeline pipeline) {
		String query = "INSERT INTO pipeline (description, tas_id) VALUES (?, ?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pipeline.getDescription());
			ps.setObject(2, pipeline.getTask());
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

	public void deletePipeLine(Pipeline pipeline) {
		String query = "DELETE FROM pipeline WHERE id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pipeline.getId());
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

	public Pipeline getPipeLineById(int id) {
		String sql = "SELECT * FROM pipeline WHERE id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Pipeline pipeline = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pipeline = new Pipeline(rs.getString("description"), rs.getObject("task_id", Task.class));
			}
			rs.close();
			ps.close();
			return pipeline;
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

	public List<Pipeline> getAllPipeLine() {
		String query = "SELECT * FROM pipeline";
		Connection conn = null;
		List<Pipeline> pipelines = new ArrayList<Pipeline>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pipeline pipeline = new Pipeline(rs.getString("description"), rs.getObject("task_id", Task.class));
				pipelines.add(pipeline);
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

		return pipelines;
	}

}
