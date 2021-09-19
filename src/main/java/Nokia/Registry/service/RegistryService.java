package Nokia.Registry.service;


public interface RegistryService {
    public Boolean add(String firstName, String lastName, String id);
    public Boolean delete(String firstName, String lastName);
}
