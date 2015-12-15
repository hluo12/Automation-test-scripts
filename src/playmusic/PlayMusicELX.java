/********************author Hongjian Luo*************************/
/************THIS SCRIPT JUST USE FOR ELX************************/
package playmusic;

import java.io.File;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class PlayMusicELX extends UiAutomatorTestCase {
	public void testDemo() throws UiObjectNotFoundException,
			InterruptedException {
		int loopTotal = 25;

		for (int loopCount = 0; loopCount < loopTotal; loopCount++) {// change
																		// the
																		// number
																		// of
																		// the
																		// loopnumber

			int temp2 = loopCount + 1;
			System.out.println("the total number of loops is: " + loopTotal);
			System.out.println("the loop is: " + temp2);
			int countFile = 0;
			String dir = "/sdcard/AudioTest";// the directory of the folder we
												// contain the files.
			File f1 = new File(dir);
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

			// In the All Apps screen, the Settings app is located in
			// the Apps tab. To simulate the user bringing up the Apps tab,
			// we create a UiSelector to find a tab with the text
			// label “Apps”.
			UiObject appsTab = new UiObject(new UiSelector().text("Apps"));

			// Simulate a click to enter the Apps tab.
			appsTab.click();

			// Next, in the apps tabs, we can simulate a user swiping until
			// they come to the Settings app icon. Since the container view
			// is scrollable, we can use a UiScrollable object.
			UiScrollable appViews = new UiScrollable(
					new UiSelector().scrollable(true));

			// Set the swiping mode to horizontal (the default is vertical)
			appViews.setAsHorizontalList();

			// Create a UiSelector to find the Settings app and simulate
			// a user click to launch the app.
			UiObject settingsApp = appViews.getChildByText(new UiSelector()
					.className(android.widget.TextView.class.getName()),
					"Play Music");
			settingsApp.clickAndWaitForNewWindow();
			Thread.sleep(3000);

			// Click the menu of the "Play Music"
			UiDevice handClick = UiDevice.getInstance();
			// menuTab.wait();
			handClick.click(15, 100);
			Thread.sleep(1000);
			UiObject libraryTab = new UiObject(
					new UiSelector().text("My Library"));
			libraryTab.clickAndWaitForNewWindow();

			// Click the "SONGS" and wait 2000 ms
			UiObject SongsTab = new UiObject(new UiSelector().text("SONGS"));
			SongsTab.clickAndWaitForNewWindow(2000);
			// count the number of file in the direction we want and print out
			// the result of the number
			countFile = f1.list().length;
			System.out.println("THE NUMBER OF FILES IS " + countFile);
			// Play the first music in the list of songs
			// and open the main window of the play music
			handClick.click(300, 300);
			Thread.sleep(1500);
			handClick.click(400, 850);
			Thread.sleep(1000);

			for (int i = 0; i < countFile; i++) {// changed the numberof
													// "countFile"
				// seek
				int temp1 = i + 1;
				System.out.println("The No " + temp1 + " song");
				handClick.click(200, 775);
				Thread.sleep(500);
				handClick.click(250, 775);
				Thread.sleep(500);
				handClick.click(300, 775);
				Thread.sleep(500);
				handClick.click(350, 775);
				Thread.sleep(500);
				handClick.click(400, 775);
				Thread.sleep(500);
				handClick.click(500, 775);
				Thread.sleep(500);
				handClick.click(100, 775);
				Thread.sleep(1000);

				// pause and restart the music
				handClick.click(275, 845);
				Thread.sleep(3000);
				handClick.click(275, 845);
				Thread.sleep(1500);

				// back to the main window and back again
				getUiDevice().pressBack();
				getUiDevice().pressBack();
				getUiDevice().pressBack();
				getUiDevice().pressHome();
				allAppsButton.clickAndWaitForNewWindow();
				appsTab.click();
				Thread.sleep(500);
				appViews.setAsHorizontalList();
				Thread.sleep(500);
				settingsApp.clickAndWaitForNewWindow();
				Thread.sleep(500);
				// handClick.click(700,1150);
				// Thread.sleep(500);
				handClick.click(200, 850);
				Thread.sleep(500);
				// handClick.click(300, 1100);
				// Thread.sleep(500);

				// go next
				Thread.sleep(1000);
				handClick.click(375, 850);
				Thread.sleep(1000);
			}

			// stop!!!!!!!
			Thread.sleep(10000);
			handClick.click(275, 845);
			Thread.sleep(1000);
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			Thread.sleep(10000);

			// Validate that the package name is the expected one
			/*
			 * UiObject settingsValidation = new UiObject(new UiSelector()
			 * .packageName("com.google.android.music"));
			 * assertTrue("Unable to detect Settings",
			 * settingsValidation.exists());
			 */

		}

	}
}
