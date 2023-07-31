package jp.suntech.s22005.bmicalculators005;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

public class BMIDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        DialogButtonClickLostener listener = new DialogButtonClickLostener();
        builder.setPositiveButton(R.string.dialog_btn_ok, listener);

        AlertDialog dialog = builder.create();
        return dialog;
    }



    private class DialogButtonClickLostener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    }
}