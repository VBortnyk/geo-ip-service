package ma.geoipservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ip_data")
public class GeoIpData {

    @Id
    @Column(name = "ipv4_decimal_from")
    private Long ipv4DecimalFrom;

    @Column(name = "ipv4_decimal_to")
    private Long ipv4DecimalTo;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;
}
