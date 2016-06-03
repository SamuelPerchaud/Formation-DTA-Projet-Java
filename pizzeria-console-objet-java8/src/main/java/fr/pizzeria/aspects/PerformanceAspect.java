package fr.pizzeria.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

	
	//@Pointcut("* (..)*Pizza)") //toute les methode qui finisse par pizza
	@Pointcut("execution(* fr.pizzeria.dao.pizza.*.*(..))") //
	public void toutesLesMethodesDaoPizza(){}
}
