package com.example.pigpa.memoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContentActivity extends AppCompatActivity {

    EditText mMemoEdit = null;
    TextFileManager mTextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        mMemoEdit=(EditText)findViewById(R.id.editText);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            // 1. 파일에 저장된 메모 텍스트 파일 불러오기
            case R.id.load: {
                String memoData = mTextFileManager.load();
                mMemoEdit.setText(memoData);

                Toast.makeText(this,"불러오기 완료", Toast.LENGTH_LONG).show();
                break;
            }
            // 2. editText에 입력된 메모를 텍스트 파일(memo.text)에 저장하기
            case R.id.save: {
                String memoData = mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);
                mMemoEdit.setText("");

                Toast.makeText(this,"저장 완료", Toast.LENGTH_LONG).show();
                break;
            }
            // 3. 저장된 메모 파일 삭제하기
            case R.id.delete: {
                mTextFileManager.delete();
                mMemoEdit.setText("");

                Toast.makeText(this,"불러오기 완료", Toast.LENGTH_LONG).show();
            }

        }
    }
}
