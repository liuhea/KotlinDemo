package com.liuhe.constraintlayoutdemo

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.support.v7.widget.RecyclerView
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
        fun Activity.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(this, msg, length).show()
        }
        fun Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(getActivity(), message, duration).show()
        }


        fun Context.loadImage(imageView: ImageView, url: String) {
            Glide.with(this).load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .crossFade().into(imageView)
        }
    }
}
