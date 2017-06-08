package com.korzh.user.collectionviews.model;

/**
 * Created by user on 08.06.17.
 */

public class SecondModel extends Model {



    private String mText;

    public SecondModel(long mId, String mText) {
        super(mId);
        this.mText = mText;
    }


    public String getmText() {
        return mText;
    }

}
