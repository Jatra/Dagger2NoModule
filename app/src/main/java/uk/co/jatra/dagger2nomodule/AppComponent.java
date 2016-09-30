package uk.co.jatra.dagger2nomodule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
//@Component(modules = AppModule.class)
@Component
public interface AppComponent {
    void inject(MainActivity mainActivity);
    Bar gimmeBar();
}
