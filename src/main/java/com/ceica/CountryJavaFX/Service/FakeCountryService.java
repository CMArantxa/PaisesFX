package com.ceica.CountryJavaFX.Service;

import com.ceica.CountryJavaFX.Models.CountryDTO;

import java.util.ArrayList;
import java.util.List;

public class FakeCountryService implements ICountryJavaFX{
    @Override
    public String[] getRegions() {
        return new String[] {"Europe ","Asia","America","Africa","Oceania","Antartida"};

    }

    @Override
    public List<CountryDTO> getCountriesByRegion(String region) {
        List<CountryDTO>countryDTOList=new ArrayList<>();
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName("Spain");
        countryDTOList.add(countryDTO);
        CountryDTO countryDTO1=new CountryDTO();
        countryDTO1.setName("China");
        countryDTOList.add(countryDTO1);
        CountryDTO countryDTO2=new CountryDTO();
        countryDTO2.setName("Filipinas");
        countryDTOList.add(countryDTO2);
        return countryDTOList;
    }

    @Override
    public CountryDTO getCountryByName(String name) {
        CountryDTO countryDTO=new CountryDTO();
        countryDTO.setName("Spain");
        countryDTO.setCapital("Madrid");
        countryDTO.setCoin("Euros");
        countryDTO.setPopulation(4000000);
        countryDTO.setFlag("https://flagcdn.com/w320/es.png");
        return countryDTO;
    }


    @Override
    public CountryDTO getCountryByCca3(String Cca3) {
        return null;
    }
}
