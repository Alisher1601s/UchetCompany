package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private int summa;
private int kolvo;
@OneToMany
@JoinColumn(name="productid")
private List<Ingredients>ingred;
public List<Ingredients>getIngredients()
{
	
	return ingred;
}
@ManyToOne
@JoinColumn(name="edinicaid")
private edinica edinica;
public edinica getEdinica()
{
	return edinica;
}
public void setEdinica(edinica ed)
{
	this.edinica=ed;
}
public void setIngredients(List<Ingredients>ll)
{
this.ingred=ll;	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSumma() {
	return summa;
}
public void setSumma(int summa) {
	this.summa = summa;
}
public int getKolvo() {
	return kolvo;
}
public void setKolvo(int kolvo) {
	this.kolvo = kolvo;
}
public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return id;
}

}
