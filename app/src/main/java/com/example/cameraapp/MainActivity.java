package com.example.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   Button button;                                       //Declaration
   ImageView imageView;
   static final int CAMERA_PIC_REQUEST = 1024;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_PIC_REQUEST);


            }
        });
    }

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode==CAMERA_PIC_REQUEST && resultCode==RESULT_OK){
            Bitmap image = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(image);
        }
    }
}

