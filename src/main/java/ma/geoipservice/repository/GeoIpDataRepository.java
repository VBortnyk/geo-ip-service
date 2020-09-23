package ma.geoipservice.repository;

import ma.geoipservice.model.GeoIpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface GeoIpDataRepository extends JpaRepository<GeoIpData, Long> {

    @Query("SELECT d FROM GeoIpData d WHERE d.ipv4DecimalFrom <= :ip AND d.ipv4DecimalTo >= :ip")
    Optional<GeoIpData> getGeoData(@Param("ip") Long decimalIp);
}
