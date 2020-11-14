package com.hsk.datepickerdialog_201812311;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSelectDate, btnSelectTime, btnSelectNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectDate = (Button) findViewById(R.id.button1);
        btnSelectTime = (Button) findViewById(R.id.button2);
        btnSelectNumber = (Button) findViewById(R.id.button3);
    }

    public void onClick(View v) {
        if (v == btnSelectDate) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btnSelectDate.setText(String.format("%d/%d/%d", dayOfMonth, month + 1, year));
                }
            }, mYear, mMonth, mDay);
            dialog.show();
        } else if (v == btnSelectTime) {
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    btnSelectTime.setText(String.format("%d:%d", hourOfDay, minute));
                }
            }, mHour, mMinute, false);
            dialog.show();
        } else if (v == btnSelectNumber) {
            final Dialog dialog = new Dialog(this);                               // Dialog 객체 생성
            dialog.setContentView(R.layout.custom_dialog);                               // Dialog의 content view 설정

            final EditText numberEditText = dialog.findViewById(R.id.edit_text_number);  // Dialog에서 인원 수를 입력하는 EditText 객체
            Button okButton = dialog.findViewById(R.id.button_ok);                       // Dialog의 OK 버튼
            okButton.setOnClickListener(new View.OnClickListener() {                     // OK 버튼을 클릭했을 때 다음을 수행
                @Override
                public void onClick(View v) {
                    String numberString = numberEditText.getText().toString();           // EditText로부터 문자열을 가져옴
                    dialog.hide();                                                       // Dialog를 숨기고
                    btnSelectNumber.setText(numberString);                               // 인원 설정 버튼의 텍스트를 바꿈
                }
            });
            Button cancelButton = dialog.findViewById(R.id.button_cancel);               // Dialog의 Cancel 버튼
            cancelButton.setOnClickListener(new View.OnClickListener() {                 // Cancel 버튼을 클릭했을 때 다음을 수행
                @Override
                public void onClick(View v) {
                    dialog.hide();                                                       // Dialog를 숨김
                }
            });
            dialog.show();                                                               // Custom dialog를 보여줌
        }
    }
}