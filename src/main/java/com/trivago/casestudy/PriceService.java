package com.trivago.casestudy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.trivago.casestudy.exception.FileNotFoundException;
import com.trivago.casestudy.exception.FileReadException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class PriceService {

    private final List<Advertiser> advertisers;
    private final String PATH = "src/main/resources/prices";

    public PriceService() {
        this.advertisers = readFiles(PATH);
    }

    private List<Advertiser> readFiles(String path) {
        List<Advertiser> advertisers = new ArrayList<>();
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        ObjectMapper jsonMapper = new ObjectMapper();

        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.filter(Files::isRegularFile).forEach(p -> {
                try {
                    Advertiser advertiser;
                    if (p.toString().endsWith(".yaml")) {
                        advertiser = yamlMapper.readValue(p.toFile(), Advertiser.class);
                    } else if (p.toString().endsWith(".json")) {
                        advertiser = jsonMapper.readValue(p.toFile(), Advertiser.class);
                    } else {
                        return;
                    }
                    advertisers.add(advertiser);
                } catch (IOException e) {
                    throw new FileReadException("Error reading file: " + p.toString(), e);
                }
            });
        } catch (IOException e) {
            throw new FileNotFoundException("Error reading files in directory: " + path, e);
        }
        return advertisers;
    }

    private Accommodation getAccommodation(int accommodationId) {
        List<Price> prices = new ArrayList<>();
        for (Advertiser advertiser : advertisers) {
            for (Accommodation accommodation : advertiser.getAccommodation()) {
                if (accommodation.getId() == accommodationId) {
                    prices.addAll(accommodation.getPrices());
                }
            }
        }
        return new Accommodation(accommodationId, prices);
    }

    public Accommodation getPrices(int accommodationId) {
        return getAccommodation(accommodationId);
    }
}
