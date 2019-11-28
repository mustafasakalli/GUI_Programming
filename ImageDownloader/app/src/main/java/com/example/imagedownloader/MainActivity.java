package com.example.imagedownloader;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.BitSet;

public class MainActivity extends AppCompatActivity {


    EditText txtURL;
    Button btnDownload;
    ImageView imgView;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE;
            Manifest.permission.WRITE_EXTERNAL_STORAGE;



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtURL = findViewById(R.id.txtURL);
        btnDownload = findViewById(R.id.btnDownload);
        imgView = findViewById(R.id.imgView);


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        )


                ImageDownloader imgDownloader = new ImageDownloader();
                imgDownloader.execute(txtURL.getText().toString());

            }
        });
    }



    class ImageDownloader extends AsyncTask<String, Integer, Bitmap>{
        @Override
        protected Bitmap doInBackground(String...strings)(
            String fileName = "temp.jpg";
            String imagePath = (Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)).toString() + "/" + fileName; //File will be written to this link
            Bitmap image = download(Strings[0], imagePath);
            return image;

    }
    @Override
    protected void  onPostExecute(Bitmap bitmap){
        super.onPostExecute(bitmap);
        float w = bitmap.getWidth();
        float h = bitmap.getHeight();

        int W = 400;
        int H = (int)((h*W)/w);
        Bitmap.createScaledBitmap(bitmap, W, H, false);
        imgView.setImageBitmap(Bitmap.createScaledBitmap())


    }


        private void download(String strurl, String imagePath) {
            try {
                URL url = new URL(strurl);

                URLConnection connection = url.openConnection();
                connection.connect();

                int fileSize = connection.getContentLength();

                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream output = new FileOutputStream(imagePath);

                int total = 0;


                byte data[] = new byte [1024];

                int size;

                while ((size = input.read(data)) != -1){
                    output.write(data, 0, size);
                    total += size;
                    int percentage = (int)((double)total / fileSize) * 100;
                    publishProgress(percentage );
                }


                output.close();
                input.close();



            }catch (IOException e){
                Log.e("download", strurl, e);
            }
            return BitmapFactory.decodeFile(imagePath);

        }
}
