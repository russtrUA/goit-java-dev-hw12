package ua.goit;

import ua.goit.config.HibernateConfig;
import ua.goit.model.Client;
import ua.goit.model.Planet;
import ua.goit.service.ClientCrudService;
import ua.goit.service.PlanetCrudService;

public class HibernateCrudUsageExample {
    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        Client clientCreated = Client.builder()
                .name("Taras Shevchenko")
                .build();
        clientCrudService.saveClient(clientCreated);
        System.out.println("clientCreated = " + clientCreated);
        Client clientRead = clientCrudService.findClientById(clientCreated.getId());
        System.out.println("clientRead = " + clientRead);
        clientRead.setName("Olena Pchilka");
        clientCrudService.updateClient(clientRead);
        Client clientUpdated = clientCrudService.findClientById(clientRead.getId());
        System.out.println("clientUpdated = " + clientUpdated);
        clientCrudService.deleteClient(clientUpdated);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        Planet planetCreated = Planet.builder()
                .id("NEPTUN")
                .name("Neptu")
                .build();
        planetCrudService.savePlanet(planetCreated);
        System.out.println("planetCreated = " + planetCreated);
        Planet planetRead = planetCrudService.findPlanetById(planetCreated.getId());
        System.out.println("planetRead = " + planetRead);
        planetRead.setName("Neptun");
        planetCrudService.updatePlanet(planetRead);
        Planet planetUpdated = planetCrudService.findPlanetById(planetRead.getId());
        System.out.println("planetUpdated = " + planetUpdated);
        planetCrudService.deletePlanet(planetUpdated);
        HibernateConfig.getInstance().close();
    }
}
