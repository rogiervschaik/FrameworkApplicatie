package nl.framework.applicatie.api;


import nl.framework.applicatie.domein.Verkoopcijfer;
import nl.framework.applicatie.persist.VerkoopcijferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VerkoopcijferEndpoint {

    @Autowired
    VerkoopcijferService vcs;

    @GetMapping("Verkoopcijfer")
    public Iterable<Verkoopcijfer> abc() {
        System.out.println("hij doet het");
       return vcs.geefAlleVerkoopcijfers();
    }
}

