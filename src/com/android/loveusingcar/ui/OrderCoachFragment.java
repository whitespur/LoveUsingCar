/**
 * 
 */

package com.android.loveusingcar.ui;

import java.util.TimeZone;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.loveusingcar.R;



/**
 * @author jinglong.jjl
 */
public class OrderCoachFragment extends Fragment {
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    private static final String TAG = "OrderCoachFragment";
    private Button mDateButton;
    private Button mTimeButton;
    private Button mOrderButton;
    private Time mTime;
    private String mTimezone = Time.TIMEZONE_UTC;

    private String mPlace;
    private EditText mPlacEditText;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(null == view){
            view = inflater.inflate(R.layout.order_coach, container,false);
            mDateButton = (Button) view.findViewById(R.id.datePicker);
            mTimeButton = (Button) view.findViewById(R.id.timePicker);
            mOrderButton = (Button) view.findViewById(R.id.orderBtn);
            mPlacEditText = (EditText) view.findViewById(R.id.place_edit);

            mTime = new Time();
            mTime.set(System.currentTimeMillis());
            setDate(mDateButton, mTime.toMillis(true));
            setTime(mTimeButton, mTime.toMillis(true));

            mDateButton.setOnClickListener(new OnClickListener() {

                @SuppressWarnings("deprecation")
                @Override
                public void onClick(View arg0) {
                    //showDialog(DATE_DIALOG_ID);
                }
            });
            mTimeButton.setOnClickListener(new OnClickListener() {

                @SuppressWarnings("deprecation")
                @Override
                public void onClick(View v) {
                    //showDialog(TIME_DIALOG_ID);
                }
            });

            mPlacEditText.setText("Hangzhou Yuhang");
            mPlace = mPlacEditText.getText().toString();
            mPlacEditText.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    mPlace = mPlacEditText.getText().toString();
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

                }

                @Override
                public void afterTextChanged(Editable arg0) {

                }
            });
            mOrderButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    
                }
            });
        }else{
            ViewGroup parentGroup = (ViewGroup)view.getParent();
            parentGroup.removeView(view);
        }
       
        return view;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(getActivity().getApplicationContext(), mDateSetListener, mTime.year, mTime.month, mTime.monthDay);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(getActivity().getApplicationContext(), mTimeSetListener, mTime.hour, mTime.minute, true);
            default:
                return null;
        }

    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mTime.year = year;
            mTime.month = monthOfYear;
            mTime.monthDay = dayOfMonth;
            Toast.makeText(getActivity().getApplicationContext(), "year is " + mTime.year, Toast.LENGTH_SHORT).show();
            setDate(mDateButton, mTime.toMillis(true));
        }
    };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mTime.hour = hourOfDay;
            mTime.minute = minute;
            Toast.makeText(getActivity().getApplicationContext(), "hour is " + mTime.hour, Toast.LENGTH_SHORT).show();
            setTime(mTimeButton, mTime.toMillis(true));
        }
    };

    private void setDate(TextView view, long millis) {
        int flags = DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_WEEKDAY | DateUtils.FORMAT_ABBREV_MONTH
                | DateUtils.FORMAT_ABBREV_WEEKDAY;

        String dateString;
        synchronized (TimeZone.class) {
            TimeZone.setDefault(TimeZone.getTimeZone(mTimezone));
            dateString = DateUtils.formatDateTime(getActivity().getApplicationContext(), millis, flags);
            // setting the default back to null restores the correct behavior
            TimeZone.setDefault(null);
        }
        view.setText(dateString);
    }

    private void setTime(TextView view, long millis) {
        int flags = DateUtils.FORMAT_SHOW_TIME;
        if (DateFormat.is24HourFormat(getActivity().getApplicationContext())) {
            flags |= DateUtils.FORMAT_24HOUR;
        }
        millis = millis + 8 * 3600 * 1000;// beijing time

        String timeString;
        synchronized (TimeZone.class) {
            TimeZone.setDefault(TimeZone.getTimeZone(mTimezone));
            timeString = DateUtils.formatDateTime(getActivity().getApplicationContext(), millis, flags);
            TimeZone.setDefault(null);
        }
        view.setText(timeString);
    }
    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
