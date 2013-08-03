package ua.org.zasadnyy.zvalidations.validations;


import android.text.TextUtils;
import ua.org.zasadnyy.zvalidations.R;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class NotEmpty implements Validation {

    @Override
    public int getErrorMessageId() {
        return R.string.zvalidations_empty;
    }

    @Override
    public boolean isValid(String text) {
        return !TextUtils.isEmpty(text);
    }
}
