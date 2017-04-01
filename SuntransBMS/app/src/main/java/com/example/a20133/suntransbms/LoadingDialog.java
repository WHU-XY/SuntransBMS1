package com.example.a20133.suntransbms;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class LoadingDialog extends Dialog {
    private Context mContext;
    private Dialog mDialog;

    public LoadingDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }
    public Dialog loadDialog(String string) {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog = new Dialog(mContext);
        LayoutInflater in = LayoutInflater.from(mContext);
        View viewDialog = in.inflate(R.layout.loading, null);
        TextView textView = (TextView) viewDialog.findViewById(R.id.tv_refresh_text);
        textView.setText(string);
        mDialog.setContentView(viewDialog);
        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setCancelable(false);
        mDialog.show();
        return mDialog;
    }
    public void removeDialog() {
    mDialog.dismiss();
    }
}
