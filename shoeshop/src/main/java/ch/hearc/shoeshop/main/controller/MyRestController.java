package ch.hearc.shoeshop.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.hearc.shoeshop.main.model.Shoe;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	CatalogService catalogService;
	
	@GetMapping(value = {"/"})
	public List<Shoe> getAllShoes(@RequestParam(defaultValue="0") Integer pageNumber) {
		List<Shoe> shoes = catalogService.getAllShoesFromCatalogNoPagination(); 
		return shoes;
	}
	
	
	
//  la version du CatalogController
//	@PostMapping(value = {"/evaluate"})
//	public String evaluateShoe(Model model,@RequestParam Integer note,@RequestParam Integer shoeId, @RequestParam Integer pageNumber) {
//	    catalogService.saveEvaluation(shoeId, note, pageNumber);
//		model.addAttribute("shoes", catalogService.getAllShoesFromCatalog(Math.abs(pageNumber)));   
//		return "redirect:/";
//	}
	
	@PostMapping(value = {"/evaluate"})
	public void evaluateShoe(@RequestParam Integer note,@RequestParam Integer shoeId, @RequestParam Integer pageNumber)
	{
		catalogService.saveEvaluation(shoeId, note, pageNumber);
	}
}
