package com.wd.doctor.adapter.wy

import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.R
import org.jetbrains.anko.toast

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/20 20:25
 * @classname :RecyclerViewMe
 */
class RecyclerViewMe : RecyclerView.Adapter<RecyclerViewMe.MyHolder> {
    private var list: List<String> = ArrayList()
    private var context: Context
    constructor(list: List<String>, context: Context) : super() {
        this.list=(list)
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = View.inflate(context, R.layout.item_me, null)
        val myHolder = MyHolder(view)
        return myHolder
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvItemMeWy.setText(list.get(position))
        if(position==0){
            val resources = context.resources
            val decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.wenzhen)
            holder.imgItemMeWy.setImageBitmap(decodeResource)
        }else if(position==1){
            val resources = context.resources
            val decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.qianbao)
            holder.imgItemMeWy.setImageBitmap(decodeResource)
        }else if(position==2){
            val resources = context.resources
            val decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.beicainayijian)
            holder.imgItemMeWy.setImageBitmap(decodeResource)
        }else if(position==3){
            val resources = context.resources
            val decodeResource = BitmapFactory.decodeResource(resources, R.mipmap.zidonghuifu)
            holder.imgItemMeWy.setImageBitmap(decodeResource)
        }
        //点击
        holder.itemView.setOnClickListener {
            context.toast("跳转")
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // !! 断言
        var imgItemMeWy: ImageView = itemView.findViewById(R.id.imgItemMeWy)
        var tvItemMeWy: TextView = itemView.findViewById(R.id.tvItemMeWy)
    }
}