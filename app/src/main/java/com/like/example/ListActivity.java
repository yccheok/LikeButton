package com.like.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.like.example.adapters.ListAdapter;
import com.like.example.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    RecyclerView listView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize View Binding
        ActivityListBinding binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = binding.listView;

        adapter = new ListAdapter(this);
        listView.setAdapter(adapter);

    }
}
