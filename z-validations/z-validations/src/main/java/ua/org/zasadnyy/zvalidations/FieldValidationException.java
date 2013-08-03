package ua.org.zasadnyy.zvalidations;

import android.widget.EditText;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class FieldValidationException extends Exception {

    private EditText mTextView;

    public FieldValidationException(String message, EditText textView) {
        super(message);
        mTextView = textView;
    }

    public EditText getTextView() {
        return mTextView;
    }
}
