package guru.springframework.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepo;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepo recipeRepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepo);
	}

	@Test
	public void getRecipeByTest() throws Exception{
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepo.findById(1l)).thenReturn(recipeOptional);
		Recipe recipeReturned = recipeService.findById(1l);
		
		assertNotNull("NULL RECIPE RETURNED",recipeReturned);
		verify(recipeRepo,times(1)).findById(1L);
		verify(recipeRepo,never()).findAll();
		
		
	}
	
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipeData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes.size(),1);
		
		verify(recipeRepo,times(1)).findAll();
	}

}
