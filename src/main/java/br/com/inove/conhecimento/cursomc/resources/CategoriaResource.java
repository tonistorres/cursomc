package br.com.inove.conhecimento.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.inove.conhecimento.cursomc.domain.Categoria;
import br.com.inove.conhecimento.cursomc.services.CategoriaService;

/**
 * CAMADA RESOURCES (Camada dos famosos Controladores REST)- é a camada mais
 * próxima da aplicação onde congiguramos os métodos que serão invocados pelos
 * EndPoints. Criamos uma Classe que vai ser um Controlador REST e ela irá
 * responder pelo End Point relativo a Categoria. 17min:23s
 * AULA:https://www.udemy.com/course/spring-boot-ionic/learn/lecture/8090536#overview
 */

@RestController // Controlador REST
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired // Importante a Notação desse Objeto(@Autowired) Essa anotação faz a
	// Instanciação do Objeto de uma classe. Funciona como
	// se fosse CategoriaRepository cat=new CategoriaRepository() isso é feito
	// automaticamente pelo Spring no momento que coloco essa anotação pelo
	// mecanismo de injeção de dependência;
	private CategoriaService service;

	// método buscar por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	/**
	 * Essa Anotação @PathVariable indica ao método find() que receba um id que virá
	 * numa URL. Esse método irá retornar um objeto mais sofisticado chamado
	 * ResponseEntity<?> (Esse tipo Especial aqui do Spring já Encapsula
	 * (armazena)varias informações de uma resposta Http para um serviço REST) o
	 * parametro ? significa que pode ser de qualuer tipo, pois, pode encontrar ou
	 * não essa resposta... )
	 */
	public ResponseEntity<?> find(@PathVariable Integer id) {
		/**
		 * Agora iremos declarar uma Categoria obj recebendo esse serviço .(PONTO) o
		 * método find(id) definido dentro de CategoriaService
		 */
		Categoria obj = service.find(id);
		/**
		 * Agora vou mandar meu método retorna um objeto do tipo Especial ResponseEntity
		 * que possui um método ok() para dizer se deu tudo certo na requisição e
		 * retornando o objeto obj que foi buscado no banco de dados pelo método
		 * find(id)
		 */
		return ResponseEntity.ok().body(obj);
	}

}
