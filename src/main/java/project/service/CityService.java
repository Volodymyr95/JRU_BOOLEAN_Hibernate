package project.service;

import org.modelmapper.ModelMapper;
import project.dao.CityCache;
import project.dao.CityDao;
import project.dto.CityDto;
import project.dto.DetailedCityDto;
import project.entity.City;
import project.exception.CityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CityService {

    private final ModelMapper modelMapper = new ModelMapper();

    private final CityDao cityDao = CityDao.getInstance();
    private final CityCache cityCache = CityCache.getInstance();

    public List<CityDto> getAll() {
        return cityDao.findAll().stream()
                .map(city -> modelMapper.map(city, CityDto.class))
                .collect(Collectors.toList());
    }

    public DetailedCityDto getById(Long id) {
        City city = cityDao.findById(id)
                .orElseThrow(() -> new CityNotFoundException(String.format("City with id %d not found", id)));
        return modelMapper.map(city, DetailedCityDto.class);
    }

    public void deleteById(Long id) {
        getById(id);
        cityDao.deleteById(id);
    }

    public void save(DetailedCityDto cityDto) {
        cityDao.save(modelMapper.map(cityDto, City.class));
    }

    public CityDto getByName(String name) {
        //TODO
        if (cityCache.get(name) != null) {
        }

        City city = cityDao.findByName(name)
                .orElseThrow(() -> new CityNotFoundException(String.format("City with name %s not found", name)));

        return modelMapper.map(city, CityDto.class);
    }
}
