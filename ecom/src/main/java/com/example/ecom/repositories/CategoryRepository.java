package com.example.ecom.repositories;


import com.example.ecom.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
