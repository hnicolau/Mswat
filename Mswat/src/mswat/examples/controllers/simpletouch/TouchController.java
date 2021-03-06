package mswat.examples.controllers.simpletouch;

import mswat.controllers.ControlInterface;
import mswat.core.CoreController;
import mswat.interfaces.IOReceiver;
import mswat.touch.TouchPatternRecognizer;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Touch interfacing scheme
 * 
 * @author Andre Rodrigues
 * 
 */
public class TouchController extends ControlInterface implements IOReceiver {
	private final String LT = "TouchController";
	private TouchPatternRecognizer tpr;

	@Override
	public void onReceive(Context context, Intent intent) {

		// Triggered when the service starts
		if (intent.getAction().equals("mswat_init")
				&& intent.getExtras().get("controller")
						.equals("touchController")) {
			
			Log.d(LT, "Touch controller initialised");

			// initialise touch pattern Recogniser
			tpr = new TouchPatternRecognizer();

			// register ioReceiver
			registerIOReceiver();

			// starts monitoring touchscreen
			int deviceIndex = CoreController.monitorTouch();

			// blocks the touch screen
			CoreController.commandIO(CoreController.SET_BLOCK, deviceIndex,
					true);

			// sets automatic highlighting
			 CoreController.setAutoHighlight(true);
		}

	}

	@Override
	public int registerIOReceiver() {
		return CoreController.registerIOReceiver(this);
	}

	@Override
	public void onUpdateIO(int device, int type, int code, int value,
			int timestamp) {

		int touchType;
		if ((touchType = tpr.identifyOnRelease(type, code, value, timestamp)) != -1) {

			switch (touchType) {
			case TouchPatternRecognizer.SLIDE:
				navNext();
				break;
			case TouchPatternRecognizer.TOUCHED:
				selectCurrent();
				break;
			case TouchPatternRecognizer.LONGPRESS: // Stops service
				CoreController.stopService();

				

			}
		}

	}


}
