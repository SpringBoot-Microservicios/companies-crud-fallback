package com.debuggeandoideas.companiescrudfallback.controllers;

import com.debuggeandoideas.companiescrudfallback.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;

@RestController
@RequestMapping(path = "company", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CompanyController {

    private static final Company DEFAULT_COMPANY = Company
            .builder()
                .id(0L)
                .founder("Fallback")
                .name("Fallback company")
                .logo("http://default-logo.com")
                .foundationDate(LocalDate.now())
                .webSites(Collections.emptyList())
            .build();

    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("Get company with name {}", name);
        return ResponseEntity.ok(DEFAULT_COMPANY);
    }

}
