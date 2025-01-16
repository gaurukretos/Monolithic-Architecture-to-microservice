package com.springboot.SpringbootDockerk8.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootDockerk8.job.Job;
import com.springboot.SpringbootDockerk8.job.JobRepository;
import com.springboot.SpringbootDockerk8.job.JobService;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    // private List<Job> jobs = new ArrayList<>();
    private Long id = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        // job.setId(id++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobsById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJob(Long id) {

        try {
            jobRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;

        }

    }

    @Override
    public Boolean updateJob(Long id, Job job) {
        Optional<Job> jobs = jobRepository.findById(id);

        if (jobs.isPresent()) {
            Job jo = jobs.get();
            jo.setDescription(job.getDescription());
            jo.setLocation(job.getLocation());
            jo.setMaxSalary(job.getMaxSalary());
            jo.setMinSalary(job.getMinSalary());
            jo.setTitle(job.getTitle());
            jobRepository.save(jo);
            return true;
        }
        return false;
    }

}
