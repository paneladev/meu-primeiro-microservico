package com.paneladev.meuprimeiromicroservico.repository;

import com.paneladev.meuprimeiromicroservico.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
