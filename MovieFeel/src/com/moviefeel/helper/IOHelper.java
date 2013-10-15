package com.moviefeel.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Context;

public class IOHelper {
	private Activity act;

	public IOHelper(Activity a) {
		this.act = a;
	}

	public void saveList(String outputFilename, String message) {

		try {
			FileOutputStream fos = act.openFileOutput(outputFilename,
					Context.MODE_PRIVATE);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(message);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String restoreList(String inputFilename){
		
		try{
			String message = "";
			FileInputStream fis = act.openFileInput (inputFilename);
			ObjectInputStream ois = new ObjectInputStream(fis);

			message =  ois.readObject().toString();

			ois.close();
			return message;

		}catch (Exception e){

			return null;
		}

	}

}
