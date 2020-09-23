package ma.geoipservice.model.mapper;

import ma.geoipservice.model.GeoIpData;
import ma.geoipservice.model.dto.GeoIpDataDto;
import org.springframework.stereotype.Component;

@Component
public class IpDataMapper {
    private static final int IPV4_DECIMAL_FROM = 0;
    private static final int IPV4_DECIMAL_TO = 1;
    private static final int COUNTRY_CODE = 2;
    private static final int COUNTRY_NAME = 3;
    private static final int REGION_NAME = 4;
    private static final int CITY_NAME = 5;
    private static final int LATITUDE = 6;
    private static final int LONGITUDE = 7;

    public GeoIpData toGeoIpData(String[] data) {
        return new GeoIpData(
                Long.parseLong(data[IPV4_DECIMAL_FROM]),
                Long.parseLong(data[IPV4_DECIMAL_TO]),
                data[COUNTRY_CODE],
                data[COUNTRY_NAME],
                data[REGION_NAME],
                data[CITY_NAME],
                data[LATITUDE],
                data[LONGITUDE]
        );
    }

    public GeoIpDataDto toIpv4DataDto(GeoIpData data) {
        return new GeoIpDataDto(
                null,
                data.getCityName(),
                data.getCountryCode(),
                data.getCountryName(),
                null,
                data.getLatitude(),
                data.getLongitude(),
                data.getRegionName()
                );
    }
}
