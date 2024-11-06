package fr.epsi.spring.base.service;

import fr.epsi.spring.base.domain.Gare;
import fr.epsi.spring.base.repository.GareRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
}
