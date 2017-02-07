package com.idfinance.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.idfinance.dao.PipeLineDAO;
import com.idfinance.dao.TaskDAO;
import com.idfinance.model.Pipeline;
import com.idfinance.model.Task;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		 TaskDAO taskDao = (TaskDAO) context.getBean("taskDAO");
		PipeLineDAO pipelineDAO = (PipeLineDAO) context.getBean("pipelineDAO");

		// taskDao.createTask(new Task("task 1", "description 1", "action 1"));
		// taskDao.createTask(new Task("task 2", "description 2", "action 2"));
		// taskDao.createTask(new Task("task 3", "description 3", "action 3"));
		// taskDao.createTask(new Task("task 4", "description 4", "action 4"));
		// taskDao.createTask(new Task("task 5", "description 5", "action 5"));
		 Task task1 = taskDao.getTaskById(5);
		 Task task2 = taskDao.getTaskById(1);

		pipelineDAO
				.createPipeLine(new Pipeline("descrip of pipeline 1", task1));
		pipelineDAO
				.createPipeLine(new Pipeline("descrip of pipeline 4", task2));

		// List<Task> tasks = taskDao.getAllTask();
		// for (Task task : tasks) {
		// System.out.println(
		// "id: " + task.getId() + ", name: " + task.getName() + ", description:
		// " + task.getDescription());
		// }

		List<Pipeline> pipelines = pipelineDAO.getAllPipeLine();
		for (Pipeline pipeline : pipelines) {
			System.out.println("Pipelen " + pipeline.getId() + ", " + pipeline.getDescription());
			System.out.println("Task " + pipeline.getTask().getId() + ", " + pipeline.getTask().getName());
		}

	}

}
