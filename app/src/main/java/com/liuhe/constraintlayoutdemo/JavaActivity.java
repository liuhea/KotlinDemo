package com.liuhe.constraintlayoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuhe.extendPac.ExtendBean;

/**
 * @author liuhe
 * @date 2017/12/7
 */
public class JavaActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_rcy_case);
        ImageView logo = findViewById(R.id.img_demo2_logo);
        TextView price = findViewById(R.id.txt_demo2_price);


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(JavaActivity.this, "java logo clicked", Toast.LENGTH_SHORT).show();
            }
        });

        getFragmentManager().getFragments();
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();


        new Thread(() -> Log.d("JavaActivity", "dd")).start();


        price.setOnClickListener((View v) -> Toast.makeText(this, "price clicked", Toast.LENGTH_SHORT).show());
    }
}
