package com.liuhe.constraintlayoutdemo

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * @author liuhe
 * @date 2017/12/8
 */
class Utils {
    companion object {
        fun toast(context: Context, msg: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, msg, length).show()
        }

        fun loadImage(context: Context, imageView: ImageView, url: String) {
            Glide.with(context).load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .crossFade().into(imageView)
        }
    }
}
