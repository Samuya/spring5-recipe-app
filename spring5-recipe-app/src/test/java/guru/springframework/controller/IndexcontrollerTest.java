package guru.springframework.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Equals;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
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
	public void testMockMvc() throws Exception{
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}
	
	@Test
	public void testGetIndexPage() {
		
//		Set<Recipe> recipes = new HashSet<>();
//		recipes.add(new Recipe());
		
//		when(recipeService.getRecipes()).thenReturn(recipes);
	
//		ArgumentCaptor<Set<Recipe>> argumentCuptur = ArgumentCaptor.forClass(Set.class);
		
		String returnVal = indexController.getIndexPage(model);
		assertEquals("index",returnVal);
		verify(recipeService,times(1)).getRecipes();
//		verify(model,times(1)).addAttribute(eq("recipes"),argumentCuptur.capture());
//		
//		Set<Recipe> setInController = argumentCuptur.getValue();
//		assertEquals(1,setInController.size());
	}

}
