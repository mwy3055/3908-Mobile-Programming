package com.hsk.activityforresult_201812311;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String INPUT_TEXT1 = "INPUT_TEXT1"; // 첫 번째 문자열 key
    public static final String INPUT_TEXT2 = "INPUT_TEXT2"; // 두 번째 문자열 Key

    static final int GET_STRING = 1;
    TextView textView1; // 첫 번째 문자열을 표시할 TextView
    TextView textView2; // 두 번째 문자열을 표시할 TextView

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        button.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent in = new Intent(MainActivity.this, SubActivity.class); // SubActivity 시작
                startActivityForResult(in, GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) { // 문자열 요청에 대한 결과라면
            if (resultCode == RESULT_OK) { // 결과값이 "완료"라면
                String input1 = data.getStringExtra(INPUT_TEXT1); // Intent에서 첫 번째 문자열을 가져옴
                String input2 = data.getStringExtra(INPUT_TEXT2); // Intent에서 두 번째 문자열을 가져옴
                textView1.setText(input1); // 첫 번쨰 문자열 표시
                textView2.setText(input2); // 두 번쨰 문자열 표시
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}