package ua.org.zasadnyy.zvalidations;

import android.content.Context;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

import ua.org.zasadnyy.zvalidations.validations.Validation;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class Field {

    private List<Validation> mValidations = new LinkedList<Validation>();
    private EditText mTextView;
    private Context mContext;

    private Field(EditText textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
    }

    public static Field using(EditText textView) {
        return new Field(textView);
    }

    public Field validate(Validation what) {
        mValidations.add(what);
        return this;
    }

    public EditText getTextView() {
        return mTextView;
    }

    public boolean isValid() throws FieldValidationException {
        for (Validation validation : mValidations) {
            if (!validation.isValid(mTextView.getText().toString())) {
                String errorMessage = mContext.getString(validation.getErrorMessageId());
                throw new FieldValidationException(errorMessage, mTextView);
            }
        }
        return true;
    }

}
