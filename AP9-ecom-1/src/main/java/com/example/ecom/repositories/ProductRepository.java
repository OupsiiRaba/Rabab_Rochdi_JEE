package com.example.ecom.repositories;


import com.example.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {

}
