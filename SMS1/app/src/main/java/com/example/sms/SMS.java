package com.example.sms;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SMS extends Activity {
	
	Button enviar;
	String  mensaje="MENSAJE DE PRUEBA";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		
		enviar=(Button)findViewById(R.id.button1);
		
		enviar.setOnClickListener(new OnClickListener (){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				enviarSMS("15555215554",mensaje);
				
				
				
							
			}

			private void enviarSMS(String telefono, String mensaje) {
				// TODO Auto-generated method stub
				SmsManager sms= SmsManager.getDefault();
				sms.sendTextMessage(telefono, null, mensaje, null, null);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sm, menu);
		return true;
	}

}
