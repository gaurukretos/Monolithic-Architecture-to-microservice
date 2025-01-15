package com.springboot.SpringbootDockerk8.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobsById(Long id);

    Boolean deleteJob(Long id);

    Boolean updateJob(Long id, Job job);

}
