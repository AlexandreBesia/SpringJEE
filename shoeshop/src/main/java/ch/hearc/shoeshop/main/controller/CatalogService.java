package ch.hearc.shoeshop.main.controller;

import java.util.List;

import ch.hearc.shoeshop.main.model.Shoe;


public interface CatalogService {

	/**
	 * Save a new shoe 
	 * @param shoe
	 */
	public void addShoeToCatalog(Shoe shoe);
	
	/**
	 * Return all shoes
	 * @return list of shoes
	 */
	public List<Shoe> getAllShoesFromCatalog(int page);

	/**
	 * Delete a shoe
	 * @return void
	 */
	public void deleteShoe(Long id);
	
	/**
	 * Update a shoe
	 * @return shoe
	 */
	public Shoe updateShoe(Shoe shoe);
	
	/**
	 * Find a shoe
	 * @return shoe
	 */
	public Shoe getShoeById(Integer id);
	
	/**
	 * Update an evaluation of a shoe
	 * @return void
	 */
	public void saveEvaluation(Integer shoeId, Integer note);
}
