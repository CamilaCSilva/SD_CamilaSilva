package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class NotaCompra {

	// construtores...
	public NotaCompra() {
	}

	public NotaCompra(@NotNull @Past LocalDate dataEmissao, Fornecedor fornecedor) {
		super();
		this.dataEmissao = dataEmissao;
		this.fornecedor = fornecedor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Past
	private LocalDate dataEmissao;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "notaCompra")
	private List<NotaCompraItem> listaNotaCompraItem;
	
	// calcula o total da nota somando os totais de cada item
	public BigDecimal getCalculoTotalNota() {
		//basicamente cria uma cópia do array para fazer operações
		BigDecimal totalNota = listaNotaCompraItem.stream()
			.map(i -> i.getCalculoTotalItem())
			.reduce(BigDecimal.ZERO, BigDecimal:: add); //soma o list
		
		return totalNota;
	}
	
	//acessores...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<NotaCompraItem> getListaNotaCompraItem() {
		return listaNotaCompraItem;
	}

	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		this.listaNotaCompraItem = listaNotaCompraItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompra other = (NotaCompra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", dataEmissao=" + dataEmissao + "]";
	}
}
