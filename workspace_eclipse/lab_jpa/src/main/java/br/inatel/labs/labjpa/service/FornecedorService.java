package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.repository.FornecedorRepository;

@Service
@Transactional
public class FornecedorService {
	
//	@PersistenceContext
//	private EntityManager em;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor salvar(Fornecedor f) {
//		f = em.merge( f );
//		return f;
		return fornecedorRepository.save(f);
	}
	
	public Optional<Fornecedor> buscarPeloId(Long id) {
//		Fornecedor f = em.find(Fornecedor.class, id);
//		return f;
		return fornecedorRepository.findById(id);
	}
	
	public List<Fornecedor> listar(){
//		List<Fornecedor> listaFornecedor = em.createQuery("select f from Fornecedor f", Fornecedor.class)
//				.getResultList();
//		return listaFornecedor;
		return fornecedorRepository.findAll();
	}
	
	public void remover(Fornecedor f) {
//		f = em.merge( f );
//		em.remove( f );
		fornecedorRepository.delete(f);
	}
}
