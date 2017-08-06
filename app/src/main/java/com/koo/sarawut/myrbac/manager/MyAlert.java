package com.koo.sarawut.myrbac.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.koo.sarawut.myrbac.R;

/**
 * Created by numnim on 8/6/2017.
 */

public class MyAlert {
    private Context context;

    public MyAlert(Context context) {
        this.context = context;

    }

    public void myDialog(String strTitle,String strMaessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_name);
        builder.setTitle(strTitle);
        builder.setMessage(strMaessage);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }






}      //main Class
