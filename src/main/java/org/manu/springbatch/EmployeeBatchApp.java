package org.manu.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBatchApp {
    public static void main(final String[] args) {

        final GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:applicationContext-batch-sample.xml");
        context.refresh();
        // classpath:input/employee.csv

        final JobLauncher jobLauncher = context.getBean("jobLauncher",
                JobLauncher.class);

        final Job empJob = context.getBean("importEmployeeJob", Job.class);

        final Map<String, JobParameter> jobParamMap = new HashMap<String, JobParameter>();
        jobParamMap.put("inputFile", new JobParameter(
                "classpath:input/employee.csv"));

        try {
            final JobExecution execution = jobLauncher.run(empJob,
                    new JobParameters(jobParamMap));
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (final Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }
}
