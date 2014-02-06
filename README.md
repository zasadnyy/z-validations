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
* HasMinimumLength - checks if field value lenght is ```value.lenght >= min```
 
You can easily create your own validations, just implement ```ua.org.zasadnyy.zvalidations.validation.Validation``` interface


Sample usage
------------
Include into your project. If you're using gradle simply copy ```z-validations-library``` folder into your project and update your ```build.gradle``` dependencies list
```groovy
    dependencies {
        compile project(':z-validations-library')
        ...
    }
```


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

Since v.0.2 you can change how validation errors are displayed. Library includes error renderers using ```TextView``` errors (used by default) and ```Toast```s. You can create your own by implementing ```ua.org.zasadnyy.zvalidations.ValidationFailedRenderer``` interface
```java
    mForm.setValidationFailedRenderer(new TextViewValidationFailedRenderer(mContext));
```


Checkout sample project for full usage example or install it from [Google Play](https://play.google.com/store/apps/details?id=ua.org.zasadnyy.sample.zvalidations)
    
    
Changelog
---------

__Current version: 0.2__

__v.0.2.1__ 
* Added HasMinimumLength validation (thanks [TheoTzaferis](https://github.com/TheoTzaferis) for pull request)

__v.0.2__ 
* Code refactoring (thanks [tadfisher](https://github.com/tadfisher) for pull request)
* Added ability to change how validation errors are displayed
* Moved [Crouton](https://github.com/keyboardsurfer/Crouton) dependency from library to sample project
* Published [Demo application on Google Play](https://play.google.com/store/apps/details?id=ua.org.zasadnyy.sample.zvalidations)

__v.0.1__ 
* Initial release
