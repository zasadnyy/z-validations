package ua.org.zasadnyy.zvalidations.validations;

import android.content.Context;

/**
 * Created by vitaliyzasadnyy on 04.08.13.
 */
abstract class BaseValidation implements Validation {

    protected Context mContext;

    protected BaseValidation(Context context) {
        mContext = context;
    }

}
