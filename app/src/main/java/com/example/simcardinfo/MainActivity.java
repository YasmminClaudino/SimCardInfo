package com.example.simcardinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        Button btn = (Button) findViewById(R.id.button);
        final TextView mccmnc = (TextView) findViewById(R.id.mccmnc);
        final TextView operadora = (TextView) findViewById(R.id.operadora);
        final TextView state = (TextView) findViewById(R.id.state);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stateValue = String.valueOf(tm.getSimState());
                String plmn = tm.getNetworkOperator();
                String operatorName = tm.getNetworkOperatorName();
                mccmnc.setText(plmn);
                operadora.setText(operatorName);
                state.setText(stateValue);

            }
        });

    }
}
