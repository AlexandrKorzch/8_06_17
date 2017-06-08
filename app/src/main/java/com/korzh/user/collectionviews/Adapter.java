package com.korzh.user.collectionviews;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.korzh.user.collectionviews.callback.ItemCallBack;
import com.korzh.user.collectionviews.model.FirstModel;
import com.korzh.user.collectionviews.model.Model;
import com.korzh.user.collectionviews.model.SecondModel;

import java.util.List;

/**
 * Created by user on 08.06.17.
 */

public class Adapter extends BaseAdapter {

    private static final String TAG = "Adapter";

    private List<Model> mModels;
    private LayoutInflater mLayoutInflater;
    private ItemCallBack mItemCallBack;

    public Adapter(Context context, List<Model> models) {
        Log.d(TAG, "Adapter: mModels - "+models.size());
        mModels = models;
        mLayoutInflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItemCallBack = (ItemCallBack) context;
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: "+mModels.size());
        return mModels.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView() called with: position = [" + position + "], convertView = [" + convertView + "]");

        ViewHolder viewHolder;
        TextView textView;

        if(convertView == null){

            if(mModels.get(position) instanceof SecondModel){
                convertView =  mLayoutInflater.inflate(R.layout.first_item, parent, false);
            }else{
                convertView =  mLayoutInflater.inflate(R.layout.second_item, parent, false);
            }

            viewHolder = new ViewHolder(convertView);
        }


//        textView
//
//        textView.setText("sdfsdfsdf");


        mItemCallBack.position(position);

        return convertView;
    }



    private static class ViewHolder{

        private TextView textView;

        public ViewHolder(View convertView) {
            textView = (TextView) convertView.findViewById(R.id.tv_text);
        }

        public TextView getTextView() {
            return textView;
        }
    }






    @Override
    public long getItemId(int position) {
        return mModels.get(position).getmId();
    }

    @Override
    public Object getItem(int position) {
        return mModels.get(position);
    }

//    @Override
//    public int getItemViewType(int position) {
//        Log.d(TAG, "getItemViewType: "+ ((mModels.get(position).getmId()%2) == 0 ? 0 : 1));
//        return mModels.get(position).getmId()%2 == 0 ? 0 : 1;
//    }

//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }
}
