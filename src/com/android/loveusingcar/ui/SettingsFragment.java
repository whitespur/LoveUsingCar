
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


public class SettingsFragment extends Fragment {
    TextView about;
    TextView problem;
    TextView clause;
    TextView helper;
    TextView version;
    TextView contact;
    Button exit;
    private View view;
    private static final String TAG = "OrderInfoFragmen";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        if(null == view){
            view = inflater.inflate(R.layout.settings, container,false);
            about = (TextView) view.findViewById(R.id.about);
            problem = (TextView) view.findViewById(R.id.problem);
            clause = (TextView) view.findViewById(R.id.clause);
            helper = (TextView) view.findViewById(R.id.helper);
            version = (TextView) view.findViewById(R.id.version);
            exit = (Button) view.findViewById(R.id.exit);
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
