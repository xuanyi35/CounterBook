package com.example.counterbook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public EditText add_name;
    public TextView add_time;
    public EditText add_init;
    public EditText add_current;
    public EditText add_comment;

    public static final String FILENAME = "file.sav";
    private int number = 0;
    private TextView numText;
    public ListView oldCounters;
    public ArrayList<Counter> counters = new ArrayList<Counter>();
    public ArrayAdapter<Counter> adapter ;
    public int click_item_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oldCounters = (ListView) findViewById(R.id.oldCounters);
        number = counters.size();
        numText = (TextView) findViewById(R.id.num);
        numText.setText("Number of counters : " + number);
        Button addBT = (Button) findViewById(R.id.add);
        addBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                Intent intent = new Intent(MainActivity.this, AddCounterActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(oldCounters);
        oldCounters.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                click_item_index=position;
                return false;
            }
        });

    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Counter>(this, R.layout.list_item, counters);
        oldCounters.setAdapter(adapter);
        number = counters.size();
        numText.setText("Number of counters : " + number);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "View details");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        if (item.getTitle().equals("View details")) {
            Intent i = new Intent(MainActivity.this, ViewCounterActivity.class);
            i.putExtra("MyClass", position);
            startActivity(i);
        }

        else {
            return false;
        }
        return true;
    }


    public void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Counter>>(){}.getType();
            counters = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            counters = new ArrayList<Counter>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(counters,writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            throw new RuntimeException();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            throw new RuntimeException();
        }
    }


}
