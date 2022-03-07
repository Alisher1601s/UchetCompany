package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
public class Budget {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int budget;
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
public int getBudget() {
	return budget;
}
public void setBudget(int budget) {
	this.budget = budget;
}

}
