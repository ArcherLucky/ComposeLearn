package com.archer.composelearn.old;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.archer.composelearn.R;

import java.util.ArrayList;
import java.util.List;

public class OldViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_view);
        RecyclerView list_view = findViewById(R.id.list_view);
        list_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("A");
        }
        list_view.setAdapter(new FlashItemAdapter(R.layout.list_item, list));
    }
}