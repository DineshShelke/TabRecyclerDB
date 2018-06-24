package com.example.shree.tabrecyclerdb;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


public class TabFragment1 extends Fragment implements View.OnClickListener {

    private EditText etName,etEmail,etPassword;
    private Button button;
    private DbHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);

        etName = view.findViewById(R.id.editText);
        etEmail = view.findViewById(R.id.editText2);
        etPassword = view.findViewById(R.id.editText3);

        button = view.findViewById(R.id.button);
        button.setOnClickListener(this);
        dbHelper = new DbHelper(getContext());

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                dbHelper.addName(etName.getText().toString(),
                        etEmail.getText().toString(),
                        etPassword.getText().toString());
        }
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
       super.setUserVisibleHint(isVisibleToUser);
       if (isVisibleToUser) {
           Log.i(TAG, String.valueOf(isVisibleToUser));
       }
    }
}