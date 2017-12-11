package com.liuhe.constraintlayoutdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_rcy.*
import kotlinx.android.synthetic.main.item_rcy_case.view.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rcy)
        var layoutManager = LinearLayoutManager(this)
        rcy.layoutManager = layoutManager
        rcy.adapter = RcyAdapter(this)
    }
}


class RcyAdapter(var context: Context) : RecyclerView.Adapter<RcyAdapter.Holder>() {

    override fun getItemCount(): Int {
        return 15
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item_rcy_case, null)
        return Holder(inflate)
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        val case = Case(title = "这是标题:" + position + 1, logoUrl = "https://shejijia-uat.oss-cn-beijing.aliyuncs.com/sjj/1512641479077jphzd868uxqad5j.jpg")
        holder?.logo?.let { Utils.loadImage(context,it, url = case.logoUrl) }
        holder?.title?.text = case.title

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        var logo: ImageView = view.img_demo2_logo
        var title: TextView = view.txt_demo2_title
    }
}

class Case(@JvmField var title: String, @JvmField var logoUrl: String)

