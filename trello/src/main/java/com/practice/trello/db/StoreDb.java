package com.practice.trello.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.trello.entity.Store;

public interface StoreDb extends JpaRepository<Store, Long> {

}
