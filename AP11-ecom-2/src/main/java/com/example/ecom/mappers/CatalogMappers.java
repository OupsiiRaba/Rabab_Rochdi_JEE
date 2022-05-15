package com.example.ecom.mappers;
import com.example.ecom.dtos.CategoryDTO;
import com.example.ecom.dtos.ProductDTO;
import com.example.ecom.entities.Category;
import com.example.ecom.entities.Product;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

/**
 * mapper permet de transferer un obj vers un autre obj
 *
 * */


@Service
public class CatalogMappers {
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO = new ProductDTO();
        //BeanUtils.copyProperties(a,b) : si les objets ont les memes propriétés il fait le transfert (get/set)
        //des copies de a à b
        BeanUtils.copyProperties(product,productDTO);
        productDTO.setCategoryDTO(fromCategory(product.getCategory()));
        return productDTO;
    }
    public Product fromProdcutDTO(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setCategory((fromCategoryDTO(productDTO.getCategoryDTO())));
        return product;
    }

    public CategoryDTO fromCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category,categoryDTO);
        return categoryDTO;
    }

    public Category fromCategoryDTO(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        return category;
    }
}
