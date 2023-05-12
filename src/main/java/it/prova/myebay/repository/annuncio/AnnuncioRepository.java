package it.prova.myebay.repository.annuncio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio,Long> {
	@Query("from Annuncio a join fetch a.categorie where a.id= ?1")
	Annuncio findSingleFilmEager(Long id);

}
