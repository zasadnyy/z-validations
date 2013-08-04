package ua.org.zasadnyy.zvalidations.validations;


import android.content.Context;
import android.text.TextUtils;
import ua.org.zasadnyy.zvalidations.R;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class NotEmpty extends BaseValidation {

    public static Validation build(Context context) {
        return new NotEmpty(context);
    }

    private NotEmpty(Context context) {
        super(context);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_empty);
    }

    @Override
    public boolean isValid(String text) {
        return !TextUtils.isEmpty(text);
    }
}
