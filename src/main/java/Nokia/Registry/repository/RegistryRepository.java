package Nokia.Registry.repository;

import Nokia.Registry.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Repository
public class RegistryRepository {

    private HashMap<Map.Entry<String, String>, List<Person>> registry = new HashMap<>();

    public Boolean add(String firstName, String lastName, String id){
        if (null != id) {
            Person person = new Person(firstName, lastName, id);
            Map.Entry<String, String> key = new AbstractMap.SimpleEntry<>(firstName,lastName);
            List<Person> people = registry.get(key);
                if (null == people){
                    people = new ArrayList<>();
                }
                if (!people.contains(person)) {
                    people.add(person);
                    registry.put(key, people);
                    return TRUE;
                }
        }
        return FALSE;
    }

    public Boolean delete(String firstName, String lastName){
        Map.Entry<String, String> key = new AbstractMap.SimpleEntry<>(firstName,lastName);
        List<Person> people = registry.get(key);
        if (null != people){
            people.remove(0);
            return TRUE;
        }
        return FALSE;
    }

    public int size(){
        int size = 0;
        for (Map.Entry k : registry.entrySet()){
            ArrayList<Person> people = (ArrayList<Person>) k.getValue();
            size += people.size();
        }
        return size;
    }
}
