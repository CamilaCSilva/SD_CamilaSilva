package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {
//	@PersistenceContext
//	private EntityManager em;
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto salvar(Produto p) {
//		p = em.merge( p );
//		return p;
		return repository.save( p );
	}
	
	public Optional<Produto> buscarPeloId(Long id) {
//		Produto produto = em.find(Produto.class, id);
//		return produto;
		return repository.findById(id);
	}
	
	public List<Produto> listar() {
//		List<Produto> listaProduto = em.createQuery("select p from Produto p", Produto.class)
//		.getResultList();
//		return listaProduto;
		return repository.findAll();
	}
	
	public void remover(Produto p) {
//		p = em.merge( p ); // precismos entender o ciclo de vida de entidades
//		em.remove( p );
		repository.delete(p);
	}
}