package ua.org.zasadnyy.zvalidations.validations;

import android.content.Context;

import ua.org.zasadnyy.zvalidations.R;

/**
 * Created by vitaliyzasadnyy on 04.08.13.
 */
public class InRange extends BaseValidation {

    private int mMin;
    private int mMax;

    private InRange(Context context, int min, int max) {
        super(context);
        mMin = min;
        mMax = max;
    }

    public static Validation build(Context context, int min, int max) {
        return new InRange(context, min, max);
    }

    @Override
    public String getErrorMessage() {
        return mContext.getString(R.string.zvalidations_not_in_range, mMin, mMax);
    }

    @Override
    public boolean isValid(String text) {
        return false;
    }
}
