package com.example.client.service.internal;

import com.example.client.Endpoints;
import com.example.client.model.Engine;
import com.example.client.service.EngineService;

import java.util.List;

public class EngineServiceImpl implements EngineService {

    private static final String ENGINES_ENDPOINT = Endpoints.ENGINES.getEndpoint();
    private final CrudService<Engine> crudService = new CrudService<>();

    @Override
    public List<Engine> getAllEngines() {
        return crudService.getAll(ENGINES_ENDPOINT, Engine.class);
    }

    @Override
    public void createEngine(Engine engine) {
        crudService.create(ENGINES_ENDPOINT, engine);
    }

    @Override
    public void updateEngine(Long id, Engine engine) {
        crudService.update(ENGINES_ENDPOINT + "/" + id, engine);
    }

    @Override
    public void deleteEngine(Long id) {
        crudService.delete(ENGINES_ENDPOINT + "/" + id);
    }

}
