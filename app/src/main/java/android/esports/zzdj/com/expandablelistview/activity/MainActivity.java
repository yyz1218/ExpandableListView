package android.esports.zzdj.com.expandablelistview.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.esports.zzdj.com.expandablelistview.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_simple).setOnClickListener(this);
        findViewById(R.id.btn_normal).setOnClickListener(this);
        findViewById(R.id.btn_indicator).setOnClickListener(this);
        findViewById(R.id.btn_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_normal) {
            startActivity(new Intent(this, NormalExpandActivity.class));
        } else if (id == R.id.btn_indicator) {
            startActivity(new Intent(this, IndicatorExpandActivity.class));
        } else if(id== R.id.btn_simple){
            startActivity(new Intent(this, SimpleExpandActivity.class));
        }else if(id == R.id.btn_list){
            startActivity(new Intent(this, ExpandListActivity.class));
        }
    }

}
