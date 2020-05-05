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
                Integer stateValue = tm.getSimState();
                String plmn = tm.getNetworkOperator();
                String operatorName = tm.getNetworkOperatorName();
                mccmnc.setText(plmn);
                operadora.setText(operatorName);
                switch (stateValue) {
                    case 0:
                        state.setText("UNKNOWN");
                        break;
                    case 1:
                        state.setText("ABSENT");
                        break;
                    case 2:
                        state.setText("PIN REQUIRED");
                        break;
                    case 3:
                        state.setText("PUK REQUIRED");
                        break;
                    case 4:
                        state.setText("NETWORKED LOCKED");
                        break;
                    case 5:
                        state.setText("READY");
                        break;
                    case 6:
                        state.setText("NOT READY");
                        break;
                    case 7:
                        state.setText("PERM DISABLED");
                        break;
                    case 8:
                        state.setText("CARD IO ERROR");
                        break;
                    case 9:
                        state.setText("CARD RESTRICTED");
                        break;

                    case 10:
                        state.setText("LOADED");
                        break;
                    case 11:
                        state.setText("PRESENT");
                        break;

                }

            }
        });

    }
}
