package com.moviefeel.helper.image;

import java.io.File;
import android.content.Context;
  
/**
 * Class that saves the images retrieved from an url to a file cache in order to improve efficiency
 * @author Vlad
 *
 */
public class FileCache {
  
    private File cacheDir;
  
    public FileCache(Context context){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"TempImages");
        else
            cacheDir=context.getCacheDir();
        if(!cacheDir.exists())
            cacheDir.mkdirs();
    }
  
    public File getFile(String url){
        String filename=String.valueOf(url.hashCode());
        File f = new File(cacheDir, filename);
        return f;
  
    }
  
    public void clear(){
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        for(File f:files)
            f.delete();
    }
  
}