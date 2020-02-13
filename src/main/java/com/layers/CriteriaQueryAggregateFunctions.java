package com.layers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.Collections.Entity.ProductStatistics;
import com.layers.Model.Product;

@Component
@Configuration
@EnableAutoConfiguration
public class CriteriaQueryAggregateFunctions
{
	
	@Autowired
	EntityManager entityManager;
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.layers.*");
	
//	@Bean
//	public EntityManager entityManager()
//	{
//		return new 
//	}

	public static EntityManager getEntityManager()
	{
	    return emf.createEntityManager();
	}
	
	
	public static void Criteria( ) 
	{
		try (org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			
			//CriteriaBuilder builder = session.getCriteriaBuilder();
//			EntityManager em = getEntityManager();
			CriteriaBuilder builder=(CriteriaBuilder) getEntityManager();
			
			
			CriteriaQuery<ProductStatistics> criteriaQuery = builder.createQuery(ProductStatistics.class);
			Root<Product> root = criteriaQuery.from(Product.class);
			
		 javax.persistence.criteria.Expression<Long> totalNoOfEmployees = builder.count(root);
			javax.persistence.criteria.Expression<Long> totalDistnctNoOfEmployees = builder.countDistinct(root);
			javax.persistence.criteria.Expression<Number> maxSalaryOfEmployee = builder.max(root.get("price"));
			 javax.persistence.criteria.Expression<Double> avgSalaryOfEmployees = builder.avg(root.get("price"));
			javax.persistence.criteria.Expression<Number> sumOfSalryOfEmployees = builder.sum(root.get("price"));
			
			
			criteriaQuery.select(builder.construct(ProductStatistics.class, totalNoOfEmployees,totalDistnctNoOfEmployees,maxSalaryOfEmployee,avgSalaryOfEmployees,sumOfSalryOfEmployees));
			ProductStatistics singleResult = ((org.hibernate.Session) session).createQuery(criteriaQuery).getSingleResult();
			System.out.println(singleResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		


		
	
	}

}

