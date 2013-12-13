
package com.android.loveusingcar.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.loveusingcar.R;


public class AccountInfoFragment extends Fragment {
    TextView usernameTV;
    TextView phoneTV;
    TextView ageTV;
    TextView sexTV;
    private View view;
    private static final String TAG = "AccountInfoFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if(null == view){
            view = inflater.inflate(R.layout.account_info, container,false);
            usernameTV = (TextView) view.findViewById(R.id.account_username);
            phoneTV = (TextView) view.findViewById(R.id.account_phone);
            ageTV = (TextView) view.findViewById(R.id.account_age);
            sexTV = (TextView) view.findViewById(R.id.account_sex);
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
