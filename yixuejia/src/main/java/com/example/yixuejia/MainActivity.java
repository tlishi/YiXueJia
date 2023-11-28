package com.example.yixuejia;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Button btn_login;
    Fragment fragment1,fragment2,fragment3,fragment4,fragment5;
    int transaction;
    FragmentManager manager;

    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        //将五个Fragment和导航栏中的五个创建联系，使用findViewbyId()对应导航栏中五个部分的id
        linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);
        linearLayout3=findViewById(R.id.layout3);
        linearLayout4=findViewById(R.id.layout4);
        linearLayout5=findViewById(R.id.layout5);

        manager=getSupportFragmentManager();

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
        fragment5=new Fragment5();

        initial();
        fragmentHide();
        showfragment(fragment1);


        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        linearLayout5.setOnClickListener(this);


    }

    /**
     * 新建init()函数用于Fragment页面初始化
     */
    public void initial(){
        transaction=manager.beginTransaction()
                .add(R.id.content,fragment1)
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                .add(R.id.content,fragment4)
                .add(R.id.content,fragment5)
                .commit();
    }

    /**
     * 由于每一次点击图标后，页面展现的是隐藏当前的界面，展示点击图标对应的界面
     * 新建showfragment展示界面
     */
    private void showfragment(Fragment fragment) {
        transaction=manager.beginTransaction()
                .show(fragment)
                .commit();
    }

    /**
     * 新建fragmentHide隐藏界面
     */
    public void fragmentHide(){
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .hide(fragment5)
                .commit();
    }

    /**
     * 设置监听程序，完成点击图标时触发事件，并使用switch完成点击不同的图标展现不同的界面
     */

    @Override
    public void onClick(View view) {
        fragmentHide();
        int id = view.getId();
        //先前想着用switch,由于要求case紧跟常量，因此选用if
        if(id == R.id.layout1) showfragment(fragment1);
        if(id == R.id.layout2) showfragment(fragment2);
        if(id == R.id.layout3) showfragment(fragment3);
        if(id == R.id.layout4) showfragment(fragment4);
        if(id == R.id.layout5) showfragment(fragment5);

    }



}