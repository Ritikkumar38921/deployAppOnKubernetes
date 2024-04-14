package com.practice.trello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDb extends JpaRepository<Task, Long> {

	public Task findByName(String name);

}
