package fr.epsi.spring.demo.web.v1.mapper;

import fr.epsi.spring.demo.web.v1.dto.Gare;
import fr.epsi.spring.demo.entity.GareEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GareMapper {

    Gare gareEntityToGare(GareEntity gare);

    GareEntity gareToGareEntity(Gare gare);
}
