package com.consultaJPA.uri2618.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consultaJPA.uri2618.dto.ImportDTO;
import com.consultaJPA.uri2618.entities.Product;
import com.consultaJPA.uri2618.projections.ImportProjection;

public interface ImportRepository extends JpaRepository<Product, Long>{

    @Query(nativeQuery = true, value = "SELECT products.name AS nameProduct, providers.name AS nameProvider, categories.name AS nameCategory " + 
                "FROM products " + 
                "INNER JOIN providers ON providers.id = products.id_providers " + 
                "INNER JOIN categories ON categories.id = products.id_categories " + 
                "WHERE providers.name = :prov AND categories.name = :cat")
    List<ImportProjection> search1(String prov, String cat);

    @Query("SELECT new com.consultaJPA.uri2618.dto.ImportDTO(obj.name, obj.provider.name, obj.category.name) FROM Product obj WHERE obj.provider.name = :prov AND obj.category.name = :cat")
    List<ImportDTO> search2(String prov, String cat);
}
