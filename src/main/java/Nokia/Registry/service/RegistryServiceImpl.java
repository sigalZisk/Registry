package Nokia.Registry.service;

import Nokia.Registry.Person;
import Nokia.Registry.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryServiceImpl implements RegistryService{
    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public Boolean add(String firstName, String lastName, String id) {
        return registryRepository.add(firstName, lastName, id);
    }

    @Override
    public Boolean delete(String firstName, String lastName) {
        return registryRepository.delete(firstName, lastName);
    }

    @Override
    public Person[] search(String firstName, String lastName){
        return registryRepository.search(firstName,lastName);
    }
}
