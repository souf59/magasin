package com.mag.magasin.dao;

import com.mag.magasin.entities.Enseigne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnseigneRepostory extends JpaRepository<Enseigne, Long> {
    public Enseigne findByName(String nom);
}
