package guru.springframework.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.springframework.service.RecipeService;

public class IndexcontrollerTest {
	
	@Mock
	RecipeService recipeService;
	@Mock
	Model model;
	
	Indexcontroller indexController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new Indexcontroller(recipeService);
	}

	@Test
	public void testGetIndexPage() {
		String returnVal = indexController.getIndexPage(model);
		assertEquals("index",returnVal);
		verify(recipeService,times(1)).getRecipes();
		verify(model,times(1)).addAttribute("recipes",recipeService.getRecipes());
	}

}
