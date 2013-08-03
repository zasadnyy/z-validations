package ua.org.zasadnyy.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ua.org.zasadnyy.zvalidations.Field;
import ua.org.zasadnyy.zvalidations.Form;
import ua.org.zasadnyy.zvalidations.validations.IsPositiveInteger;
import ua.org.zasadnyy.zvalidations.validations.NotEmpty;


public class SampleActivity extends Activity {

    private EditText mName;
    private EditText mEmail;
    private EditText mAge;
    private Button mSubmit;

    // Form used for validation
    private Form mForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        initFields();

        mForm = new Form(this);
        mForm.addField(Field.using(mName).validate(new NotEmpty()));
        mForm.addField(Field.using(mEmail).validate(new NotEmpty()));
        mForm.addField(Field.using(mAge).validate(new IsPositiveInteger()));

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample, menu);
        return true;
    }

    private void initFields() {
        mName = (EditText) findViewById(R.id.name);
        mEmail = (EditText) findViewById(R.id.email);
        mAge = (EditText) findViewById(R.id.age);
        mSubmit = (Button) findViewById(R.id.submit);
    }

    private void submit() {
        if(mForm.isValid()){
            Toast.makeText(this, "Form is valid", Toast.LENGTH_SHORT).show();
        }
    }
    
}
