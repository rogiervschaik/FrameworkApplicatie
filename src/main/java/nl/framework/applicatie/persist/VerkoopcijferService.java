package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Verkoopcijfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerkoopcijferService {

    @Autowired
    VerkoopcijferRepository vcr;

    public Iterable<Verkoopcijfer> geefAlleVerkoopcijfers(){
        return vcr.findAll();
    }
}