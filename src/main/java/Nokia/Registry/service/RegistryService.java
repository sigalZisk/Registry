package Nokia.Registry.service;


import Nokia.Registry.Person;

public interface RegistryService {
    public Boolean add(String firstName, String lastName, String id);
    public Boolean delete(String firstName, String lastName);
    public Person[] search(String firstName, String lastName);
}
