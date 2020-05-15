package com.example.simcardinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.simcardinfo.wrapper.TelephonyManagerWrapper;


public class MainActivity extends AppCompatActivity {
    private static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        final TelephonyManagerWrapper tmw = new TelephonyManagerWrapper(tm);

        Button btn = (Button) findViewById(R.id.button);
        final TextView mccmnc = (TextView) findViewById(R.id.mccmnc);
        final TextView operadora = (TextView) findViewById(R.id.operadora);
        final TextView state = (TextView) findViewById(R.id.state);

        //implementar uma chamada ao brodcast para caso houver alguma mudança no estado do
        //sim atualizar valores
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stateValue = tmw.getSimState();
                String plmn = tmw.getNetworkOperator();
                String operatorName = tmw.getNetworkOperatorName();
                mccmnc.setText(plmn);
                operadora.setText(operatorName);
                state.setText(stateValue);
            }
        });

    }
}
