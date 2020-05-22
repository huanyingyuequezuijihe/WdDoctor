package com.wd.doctor.adapter.wy

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wd.doctor.activity.SickCircleInfoActivity
import com.wd.doctor.bean.wy.FindSickCircleListBean
import com.wd.doctor.net.App.Companion.context
import com.wd.doctor.widget.AskWithinView
import com.wd.doctor.widget.LoadMoreView
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 19:39
 * @classname :RecyclerViewAskWithin
 * recycler内科，条目，适配器
 */
class RecyclerViewAskWithin : RecyclerView.Adapter<RecyclerViewAskWithin.MyHolder>() {
   /* private var list: List<FindSickCircleListBean.Result> = ArrayList()
    private var context : Context*/
    private var isChecked = -1
    //控制一段时间只触发一次事件
    private val lastOnClickTime=0;
    /*constructor(list: List<FindSickCircleListBean.Result>, context: Context) : super() {
        this.list = list
        this.context = context
    }*/
    private var list=ArrayList<FindSickCircleListBean.Result>()
    //更新数据的操作
    fun updateList(list: List<FindSickCircleListBean.Result>?){
        //判个空
        list?.let {
            this.list.clear()//清空
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    //加载更多，在不删除以前啥数据的基础上
    fun loadMore(list:List<FindSickCircleListBean.Result>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //如果是最后一条，就不设置数据了
        if(position==list.size)  return
        //条目数据
        val data = list.get(position)
        val askWithinView = holder.itemView as AskWithinView
        askWithinView.setData(data)
        /*holder.tvTitleAskWithin.setText(list.get(position).title)
        holder.tvAmountAskWithin.setText(""+list.get(position).amount)
        holder.tvDetailAskWithin.setText(list.get(position).detail)
        holder.tvDetailAskWithin.setText(list.get(position).detail)
        val transToString = TimeStampUtil.transToString(list.get(position).releaseTime)
        holder.tvTimeAskWithin.setText(transToString)*/
        //点击  变色
        if (isChecked == position) {
            askWithinView.setBackgroundColor(Color.GREEN)
        } else {
            askWithinView.setBackgroundColor(Color.WHITE)
        }
        //跳转
        val sickCircleId = list.get(position).sickCircleId
        askWithinView.setOnClickListener {
            isChecked = position
            notifyDataSetChanged()
            //第一次点击的时间（上一次）
            val timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - lastOnClickTime > 2000) {
                val intent = Intent()
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context?.let { it1 -> intent.setClass(it1,SickCircleInfoActivity::class.java) }
                val bundle = Bundle()
                bundle.putInt("sickCircleId",sickCircleId)
                intent.putExtras(bundle)
                context?.startActivity(intent)
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size+1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        if(viewType==0){
            //最后一条  加载更多
            val myHolder = MyHolder(LoadMoreView(parent?.context))
            return myHolder
        }else{
            val myHolder = MyHolder(AskWithinView(parent?.context))
            return myHolder
        }
        /* val view = View.inflate(context, R.layout.item_askwithin,null)
         val myHolder = MyHolder(view)
         return myHolder*/
    }
    override fun getItemViewType(position: Int): Int {
        if(position==list.size){
            return 0
        }else{
            return 1
        }
    }
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
       /* var tvTitleAskWithin:TextView=itemView.findViewById(R.id.tvTitleAskWithin)
        var imgAmountAskWithin:ImageView=itemView.findViewById(R.id.imgAmountAskWithin)
        var tvAmountAskWithin:TextView=itemView.findViewById(R.id.tvAmountAskWithin)
        var tvDetailAskWithin:TextView=itemView.findViewById(R.id.tvDetailAskWithin)
        var tvTimeAskWithin:TextView=itemView.findViewById(R.id.tvTimeAskWithin)*/

}