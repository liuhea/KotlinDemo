package com.liuhe.constraintlayoutdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuhe.constraintlayoutdemo.Utils.Companion.loadImage
import com.liuhe.constraintlayoutdemo.Utils.Companion.toast
import kotlinx.android.synthetic.main.activity_rcy.*
import kotlinx.android.synthetic.main.item_rcy_case.view.*

class KotlinActivity : AppCompatActivity(), OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rcy)
        var layoutManager = LinearLayoutManager(this)
        rcy.layoutManager = layoutManager
        val rcyAdapter = RcyAdapter(context = this, listener = this)
        rcy.adapter = rcyAdapter
    }


    override fun onItemClickListener(position: Int) {
        toast("click->" + position)
    }
}


class RcyAdapter(var context: Context, private val listener: OnItemClickListener) : RecyclerView.Adapter<RcyAdapter.Holder>() {

    override fun getItemCount(): Int {
        return 15
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val inflate = LayoutInflater.from(parent?.context).inflate(R.layout.item_rcy_case, null)
        return Holder(inflate)
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        val case = Case(title = "这是标题:" + (position + 1), logoUrl = "https://shejijia-uat.oss-cn-beijing.aliyuncs.com/sjj/1512641479077jphzd868uxqad5j.jpg")
        holder?.itemView?.img_demo2_logo.let { it?.let { it1 -> context.loadImage(it1, url = case.logoUrl) } }
        holder?.itemView?.txt_demo2_title?.text = case.title
        holder?.itemView?.setOnClickListener({
            listener?.onItemClickListener(position)
        })

    }

    class Holder(view: View) : RecyclerView.ViewHolder(view)
}

//val listener: OnItemClickListener? = null

class Case(@JvmField var title: String, @JvmField var logoUrl: String)

interface OnItemClickListener {
    fun onItemClickListener(position: Int)
}

