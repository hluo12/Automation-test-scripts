/********************author Hongjian Luo*************************/
package playmusic;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import android.os.SystemClock;

public class PlayNetflix extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException,
			InterruptedException {

		// Simulate a short press on the HOME button.
		getUiDevice().pressHome();

		// We’re now in the home screen. Next, we want to simulate
		// a user bringing up the All Apps screen.
		// If you use the uiautomatorviewer tool to capture a snapshot
		// of the Home screen, notice that the All Apps button’s
		// content-description property has the value “Apps”. We can
		// use this property to create a UiSelector to find the button.
		UiObject allAppsButton = new UiObject(
				new UiSelector().description("Apps"));

		// Simulate a click to bring up the All Apps screen.
		allAppsButton.clickAndWaitForNewWindow();
		
		Thread.sleep(2000);

		// In the All Apps screen, the Settings app is located in
		// the Apps tab. To simulate the user bringing up the Apps tab,
		// we create a UiSelector to find a tab with the text
		// label “Apps”.
		UiObject appsTab = new UiObject(new UiSelector().text("Apps"));

		// Simulate a click to enter the Apps tab.
		appsTab.click();
		//SystemClock.sleep(2000);

		// Next, in the apps tabs, we can simulate a user swiping until
		// they come to the Settings app icon. Since the container view
		// is scrollable, we can use a UiScrollable object.
		UiScrollable appViews = new UiScrollable(
				new UiSelector().scrollable(true));

		// Set the swiping mode to horizontal (the default is vertical)
		appViews.setAsHorizontalList();

		// Create a UiSelector to find the Netflix app and simulate
		// a user click to launch the app.
		UiObject netflixApp = appViews.getChildByText(new UiSelector()
				.className(android.widget.TextView.class.getName()), "Netflix");
		netflixApp.clickAndWaitForNewWindow();
		SystemClock.sleep(3000);

		// create a virtual hand to click
		UiDevice handClick = UiDevice.getInstance();

		// click the menu and "Comedies"
		handClick.click(20, 95);
		SystemClock.sleep(1500);
		handClick.click(300, 650);

		// enter the first movie in this page
		SystemClock.sleep(1000);
		handClick.click(150, 450);
		SystemClock.sleep(3000);
		for (int i = 0; i < 2; i++) {// the loop of we want to play
			// print out which loop now
			int counti = i+1;
			System.out.println("the number of the loop is " + counti);

			// start play the movie
			handClick.click(400, 350);
			System.out.println("start play the movie 1 "+counti);
			SystemClock.sleep(10000);
			System.out.println("start play the movie 2 "+counti );

			// do some operation
			
			
			handClick.click(500, 500);
			SystemClock.sleep(20000);
			handClick.click(500, 500);
			SystemClock.sleep(1000);
			for (int j = 0; j < 10; j++) {
				int countj = j + 1;
				handClick.click(150, 675);// 10 sec seek, 10 times
				SystemClock.sleep(2000);
				System.out.println("sec seek " + countj);
			}
			handClick.click(750, 685);// normal seek
			SystemClock.sleep(2000);
			System.out.println("normal seek 1 " + counti);
			handClick.click(450, 685);// normal seek
			SystemClock.sleep(2000);
			System.out.println("normal seek 2 " + counti);
			handClick.click(590, 685);// normal seek
			SystemClock.sleep(2000);
			System.out.println("normal seek 3 " + counti);
			SystemClock.sleep(7000);// let is play 5000 ms
			System.out.println("playing" + counti);

			// back
			handClick.click(500, 500);
			SystemClock.sleep(100);
			getUiDevice().pressBack();
			SystemClock.sleep(150);

			// add the movie in MyList
			handClick.click(550, 730);
			SystemClock.sleep(1000);

			// drag the menu and enter the next movie
			handClick.drag(16, 1025, 16, 185, 80);
			SystemClock.sleep(200);
			handClick.click(350, 1050);
			 }
			// back and over
			// getUiDevice().pressHome();
			handClick.click(20, 95);
			SystemClock.sleep(200);
			getUiDevice().pressBack();
			System.out.println("The test is over");

			// Validate that the package name is the expected one
			UiObject settingsValidation = new UiObject(
					new UiSelector().packageName("com.netflix.mediaclient"));
			assertTrue("Unable to detect Settings", settingsValidation.exists());

		}
	

}
