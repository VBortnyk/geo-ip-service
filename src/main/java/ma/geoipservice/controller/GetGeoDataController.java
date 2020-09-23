package ma.geoipservice.controller;

import ma.geoipservice.model.dto.GeoIpDataDto;
import ma.geoipservice.service.GeoIpDataService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geoip")
public class GetGeoDataController {

    private final GeoIpDataService service;

    public GetGeoDataController(GeoIpDataService service) {
        this.service = service;
    }

    @RequestMapping("/{ip}")
    public GeoIpDataDto get(@PathVariable String ip) {
        return service.get(ip);
    }
}

