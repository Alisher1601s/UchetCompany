package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Doljnost;
import com.example.demo.models.Ingredients;
import com.example.demo.models.Syrie;
import com.example.demo.repos.DoljnostRepo;
import com.example.demo.repos.IngredientsRepo;
import com.example.demo.repos.SyrieRepo;
@RestController
@RequestMapping("/api/v1/developers")
public class RestControl {
	@Autowired
	private DoljnostRepo dolg;
	@Autowired
	private SyrieRepo syrierepo;
	@Autowired
	private IngredientsRepo ingred;
	
	
	@GetMapping()
	public List<Doljnost> listDolgov()
	{
		return dolg.findAll();
	}
	@GetMapping("{id}")
	public Doljnost getById(@PathVariable("id") int id)
	{
		return dolg.findById(id).get();
	}
	@GetMapping("/exampleofsecurity")
	public String gegs(@ModelAttribute("doljnost") Doljnost dolg)
	{
		return "sec";
		
	}
	@PostMapping
	public Doljnost create(@RequestBody Doljnost doljnost)
	{
		dolg.findAll().add(doljnost);
		return doljnost;
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") int id)
	{
		this.dolg.findAll().removeIf(developer->developer.getId()==id);
	}
}
