package android.esports.zzdj.com.expandablelistview.adapter;

import android.content.Context;
import android.esports.zzdj.com.expandablelistview.bean.ItemBean;
import android.esports.zzdj.com.expandablelistview.R;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *  anthor yaoyaozhong // FIXME: 2018/8/1
 */
public class ExpandListAdaper extends BaseAdapter {

    private Context context;
    private ArrayList<ItemBean> list;
    private ArrayList<ItemBean> itemList;
    protected LayoutInflater inflater;
    private boolean isFirst = false;
    private int cellCount;
    public ExpandListAdaper(Context context, ArrayList <ItemBean> list, boolean isFirst) {
         this.context = context;
         inflater = LayoutInflater.from(context);
         this.isFirst = isFirst;
         this.list = list;

    }
    public void updateAdapter(boolean isFirst) {
         this.isFirst = isFirst;
         notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if(isFirst== false){
            return 1;
        }else{
            if(list.size()%3>0) {
                return list.size()/3+1;
            } else {
                return list.size()/3;
            }
        }
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null ) {
            convertView = inflater.inflate(R.layout.list_view_item, null);
            vh = new ViewHolder();
            vh.tv1=(TextView)convertView.findViewById(R.id.tv1);
            vh.tv2=(TextView)convertView.findViewById(R.id.tv2);
            vh.tv3=(TextView)convertView.findViewById(R.id.tv3);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder)convertView.getTag();
        }
        itemList = new ArrayList<>();
        //如果第一次点击
        if(isFirst==false){
            //d大于3只取三个
            if(list.size()>3){
                for(int i=0;i<3;i++){
                    itemList.add(list.get(i));
                }
            }else{
                itemList = list;
            }
        }else{//如果是点击扩展按钮
            int distance =list.size() - position*3;
            cellCount = distance >= 3? 3:distance;
            for(int i=position*3;i<position*3+cellCount;i++){
                itemList.add(list.get(i));
            }
        }
        Log.i("MainActivity",itemList.toString());
        if (itemList.size() >0) {
            vh.tv1.setText(list.get(position*3).getGameName());
            vh.tv1.setVisibility(View.VISIBLE);
            final ViewHolder finalVh = vh;
            vh.tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.get(position*3).isCheck() ==false){
                        finalVh.tv1.setBackgroundResource(R.color.colorPrimary);
                        list.get(position*3).setCheck(true);
                    }else{
                        finalVh.tv1.setBackgroundResource(R.color.colorAccent);
                        list.get(position*3).setCheck(false);
                    }

                }
            });
            if (itemList.size() >1){
                vh.tv2.setVisibility(View.VISIBLE);
                vh.tv2.setText(list.get(position*3+1).getGameName());
                vh.tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(list.get(position*3+1).isCheck() ==false){
                            finalVh.tv2.setBackgroundResource(R.color.colorPrimary);
                            list.get(position*3+1).setCheck(true);
                        }else{
                            finalVh.tv2.setBackgroundResource(R.color.colorAccent);
                            list.get(position*3+1).setCheck(false);
                        }
                    }
                });
            }
            if(itemList.size()>2){
                vh.tv3.setVisibility(View.VISIBLE);
                vh.tv3.setText(list.get(position*3+2).getGameName());
                vh.tv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(list.get(position*3+2).isCheck() ==false){
                            finalVh.tv3.setBackgroundResource(R.color.colorPrimary);
                            list.get(position*3+2).setCheck(true);
                        }else{
                            finalVh.tv3.setBackgroundResource(R.color.colorAccent);
                            list.get(position*3+2).setCheck(false);
                        }
                    }
                });
            }
        }
        return convertView;
    }

    /**
     * 封装ListView中item控件以优化ListView
     * @author tongleer
     */
class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }
}
