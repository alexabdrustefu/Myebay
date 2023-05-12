package it.prova.myebay.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.myebay.dto.utente.UtenteDTO;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Categoria;

public class AnnuncioDTO {

	private Long id;

	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;
	@NotNull(message = "{prezzo.notnull}")
	private Integer prezzo;

	private LocalDate data;

	private Long[] categorieIds;

	public AnnuncioDTO() {

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


	public Long[] getCategorieIds() {
		return categorieIds;
	}

	public void setCategorieIds(Long[] categorieIds) {
		this.categorieIds = categorieIds;
	}

	public AnnuncioDTO id(Long id) {
		this.setId(id);
		return this;
	}

	public AnnuncioDTO testoAnnuncio(String testoAnnuncio) {
		this.setTestoAnnuncio(testoAnnuncio);
		return this;
	}

	public AnnuncioDTO data(LocalDate data) {
		this.setData(data);
		return this;
	}

	public AnnuncioDTO prezzo(Integer prezzo) {
		this.setPrezzo(prezzo);
		return this;
	}

	

	public AnnuncioDTO categorieIds(Long[] ids) {
		this.setCategorieIds(ids);
		return this;
	}

	public static AnnuncioDTO buildAnnuncioDTOFromModel(Annuncio model,boolean includeAnnuncio ) {
		return new AnnuncioDTO().id(model.getId()).testoAnnuncio((String) model.getTestoAnnuncio())
				.prezzo(model.getPrezzo()).data(model.getData())
				.categorieIds(model.getCategorie().stream().map(c -> c.getId()).collect(Collectors.toList())
						.toArray(new Long[] {}));
	}

	public static List<AnnuncioDTO> buildAnnuncioDTOListFromModelList(List<Annuncio> listAnnunci,boolean includeAnnuncio ) {
		return listAnnunci.stream().map(annuncioItem -> {
			return AnnuncioDTO.buildAnnuncioDTOFromModel(annuncioItem,includeAnnuncio);
		}).collect(Collectors.toList());
	}
	
	
	//
	public static List<AnnuncioDTO> createAnnuncioDTOListFromModelList(List<Annuncio> modelListInput,boolean includeAnnuncio) {
		return modelListInput.stream().map(annuncioEntity -> {
			return AnnuncioDTO.buildAnnuncioDTOFromModel(annuncioEntity, includeAnnuncio);
		}).collect(Collectors.toList());
	}
	public Annuncio buildAnnuncioModel() {
		return new Annuncio(this.id, this.descrizione, this.prezzo, this.data, this.categorieIds);
	}

}