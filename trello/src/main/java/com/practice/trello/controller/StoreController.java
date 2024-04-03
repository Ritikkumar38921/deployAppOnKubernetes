package com.practice.trello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.trello.db.StoreDb;
import com.practice.trello.entity.Store;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreDb storeDb;

	@PostMapping("/save")
	public void save(@RequestBody Store store) {
		storeDb.save(store);
	}

	@GetMapping("/getAll")
	public List<Store> getAll() {
		return storeDb.findAll();
	}
}
