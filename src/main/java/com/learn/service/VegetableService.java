package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.model.Vegetable;
import com.learn.repository.VegetableRepository;

@Service
public class VegetableService {
	
	@Autowired
	private VegetableRepository vegetableRepository;

	public Vegetable saveVegetable(Vegetable vegetable) {
	return	this.vegetableRepository.save(vegetable);
	}
	
	public List<Vegetable> getAllVegetables()
	{
		return this.vegetableRepository.findAll();
	}
	
	public Vegetable getVegetableById(int id)
	{
		return this.vegetableRepository.findById(id).orElse(null);
	}
	
	public Vegetable updateVegetable(Vegetable vegetable,int id)
	{
		Vegetable vegetableTemp=vegetableRepository.findById(id).orElse(null);
		vegetableTemp.setPrice(vegetable.getPrice());
		vegetableTemp.setQuantity(vegetable.getQuantity());
		vegetableRepository.save(vegetableTemp);
		return vegetableTemp;
	}
	
	public void deleteVegetable(int id)
	{
		vegetableRepository.deleteById(id);
	}
	
	
	public Vegetable findByName(String name)
	{
		return vegetableRepository.findByName(name);
	}
}
