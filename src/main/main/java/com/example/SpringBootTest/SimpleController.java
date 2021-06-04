package com.example.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping
    public ResponseEntity<String> simpleGet() {
        return ResponseEntity.ok("CIAO MONDO");
    }


}
