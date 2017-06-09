package com.korzh.user.collectionviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.korzh.user.collectionviews.adapter.RecyclerAdapter;
import com.korzh.user.collectionviews.callback.RecyclerCallback;
import com.korzh.user.collectionviews.model.FirstModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerActivity extends AppCompatActivity implements RecyclerCallback {

    private int mManagerType = 0;
    private RecyclerView mRecyclerView;
    private List<FirstModel> mModels = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        fillCollection();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(mModels, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickOnPosition(int position) {
        mManagerType++;
        if(mManagerType % 2 == 0){
            mLayoutManager = new GridLayoutManager(RecyclerActivity.this, 3, OrientationHelper.HORIZONTAL, false);
        }else{
            mLayoutManager = new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL);
        }
        mRecyclerView.setLayoutManager(mLayoutManager);
    }


    private void fillCollection() {
        Random random = new Random();
        int mItemCount = 200;
        for(int i = 0; i< mItemCount; i++){
            int randomInt = random.nextInt();
            mModels.add(new FirstModel(i, String.valueOf(randomInt)));
        }
    }
}
