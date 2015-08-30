package ua.org.zasadnyy.sample.zvalidations;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ua.org.zasadnyy.zvalidations.ValidationFailedRenderer;
import ua.org.zasadnyy.zvalidations.ValidationResult;

/**
 * Created by sachini on 25/8/15.
 */
public class SnackbarValidateFailedRenderer implements ValidationFailedRenderer {

    private Activity mActivity;
    private List<Snackbar> mSnackbars = new ArrayList<Snackbar>();
    private View mMainView;

    public SnackbarValidateFailedRenderer(Activity activity, View mainView) {
        mActivity = activity;
        mMainView = mainView;
    }

    @Override
    public void showErrorMessage(ValidationResult validationResult) {
        Snackbar snackbar = Snackbar.make(mMainView, validationResult.getMessage(), Snackbar.LENGTH_LONG)
                .setAction("redo", null);
        snackbar.show();
        mSnackbars.add(snackbar);
    }

    @Override
    public void clear() {
        for (Snackbar crouton : mSnackbars) {
            crouton.dismiss();
        }
        mSnackbars.clear();
    }

}
