package ch.hearc.shoeshop.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ch.hearc.shoeshop.main.model.Shoe;

public interface ShoeRepository extends CrudRepository<Shoe, Long>, PagingAndSortingRepository<Shoe, Long>
{
	Shoe findByName(String name);
}