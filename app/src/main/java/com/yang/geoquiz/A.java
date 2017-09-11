package com.yang.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class A extends AppCompatActivity {
    private TextView tv_show;
    private EditText et_write;
    private Button bt_send;
    private static final int SEND=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        et_write=(EditText)findViewById(R.id.et_write);
        bt_send=(Button)findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent=new Intent(A.this,B.class);
                startActivity(intent);*/
                String context=et_write.getText().toString();
                Intent intent=B.newIntent(A.this,context);
                //startActivity(intent);
                startActivityForResult(intent,SEND);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode!=1){
            return;
        }
        if(requestCode==SEND){
            if(data==null){
                return;
            }
            tv_show=(TextView)findViewById(R.id.tv_show);
            tv_show.setText(data.getStringExtra("MESSAGE"));
        }
    }
}
