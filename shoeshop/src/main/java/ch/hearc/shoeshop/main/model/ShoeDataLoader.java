package ch.hearc.shoeshop.main.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShoeDataLoader implements CommandLineRunner {
	@Autowired
	ShoeRepository2 shoeRepository;

	@Override
	public void run(String... args) throws Exception {
		loadShoeData();
	}

	private void loadShoeData() {
		if (shoeRepository.count() == 0) {
			Shoe shoe1 = new Shoe(100, "Timberland Baskets - Sprint Trekker Mid", "brown", new BigDecimal(106.40), new BigDecimal(42));
			Shoe shoe2 = new Shoe(50, "Timberland - Bottines - Euro Sprint Hiker", "blue", new BigDecimal(151.20), new BigDecimal(36));
			Shoe shoe3 = new Shoe(50, "Timberland - Bottines - 6 Premium Boot", "white", new BigDecimal(184.70), new BigDecimal(41));
			Shoe shoe4 = new Shoe(80, "Baskets - Sprint Trekker Super Ox", "black", new BigDecimal(122.90), new BigDecimal(45));
			Shoe shoe5 = new Shoe(50, "Chaussures bateaux - Classic Boat", "brown", new BigDecimal(152.0), new BigDecimal(122.90));
			shoeRepository.save(shoe1);
			shoeRepository.save(shoe2);
			shoeRepository.save(shoe3);
			shoeRepository.save(shoe4);
			shoeRepository.save(shoe5);
		}
	}
}
