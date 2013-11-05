package com.moviefeel.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.moviefeel.activities.R;
import com.moviefeel.helper.Constants;
import com.moviefeel.helper.IOHelper;

public class IpAddressDialog {
	
	private Activity act;
	private Dialog dialog;
	private String ipAddress;
	public IpAddressDialog(Activity act){
		this.act = act;
		ipAddress = new IOHelper(act).restoreList(Constants.FILENAME);
		if ( ipAddress == null){
			ipAddress = Constants.DEFAULT_IP_ADDRESS;
		}
		setupDialog();
		dialog.show();
	}
	
	private void setupDialog(){
		dialog = new Dialog(act);
		dialog.setContentView(R.layout.dialog_ip);
		final Button dialogOk = (Button) dialog.findViewById(R.id.btnOkIpAddress);
		final Button dialogCancel = (Button) dialog.findViewById(R.id.btnCancelIpAddress);
		final EditText etDialog = (EditText) dialog.findViewById (R.id.etIpAddress);
		etDialog.setText(ipAddress);
		dialogOk.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {

				if (!etDialog.getText().toString().equals("")){
					new IOHelper(act).saveList(Constants.FILENAME, etDialog.getText().toString());
					dialog.dismiss();
				}
				
			}

		});
		dialogCancel.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {

				dialog.dismiss();
			}

		});
	}

}
