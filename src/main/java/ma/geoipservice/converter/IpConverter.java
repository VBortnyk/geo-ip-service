package ma.geoipservice.converter;

import org.springframework.stereotype.Component;

@Component
public class IpConverter {
    public Long toDecimalIp(String canonicalIp) {
        String[] ipAddressInArray = canonicalIp.split("\\.");
        long result = 0;

        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    public String toCanonical(Long decimalIp) {
        StringBuilder sb = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {
            sb.insert(0, (decimalIp & 0xff));
            if (i < 3) {
                sb.insert(0,'.');
            }
            decimalIp = decimalIp >> 8;
        }
        return sb.toString();
    }
}
