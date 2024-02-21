package com.ceica.CountryJavaFX.Service;

import com.ceica.CountryJavaFX.Models.CountryDTO;

import java.util.List;

public interface ICountryJavaFX {
    public String[] getRegions();
    public List<CountryDTO>getCountriesByRegion(String region);
    public CountryDTO getCountryByName(String name);
    public CountryDTO getCountryByCca3(String Cca3);

}
