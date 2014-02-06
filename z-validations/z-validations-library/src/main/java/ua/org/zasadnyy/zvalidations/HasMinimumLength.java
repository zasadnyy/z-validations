package ua.org.zasadnyy.zvalidations.validations;

import ua.org.zasadnyy.zvalidations.Field;
import ua.org.zasadnyy.zvalidations.ValidationResult;
import android.content.Context;
import android.widget.EditText;

/**
 * Created by TheoTzafers on 6. February 2014
 */
public class HasMinimumLength extends BaseValidation {

	private int mMin;
	
	private HasMinimumLength(Context context, int min ) {
		super(context);
		mMin = min;
	}
	
	public static Validation build(Context context, int min) {
		return new HasMinimumLength(context, min);
	}

	@Override
    public ValidationResult validate(Field field) {
        EditText textView 	= field.getTextView();
        int textLength 		= textView.getText().toString().length(); 
        return textLength >= mMin  ?
            ValidationResult.buildSuccess(textView)
            : ValidationResult.buildFailed(textView, mContext.getString(R.string.zvalidations_too_short, mMin));
    }

}
