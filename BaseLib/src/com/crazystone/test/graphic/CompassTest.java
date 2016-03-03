package com.crazystone.test.graphic;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.crazystone.test.R;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.L;

/**
 * Created by crazystone on 2016/2/1.
 */
public class CompassTest extends BaseActivity implements SensorEventListener {

    private CompassView mCompassView;
    private SensorManager mManager;
    private Sensor mSensor;
    private float[] values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        mManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        mCompassView = (CompassView) findViewById(R.id.compass);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mManager != null) {
            mManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mManager != null) {
            mManager.unregisterListener(this);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mManager != null) {
            mManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        values = event.values;
        L.d("x offset:" + values[0] + ",y offset:" + values[1] + ",z offset:" + values[2]);
        if(mCompassView!=null){
            mCompassView.setDirector(values[0]);
            mCompassView.invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

