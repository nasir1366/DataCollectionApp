package com.example.roomapp.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.example.roomapp.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {
    private static final String TAG = "file_operation";

//    private File extDir;
//    private Context context;
//
//    public FileOperation(Context context){
//        this.context = context;
//        extDir = Environment.getExternalStorageDirectory();
//        Log.i(TAG,"external storage path : "+extDir.getAbsolutePath());
//    }

    public static void copyFile(Context context , String destpath , String srcpath){
        if(!checkExternalStorage())
            return;
        String extdir = Environment.getExternalStorageDirectory().toString();
        File dir = new File(extdir,destpath);
        if(!dir.exists()){
            if(!dir.mkdirs()){
                Log.i(TAG,"Can not create dir");
            }
        }

        int[] imageIDs = {0
//                R.drawable.station1,
//                R.drawable.station2,
//                R.drawable.station3,
//                R.drawable.station4,
//                R.drawable.station5,
//                R.drawable.station6,
//                R.drawable.station7,
//                R.drawable.station8,
//                R.drawable.station9,
//                R.drawable.station10,
//                R.drawable.station11,
//                R.drawable.station12
        };


        for(int i=1 ; i<12 ; i++) {

            Bitmap bm = BitmapFactory.decodeResource( context.getResources(),imageIDs[i]);

            File file = new File(dir, "station" + i+".jpg");
            FileOutputStream outStream = null;

            try {
                outStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.i(TAG,e.getMessage());
                return;
            }
            bm.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            try {
                outStream.flush();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG , e.getMessage());
            }


        }

    }

    public static void loadImageFromFile(ImageView imageView , String path , String filename){
        if(!checkExternalStorage())
            return;

        File extDir = Environment.getExternalStorageDirectory();
        File dir = new File(extDir,path);
        /**اگر در نام فایل ورودی فضای خالی باشد با کاراکتر _ جایگزین میشود*/
        String fileName = filename.replace(' ','_');
        File imgFile = new File(dir,fileName);
        if(!imgFile.exists()){
            Log.i(TAG, "file does not exist");
            return;
        }
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);

    }

    public static void writeFile(String path, String filename, byte[] content){
        if(!checkExternalStorage())
            return;

        File extDir = Environment.getExternalStorageDirectory();
        File dir = new File(extDir,path);
        if(!dir.exists()){
            if(!dir.mkdirs()){
                Log.i(TAG,"Can not create dir");
            }
        }
        String fileName = filename.replace(' ','_');
        File f = new File(dir,fileName);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(content);
            fos.close();
            Log.i(TAG, "file created");

        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "Exeption : "+e.getMessage());
        }

    }

    public static byte[] readFile(String path, String filename){
        byte[] content = new byte[0];
        long filesize;

        if(!checkExternalStorage())
            return content;

        File extDir = Environment.getExternalStorageDirectory();
        File dir = new File(extDir,path);
        /**اگر در نام فایل ورودی فضای خالی باشد با کاراکتر _ جایگزین میشود*/
        String fileName = filename.replace(' ','_');
        File f = new File(dir,fileName);
        if(!f.exists()){
            Log.i(TAG, "file does not exist");
            return content;
        }
        try {
            filesize = f.length();
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(content,0, (int) filesize);
//            StringBuilder sb = new StringBuilder();
//            while (bis.available()!=0){
//                f.length()
//                sb.append((char) bis.read());
//            }
            fis.close();
            bis.close();
            return content;

        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "Exeption : "+e.getMessage());
        }

        return null;
    }

    //    **********************************************************************
    public static boolean checkExternalStorage(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            Log.i(TAG, "Read only storage !");

        }else{
            Log.i(TAG, "Storage is not available");
        }
        return false;
    }

}
