package ua.org.zasadnyy.zvalidations.validations;

import android.content.Context;

import ua.org.zasadnyy.zvalidations.R;

/**
 * Created by vitaliyzasadnyy on 04.08.13.
 */
public class IsEmail extends BaseValidation {

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private IsEmail(Context context) {
        super(context);
    }

    public static Validation build(Context context) {
        return new IsEmail(context);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_not_email);
    }

    @Override
    public boolean isValid(String text) {
        return text.matches(EMAIL_PATTERN);
    }
}
