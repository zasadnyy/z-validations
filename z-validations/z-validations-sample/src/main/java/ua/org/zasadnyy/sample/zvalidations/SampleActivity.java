package ua.org.zasadnyy.sample.zvalidations;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import ua.org.zasadnyy.zvalidations.Field;
import ua.org.zasadnyy.zvalidations.Form;
import ua.org.zasadnyy.zvalidations.FormUtils;
import ua.org.zasadnyy.zvalidations.TextViewValidationFailedRenderer;
import ua.org.zasadnyy.zvalidations.ToastValidationFailedRenderer;
import ua.org.zasadnyy.zvalidations.ValidationFailedRenderer;
import ua.org.zasadnyy.zvalidations.validations.InRange;
import ua.org.zasadnyy.zvalidations.validations.IsEmail;
import ua.org.zasadnyy.zvalidations.validations.NotEmpty;


public class SampleActivity extends Activity {

    private static final String GITHUB_PAGE = "https://github.com/zasadnyy/z-validations";

    private EditText mName;
    private EditText mEmail;
    private EditText mAge;
    private Button mSubmit;

    private Menu mOptionsMenu;
    private Map<Integer, ValidationFailedRenderer> mVaildationRenderers;

    // Form used for validation
    private Form mForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        initFields();
        initValidationForm();
        initCallbacks();
        registerValidationErrorRenderers();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample, menu);

        mOptionsMenu = menu;
        switchValidationFailedRenderer(R.id.action_show_error_as_crouton);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_github:
                openGitHub();
                return true;
            case R.id.action_show_error_as_toast:
            case R.id.action_show_error_in_text_view:
            case R.id.action_show_error_as_crouton:
                switchValidationFailedRenderer(itemId);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initFields() {
        mName = (EditText) findViewById(R.id.name);
        mEmail = (EditText) findViewById(R.id.email);
        mAge = (EditText) findViewById(R.id.age);
        mSubmit = (Button) findViewById(R.id.submit);
    }

    private void initValidationForm() {
        mForm = new Form(this);
        mForm.setValidationFailedRenderer(new CroutonValidationFailedRenderer(this));

        mForm.addField(Field.using(mName).validate(NotEmpty.build(this)));
        mForm.addField(Field.using(mEmail).validate(NotEmpty.build(this)).validate(IsEmail.build(this)));
        mForm.addField(Field.using(mAge).validate(InRange.build(this, 0, 120)));
    }

    private void initCallbacks() {
        mAge.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    submit();
                    return true;
                }
                return false;
            }

        });

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    private void registerValidationErrorRenderers() {
        mVaildationRenderers = new HashMap<Integer, ValidationFailedRenderer>();

        mVaildationRenderers.put(R.id.action_show_error_as_toast, new ToastValidationFailedRenderer(this));
        mVaildationRenderers.put(R.id.action_show_error_in_text_view, new TextViewValidationFailedRenderer(this));

        // add our custom validation error renderer
        mVaildationRenderers.put(R.id.action_show_error_as_crouton, new CroutonValidationFailedRenderer(this));
    }

    private void submit() {
        FormUtils.hideKeyboard(SampleActivity.this);
        if (mForm.isValid()) {
            Crouton.makeText(this, getString(R.string.sample_activity_form_is_valid), Style.CONFIRM).show();
        }
    }


    private void openGitHub() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_PAGE));
        startActivity(browserIntent);
    }

    private void switchValidationFailedRenderer(int selectedMenuItemId) {
        for(int menuItemId : mVaildationRenderers.keySet()) {
            mOptionsMenu.findItem(menuItemId).setChecked(menuItemId == selectedMenuItemId);
        }

        mForm.getValidationFailedRenderer().clear();
        mForm.setValidationFailedRenderer(mVaildationRenderers.get(selectedMenuItemId));
    }

}
