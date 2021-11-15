package main.rest.model;

import java.util.ArrayList;
import java.util.List;

public class UniCorns {
    List<UniCorn> unicorns = new ArrayList<>();

    public List<UniCorn> getUnicorns() {
        return unicorns;
    }

    public void setUnicorns(final List<UniCorn> unicorns) {
        this.unicorns = unicorns;
    }
}
