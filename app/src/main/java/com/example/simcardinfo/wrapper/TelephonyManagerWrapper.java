package com.example.simcardinfo.wrapper;

import android.telephony.TelephonyManager;

public class TelephonyManagerWrapper implements ITelephonyManager {

    private TelephonyManager tm;

    public TelephonyManagerWrapper(final TelephonyManager telephonyManager){
        tm = telephonyManager;
    }

    @Override
    public String getNetworkOperatorName() {
        return tm.getNetworkOperatorName();
    }

    @Override
    public String getNetworkOperator() {
        return tm.getNetworkOperator();
    }

    @Override
    public String getSimState() {
        Integer state = tm.getSimState();
        return getStringStateValue(state);
    }

    public String getStringStateValue(Integer state){
        String value;

        switch (state) {
            case 0:
                value =  "UNKNOWN";
                break;
            case 1:
                value = "ABSENT";
                break;
            case 2:
                value = "PIN_REQUIRED";
                break;
            case 3:
                value = "PUK_REQUIRED";
                break;
            case 4:
                value = "NETWORKED_LOCKED";
                break;
            case 5:
                value = "READY";
                break;
            case 6:
                value = "NOT_READY";
                break;
            case 7:
                value = "PERM_DISABLED";
                break;
            case 8:
                value = "CARD_IO_ERROR";
                break;
            case 9:
                value = "CARD RESTRICTED";
                break;

            case 10:
                value = "LOADED";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }

        return value;
    }
}
