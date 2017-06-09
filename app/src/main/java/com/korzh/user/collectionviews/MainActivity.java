package com.korzh.user.collectionviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.korzh.user.collectionviews.adapter.Adapter;
import com.korzh.user.collectionviews.callback.ItemCallBack;
import com.korzh.user.collectionviews.model.FirstModel;
import com.korzh.user.collectionviews.model.Model;
import com.korzh.user.collectionviews.model.SecondModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ItemCallBack {

    private ListView mListView;
    private List<Model> mModels = new ArrayList<>();
    private int mItemCount = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.list_view);
        fillCollection();

        Adapter adapter = new Adapter(this, mModels);
        mListView.setAdapter(adapter);

    }

    private void fillCollection() {
        Random random = new Random();
        for(int i = 0; i< mItemCount; i++){
            int randomInt = random.nextInt();
            if(randomInt%2 == 0){
                mModels.add(new FirstModel(i, String.valueOf(randomInt)));
            }else{
                mModels.add(new SecondModel(i, String.valueOf(randomInt)));
            }
        }
    }

    @Override
    public void position(int position) {
        Toast.makeText(this, "position - "+position, Toast.LENGTH_SHORT).show();
    }
}
