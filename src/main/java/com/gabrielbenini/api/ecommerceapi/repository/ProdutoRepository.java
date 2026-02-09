package com.gabrielbenini.api.ecommerceapi.repository;

import com.gabrielbenini.api.ecommerceapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
