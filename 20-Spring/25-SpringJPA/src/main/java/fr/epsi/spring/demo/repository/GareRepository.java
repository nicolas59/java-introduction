package fr.epsi.spring.demo.repository;

import fr.epsi.spring.demo.entity.GareEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GareRepository extends CrudRepository<GareEntity, Long>, PagingAndSortingRepository<GareEntity, Long> {

    @Query("from GareEntity ge where ge.adresse.commune=?1")
    List<GareEntity> findGareByVille(String commune);
}
