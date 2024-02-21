package com.ceica.CountryJavaFX.Models;

import com.ceica.CountryJavaFX.Models.Extras.Currency;
import com.ceica.CountryJavaFX.Models.Extras.Flag;
import com.ceica.CountryJavaFX.Models.Extras.Name;


import java.util.Map;

public class CountryDAO {
public Name name;
public String[] capital;
public String region;
public int population;
public Map<String, Currency> currencies;
public Flag flags;
public String cca3;
}

