package com.gabrielbenini.api.ecommerceapi.service;

import com.gabrielbenini.api.ecommerceapi.dtos.ProdutoRequestDTO;
import com.gabrielbenini.api.ecommerceapi.dtos.ProdutoResponseDTO;
import com.gabrielbenini.api.ecommerceapi.model.Produto;
import com.gabrielbenini.api.ecommerceapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

//    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO){
//
//        Produto produto = new Produto();
//        produto.setName(produtoRequestDTO.name());
//        produto.setDescription(produtoRequestDTO.description());
//        produto.setPrice(produtoRequestDTO.price());
//        produto.setStock(produtoRequestDTO.stock());
//        produto.setImageUrl(produtoRequestDTO.imageUrl());
//
//        Produto produtoSalvo = produtoRepository.save(produto);
//
//
//    }

}
