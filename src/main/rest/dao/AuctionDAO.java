package main.rest.dao;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import main.rest.exception.ValidationException;
import main.rest.model.UniCorn;
import main.rest.model.UniCorns;
import org.springframework.stereotype.Repository;

@Repository
public class AuctionDAO {
    private static final Map<Long, UniCorn> uniCornMap = new HashMap<>();

    public UniCorns getAllUnicorns() {
        UniCorns unicorns = new UniCorns();
        for (UniCorn uniCorn : uniCornMap.values()) {
            unicorns.getUnicorns()
                    .add(uniCorn);
        }
        return unicorns;
    }

    public Long addUnicorn(UniCorn uniCorn) {
        long id = Instant.now()
                         .toEpochMilli();
        uniCorn.setUnicornId(id);
        uniCornMap.put(id, uniCorn);
        return id;
    }

    public UniCorn getUniCorn(Long id) {
        return uniCornMap.get(id);
    }

    public void putUniCorn(final UniCorn uniCorn) {
        if(uniCornMap.get(uniCorn.getUnicornId()) == null){
            throw new ValidationException("UnicornId Provided part of the PUT call is Invalid");
        }
        uniCornMap.put(uniCorn.getUnicornId(), uniCorn);
    }
}
