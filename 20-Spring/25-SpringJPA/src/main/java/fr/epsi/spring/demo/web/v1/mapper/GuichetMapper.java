package fr.epsi.spring.demo.web.v1.mapper;

import fr.epsi.spring.demo.entity.GareEntity;
import fr.epsi.spring.demo.entity.GuichetEntity;
import fr.epsi.spring.demo.web.v1.dto.Gare;
import fr.epsi.spring.demo.web.v1.dto.Guichet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuichetMapper {
    Guichet guichetEntityToGuichet(GuichetEntity guichet);
}
