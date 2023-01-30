package ch.hearc.shoeshop.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ch.hearc.shoeshop.main.model.EvaluationShoe;
import ch.hearc.shoeshop.main.model.Shoe;
import ch.hearc.shoeshop.main.repository.EvaluationShoeRepository;
import ch.hearc.shoeshop.main.repository.ShoeRepository;

/**
 * Shoe Catalog Management Service
 * @author AlexandreBesia
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService{
	
	private static final int PAGE_SIZE = 4; //nb of item per page

	@Autowired
	ShoeRepository shoeRepository;
	
	@Autowired
	EvaluationShoeRepository evaluationRepository;
	
	/**
	 * Save a new shoe 
	 * @param shoe
	 */
	public void addShoeToCatalog(Shoe shoe) {
		shoeRepository.save(shoe);
	}
	
	/**
	 * Return all shoes
	 * @return list of shoes
	 */
	public List<Shoe> getAllShoesFromCatalog(int page){
		List<Shoe> result = new ArrayList<Shoe>();
		shoeRepository.findAll().forEach(result::add);
		
		return shoeRepository.findAll(PageRequest.of(page, PAGE_SIZE)).toList();
	}

	/**
	 * Delete a shoe
	 * @return void
	 */
	public void deleteShoe(Long id) {
		shoeRepository.deleteById(Long.valueOf(id));
	}

	/**
	 * Delete a shoe
	 * @return void
	 */
	public void deleteShoe(Integer id) {
		Shoe bDeleteShoe = shoeRepository.findById(Long.valueOf(id)).get();
		shoeRepository.delete(bDeleteShoe);	
	}
	
	/**
	 * Update a shoe
	 * @return shoe
	 */
	public Shoe updateShoe(Shoe shoe) {
		shoeRepository.save(shoe);
		return shoe;	
	}
	
	/**
	 * Find a shoe
	 * @return shoe
	 */
	public Shoe getShoeById(Integer id) {
		return shoeRepository.findById(Long.valueOf(id)).get();	
	}

	/**
	 * Update an evaluation of a shoe
	 * @return void
	 */
	public void saveEvaluation(Integer shoeId, Integer note, Integer pageNumber) {
		Shoe shoe = shoeRepository.findById(Long.valueOf(note)).get();
		
		EvaluationShoe evaluationShoe =  new EvaluationShoe(note, pageNumber);
		evaluationShoe.setShoe(shoe);
		evaluationRepository.save(evaluationShoe);
	}
}
