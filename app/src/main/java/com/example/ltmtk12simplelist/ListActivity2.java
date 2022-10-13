package com.example.ltmtk12simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity2 extends AppCompatActivity {

    private EditText edtInput;
    private ListView lvOs;

    private List<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        edtInput = findViewById(R.id.edtInput);
        lvOs = findViewById(R.id.lvOs);

        // Tạo ra dữ liêu
        dataSource = new ArrayList<>();
//        dataSource.add("Window XP");
//        dataSource.add("Window 7");
//        dataSource.add("Ubuntu");

        // Tạo Adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSource);

        // Set Adapter cho listview
        lvOs.setAdapter(arrayAdapter);
    }

    public void addNewOs(View view) {
        // Hàm này sẽ chạy khi click vào button -> bind bên XML
        String myOS = edtInput.getText().toString().trim();
        if (myOS.isEmpty()) {
            edtInput.setError("Hãy nhập dữ liệu");
            return;
        }
        // Thêm dữ liệu vào datasouce
        dataSource.add(myOS);
        // Thông báo cho adapter biết dữ liệu đã thay đổi -> render lại listview
        arrayAdapter.notifyDataSetChanged();

        // Reset lai input
        edtInput.setText("");

        // onClick -> tự làm

        // Nhấn giữ để xóa
        lvOs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Người dùng cần xác nhận trước khi xóa
                String os = dataSource.get(i);
                new AlertDialog.Builder(ListActivity2.this)
                        .setTitle("Cảnh báo")
                        .setMessage("Bạn có muốn xóa " + os + "?")
                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int j) {
                                // Xóa -> xóa trong dataSource -> thông báo cho Adapter
                                dataSource.remove(i);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).create().show();
                return false;
            }
        });

    }
}