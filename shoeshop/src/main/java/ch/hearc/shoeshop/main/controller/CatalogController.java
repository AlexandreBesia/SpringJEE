package ch.hearc.shoeshop.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Shoe Catalog Linked Controller
 * @author AlexandreBesia
 *
 */
@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	/**
	 * Return home page template
	 * @param model
	 * @return template name
	 */
	@GetMapping(value = {"/","/accueil"})
	public String showAccueilPage(Model model, @RequestParam(defaultValue="0") Integer pageNumber) {
	    model.addAttribute("shoes", catalogService.getAllShoesFromCatalog(Math.abs(pageNumber)));   
	    model.addAttribute("isPublic",Boolean.TRUE);
	    model.addAttribute("pageNumber", pageNumber);
		return "accueil"; 
	}
	
	/**
	 * Return about page template
	 * @param model
	 * @return template name
	 */
	@GetMapping(value = {"/about"})
	public String showAboutPage() {
		return "about"; 
	}

	
	/**
	 * Save shoe rating
	 * @param note
	 * @param shoeId
	 * @return current page
	 */
	@PostMapping(value = {"/evaluate"})
	public String evaluateShoe(Model model,@RequestParam Integer note,@RequestParam Integer shoeId, @RequestParam Integer pageNumber) {
	    catalogService.saveEvaluation(shoeId, note, pageNumber);
		model.addAttribute("shoes", catalogService.getAllShoesFromCatalog(Math.abs(pageNumber)));   
		return "redirect:/";
	}
	
}