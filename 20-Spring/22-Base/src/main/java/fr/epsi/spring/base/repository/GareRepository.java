package fr.epsi.spring.base.repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import fr.epsi.spring.base.domain.Gare;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Repository
public class GareRepository {

    private List<Gare> gares;

    private final String file;

    public GareRepository(@Value("${demo.file}") String file) {
        this.file = file;
    }

    @PostConstruct
    public void initialize() {
        try (var reader = new BufferedReader(new InputStreamReader(GareRepository.class.getResourceAsStream(this.file)))) {
            var csvReader = new CsvToBeanBuilder<Gare>(reader)
                    .withType(Gare.class)
                    .withSeparator(';')
                    .build();
            this.gares = csvReader.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Gare> findGareByVille(String ville) {
        return gares.stream().filter(gare -> gare.getLibelle().startsWith(ville)).findFirst();
    }
}
