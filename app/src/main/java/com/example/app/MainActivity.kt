package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //保存抽奖名单
    var names= listOf<String>("张三","李四","王麻子","黄五")
    //定时器 每隔一段时间且换一次名字
  lateinit var timer: Timer
    //记录当前索引
    var index=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        //设置默认显示第一个人
        mNameTextView.text=names[index]
        //响应点击事件
        mStartBtn.setOnClickListener{
            //判断标题是start还是stop
            if(mStartBtn.text.toString()=="start"){
                mStartBtn.text="stop"
                //创建定时器
                timer=Timer()
                //设置分配一个定时任务
                timer.schedule(object: TimerTask(){
                    override fun run() {
                        //判断是否越界

                        if(index+1>names.size-1){
                            index=0
                        }else{
                            index++
                        }
                        //取出对应的名字
                        mNameTextView.text=names[index]
                        //改变索引值
                    }
                },0,100)
            }else{
                mStartBtn.text="start"
                timer.cancel()
            }
        }
    }
}