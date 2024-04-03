package com.practice.trello.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.trello.entity.Task;

public interface TaskDb extends JpaRepository<Task, Long> {

	public Task findByName(String name);

}
