package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;

@Service
@Transactional
public class NotaCompraService {

//	@PersistenceContext
//	private EntityManager em;
	@Autowired
	private NotaCompraRepository notaCompraRepository;
	
	@Autowired
	private NotaCompraItemRepository notaCompraItemRepository;
	
	// nota compra...
	public NotaCompra salvarNotaCompra(NotaCompra nota) {
//		return em.merge( nota );
		return notaCompraRepository.save(nota); 
	}

	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
//		return em.find(NotaCompra.class,  id);
		return notaCompraRepository.findById(id);
	}
	
	public List<NotaCompra> listarNotaCompra() {
//		return em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
		return notaCompraRepository.findAll();
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		Optional<NotaCompra> opNotaCompra = notaCompraRepository.findById(id);
//		NotaCompra nota = em.find(NotaCompra.class, id);
//		nota.getListaNotaCompraItem().size(); // força o carregamento estando em managed
		
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		} else {
			throw new RuntimeException("Nenhum nota compra encontrada");
		}
	}
	
	// nota compra item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
//		return em.merge( item );
		return notaCompraItemRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id){
//		return em.find(NotaCompraItem.class, id);
		return notaCompraItemRepository.findById(id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem() {
//		return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class)
//		.getResultList();
		return notaCompraItemRepository.findAll();
	}
}