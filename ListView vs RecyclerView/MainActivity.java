package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] ITEMS = {"Item 1", "Item 2", "Item 3"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ListView
        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ITEMS);
        listView.setAdapter(adapter);
        
        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(ITEMS));
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] items;
    
    public MyAdapter(String[] items) {
        this.items = items;
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(items[position]);
    }
    
    @Override
    public int getItemCount() {
        return items.length;
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        
        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}
