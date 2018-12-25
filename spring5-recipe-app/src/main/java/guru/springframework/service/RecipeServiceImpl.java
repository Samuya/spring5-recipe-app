package guru.springframework.service;

import java.util.HashSet;
import java.util.Optional;
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

	public Recipe findById(Long l)
	{
		Optional<Recipe> recipeOptional = recipeRepo.findById(l);
		
		if(!recipeOptional.isPresent())
		{
			throw new RuntimeException("Recipe Not Found!");
		}
		return recipeOptional.get();
	}
}
