package ua.org.zasadnyy.zvalidations.validations;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;

import ua.org.zasadnyy.zvalidations.Field;
import ua.org.zasadnyy.zvalidations.ValidationResult;

/**
 * Created by assistant on 17/2/16.
 */
public class ConfirmPassword extends BaseValidation {

    private final Field passwordField;

    public static ConfirmPassword build(Context ctx,Field passwordField){
        return new ConfirmPassword(ctx,passwordField);
    }

    public ConfirmPassword(Context ctx, Field passwordField){
        super(ctx);
        this.passwordField=passwordField;
    }

    @Override
    public ValidationResult validate(Field field) {
        boolean isValid = field.getTextView().getText().toString().equals(passwordField.getTextView().getText().toString());
        return isValid ?
                ValidationResult.buildSuccess(field.getTextView())
                : ValidationResult.buildFailed(field.getTextView(), mContext.getString(ua.org.zasadnyy.zvalidations.R.string.zvalidations_passwords_dont_match));

    }


}
