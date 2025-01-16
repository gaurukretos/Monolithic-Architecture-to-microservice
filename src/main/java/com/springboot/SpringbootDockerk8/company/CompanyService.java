package com.springboot.SpringbootDockerk8.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompany();

    void createCompany(Company company);

    boolean updateCompany(Company company, Long id);

    boolean deleteCompany(Long id);

    Company getCompanyById(Long id);

}
