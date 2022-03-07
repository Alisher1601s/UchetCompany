package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Budget;
import com.example.demo.models.Doljnost;
import com.example.demo.models.Product;
import com.example.demo.models.Sotrudnik;
import com.example.demo.models.Syrie;
import com.example.demo.models.edinica;
import com.example.demo.repos.*;

@Controller
public class mainController {
	@Autowired
	private IngredientsRepo IngredRepo;
	@Autowired
	private SotrudnikRepo sotrrepo;
	@Autowired
	private SyrieRepo syrierepo;
	@Autowired
	private BudgetRepos budgetrepos;
	@Autowired
	private ProductRepo prodrepo;
	@Autowired
	
	private edinicaRepo edrepo;
	@Autowired
	private DoljnostRepo dolg;
@GetMapping("/budget")
public String getIndex(Model model)
{
	model.addAttribute("budgets",budgetrepos.findAll());
	return "budgettt";
}

@PostMapping("/budget")
public String setBudget(@ModelAttribute("budg") Budget budg)
{
	
	this.budgetrepos.save(budg);
	return "redirect:/budget";
}
@GetMapping("/newbudget")
public String getnewBudget(@ModelAttribute("budget") Budget budg)
{
	return "new";
}
@GetMapping("/newedinica")
public String getnewEdinica(@ModelAttribute("edinicas")edinica ed)
{
		
	return "newedinica";
}
@PostMapping("/edinicaizmereniyas")
public String getNewEdd(@ModelAttribute("edinica") edinica ed)
{
	this.edrepo.save(ed);
	return "redirect:/edinicaizmereniyas";
}
@GetMapping("/edinicaizmereniyas")
public String getEd(Model model)
{
	 model.addAttribute("edinica",edrepo.findAll());
	 
	 
	 
	 return "edinicaizm";
}
@GetMapping("/syriies")
public String getSyrie(Model model)
{
	model.addAttribute("syries",syrierepo.findAll());
	return "syriie";
}
@GetMapping("/syriies/{id}")
public String getId(@PathVariable("id") int id,Model model)
{
	model.addAttribute("syrieid",this.syrierepo.findById(id).get());
	return "syrieid";
}
@GetMapping("/newsyriee")
public String getnewSyrie(@ModelAttribute("syrie") Syrie syrie,Model model)
{
	
	model.addAttribute("edinica",this.edrepo.findAll());
	return "newsyrie";
	
}
@PostMapping("/syriies")
public String getnewSyrr(@ModelAttribute("syrie") Syrie syrie)
{
	this.syrierepo.save(syrie);
	return "redirect:/syriies";
	
}
@GetMapping("/products")

public String getProducts(Model model){

	model.addAttribute("prodd",prodrepo.findAll());
	return "prodd";
}
@GetMapping("/newproduct")
public String getNewProduct(@ModelAttribute("product") Product produc,Model model)
{
	
	model.addAttribute("edinica",this.edrepo.findAll());
	return "newproductt";
}
@PostMapping("/products")
public String setNewProd(@ModelAttribute("product") Product prod)
{
	this.prodrepo.save(prod);
	return "redirect:/products";
}
@GetMapping("/Sotrudniki")
public String getSotrdunik(Model model)
{
	model.addAttribute("sotr",sotrrepo.findAll());
	
	return "sotrudniki";
}
@GetMapping("/budget/{id}")
public String getBudgetid(@PathVariable("id") int id,Model model)
{
	model.addAttribute("budget",this.budgetrepos.findById(id).get());
	return "budgetid";
}
@GetMapping("/newSotrudnik")
public String getNewsotr(@ModelAttribute("sotrudnik") Sotrudnik sotr,Model model)
{
	
	model.addAttribute("doljnost",this.dolg.findAll());
	return "newsotrudnik";
	
}
@PostMapping("/Sotrudniki")
public String getSotrd(@ModelAttribute("sotrudnik") Sotrudnik sotr)
{

	this.sotrrepo.save(sotr);
	
	
	
	return "redirect:/Sotrudniki";
	
	
}
@GetMapping("/Ingrediients")
public String getIngr(Model model)
{
	model.addAttribute("ingr",IngredRepo.findAll());
	return "Ingred";
}
@GetMapping("/doljnosti")
public String getDoljnosti(Model model)
{
	model.addAttribute("doljn",dolg.findAll());
	
	return "doljnosti";
}
@GetMapping("/newdoljnost")
public String getNewDOljnost(@ModelAttribute("doljnost") Doljnost dolg)
{
	return "newdolgii";
}
@PostMapping("/doljnosti")
public String getDoljnostii(@ModelAttribute("doljnost") Doljnost dolgs)
{
	this.dolg.save(dolgs);
	return "redirect:/doljnosti";
}

}
