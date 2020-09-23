package ma.geoipservice.controller;

import ma.geoipservice.converter.CsvService;
import ma.geoipservice.model.GeoIpData;
import ma.geoipservice.repository.GeoIpDataRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/")
public class InjectController {

    private final CsvService csvService;
    private final GeoIpDataRepository repository;

    public InjectController(CsvService csvService, GeoIpDataRepository repository) {
        this.csvService = csvService;
        this.repository = repository;
    }

    @RequestMapping("/inject")
    public void injectData() {
        List<GeoIpData> data = csvService.getDataFromCsvFile(
                "C:\\Mate Academy Projects\\data\\IPv4_database.CSV");
        for(GeoIpData ipData : data) {
            repository.save(ipData);
        }
    }
}
