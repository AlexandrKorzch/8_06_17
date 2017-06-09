package com.korzh.user.collectionviews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.korzh.user.collectionviews.R;
import com.korzh.user.collectionviews.callback.RecyclerCallback;
import com.korzh.user.collectionviews.model.FirstModel;

import java.util.List;

/**
 * Created by user on 09.06.17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private final RecyclerCallback mCallBack;
    private List<FirstModel> mModels;

    public RecyclerAdapter(List<FirstModel> mModels, RecyclerCallback callback) {
        this.mModels = mModels;
        this.mCallBack = callback;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = viewType == 0 ? R.layout.first_item : R.layout.image_item;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        if(holder.mTextView != null){
            holder.mTextView.setText(mModels.get(position).getmText());
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.clickOnPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 0 : 1;
    }


    static class Holder extends RecyclerView.ViewHolder{
        View view;
        TextView mTextView;
        ImageView mImageView;
        Holder(View itemView) {
            super(itemView);
            view = itemView;
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
            mImageView = (ImageView) itemView.findViewById(R.id.img_icon);
        }
    }

}
