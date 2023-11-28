package com.example.client;

import com.example.client.service.CarService;
import com.example.client.service.EngineService;
import com.example.client.service.EquipmentOptionService;
import com.example.client.service.WeatherService;
import com.example.client.service.internal.AccuWeatherService;
import com.example.client.service.internal.CarServiceImpl;
import com.example.client.service.internal.EngineServiceImpl;
import com.example.client.service.internal.EquipmentOptionServiceImpl;
import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WeatherService.class).to(AccuWeatherService.class);
        bind(CarService.class).to(CarServiceImpl.class);
        bind(EngineService.class).to(EngineServiceImpl.class);
        bind(EquipmentOptionService.class).to(EquipmentOptionServiceImpl.class);
    }

}
