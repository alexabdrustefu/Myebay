package it.prova.myebay.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.myebay.model.Categoria;
import it.prova.myebay.model.Utente;

@Entity
@Table(name = "annuncio")
public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "data")
	private LocalDate data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utenteInserimento;

	@ManyToMany
	@JoinTable(name = "annuncio_categoria", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<>();

	public Annuncio(String descrizione, Integer prezzo, LocalDate data, Boolean aperto, Utente utenteInserimento,
			Set<Categoria> categorie) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.data = data;
		this.utenteInserimento = utenteInserimento;
		this.categorie = categorie;
	}

	public Annuncio(Long id, String descrizione, Integer prezzo, LocalDate data, 
			Set<Categoria> categorie) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.data = data;
		this.categorie = categorie;
	}

	public Annuncio() {
		// TODO Auto-generated constructor stub
	}

	public Annuncio(Long id, @NotBlank(message = "{testoannunci.notblank}") String descrizione,
			@NotNull(message = "{prezzo.notnull}") Integer prezzo, LocalDate data, Long[] categorieIds) {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestoAnnuncio() {
		return descrizione;
	}

	public void setTestoAnnuncio(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}