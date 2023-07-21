package nl.framework.applicatie.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    String a;
    String b;
    String c;
    int x;
    LocalDate y;
    boolean z;
}
