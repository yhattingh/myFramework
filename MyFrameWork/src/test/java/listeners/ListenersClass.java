package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import frameWorkClasses.BasePage;
import frameWorkClasses.Utilities;

public class ListenersClass extends BasePage implements ITestListener {
	
	Utilities utilities = new Utilities();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		// when this method is triggered take a screenshot
		try {
			utilities.takeSnapShot("On test success" + utilities.timeReturn() + ".png");
			System.out.println("Listener:  On test success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		// when this method is triggered take a screenshot
		try {
			utilities.takeSnapShot("On test failure" + utilities.timeReturn() + ".png");
			System.out.println("Listener:  On test failure");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		cleanUp();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
