package com.hsk.activityforresult_201812311;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity2 extends AppCompatActivity {

    EditText editText; // 두 번째 문자열을 입력받을 EditText
    Button buttonOk; // 문자열 입력 완료 버튼
    Button buttonCancel; // 문자열 입력 취소 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        editText = (EditText) findViewById(R.id.edit_text);
        buttonOk = (Button) findViewById(R.id.button_ok);
        buttonCancel = (Button) findViewById(R.id.button_cancel);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonOkClick();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonCancelClick();
            }
        });
    }

    public void onButtonOkClick() { // 문자열 입력 완료 코드
        Intent intent = new Intent();
        intent.putExtra(SubActivity.INPUT_TEXT, editText.getText().toString()); // 두 번째 문자열을 가져옴
        setResult(RESULT_OK, intent); // 결과값(완료) 설정
        finish(); // SubActivity2 종료
    }

    public void onButtonCancelClick() { // 문자열 입력 취소 코드
        setResult(RESULT_CANCELED); // 결과값(취소) 설정
        finish(); // SubActivity2 종료
    }
}