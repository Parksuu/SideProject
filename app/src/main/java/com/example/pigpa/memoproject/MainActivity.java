package com.example.pigpa.memoproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> items1 = new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ContentActivity.class);
                startActivity(intent);
            }
        });


        listView = (ListView)this.findViewById(R.id.listView);

        ArrayList<String> items = new ArrayList<>();
        items.add("00");
        items.add("11");

        items1.add("첫 내용입니다");
        items1.add("두번째 내용입니다");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        listView.setAdapter(adapter);
    }


    //customAdapter 클래스
    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        //customadapter로 items 단다
        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            //흠 이부분만
            super(context, textViewResourceId, objects);

            this.items = objects;
        }

        //제목에 맞는 이미지로 변경한다
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.listview_item, null);
            }

            // ImageView 인스턴스
            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

            // 리스트뷰의 아이템에 이미지를 변경한다.
            if("00".equals(items.get(position)))
                imageView.setImageResource(R.drawable.profile);
            else if("11".equals(items.get(position)))
                imageView.setImageResource(R.drawable.profile);


            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            TextView textView1 = v.findViewById(R.id.editText2);
            textView1.setText(items1.get(position));


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "내용 화면으로 넘어가야지", Toast.LENGTH_SHORT).show();
                }
            });

            return v;
        }// end of getView 함수

    }
}