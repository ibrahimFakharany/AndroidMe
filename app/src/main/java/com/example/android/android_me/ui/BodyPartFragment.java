package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 450 G1 on 27/09/2017.
 */

public class BodyPartFragment extends Fragment {
    private static final String TAG = "BodyPartFragment";
    private static final String IMAGE_LIST = "imageList";
    private static final String LIST_INDEX = "imageListIndex";

    private List<Integer> mImageIDs;
    private int mListIndex;


    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);

        if(savedInstanceState != null){
            mImageIDs = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        final ImageView imageView = (ImageView) view.findViewById(R.id.body_part_imageview);
        if(mImageIDs != null){
            imageView.setImageResource(mImageIDs.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListIndex <= (mImageIDs.size())-1){
                        mListIndex++;

                    }else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIDs.get(mListIndex));
                }
            });
        }else {
            Log.e(TAG, "This fragment has a null of list of image ID's");
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) mImageIDs);
        outState.putInt(LIST_INDEX, mListIndex);
    }

    public void setImageIDs(List<Integer> imageIDs) {
        this.mImageIDs = imageIDs;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

}
