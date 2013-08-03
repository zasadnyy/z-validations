package ua.org.zasadnyy.zvalidations;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class Form {

    private List<Field> mFields = new ArrayList<Field>();
    private Activity mActivity;

    public Form(Activity activity) {
        this.mActivity = activity;
    }

    public void addField(Field field) {
        mFields.add(field);
    }

    public boolean isValid() {
        boolean result = true;
        try {
            for (Field field : mFields) {
                result &= field.isValid();
            }
        } catch (FieldValidationException e) {
            result = false;

            EditText textView = e.getTextView();
            textView.requestFocus();
            textView.selectAll();

            FormUtils.showKeyboard(mActivity, textView);

            showErrorMessage(e.getMessage());
        }
        return result;
    }

    protected void showErrorMessage(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
//        Crouton.makeText(mActivity, message, Style.ALERT).show();
    }


}
