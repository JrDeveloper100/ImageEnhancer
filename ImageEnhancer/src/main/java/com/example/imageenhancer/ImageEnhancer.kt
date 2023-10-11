package com.example.imageenhancer

import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageEnhancer {

    fun improveColors(context: Context, imageUri: Uri, imageView: ImageView){

        val matrix = ColorMatrix().apply {
            setSaturation(1f) // Reset the saturation
            postConcat(
                ColorMatrix(floatArrayOf(
                1.3f, 0f, 0f, 0f, 0f,
                0f, 1.3f, 0f, 0f, 0f,
                0f, 0f, 1.3f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            ))
            )
        }

        val filter = ColorMatrixColorFilter(matrix)
        imageView.colorFilter = filter
        Glide.with(context)
            .load(imageUri)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)

    }

    fun sharpBlack(context: Context, imageUri: Uri, imageView: ImageView){

        val matrix = ColorMatrix().apply {
            setSaturation(1f) // Reset the saturation
            postConcat(ColorMatrix(floatArrayOf(
                1.3f, 0f, 0f, 0f, -150f,
                0f, 1.3f, 0f, 0f, -150f,
                0f, 0f, 1.3f, 0f, -150f,
                0f, 0f, 0f, 1f, 0f
            )))
        }

        val filter = ColorMatrixColorFilter(matrix)
        imageView.colorFilter = filter
        Glide.with(context)
            .load(imageUri)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)

    }

    fun BlackandWhite(context: Context, imageUri: Uri, imageView: ImageView){

        val matrix = ColorMatrix().apply {
            setSaturation(1f) // Reset the saturation
            postConcat(ColorMatrix(floatArrayOf(
                0.2f, 0f, 0f, 0f, 0f,
                0f, 0.2f, 0f, 0f, 0f,
                0f, 0f, 0.2f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )))
        }

        val filter = ColorMatrixColorFilter(matrix)
        imageView.colorFilter = filter
        Glide.with(context)
            .load(imageUri)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)

    }

}