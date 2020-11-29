package br.com.inove.conhecimento.cursomc.repositories;
//INTERFACE DE ACESSO (BOTOES ETC.)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inove.conhecimento.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

}
