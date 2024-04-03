package com.practice.trello.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.trello.db.TaskDb;
import com.practice.trello.entity.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDb taskDb;

	public void createProject(String title) {
		Task task = new Task();
		task.setName(title);
		task.setTasks(Map.of("tasks", new ArrayList<>()));
		taskDb.save(task);
	}

	public Task getProject(String name) {
		return taskDb.findByName(name);
	}

	public List<Task> getAllProjects() {
		return taskDb.findAll();
	}

	public void updateProject(Task task) {
		taskDb.save(task);
	}

	public Task addList(String name, String title) {
		ObjectMapper objectMapper = new ObjectMapper();
		Task task = taskDb.findByName(name);
		ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
		if (task.getTasks() != null) {
			arrayList = objectMapper.convertValue(task.getTasks().get("tasks"), ArrayList.class);
		}

		Map<String, Object> data = new HashMap<>();
		data.put("table", title);
		data.put("data", new ArrayList<>());
		arrayList.add(data);
		task.setTasks(Map.of("tasks", arrayList));
		task = taskDb.save(task);
		return task;
	}

}
