package org.acme.entity;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity(name = "sitemap")
public class SiteMap extends PanacheEntity {

    public Integer year;
    public Integer month;
    public String url;

    public static List<SiteMap> findByYear(int year) {
        return list("year", year);
    }
}
