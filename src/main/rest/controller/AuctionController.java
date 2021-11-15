package main.rest.controller;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.rest.dao.AuctionDAO;
import main.rest.exception.ValidationException;
import main.rest.model.UniCorn;
import main.rest.model.UniCorns;
import main.rest.model.UnicornCreateResponse;
import main.rest.validator.UnicornValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Service
@RequestMapping(path = "/unicorns")
public class AuctionController {
    Logger LOGGER = Logger.getLogger(AuctionController.class.getName());
    @Autowired
    private AuctionDAO auctionDAO;
    @Autowired
    private UnicornValidator validator;

    @GetMapping(path = "/", produces = "application/json")
    public UniCorns getUniCorns() {
        try {
            return auctionDAO.getAllUnicorns();
        }
        catch (RuntimeException e) {
            LOGGER.log(Level.SEVERE, "Exception Occurred while getting Unicorns, Reason is:" + e.getMessage());
            throw e;
        }
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public UnicornCreateResponse addUniCorn(@RequestBody UniCorn uniCorn) {
        try {
            validator.validate(uniCorn);
            Long id = auctionDAO.addUnicorn(uniCorn);
            uniCorn.setUnicornId(id);
            return new UnicornCreateResponse(id);
        }
        catch (RuntimeException e) {
            LOGGER.log(Level.SEVERE, "Exception Occurred while Adding Unicorn, Reason is" + e.getMessage());
            throw e;
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public UniCorn getUniCorns(@PathVariable Long id) {
        try {
            if(StringUtils.isEmpty(id)){
                throw new ValidationException("UniCornId cannot be null or empty");
            }
            return auctionDAO.getUniCorn(id);
        }
        catch (RuntimeException e) {
            LOGGER.log(Level.SEVERE, "Exception Occurred while getting Unicorn for the Id:" + id + "  Reason is:" + e.getMessage());
            throw e;
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public UniCorn updateUniCorn(@RequestBody UniCorn uniCorn) {
        try {
            if(uniCorn.getUnicornId() == null){
                throw new ValidationException("UniCornId is Expected for the PUT request");
            }
            validator.validate(uniCorn);
            auctionDAO.putUniCorn(uniCorn);
            return uniCorn;
        }
        catch (RuntimeException e) {
            LOGGER.log(Level.SEVERE, "Exception Occurred while updating Unicorn for the Id:" + uniCorn.getUnicornId() + "  Reason is:" + e.getMessage());
            throw e;
        }
    }
}
