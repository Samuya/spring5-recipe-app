package guru.springframework.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepo;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepo recipeRepo;

	public RecipeServiceImpl(RecipeRepo recipeRepo) {
		super();
		this.recipeRepo = recipeRepo;
	}
	
	@Override
	public Set<Recipe> getRecipes() {
	
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepo.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}

}
