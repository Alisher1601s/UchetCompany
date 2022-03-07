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
public class Syrie {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private int summa;
private int kolvo;
@OneToMany
private List<ZakupkaSyria> zakupkasyriya;
public void setZakupkaSyria(List<ZakupkaSyria>l)
{
	this.zakupkasyriya=l;
}
public List<ZakupkaSyria>getZakupkaSyria()
{
	return this.zakupkasyriya;
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
@OneToMany
@JoinColumn(name="syrieid")
private List<Ingredients>ingred;
public List<Ingredients>getIngredients()
{
	
	return ingred;
}
public void setIngredients(List<Ingredients>ll)
{
this.ingred=ll;	
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id=id;
}
}
