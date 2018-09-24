package com.faysselyabahddou.codingchallengehiddenfounders.common;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.faysselyabahddou.codingchallengehiddenfounders.R;

/**
 * Created by Fayssel Yabahddou on 9/24/18.
 */
public class PopUpMessage implements View.OnClickListener {

    private Dialog dialog;
    private Context mContext;
    private TextView buttonOk;
    private TextView txtTitle;
    private TextView txtMessage;

    public PopUpMessage(Context activity) {
        this.mContext = activity;
        dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_pop_up);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        buttonOk = dialog.findViewById(R.id.popup_btn_ok);
        txtTitle = dialog.findViewById(R.id.popup_title);
        txtMessage = dialog.findViewById(R.id.popup_text);
    }

    public void showPopUp(String mTitle, String mMessage) {
        txtTitle.setText(mTitle);
        txtMessage.setText(mMessage);
        buttonOk.setOnClickListener(this);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout((int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.90), WindowManager.LayoutParams.WRAP_CONTENT);
        }

        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.popup_btn_ok) {
            this.dialog.dismiss();
        }
    }
}