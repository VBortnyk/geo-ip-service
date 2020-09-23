package ma.geoipservice.service;

import ma.geoipservice.converter.IpConverter;
import ma.geoipservice.model.GeoIpData;
import ma.geoipservice.model.dto.GeoIpDataDto;
import ma.geoipservice.model.mapper.IpDataMapper;
import ma.geoipservice.repository.GeoIpDataRepository;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class GeoIpDataServiceImpl implements GeoIpDataService {

    private static final Logger logger = Logger.getLogger(GeoIpDataServiceImpl.class);
    private final IpDataMapper mapper;
    private final IpConverter converter;
    private final GeoIpDataRepository repository;

    public GeoIpDataServiceImpl(IpDataMapper mapper,
                                IpConverter converter,
                                GeoIpDataRepository repository) {
        this.mapper = mapper;
        this.converter = converter;
        this.repository = repository;
    }


    @Override
    public GeoIpDataDto get(String canonical) {
                if(!canonical.matches("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$")) {
            logger.warn("Incorrect IP address. Returned empty Json object");
            return new GeoIpDataDto();
        }

        try {
            Long decimalIp = converter.toDecimalIp(canonical);
            GeoIpData data = repository.getGeoData(decimalIp).get();
            GeoIpDataDto dto = mapper.toIpv4DataDto(data);
            dto.setCanonicalIPv4Representation(canonical);
            dto.setIpv4(String.valueOf(decimalIp));
            return dto;
        } catch (Exception e) {
            logger.warn("No IP found in the database. Returned empty Json object");
            return new GeoIpDataDto();
        }
    }
}
