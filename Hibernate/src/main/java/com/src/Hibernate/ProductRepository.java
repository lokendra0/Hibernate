package com.src.Hibernate;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductRepository {
	   private final EntityManagerFactory entityManagerFactory;

	   public ProductRepository() {
	       entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
	   }

	   public void save(Product product) {
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       entityManager.getTransaction().begin();
	       entityManager.persist(product);
	       entityManager.getTransaction().commit();
	       entityManager.close();
	   }

	   public Product findById(Long id) {
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       Product product = entityManager.find(Product.class, id);
	       entityManager.close();
	       return product;
	   }

	   public List<Product> findAll() {
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	       entityManager.close();
	       return products;
	   }

	   public void update(Product product) {
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       entityManager.getTransaction().begin();
	       entityManager.merge(product);
	       entityManager.getTransaction().commit();
	       entityManager.close();
	   }

	   public void delete(Product product) {
	       EntityManager entityManager = entityManagerFactory.createEntityManager();
	       entityManager.getTransaction().begin();
	       entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
	       entityManager.getTransaction().commit();
	       entityManager.close();
	   }

	   public void close() {
	       entityManagerFactory.close();
	   }
	}

