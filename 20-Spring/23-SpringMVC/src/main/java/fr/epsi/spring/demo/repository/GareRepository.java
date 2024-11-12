package fr.epsi.spring.demo.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.epsi.spring.demo.domain.Gare;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Page<Gare> findAll(Pageable pageable){
        return new PageImpl<>(gares.subList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageNumber() * pageable.getPageSize() + pageable.getPageSize()), pageable, gares.size());
    }

    public Optional<Gare> findById(Long id){
        return gares.stream()
                .filter(gare -> Objects.equals(gare.getId(),id))
                .findFirst();
    }

    public void save(Gare gare){
        Long id = this.gares.stream().map(Gare::getId).max(Long::compareTo).orElseThrow() + 1L;
        this.gares = new ArrayList<>(this.gares);
        gare.setId(id);
        gares.add(gare);
    }
}
