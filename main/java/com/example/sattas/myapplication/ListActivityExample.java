package com.example.sattas.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivityExample extends ListActivity {


    /** Called when the activity is first created. */

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_list_activity_example);
        final InteractiveArrayAdapter adapter = new InteractiveArrayAdapter(this,
                new ArrayList<AlgoDisplayRow>());

        Button runButton = (Button) findViewById(R.id.button);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adapter.addAll(getModel());

                AlgoCompute computer = new AlgoCompute();
                computer.setAdapter(adapter);
                computer.execute("dummy");


            }
        });
        setListAdapter(adapter);
    }

    private List<AlgoDisplayRow> getModel() {
        List<AlgoDisplayRow> list = new ArrayList<AlgoDisplayRow>();
        list.add(get("Linux"));
        list.add(get("Windows7"));
        list.add(get("Suse"));
        list.add(get("Eclipse"));
        list.add(get("Ubuntu"));
        list.add(get("Solaris"));
        list.add(get("Android"));
        list.add(get("iPhone"));
        return list;
    }

    public AlgoDisplayRow get(String s) {
        return new AlgoDisplayRow(s, 0, 0);
    }

}