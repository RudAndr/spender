package ua.boring.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rudenko Andrey
 * @project project
 */

@RestController
public class MainController {

    @GetMapping(value = {"/", "/index"}, headers = {"Accept=application/json"})
    public ResponseEntity index() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
