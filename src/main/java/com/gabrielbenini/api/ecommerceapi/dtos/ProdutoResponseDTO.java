package com.gabrielbenini.api.ecommerceapi.dtos;

public record ProdutoResponseDTO(Long id, String name, String description, double price, int stock, String imageUrl) {
}
