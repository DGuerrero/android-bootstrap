package com.quoders.apps.androidbootstrap;

import android.widget.TextView;

public class LogHelper {
    public static void addLog(TextView textView, String s) {
        textView.setText(textView.getText().toString() + "\n" + s);
    }
}
