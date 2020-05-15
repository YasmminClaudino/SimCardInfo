package com.example.simcardinfo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SimCardReceiver extends BroadcastReceiver {

    private static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";

    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
