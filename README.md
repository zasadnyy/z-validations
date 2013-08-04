z-validations
=============

Small library that helps with Android form validations

_Library was written in scope of post: [Android form validation - the right way](http://blog.zasadnyy.org.ua/2013/08/android-form-validation-right-way.html)_

![Chuck Noris is always valid](http://4.bp.blogspot.com/-aB-mb25JcW8/Uf7EW9VKOuI/AAAAAAABKP8/jkVW7J7T04E/s1600/chuck-is-always-valid.png)

Available validations
---------------------
* NotEmpty - checks if field is not blank
* IsEmail - checks if field is valid email
* IsPositiveInteger - checks if fiels value is integer and if ```value > 0```
* InRange - checks if field value is integer and is in range ```min < value < max```
 
You can easyly create your own validations, just implement ```ua.org.zasadnyy.zvalidations.validation.Validation``` interface


Sample usage
------------

Create validation form and add some validations
```java
    Form mForm = new Form(mActivity);
    mForm.addField(Field.using(mNameEditText).validate(NotEmpty.build(mContext)));
    mForm.addField(Field.using(mEmailEditText).validate(NotEmpty.build(mContext)).validate(IsEmail.build(mContext)));
    mForm.addField(Field.using(mAgeEditText).validate(InRange.build(mContext, 0, 120)));
```

Check if form is valid 
```java
    private void submit() {
        if (mForm.isValid()) {
            Toast.makeText(this, "Form is valid", Toast.LENGTH_SHORT).show();
        }
    }
```
Checkout sample project for full usage example.    
    
    
Changelog
---------

__Current version: 0.1__

__v.0.1__ Initial release
