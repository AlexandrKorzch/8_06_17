package com.korzh.user.collectionviews.model;

/**
 * Created by user on 08.06.17.
 */

public class FirstModel extends Model{

    private String mText;

    public FirstModel(long mId, String mText) {
        super(mId);
        this.mText = mText;
    }

    public String getmText() {
        return mText;
    }
}
