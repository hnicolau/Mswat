package mswat.core.calibration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mswat.core.CoreController;
import mswat.core.activityManager.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CalibrationActivity extends Activity {

	ImageButton imageButton;
	private final static String LT = "Calibration";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_calibration);
		// addListenerOnButton();

		setContentView(R.layout.activity_listviewexampleactivity);

		final ListView listview = (ListView) findViewById(R.id.listview);
		String[] values = CoreController.getDevices();

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}
		final ListAdapter ad = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(ad);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {


				CoreController.commandIO(CoreController.SETUP_TOUCH, position, false);
				Intent i = new Intent(getBaseContext(), CalibrationScreen.class);
				startActivity(i);
			}

		});
	}

	/*
	 * public void addListenerOnButton() {
	 * 
	 * imageButton = (ImageButton) findViewById(R.id.imageButton1);
	 * 
	 * imageButton.setOnClickListener(new OnClickListener() {
	 * 
	 * @Override public void onClick(View arg0) {
	 * 
	 * CoreController.stopCalibration(); close();
	 * 
	 * }
	 * 
	 * });
	 * 
	 * }
	 * 
	 * public void close(){ this.finish(); }
	 * 
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.calibration, menu); return true; }
	 */

}
