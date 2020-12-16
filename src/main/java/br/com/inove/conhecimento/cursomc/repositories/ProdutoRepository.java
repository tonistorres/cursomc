package br.com.inove.conhecimento.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inove.conhecimento.cursomc.domain.Produto;


/**
 * CAMADA DE ACESSO A DADOS(Objetos Repository/DAO) - A responsabilidade dessa
 * Camada é conversar com o Banco de Dados(Incluir,Alterar,Excluir,Selecionar).
 * A CAMADA DE SERVIÇO irá utilizar a CAMADA DE ACESSO A DADOS para realizar
 * regras de negócio.
 * LINK AULA:https://www.udemy.com/course/spring-boot-ionic/learn/lecture/8090536#overview
 */

//OBSERVAÇÕES IMPORTANTES Check-List(s):
//1º Ponto Importante:Colocar a Anotação @Repository conforme expresso logo abaixo;
//2º Ponto Importante: Transformaremos essa Classe em uma interface que irá herdar(extends)
//                     de ma outra Interface chamada jpaRepository; 


@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

}
