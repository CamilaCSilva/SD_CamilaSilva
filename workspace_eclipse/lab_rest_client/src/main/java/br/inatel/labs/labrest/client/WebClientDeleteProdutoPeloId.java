package br.inatel.labs.labrest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientDeleteProdutoPeloId {

	public static void main(String[] args) {
		ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
				.delete()
				.uri("/produto/3")
				.retrieve()
				.toBodilessEntity()
				.block(); // faz o subscribe e o block
			
			System.out.println("Produto removido:");
			System.out.println("Status da resposta " + responseEntity.getStatusCode() );
	}
}
