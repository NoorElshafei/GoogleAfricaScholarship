package com.example.googleafricascholarship.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.googleafricascholarship.R;

public class ViewDialog {
    public ViewDialog() {
    }

    public Dialog showDialog(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_ask);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;

    }
    public static void showDialogSuccess(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_result);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        TextView textView = (TextView) dialog.findViewById(R.id.ask_text);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.cancel);
        textView.setText("Submission SuccessFull");
        imageView.setImageResource(R.drawable.success);
        dialog.show();

    }
    public static void showDialogFailed(Context context) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_result);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView textView = (TextView) dialog.findViewById(R.id.ask_text);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.cancel);
        textView.setText("Submission not SuccessFull");
        imageView.setImageResource(R.drawable.failed);
        dialog.show();

    }

}
