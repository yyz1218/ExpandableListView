package android.esports.zzdj.com.expandablelistview.activity;

import android.app.Activity;
import android.esports.zzdj.com.expandablelistview.bean.ItemBean;
import android.esports.zzdj.com.expandablelistview.R;
import android.esports.zzdj.com.expandablelistview.adapter.ExpandListAdaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *  anthor yaoyaozhong // FIXME: 2018/8/1
 */
public class ExpandListActivity extends AppCompatActivity {

    private ImageView zz_iv;
    private ListView listview;
    private ExpandListAdaper expandListAdaper;
    private ArrayList<ItemBean> list;
    private Activity activity;
    private boolean isFirstClick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list);
        activity = this;
        initView();
        initData();
    }
    private void initView() {
        zz_iv = findViewById(R.id.zz_iv);
        listview = findViewById(R.id.listview);
    }
    private void initData() {
        zz_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFirstClick==false){
                    expandListAdaper.updateAdapter(true);
                }else{
                    expandListAdaper.updateAdapter(false);
                }
                isFirstClick =!isFirstClick;
            }
        });
        list = new ArrayList<ItemBean>();
        ItemBean itemBean;
        for(int i=0;i<10;i++){
            itemBean = new ItemBean();
            itemBean.setGameName("绝地求生"+i);
            itemBean.setCheck(false);
            list.add(itemBean);
        }
        if(list.size()>3){
            zz_iv.setVisibility(View.VISIBLE);
        }else{
            zz_iv.setVisibility(View.INVISIBLE);
        }
        expandListAdaper = new ExpandListAdaper(this,list,false);
        listview.setAdapter(expandListAdaper);
    }
}
