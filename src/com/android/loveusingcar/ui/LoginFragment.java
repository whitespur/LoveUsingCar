
package com.android.loveusingcar.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.loveusingcar.R;


public class LoginFragment extends Fragment {
    EditText username;
    EditText password;
    Button login, register;
    boolean result;
    private String url;
    private View view;
    private static final String TAG = "LoginActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if(null == view){
            view = inflater.inflate(R.layout.login, container,false);
            username = (EditText) view.findViewById(R.id.username);
            password = (EditText) view.findViewById(R.id.password);
            login = (Button) view.findViewById(R.id.login);
            register = (Button) view.findViewById(R.id.register);
            login.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                }
            });
            register.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    
                }
            });
        }else{
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
       
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
