package ch.hearc.shoeshop.main.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import ch.hearc.shoeshop.main.ShoeshopApplication;
import ch.hearc.shoeshop.main.controller.CatalogService;
import ch.hearc.shoeshop.main.model.Shoe;

class TestClass {

	// test for main application
	@RunWith(SpringRunner.class)
	public class ShoeshopApplicationTest {

		@Test
		public void contextLoads() {
			String[] args = {};
			ShoeshopApplication.main(args);
		}

	}
	
	// tests for AdminController
	public class SaveShoeTest {
		
	    @Mock
	    CatalogService catalogueService;

	    @Test
	    public void testSaveShoe() {
	        String type = "new";
	        Shoe shoe = new Shoe();
	        String result = saveShoe(shoe, type);

	        verify(catalogueService).addShoeToCatalog(shoe);
	        assertEquals(result, "redirect:/admin/");
	        
	        deleteShoe(shoe.getId());
	    }

		private void deleteShoe(Long id) {
		}

		private String saveShoe(Shoe shoe, String type) {
			return null;
		}
	}
	
	public class TestShowNewShoeForm {

	    @Test
	    public void testShowNewShoeForm() {
	        Model model = (Model) new Shoe();
	        String result = showNewShoeForm(model);
	        assertEquals("admin/accueil", result);
	        assertEquals(model.getAttribute("shoe"), new Shoe(null, null, null, null, null));
	        assertEquals(model.getAttribute("showList"), Boolean.FALSE);
	        assertEquals(model.getAttribute("showNew"), Boolean.TRUE);
	        assertEquals(model.getAttribute("isNew"), Boolean.TRUE);
	        assertEquals(model.getAttribute("isEdit"), Boolean.FALSE);
	    }

		private String showNewShoeForm(Model model) {
			return null;
		}

	}
	
	public class TestShowNEditShoeForm {

	    @Test
	    public void testShowNEditShoeForm() {
	        Model model = (Model) new Shoe();
	        String result = showNewShoeForm(model);
	        assertEquals("admin/accueil", result);
	        assertEquals(model.getAttribute("shoe"), new Shoe(null, null, null, null, null));
	        assertEquals(model.getAttribute("showList"), Boolean.FALSE);
	        assertEquals(model.getAttribute("showNew"), Boolean.TRUE);
	        assertEquals(model.getAttribute("isNew"), Boolean.FALSE);
	        assertEquals(model.getAttribute("isEdit"), Boolean.TRUE);
	        assertEquals(model.getAttribute("showCurrent"), Boolean.FALSE);
	    }

		private String showNewShoeForm(Model model) {
			return null;
		}

	}
	
	public class TestShowShoeForm {

	    @Test
	    public void testShowShoeForm() {
	        Model model = (Model) new Shoe();
	        String result = showNewShoeForm(model);
	        assertEquals("admin/accueil", result);
	        assertEquals(model.getAttribute("shoe"), new Shoe(null, null, null, null, null));
	        assertEquals(model.getAttribute("showList"), Boolean.FALSE);
	        assertEquals(model.getAttribute("showNew"), Boolean.TRUE);
	        assertEquals(model.getAttribute("isNew"), Boolean.FALSE);
	        assertEquals(model.getAttribute("isEdit"), Boolean.TRUE);
	        assertEquals(model.getAttribute("showCurrent"), Boolean.FALSE);
	    }

		private String showNewShoeForm(Model model) {
			return null;
		}

	}
	
	public class AccueilPageTest {

		@Test
		public void showAccueilPageTest() {
			Model model = (Model) new Shoe();
			String result = showAccueilPage(model, 0);
			assertEquals(result, "admin/accueil");

			assertEquals(model.getAttribute("showList"), Boolean.TRUE);
			assertEquals(model.getAttribute("showNew"), Boolean.FALSE);
			assertEquals(model.getAttribute("isAdmin"), Boolean.TRUE);
			assertEquals(model.getAttribute("pageNumber"), 0);
			assertNotNull(model.getAttribute("shoes"));
		}

		private String showAccueilPage(Model model, int i) {
			return null;
		}
	}
	
	
}
