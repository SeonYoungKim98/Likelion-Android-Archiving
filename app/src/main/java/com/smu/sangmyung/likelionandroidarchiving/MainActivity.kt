package com.smu.sangmyung.likelionandroidarchiving

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList



class MainActivity : AppCompatActivity() {

    var FeedList = arrayListOf<Feed>(
        Feed("flower2", "syKim98")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = FeedRvAdapter(this, FeedList)
        recycler_View.adapter = mAdapter

        //Linear layout을 사용할 것 이다.
        val lm = LinearLayoutManager(this)
        recycler_View.layoutManager = lm

        recycler_View.setHasFixedSize(true)  // 안에 들어가는 네모의 크기를 고정해주겠다.
    }
}
