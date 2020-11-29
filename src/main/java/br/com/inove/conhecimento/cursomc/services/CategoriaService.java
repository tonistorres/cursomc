package br.com.inove.conhecimento.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//CAMADA DAO
import org.springframework.stereotype.Service;

import br.com.inove.conhecimento.cursomc.domain.Categoria;
import br.com.inove.conhecimento.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	//esse método retorna um objeto Categoria pelo ID
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
