package com.example.simcardinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.simcardinfo.receiver.SimCardReceiver;
import com.example.simcardinfo.wrapper.TelephonyManagerWrapper;


public class MainActivity extends AppCompatActivity {
    private static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";
    private SimCardReceiver mReciever;
    private static String stateValue;
    private static String plmn;
    private static String operatorName;

    static TextView mccmnc;
    static TextView operadora;
    static TextView state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        Button btn = (Button) findViewById(R.id.button);

        mccmnc = (TextView) findViewById(R.id.mccmnc);
        operadora = (TextView) findViewById(R.id.operadora);
        state =  (TextView) findViewById(R.id.state);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues(tm);
                mReciever = new SimCardReceiver();
                IntentFilter filter = new IntentFilter(ACTION_SIM_STATE_CHANGED);
                registerReceiver(mReciever, filter);

            }
        });

    }
    public static void setValues(){
        mccmnc.setText(plmn);
        operadora.setText(operatorName);
        state.setText(stateValue);

    }

    public static void getValues(TelephonyManager tm) {
        final TelephonyManagerWrapper tmw = new TelephonyManagerWrapper(tm);
        stateValue = tmw.getSimState();
        plmn = tmw.getNetworkOperator();
        operatorName = tmw.getNetworkOperatorName();
    }

}
