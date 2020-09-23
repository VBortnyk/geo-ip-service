package ma.geoipservice.service;

import ma.geoipservice.model.dto.GeoIpDataDto;

public interface GeoIpDataService {

    GeoIpDataDto get(String canonical);
}
