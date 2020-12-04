package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.dtos.ProductRequestDtos;
import com.example.demo.dtos.ProductResponseDtos;
import com.example.demo.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductResponseDtos toProductDTO(Product product);

    List<ProductResponseDtos> toProductDTOs(List<Product> products);

    Product toProduct(ProductRequestDtos productDTO);
}
