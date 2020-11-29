package br.com.inove.conhecimento.cursomc.repositories;
//INTERFACE DE ACESSO (BOTOES ETC.)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inove.conhecimento.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{

}
