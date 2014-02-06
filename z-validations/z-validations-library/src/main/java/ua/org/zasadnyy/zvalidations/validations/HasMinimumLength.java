
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Vitaliy Zasadnyy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package ua.org.zasadnyy.zvalidations.validations;

import android.content.Context;
import android.widget.EditText;

import ua.org.zasadnyy.zvalidations.Field;
import ua.org.zasadnyy.zvalidations.R;
import ua.org.zasadnyy.zvalidations.ValidationResult;

/**
 * Created by TheoTzafers on 6. February 2014
 */
public class HasMinimumLength extends BaseValidation {

    private int mMin;

    private HasMinimumLength(Context context, int min) {
        super(context);
        mMin = min;
    }

    public static Validation build(Context context, int min) {
        return new HasMinimumLength(context, min);
    }

    @Override
    public ValidationResult validate(Field field) {
        EditText textView = field.getTextView();
        int textLength = textView.getText().toString().length();
        return textLength >= mMin ?
            ValidationResult.buildSuccess(textView)
            : ValidationResult.buildFailed(textView, mContext.getString(R.string.zvalidations_too_short, mMin));
    }

}
