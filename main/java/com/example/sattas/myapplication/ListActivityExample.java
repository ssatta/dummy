package com.example.sattas.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActivityExample extends ListActivity {


    /** Called when the activity is first created. */

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_list_activity_example);
        ArrayAdapter<AlgoDisplayRow> adapter = new InteractiveArrayAdapter(this,
                getModel());
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

    private AlgoDisplayRow get(String s) {
        return new AlgoDisplayRow(s, 0, 0);
    }

}