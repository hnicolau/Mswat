package mswat.examples.controllers.autonav;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

public class CallManagement {
	
	public static void answer(Context context) {
		Log.d("easyphone", "InSecond Method Ans Call");
		// froyo and beyond trigger on buttonUp instead of buttonDown
		Intent buttonUp = new Intent(Intent.ACTION_MEDIA_BUTTON);
		buttonUp.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(
				KeyEvent.ACTION_UP, KeyEvent.KEYCODE_HEADSETHOOK));
		context.sendOrderedBroadcast(buttonUp,
				"android.permission.CALL_PRIVILEGED");
		Intent headSetUnPluggedintent = new Intent(Intent.ACTION_HEADSET_PLUG);
		headSetUnPluggedintent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY);
		headSetUnPluggedintent.putExtra("state", 0);
		headSetUnPluggedintent.putExtra("name", "Headset");
		try {
			context.sendOrderedBroadcast(headSetUnPluggedintent, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
