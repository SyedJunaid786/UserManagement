package com.layers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.layers.Model.Products;

public interface ProductsRepository extends JpaRepository<Products ,Integer>
{

}
