package uk.co.jatra.dagger2nomodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject Foo foo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Bar bar = DaggerAppComponent.create().gimmeBar();
        Log.d(TAG, "injected bar's value: " + bar.barVal);


        DaggerAppComponent.builder()
//                .appModule(new AppModule())
                .build().inject(this);
        Log.d(TAG, "injected foo's value: " + foo.fooVal);

    }

}
