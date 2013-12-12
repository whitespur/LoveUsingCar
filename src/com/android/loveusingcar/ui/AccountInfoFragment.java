
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
    TextView trainTime;
    TextView place;
    TextView bookTime;
    TextView money;
    TextView status;
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
            view = inflater.inflate(R.layout.account_info, container,false);
            trainTime = (TextView) view.findViewById(R.id.train_time);
            place = (TextView) view.findViewById(R.id.place);
            bookTime = (TextView) view.findViewById(R.id.book_time);
            money = (TextView) view.findViewById(R.id.money);
            status = (TextView) view.findViewById(R.id.order_status);
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
