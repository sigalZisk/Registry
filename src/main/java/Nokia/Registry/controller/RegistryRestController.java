package Nokia.Registry.controller;

import Nokia.Registry.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistryRestController{

    @Autowired
    private RegistryRepository repo;

    @GetMapping("/add")
    public Boolean add(@RequestParam(value = "firstName") String firstName,
                       @RequestParam(value = "lastName") String lastName,
                       @RequestParam(value = "id") String id){
        return repo.add(firstName, lastName, id);
    }

    @GetMapping("/delete")
    public Boolean delete(@RequestParam(value = "firstName") String firstName,
                          @RequestParam(value = "lastName") String lastName){
        return repo.delete(firstName, lastName);
    }
}
