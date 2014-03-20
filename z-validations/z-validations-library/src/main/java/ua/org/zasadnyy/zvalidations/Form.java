
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

package ua.org.zasadnyy.zvalidations;

import android.content.Context;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliyzasadnyy on 01.08.13.
 */
public class Form {

    private List<Field> mFields = new ArrayList<Field>();
    private ValidationFailedRenderer mValidationFailedRenderer;
    private Context mContext;

    public Form(Context context) {
        this.mContext = context;
        this.mValidationFailedRenderer = new TextViewValidationFailedRenderer(context);
    }

    public void addField(Field field) {
        mFields.add(field);
    }

    public void setValidationFailedRenderer(ValidationFailedRenderer renderer) {
        this.mValidationFailedRenderer = renderer;
    }

    public ValidationFailedRenderer getValidationFailedRenderer() {
        return this.mValidationFailedRenderer;
    }

    public boolean isValid() {
        boolean isValid = true;
        mValidationFailedRenderer.clear();

        for (Field field : mFields) {
            FieldValidationResult result = field.validate();

            if (!result.isValid()) {
                ValidationResult firstFailedValidation = result.getFailedValidationResults().get(0);
                EditText textView = firstFailedValidation.getTextView();
                textView.requestFocus();
                textView.selectAll();

                FormUtils.showKeyboard(mContext, textView);

                mValidationFailedRenderer.showErrorMessage(firstFailedValidation);

                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
