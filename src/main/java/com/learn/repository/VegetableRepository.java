package com.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.model.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

	public Vegetable findByName(String name);
}
