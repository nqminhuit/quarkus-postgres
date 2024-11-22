package org.acme.entity;

import java.util.List;
import java.util.UUID;
import org.acme.dto.SiteMapDto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@Entity(name = "sitemap")
public class SiteMap extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID id;

    public Integer year;
    public Integer month;
    public String url;

    public static List<SiteMap> findByYear(int year) {
        return list("year", year);
    }

    @Transactional
    public static void save(List<SiteMapDto> dtos) {
        dtos.stream()
                .map(SiteMapDto::toEntity)
                .forEach(x -> SiteMap.persist(x));
    }
}
