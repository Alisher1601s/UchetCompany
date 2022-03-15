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
public class Syrie implements Comparable<Syrie> {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private double summa;
private double kolvo;
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
public double getSumma() {
	return summa;
}
public void setSumma(double d) {
	this.summa = d;
}
public double getKolvo() {
	return kolvo;
}
public void setKolvo(double d) {
	this.kolvo = d;
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
@Override
public int compareTo(Syrie o) {
	// TODO Auto-generated method stub
	return Integer.compare(id, o.id);
}
}
