package com.mag.magasin.dao;
import com.mag.magasin.entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MagasinRepository extends JpaRepository<Magasin, Long> {
    public Magasin findByName(String name);
}
