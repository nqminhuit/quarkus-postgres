package org.acme.dto;

import org.acme.entity.SiteMap;

public class SiteMapDto {

    public Integer year;
    public Integer month;
    public String url;

    public static SiteMapDto fromEntity(SiteMap entity) {
        var dto = new SiteMapDto();
        dto.year = entity.year;
        dto.month = entity.month;
        dto.url = entity.url;
        return dto;
    }

}
