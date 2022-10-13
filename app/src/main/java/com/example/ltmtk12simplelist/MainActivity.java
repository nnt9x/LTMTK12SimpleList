package com.example.ltmtk12simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    // Dữ liệu
    private List<String> dataSource;

    // Adapter
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind Id
        lv = findViewById(R.id.lv);
        // Tạo dữ liệu
        dataSource = new ArrayList<>();
        for(int i = 1; i <= 12; i++){
            dataSource.add("Tháng "+i);
        }
        // Tạo Adapter
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, dataSource);

        // Set Adapter cho listview
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int month = i + 1;
                switch (month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        Toast.makeText(MainActivity.this, "31 ngày",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "28, 29 ngày", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"30 ngày", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}