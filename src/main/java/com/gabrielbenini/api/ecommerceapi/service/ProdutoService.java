package com.gabrielbenini.api.ecommerceapi.service;

import com.gabrielbenini.api.ecommerceapi.dtos.ProdutoRequestDTO;
import com.gabrielbenini.api.ecommerceapi.dtos.ProdutoResponseDTO;
import com.gabrielbenini.api.ecommerceapi.model.Produto;
import com.gabrielbenini.api.ecommerceapi.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {

        Produto produto = new Produto();
        produto.setName(produtoRequestDTO.name());
        produto.setDescription(produtoRequestDTO.description());
        produto.setPrice(produtoRequestDTO.price());
        produto.setStock(produtoRequestDTO.stock());
        produto.setImageUrl(produtoRequestDTO.imageUrl());

        Produto produtoSalvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getName(),
                produto.getDescription(),
                produto.getPrice(),
                produto.getStock(),
                produto.getImageUrl()
        );
    }

    public List<ProdutoResponseDTO> listarProdutos() {

        return produtoRepository.findAll()
                .stream()
                .map(produto -> new ProdutoResponseDTO(
                        produto.getId(),
                        produto.getName(),
                        produto.getDescription(),
                        produto.getPrice(),
                        produto.getStock(),
                        produto.getImageUrl()
                ))
                .toList();
    }

    public ProdutoResponseDTO buscarProdutoPorId(Long id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getName(),
                produto.getDescription(),
                produto.getPrice(),
                produto.getStock(),
                produto.getImageUrl()
        );
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO){

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produto.setName(produtoRequestDTO.name());
        produto.setDescription(produtoRequestDTO.description());
        produto.setPrice(produtoRequestDTO.price());
        produto.setStock(produtoRequestDTO.stock());
        produto.setImageUrl(produtoRequestDTO.imageUrl());

        Produto produtoAtualizado = produtoRepository.save(produto);

        return new ProdutoResponseDTO(
                produtoAtualizado.getId(),
                produtoAtualizado.getName(),
                produtoAtualizado.getDescription(),
                produtoAtualizado.getPrice(),
                produtoAtualizado.getStock(),
                produtoAtualizado.getImageUrl()
        );
    }

    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produtoRepository.delete(produto);
    }

}
