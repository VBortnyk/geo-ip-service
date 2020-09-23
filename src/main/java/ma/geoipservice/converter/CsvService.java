package ma.geoipservice.converter;

import au.com.bytecode.opencsv.CSVReader;
import ma.geoipservice.exception.DataProcessingException;
import ma.geoipservice.model.GeoIpData;
import ma.geoipservice.model.mapper.IpDataMapper;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvService {

    private final IpDataMapper mapper;

    CsvService(IpDataMapper mapper) {
        this.mapper = mapper;
    }
    public List<GeoIpData> getDataFromCsvFile(String path) {
        List<GeoIpData> dataFromCsv = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] line;
            while ((line = reader.readNext()) != null) {
                dataFromCsv.add(mapper.toGeoIpData(line));
            }
        } catch (IOException e) {
            throw new DataProcessingException("Failed to read data form directory:" + path, e);
        }
        return dataFromCsv;
    }
}
