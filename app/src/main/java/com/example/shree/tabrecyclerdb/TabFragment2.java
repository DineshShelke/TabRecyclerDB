package com.example.shree.tabrecyclerdb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class TabFragment2 extends Fragment {

    private ArrayList<Data> arrayList = new ArrayList<>();
    private DbHelper dbHelper;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        dbHelper = new DbHelper(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter = new RecyclerAdapter(getActivity());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter.notifyDataSetChanged();

        loadNames();
        return view;
    }


    private void loadNames() {

        arrayList.clear();
        Cursor cursor = dbHelper.getNames();
        if (cursor.moveToFirst()) {
            do {
                Data name = new Data(
                        cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_PASS))
                );
                arrayList.add(name);
            } while (cursor.moveToNext());
        }

        recyclerAdapter.setData(arrayList);
        recyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.i(TAG, String.valueOf(isVisibleToUser));
//            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//            recyclerAdapter = new RecyclerAdapter(getActivity());
//            recyclerView.setAdapter(recyclerAdapter);
//            recyclerView.setHasFixedSize(true);
           // recyclerAdapter.notifyDataSetChanged();
            loadNames();

        }
    }
    
}