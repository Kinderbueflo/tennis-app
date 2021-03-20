package fr.fgirard.tennisapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.fgirard.tennisapp.domain.Surface;

@Repository
public interface SurfaceRepository extends JpaRepository<Surface, Long> {

	public Surface findBySurface(final String surface);
}
