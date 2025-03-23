package TestNGPractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTestToSolve implements IRetryAnalyzer {
    
    private int count = 0; 
    private final int max = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < max) { 
            count++;
            System.out.println("Retrying test: " + result.getName() + " | Attempt: " + count);
            return true; 
        }
        return false;
    }
}
