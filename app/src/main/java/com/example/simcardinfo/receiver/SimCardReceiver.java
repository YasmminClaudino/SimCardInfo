package com.example.simcardinfo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.simcardinfo.MainActivity;



public class SimCardReceiver extends BroadcastReceiver {

    private static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";

    private static final String EXTRA_SIM_STATE = "ss";
    private static final String SIM_STATE_ABSENT = "ABSENT";
    private static final String SIM_STATE_READY = "READY";

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean action = ACTION_SIM_STATE_CHANGED.equals(intent.getAction());
        if (ACTION_SIM_STATE_CHANGED.equals(intent.getAction())) {
            Log.d("SimCardReceiver",   "value of action " + action);
            MainActivity.setValues();


        }

    }


}
