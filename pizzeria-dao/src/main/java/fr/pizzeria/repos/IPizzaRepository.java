package fr.pizzeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface IPizzaRepository extends JpaRepository<Pizza, Long> {

		public Integer deleteByCode(String code);

		public Pizza findByCode(String codePizza);
}
