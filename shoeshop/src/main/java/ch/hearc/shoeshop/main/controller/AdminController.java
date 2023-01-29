package ch.hearc.shoeshop.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.shoeshop.main.model.Shoe;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CatalogService catalogueService;
	
	/**
	 * Allows the creation of a new shoe
	 * @param shoe
	 * @param errors
	 * @param model
	 * @return redirect to home page
	 */
	@PostMapping(value = "/save-shoe")
    public String saveShoe(@ModelAttribute Shoe shoe, BindingResult errors, Model model,@RequestParam String type) {
		if(type.equals("new")) {
			catalogueService.addShoeToCatalog(shoe);
		}else {
			catalogueService.deleteShoe(shoe.getId());
			catalogueService.addShoeToCatalog(shoe);
		}
       return "redirect:/admin/";
    }
	
	@PostMapping(value = "/delete-shoe")
	private String deleteShoe(@RequestParam Integer id){
	    catalogueService.deleteShoe((long)id);
	    return "redirect:/admin/";
	}
	
	/**
	 * Return a form to create a new shoe 
	 * @param model
	 * @return template name
	 */
	@GetMapping(value = "/new-shoe")
	public String showNewShoeForm(Model model) {
	    model.addAttribute("shoe", new Shoe());   
	    model.addAttribute("showList",Boolean.FALSE);
	    model.addAttribute("showNew",Boolean.TRUE);
	    
	    model.addAttribute("isNew",Boolean.TRUE);
	    model.addAttribute("isEdit",Boolean.FALSE);
		return "admin/accueil";
	}
	
	/**
	 * Return a form to edit a shoe
	 * @param model
	 * @return template name
	 */
	@PostMapping(value = "/edit-shoe")
	public String showNEditShoeForm(Model model,@RequestParam Integer id) {
	    
		Shoe shoeToEdit = catalogueService.getShoeById(id);
		
		model.addAttribute("shoe", shoeToEdit);   
	    model.addAttribute("showList",Boolean.FALSE);
	    model.addAttribute("showNew",Boolean.TRUE);
	    
	    model.addAttribute("isEdit",Boolean.TRUE);
	    model.addAttribute("isNew",Boolean.FALSE);

		return "admin/accueil";
	}
	
	/**
	 * Return home template
	 * @param model
	 * @return template name
	 */
	@GetMapping(value = {"/"})
	public String showAccueilPage(Model model,@RequestParam(defaultValue="0") Integer pageNumber) {
	    model.addAttribute("showList",Boolean.TRUE);
	    model.addAttribute("showNew",Boolean.FALSE);
	    model.addAttribute("isAdmin",Boolean.TRUE);
	    model.addAttribute("pageNumber", Math.abs(pageNumber));
	    model.addAttribute("shoes", catalogueService.getAllShoesFromCatalog(pageNumber));  
	    return "admin/accueil";
	}
}
