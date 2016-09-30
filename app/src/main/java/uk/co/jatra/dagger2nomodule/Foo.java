package uk.co.jatra.dagger2nomodule;


import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Foo {

    @Inject Bar bar;

    public static final String TAG = Bar.class.getSimpleName();

    public int fooVal;
    @Inject public Foo(Bar bar) {
        fooVal = bar.barVal;
    }

    @Inject
    public void aMethod(Bar bar) {
        Log.d(TAG, "Method injection passing in a bar with value: "+bar.barVal);
    }
}
