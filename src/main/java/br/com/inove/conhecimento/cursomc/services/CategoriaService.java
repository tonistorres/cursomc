package br.com.inove.conhecimento.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//CAMADA DAO
import org.springframework.stereotype.Service;

import br.com.inove.conhecimento.cursomc.domain.Categoria;
import br.com.inove.conhecimento.cursomc.repositories.CategoriaRepository;
import br.com.inove.conhecimento.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	// esse método retorna um objeto Categoria pelo ID
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
