package guru.springframework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.domain.Category;

public class CategoryTest {

	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void testGetId() {
		Long idvalue = 4L;
		category.setId(idvalue);
		assertEquals(idvalue,category.getId());
	}

	@Test
	public void testGetDescription() {
	}

	@Test
	public void testGetRecipes() {
	}

}
