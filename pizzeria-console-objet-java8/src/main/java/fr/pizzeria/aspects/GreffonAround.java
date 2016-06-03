package fr.pizzeria.aspects;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.performance.PerformanceDaoSpringData;
import fr.pizzeria.model.Performance;

@Aspect
@Component
public class GreffonAround {
	
	@Autowired private PerformanceDaoSpringData performanceDao;
	
	@Around("fr.pizzeria.aspects.PerformanceAspect.toutesLesMethodesDaoPizza()")
	public Object logPizza(ProceedingJoinPoint pjp) throws Throwable{
		
		Performance performance = new Performance();
		performance.setDate(Calendar.getInstance().getTime());
		long temps = Calendar.getInstance().getTimeInMillis();
		performance.setService(pjp.getSignature().toShortString());
//		System.out.println(performance.getService());
		
		Object valeurRetourne = pjp.proceed();
		
		temps = (Calendar.getInstance().getTimeInMillis() - temps);
		performance.setTempsExecution(temps);
		performanceDao.savePerformance(performance);
		
		return valeurRetourne;
	}

}
