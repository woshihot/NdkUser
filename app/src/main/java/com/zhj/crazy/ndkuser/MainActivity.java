package com.zhj.crazy.ndkuser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.zhj.crazy.ndklib.NdkUserInterface;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.index_ndk_str_tv)
    TextView indexNdkStrTv;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = MainActivity.this;
    }

    @OnClick(R.id.index_ndk_str_tv)
    public void onClick() {

        String ndkStr = NdkUserInterface.getInstance().getNdkString();
        indexNdkStrTv.setText(ndkStr);
        Toast.makeText(context, ndkStr, Toast.LENGTH_SHORT).show();
    }

}
