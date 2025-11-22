package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners  implements ITestListener {

    @Override
    public  void onStart(ITestContext arg) {
        System.out.println("Starts Test execution ...." + arg.getName());
    }

    @Override
    public  void onFinish(ITestContext arg) {
        System.out.println("Finish Test execution ...." + arg.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starts Test  ...." + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success ...." + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed ...." + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped ...." + result.getName());
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }


    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
//        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }

}
