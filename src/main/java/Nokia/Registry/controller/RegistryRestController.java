package Nokia.Registry.controller;

import Nokia.Registry.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistryRestController{

    @Autowired
    private RegistryService registerService;

    @GetMapping("/add")
    public Boolean add(@RequestParam(value = "firstName") String firstName,
                       @RequestParam(value = "lastName") String lastName,
                       @RequestParam(value = "id") String id){
        return registerService.add(firstName, lastName, id);
    }

    @GetMapping("/delete")
    public Boolean delete(@RequestParam(value = "firstName") String firstName,
                          @RequestParam(value = "lastName") String lastName){
        return registerService.delete(firstName, lastName);
    }
}
