package com.idfinance.dao;

import java.util.List;

import com.idfinance.model.Task;

public interface TaskDAO {
	
	void createTask (Task task);
	
	void deleteTask(Task task);
	
	List<Task> getAllTask();

}
