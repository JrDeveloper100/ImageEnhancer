package com.example.imageenhancer

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val REQUEST_IMAGE_SELECTION = 1
    private lateinit var imageView: ImageView
    private var buttonNo = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView= findViewById(R.id.imageView)
        val improveColors: Button = findViewById(R.id.btnSelectImage)
        val sharpBlack: Button = findViewById(R.id.btnSelectImage2)
        val blackAndWhite: Button = findViewById(R.id.btnSelectImage3)

        improveColors.setOnClickListener {
            buttonNo = 1
            openGallery()
        }
        sharpBlack.setOnClickListener {
            buttonNo = 2
            openGallery()
        }
        blackAndWhite.setOnClickListener {
            buttonNo = 3
            openGallery()
        }

    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_SELECTION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_SELECTION && resultCode == RESULT_OK && data != null){
            val imageUri: Uri? = data.data
            if (imageUri != null){
                if (buttonNo==1){
                    ImageEnhancer.improveColors(this,imageUri,imageView)
                }else if (buttonNo==2){
                    ImageEnhancer.sharpBlack(this,imageUri,imageView)
                }else{
                    ImageEnhancer.BlackandWhite(this,imageUri,imageView)
                }
                Toast.makeText(this,"Image Quality Has been Improved",Toast.LENGTH_SHORT).show()
            }
        }
    }

}