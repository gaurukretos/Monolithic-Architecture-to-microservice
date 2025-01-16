package com.springboot.SpringbootDockerk8.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootDockerk8.company.Company;
import com.springboot.SpringbootDockerk8.company.CompanyRepository;
import com.springboot.SpringbootDockerk8.company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        List<Company> companies = companyRepository.findAll();
        for (Company c : companies) {
            if (c.getId().equals(id)) {
                c.setName(company.getName());
                c.setJobs(company.getJobs());
                c.setDescription(company.getDescription());
                companyRepository.save(c);
                return true;
            }
        }
        return false;

    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public boolean deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company.getId().equals(id)) {
            companyRepository.delete(company);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Company getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company;
    }

}
