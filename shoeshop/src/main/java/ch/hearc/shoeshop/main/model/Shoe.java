package ch.hearc.shoeshop.main.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Shoe {
	// table fields and table relationship
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "db_stock")
		private Integer stock;
		private String name;
		private String color;
		private BigDecimal price;
		private BigDecimal size;

		@OneToMany(mappedBy="shoe")
		private Set<EvaluationShoe> evaluations;
		
		public Set<EvaluationShoe> getEvaluations() {
			return evaluations;
		}

		public void addEvaluation(EvaluationShoe evaluation) {
			evaluations.add(evaluation);
		}
		private static final DecimalFormat df = new DecimalFormat("0.00");
		
		public void setEvaluations(Set<EvaluationShoe> evaluations){
			this.evaluations = evaluations;
		}
		
		public String getPopularite() {
			df.setRoundingMode(RoundingMode.UP);
			int nbEval = evaluations.size();
			
			if(nbEval == 0) {
				return "0";
			}
			
			int somme = evaluations.stream()
					.map(evaluation -> evaluation.getNote())
					.reduce(0, (a, b) -> a + b); 
			
			return df.format((double)somme/(double)nbEval*20.0d);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Shoe other = (Shoe) obj;
			return Objects.equals(id, other.id);
		}

		// getter and setter for table fields
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {

			this.price = price;
		}

		public String getColor() {
			return color;
		}
		public void setColor(String color) {

			this.color = color;
		}

		public BigDecimal getSize() {
			return size;
		}
		public void setSize(BigDecimal size) {

			this.size = size;
		}
}
