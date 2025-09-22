package com.consultaJPA.uri2618.dto;

import com.consultaJPA.uri2618.projections.ImportProjection;

public class ImportDTO {

    private String nameProduct;
    private String nameProvider;
    private String nameCategory;
    
    public ImportDTO() {
    }

    public ImportDTO(String nameProduct, String nameProvider, String nameCategory) {
        this.nameProduct = nameProduct;
        this.nameProvider = nameProvider;
        this.nameCategory = nameCategory;
    }

    public ImportDTO(ImportProjection projection) {
        nameProduct = projection.getNameProduct();
        nameProvider = projection.getNameProvider();
        nameCategory = projection.getNameCategory();
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    @Override
    public String toString() {
        return "ImportDTO [nameProduct=" + nameProduct + ", nameProvider=" + nameProvider + ", nameCategory="
                + nameCategory + "]";
    }

}
