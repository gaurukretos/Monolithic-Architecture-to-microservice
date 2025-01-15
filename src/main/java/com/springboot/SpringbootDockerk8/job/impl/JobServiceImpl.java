package com.springboot.SpringbootDockerk8.job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.SpringbootDockerk8.job.Job;
import com.springboot.SpringbootDockerk8.job.JobService;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long id = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(id++);
        jobs.add(job);
    }

    @Override
    public Job getJobsById(Long id) {
        for (Job b : jobs) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Boolean deleteJob(Long id) {

        Iterator<Job> iterator = jobs.iterator();

        if (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();

                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateJob(Long id, Job job) {

        for (Job j : jobs) {
            if (j.getId().equals(id)) {
                j.setDescription(job.getDescription());
                j.setLocation(job.getLocation());
                j.setMaxSalary(job.getMaxSalary());
                j.setMinSalary(job.getMinSalary());
                j.setTitle(job.getTitle());
                return true;
            }
        }
        return false;
    }

}
