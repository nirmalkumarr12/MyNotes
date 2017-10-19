package com.example.hanya.starterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NumberListAdapter.ListClick {
private int num=100;
    NumberListAdapter adapter;
    RecyclerView rclist;
    EditText ex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rclist=(RecyclerView)findViewById(R.id.rv_numbers);
        LinearLayoutManager lm=new LinearLayoutManager(this);
        rclist.setLayoutManager(lm);
        rclist.setHasFixedSize(true);
        adapter=new NumberListAdapter(this);
        rclist.setAdapter(adapter);
        ex=(EditText)findViewById(R.id.et1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.serach_bar){
            String word=ex.getText().toString();
            ex.setText("");
            ex.setFocusable(true);
            adapter.update(word);
        }
        return true;
    }

    @Override
    public void onListClick(String click) {
        Toast.makeText(this,""+click,Toast.LENGTH_LONG).show();
    }
}
