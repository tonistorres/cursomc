package br.com.inove.conhecimento.cursomc.repositories;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inove.conhecimento.cursomc.domain.Categoria;

/**
 * CAMADA DE ACESSO A DADOS(Objetos Repository/DAO) - A responsabilidade dessa
 * Camada é conversar com o Banco de Dados(Incluir,Alterar,Excluir,Selecionar).
 * A CAMADA DE SERVIÇO irá utilizar a CAMADA DE ACESSO A DADOS para realizar
 * regras de negócio. LINK
 * AULA:https://www.udemy.com/course/spring-boot-ionic/learn/lecture/8090536#overview
 */
//OBSERVAÇÕES IMPORTANTES Check-List(s):
//1º Ponto Importante:Colocar a Anotação @Repository conforme expresso logo abaixo;
//2º Ponto Importante: Transformaremos essa Classe em uma interface que irá herdar(extends)
//                     de ma outra Interface chamada jpaRepository; 

@Repository
/**
 * Nesta interface que extends JpaRepository no tipo
 * JpaRepository<Categoria,XXXX> o tipo identificador deve ser colocado como
 * segundo parametro depois de categoria neste Caso em especifico foi o Integer
 * porque na Classe de dominio Categoria a anotação
 * 
 * @Id
 * @GeneratedValue(strategy = GenerationType.IDENTITY) está em cima de id que é
 *                          do tipo Integer
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
