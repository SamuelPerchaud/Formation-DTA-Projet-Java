package fr.pizzeria.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;

public interface IPerformanceRepository extends JpaRepository<Performance, Long> {

		public Integer deleteByService(String service);

		public Performance findByService(String servicePerformance);
}
