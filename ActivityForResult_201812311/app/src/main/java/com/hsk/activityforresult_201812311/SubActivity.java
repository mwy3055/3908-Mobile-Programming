package com.hsk.activityforresult_201812311;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    public static final String INPUT_TEXT = "INPUT_TEXT"; // 두 번째 문자열 Key
    public static final int REQUEST_INPUT = 100; // 두 번째 문자열 Request Code

    EditText edit; // 첫 번째 문자열을 입력할 EditText
    TextView textViewInput2; // 두 번쨰 문자열을 보여줄 TextView
    Button buttonInput2; // 누르면 SubActivity2를 띄워줄 버튼
    Button button_ok; // MainActivity로 문자열을 반환할 버튼
    Button button_cancel; // 취소 버튼

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        edit = (EditText) findViewById(R.id.edit);
        textViewInput2 = (TextView) findViewById(R.id.text_view_input2);

        buttonInput2 = (Button) findViewById(R.id.button_input2);
        buttonInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, SubActivity2.class);
                startActivityForResult(intent, REQUEST_INPUT); // SubActivity2를 띄우고 결과를 반환받음
            }
        });

        button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() { // 문자열을 반환하는 코드
            public void onClick(View v) {
                Intent intent = new Intent();
                String input1 = edit.getText().toString(); // 첫 번째 문자열을 가져옴
                String input2 = textViewInput2.getText().toString(); // 두 번째 문자열을 가져옴
                intent.putExtra(MainActivity.INPUT_TEXT1, input1); // 첫 번째 문자열을 Intent에 넣음
                intent.putExtra(MainActivity.INPUT_TEXT2, input2); // 두 번째 문자열을 Intent에 넣음
                setResult(RESULT_OK, intent); // 결과값(완료) 설정
                finish(); // SubActivity 종료
            }
        });

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED); // 결과값(취소) 설정
                finish(); // SubActivity 종료
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_INPUT) { // 문자열 요청에 대한 결과라면
            if (resultCode == RESULT_OK && data != null) { // 결과값이 "완료"라면
                String input2 = data.getStringExtra(INPUT_TEXT); // 두 번째 문자열을 가져옴
                textViewInput2.setText(input2); // 두 번째 문자열을 보여줌
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}