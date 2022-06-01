package allurerReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Tutorial.base.TestBase;

import io.qameta.allure.Attachment;

public   class AllureListener implements ITestListener{

	private static String getMethodTestName(ITestResult itestResult) {
		return itestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value="{0}", type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	
	@Override
	public void onTestFailure(ITestResult itestResult) {
		
		System.out.println("I am in onTestFailureMethod "+ getMethodTestName(itestResult)+" failed");
		
		Object testClass=itestResult.getInstance();
		WebDriver driver =((TestBase)testClass).getDriver();
		
		if (driver instanceof WebDriver) {
			System.out.println("ScreenShot captured for test case: "+getMethodTestName(itestResult));
		saveFailureScreenShot(driver);
		}
		saveTextLog(getMethodTestName(itestResult)+" failed and screenshot taken");	
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
