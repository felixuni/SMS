package com.example.sms;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context contexto, Intent intento) {
		// TODO Auto-generated method stub
		
		Bundle armador= intento.getExtras();
		
		SmsMessage [] msgs=null;
		
		String str="";
		
		if(armador!=null){
			//si llega el mensaje lo recupera
			Object [] pdus=(Object []) armador.get("pdus");
			
			msgs=new SmsMessage[pdus.length];
			
			for (int i=0;i<msgs.length;i++ ){
				msgs[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
				
				str+="SMS de:"+msgs[i].getOriginatingAddress();
				str+=":";
				str+=msgs[i].getMessageBody().toString();
				
				str+="\n";
				
				}
			//muestra el mensaje de texto
			Toast.makeText(contexto, str, Toast.LENGTH_LONG).show();
			
		}
		
	}
	
	

}
