package org.manu.springbatch.reader;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;

/**
 * @author: Manu
 * Time: 11/29/13 - 8:05 PM
 */
public class StepListner  /*implements StepExecutionListener*/ {
    public void test() {
        System.out.println("Starting the step...");
    }

    //@Override
    //@BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Starting step");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void init() {
        System.out.println("initializing....");
    }

    //@Override
    //@AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("end of step");
        return stepExecution.getExitStatus();
    }
}
