package com.example.yb_project;

import android.app.AlertDialog;
import android.content.Context;

import com.example.yb_project.api.YBApi;
import com.example.yb_project.api.YBClient;

public class Utils{

    public static YBApi getApi() {
        return YBClient.getYBClient().create(YBApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .show();
        if (alertDialog.isShowing()){
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
