package ua.org.zasadnyy.zvalidations.validations;

import ua.org.zasadnyy.zvalidations.R;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class IsPositiveInteger implements Validation {

    @Override
    public int getErrorMessageId() {
        return R.string.zvalidations_not_positive_integer;
    }

    @Override
    public boolean isValid(String text) {
        return text.matches("\\d+");
    }
}
