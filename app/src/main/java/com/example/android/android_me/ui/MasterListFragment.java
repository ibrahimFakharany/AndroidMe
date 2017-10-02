package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by 450 G1 on 27/09/2017.
 */

public class MasterListFragment extends Fragment {

    public MasterListFragment() {
    }
    OnItemClickedListener callback;

    public interface OnItemClickedListener{
        void onItemClick(int position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.master_list_gridview);
        gridView.setAdapter(new MasterListAdapter(getActivity(), AndroidImageAssets.getAll()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.onItemClick(position);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{

            callback = (OnItemClickedListener) context;

        }catch (Exception ex){

        }
    }
}
