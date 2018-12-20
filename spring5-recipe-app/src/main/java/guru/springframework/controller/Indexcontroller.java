package guru.springframework.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitofMeasure;
import guru.springframework.repositories.CategoryRepo;
import guru.springframework.repositories.UnitOfMeasureRepo;

@Controller
public class Indexcontroller {

	private CategoryRepo categoryRepo;
	private UnitOfMeasureRepo unitofMeasureRepo;
	
	
	public Indexcontroller(CategoryRepo categoryRepo, UnitOfMeasureRepo unitofMeasureRepo) {
		super();
		this.categoryRepo = categoryRepo;
		this.unitofMeasureRepo = unitofMeasureRepo;
	}


	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepo.findByDescription("American");
		Optional<UnitofMeasure> unitofmeasureOptional = unitofMeasureRepo.findByDescription("Teaspoon");
				
		System.out.println("Cat Id: " + categoryOptional.get().getId());
		System.out.println("UOM ID: " + unitofmeasureOptional.get().getId());
		
		return "index";
	}
	
}
