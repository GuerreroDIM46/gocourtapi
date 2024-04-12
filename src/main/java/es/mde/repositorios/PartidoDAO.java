package es.mde.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import es.mde.entidades.Partido;

@RepositoryRestResource(path = "partidos", itemResourceRel = "partido", collectionResourceRel = "partidos")
public interface PartidoDAO extends JpaRepository<Partido, Long>{

}
