package com.gabrielbenini.api.ecommerceapi.dtos;

public record ProdutoRequestDTO(String name, String description, double price, int stock, String imageUrl) {
}
