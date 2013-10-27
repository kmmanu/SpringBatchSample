package org.manu.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(final String[] args) {

		final GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:applicationContext-batch-sample.xml");
		context.refresh();

		final JobLauncher jobLauncher = (JobLauncher) context
				.getBean("jobLauncher");
		final Job job = (Job) context.getBean("helloWorldJob");

		try {

			final JobExecution execution = jobLauncher.run(job,
					new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (final Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
