package com.springboot.SpringbootDockerk8.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    public CompanyController() {
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompany() {
        return ResponseEntity.ok(companyService.findAllCompany());

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable Long id) {
        boolean companies = companyService.updateCompany(company, id);
        if (companies) {
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompany(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Company is not found", HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }
}