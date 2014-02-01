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

package ua.org.zasadnyy.sample.zvalidations;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import ua.org.zasadnyy.zvalidations.ValidationFailedRenderer;
import ua.org.zasadnyy.zvalidations.ValidationResult;

/**
 * Created by vitaliyzasadnyy on 01.02.14.
 */
public class CroutonValidationFailedRenderer implements ValidationFailedRenderer {

    private Activity mActivity;
    private List<Crouton> mCroutons = new ArrayList<Crouton>();

    public CroutonValidationFailedRenderer(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void showErrorMessage(ValidationResult validationResult) {
        Crouton crouton = Crouton.makeText(mActivity, validationResult.getMessage(), Style.ALERT);
        mCroutons.add(crouton);
        crouton.show();
    }

    @Override
    public void clear() {
        for (Crouton crouton : mCroutons) {
            crouton.cancel();
        }
        mCroutons.clear();
    }

}
