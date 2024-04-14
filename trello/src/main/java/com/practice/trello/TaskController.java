package com.practice.trello;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/createProject")
	public void createProject(@RequestBody Map<String, Object> request) {
		String title = (String) request.get("title");
		title = title.concat("-").concat(UUID.randomUUID().toString());
		taskService.createProject(title);
	}

	@PostMapping("/getProject")
	public Task getProject(@RequestBody Map<String, Object> request) {
		String name = request.get("name").toString();
		return taskService.getProject(name);
	}

	@GetMapping("/getAllProjects")
	public List<Task> getAllProjects() {
		return taskService.getAllProjects();
	}

	@PostMapping("/updateProject")
	public void updateProject(@RequestBody Task task) {
		taskService.updateProject(task);
	}

	@PostMapping("/addList")
	public Task addList(@RequestBody Map<String, Object> request) {
		String name = (String) request.get("name");
		String title = (String) request.get("title");
		return taskService.addList(name, title);
	}

}
