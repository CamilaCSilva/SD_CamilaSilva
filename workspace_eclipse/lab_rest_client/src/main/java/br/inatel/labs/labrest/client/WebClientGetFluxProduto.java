package br.inatel.labs.labrest.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;
import reactor.core.publisher.Flux;

public class WebClientGetFluxProduto {
	
	public static void main(String[] args) {	
		
		List<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();
		Flux<ProdutoDTO> fluxProduto = WebClient.create(Constantes.BASE_URL)
			.get()
			.uri("/produto")
			.retrieve()
			.bodyToFlux( ProdutoDTO.class );
		
		fluxProduto.subscribe( p -> listaProduto.add(p) ); //expressao lambda que a cada pedacinho
		// vai adicionando um produto
		
		fluxProduto.blockLast(); // bloquei para mostrar a lista quando todos os pacotes chegarem
		// porque o flux é assincrono (traz um pacote por vez)
		
		System.out.println("Lista de produtos:");
		System.out.println( listaProduto );
	}
}
