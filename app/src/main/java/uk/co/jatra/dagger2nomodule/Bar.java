package uk.co.jatra.dagger2nomodule;

import javax.inject.Inject;

public class Bar {
    public int barVal;

    @Inject
    public Bar() {
        barVal = (int) (Math.random() * 100);
    }
}
