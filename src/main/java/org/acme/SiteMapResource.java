package org.acme;

import java.util.List;
import org.acme.dto.SiteMapDto;
import org.acme.entity.SiteMap;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/sitemap")
public class SiteMapResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SiteMapDto> getSiteMaps() {
        return SiteMap.findByYear(2024).stream().map(SiteMapDto::fromEntity).toList();
    }

    @POST
    public void addSiteMaps(List<SiteMapDto> dtos) {
        SiteMap.save(dtos);
    }

}
