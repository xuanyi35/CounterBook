package com.example.counterbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by XuanyiWu on 2017-09-25.
 */

public class ViewCounterActivity extends MainActivity{

    private TextView details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_counter);


        details = (TextView) findViewById(R.id.detail);

        Intent intent = getIntent();
        final int current_pos = intent.getIntExtra("MyClass", 0);
        int pos = intent.getIntExtra("MyClass",0);




/////////////////////////  actions for delete ///////////////////
        Button deleteBT = (Button) findViewById(R.id.delete);
        deleteBT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                counters.remove(current_pos);
                oldCounters.setAdapter(adapter);
                saveInFile();
                Toast.makeText(getApplicationContext(), "Successfully deleted", Toast.LENGTH_SHORT).show();
                //Intent i2 = new Intent(ViewCounterActivity.this, MainActivity.class);
                //startActivity(i2);

            }
        });


//////////////////////////////////  actions for edit ///////////////////
        Button editBT = (Button) findViewById(R.id.edit);
        editBT.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                //setContentView(R.layout.activity_change_counter);
                Intent i3 = new Intent(ViewCounterActivity.this, ChangeCountActivity.class);
                i3.putExtra("MyClass",current_pos );
                startActivity(i3);


            }
        });

    }

    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        int pos = intent.getIntExtra("MyClass",0);

        //details = (TextView) findViewById(R.id.detail);
        details.setText(counters.get(pos).toString());

    }




}
