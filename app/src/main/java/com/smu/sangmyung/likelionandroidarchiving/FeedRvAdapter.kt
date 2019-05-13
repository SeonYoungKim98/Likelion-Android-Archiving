package com.smu.sangmyung.likelionandroidarchiving

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FeedRvAdapter(val context: Context, val feedList: ArrayList<Feed> ):
    RecyclerView.Adapter<FeedRvAdapter.Holder>(){
    override fun getItemCount(): Int {
            return feedList.size
        }

    override fun onBindViewHolder(holder: FeedRvAdapter.Holder, position: Int){
        holder.bind(feedList[position],context) //Feed 몇 번째를 이 view에 씌우겠다는 역할이다.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder{
        val view = LayoutInflater.from(context).inflate(//레이아웃 인플레이터뷰를 가져오는 역할.//context는 부모가 접근할 수 있게끔
            R.layout.item_feed,parent,false
        )
        return Holder(view)
    }

    inner class Holder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val feedImage: ImageView = itemView.findViewById<ImageView>(R.id.iv_feed)
        val feedName: TextView = itemView.findViewById<TextView>(R.id.tv_name)

        fun bind(feed: Feed, context:Context){
            if(feed.image != ""){   //이미지를 준 경우
                val resourceId = context.resources
                    .getIdentifier(feed.image,"drawable",context.packageName)

                feedImage.setImageResource(resourceId)
            }
            feedName.text = feed.name   //text는 NULL받아도 상관없음.
        }
    }
}
