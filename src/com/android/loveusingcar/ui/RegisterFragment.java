
package com.android.loveusingcar.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.loveusingcar.R;


public class RegisterFragment extends Fragment {
    EditText username;
    EditText password;
    EditText age;
    EditText phone;
    RadioGroup sex;
    Button register;
    boolean result;
    private String url;
    private static final String TAG = "RegisterFragment";
    private View view;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if(null == view){
            View view = inflater.inflate(R.layout.register, container,false);
            username = (EditText) view.findViewById(R.id.usernameRegister);
            password = (EditText) view.findViewById(R.id.passwordRegister);
            age = (EditText) view.findViewById(R.id.ageRegister);
            phone = (EditText) view.findViewById(R.id.phoneRegister);
            sex = (RadioGroup) view.findViewById(R.id.sexRegister);
            register = (Button) view.findViewById(R.id.Register);
            register.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    String name = username.getText().toString().trim();
                    String pass = password.getText().toString().trim();
                    String agestr = age.getText().toString().trim();
                    String phonestr = phone.getText().toString().trim();
                    String sexstr = ((RadioButton)getView().findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                    Log.d(TAG, name + "_" + pass + "_" + agestr + "_" + sexstr);
                    if (TextUtils.isEmpty(name)) {// no this name  before
                        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(agestr) || TextUtils.isEmpty(sexstr)) {
                            Toast.makeText(getActivity().getApplicationContext(), "Register failed,please fill in your information completely", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "Regitster failed", Toast.LENGTH_LONG).show();
                        }

                    }
                }
            });
        }else{
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
       
        return view;
    }


}
