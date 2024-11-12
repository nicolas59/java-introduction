package fr.epsi.spring.demo.service;

import fr.epsi.spring.demo.domain.Gare;
import fr.epsi.spring.demo.repository.GareRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GareService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GareService.class);

    private GareRepository gareRepository;

    public GareService(GareRepository gareRepository) {
        this.gareRepository = gareRepository;
    }

    public Optional<Gare> findGareByVille(String ville) {
        LOGGER.debug("Rercherche de la gare commencant par {}", ville);
        return this.gareRepository.findGareByVille(ville);
    }


    public Page<Gare> findAll(Pageable pageable) {
        return this.gareRepository.findAll(pageable);
    }

    public Optional<Gare> findById(Long id) {
        return this.gareRepository.findById(id);
    }

    public void save(Gare gare) {
        this.gareRepository.save(gare);
    }
}
