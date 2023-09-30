package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.repository.RelatorioRepository;

public class RelatorioService {

//	@PersistenceContext
//	EntityManager em;
	@Autowired
	private RelatorioRepository repository;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
//		String query = 
//		"""
//			 select new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO "
//			 ( f.razaoSocial "
//			 , sum( i.quantidade * i.valorCompraProduto ) 
//			 ) 
//			 from NotaCompraItem i 
//			 join i.notaCompra n 
//			 join n.fornecedor f 
//			 group by f.razaoSocial 
//		""";
//		 return em.createQuery(query, TotalCompradoPorFornecedorDTO.class)
//		 .getResultList();
		
		return repository.pesquisarTotalCompradoPorFornecedor();
	}

}