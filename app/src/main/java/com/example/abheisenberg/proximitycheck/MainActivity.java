package com.example.abheisenberg.proximitycheck;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sm;
    Sensor proxSens;
    Button btProx;
    ListView lvlist;
    ArrayList<content> pvals;
    adapter adapter;
    float maxVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pvals = new ArrayList<>();
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        proxSens = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        maxVal = proxSens.getMaximumRange();
        btProx = (Button) findViewById(R.id.btProx);
        lvlist = (ListView) findViewById(R.id.lvlist);
        adapter = new adapter(pvals, this);

        lvlist.setAdapter(adapter);

        btProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.registerListener(MainActivity.this, proxSens, SensorManager.SENSOR_DELAY_NORMAL);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        content newContent;
        if(sensorEvent.values[0] == maxVal){
            newContent = new content(sensorEvent.values[0], System.currentTimeMillis(), "Uncovered");
        } else {
            newContent = new content(sensorEvent.values[0], System.currentTimeMillis() ,"Covered");
        }
        pvals.add(newContent);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
