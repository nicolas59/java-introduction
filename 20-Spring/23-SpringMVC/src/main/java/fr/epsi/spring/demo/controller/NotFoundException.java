package fr.epsi.spring.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception levée lorsque la ressource n'existe pas.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends Exception{
}
