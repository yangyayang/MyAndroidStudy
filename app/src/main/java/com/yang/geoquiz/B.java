package com.yang.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class B extends AppCompatActivity {
    private TextView tv_showFromA;
    private static final String message="已经发送过了哦";

    public static Intent newIntent(Context packageContext,String context){
        Intent intent=new Intent(packageContext,B.class);
        intent.putExtra("CONTEXT",context);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tv_showFromA=(TextView)findViewById(R.id.tv_showFromA);
        String context=getIntent().getStringExtra("CONTEXT");
        tv_showFromA.setText(context);
        Intent data=new Intent();
        data.putExtra("MESSAGE",message);
        setResult(1,data);
    }

}
