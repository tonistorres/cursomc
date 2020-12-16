package br.com.inove.conhecimento.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

/**CAMADA DE SERVIÇO(JavaDeskTop CAMADA BO(Busines Object)) -
 *  A camada de Serviço será responsável 
 * por oferecer operações e consultas para os Controladores REST. 
 * Esta Camada de Serviço é uma camada sem contato nenhum com tecnologia
 * especifica, ela apenas implementa regras de negócio que por ventura não
  * tenha sido implementada pela camada de Domínio.
  * OBSERVAÇÕES IMPORTANTES:Essa Classe é um Serviço que Oferece Operações 
  * de Consulta do Objeto do Tipo Categoria.
  * AULA:https://www.udemy.com/course/spring-boot-ionic/learn/lecture/8090536#overview
   */

import org.springframework.stereotype.Service;

import br.com.inove.conhecimento.cursomc.domain.Categoria;
import br.com.inove.conhecimento.cursomc.repositories.CategoriaRepository;
import br.com.inove.conhecimento.cursomc.services.exceptions.ObjectNotFoundException;

@Service // instanciando uma Classe
public class CategoriaService {

	// Criando um método capaz de buscar ma Categoria por Código
	/**
	 * Como implementar um Serviço que busque uma Categoria por id? Bem esse serviço
	 * deverá chamar uma operação no Objeto de Acesso a Dados (CategoriaRepository).
	 * Para isso vou declarar uma dependência de um Objeto do Tipo
	 * CategoriaRepository conforme explicitado logo abaixo
	 */

	@Autowired // Importante a Notação desse Objeto(@Autowired) Essa anotação faz a
	// Instanciação do Objeto de uma classe. Funciona como
	// se fosse CategoriaRepository cat=new CategoriaRepository() isso é feito
	// automaticamente pelo Spring no momento que coloco essa anotação pelo
	// mecanismo de injeção de dependência;
	private CategoriaRepository repo;// dependência do objeto do tipo CategoriaRepository

	public Categoria find(Integer id) {
		/**
		 * Optional<Categoria> obj- irá receber o resultado da busca do método
		 * findByÌd() já existente no objeto instancia (repo) que é da Classe
		 * CategoriaRepository e foi instanciado logo acima, e essa Classe
		 * CategoriaRepository foi transformada em uma interface que herda(extends)
		 * JpaRepository que já tras todos esse método embutido na mesma
		 */
		Optional<Categoria> obj = repo.findById(id);
		/**
		 * Neste ponto retornamos o Objeto buscado pelo método findById(id) e atrelamos
		 * ao método uma exception caso ele não encontre
		 */
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
