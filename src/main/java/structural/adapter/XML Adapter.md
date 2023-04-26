## XML Adapter
In some messaging systems, we may need to convert messages between different formats or protocols, each of which has its own message schema and message broker API. An adapter can be used to abstract away the differences between these systems and provide a consistent interface for the application.
```java
@XmlRootElement(name = "person")
public class Person {
    @XmlElement
    public String name;
    
    @XmlElement
    public int age;
}

@XmlRootElement(name = "employee")
public class Employee {
    @XmlElement(name = "full_name")
    public String name;
    
    @XmlElement
    public int years_of_service;
}

public class PersonAdapter extends XmlAdapter<Employee, Person> {
    public Person unmarshal(Employee employee) {
        Person person = new Person();
        person.name = employee.name;
        person.age = 0; // not available in Employee
        return person;
    }
    
    public Employee marshal(Person person) {
        Employee employee = new Employee();
        employee.name = person.name;
        employee.years_of_service = 0;
        return employee;
    }
}
```
In this example, we define two classes `Person` and `Employee`, each with their own XML schema. We then create a `PersonAdapter` class that extends the `XmlAdapter` class provided by the JAXB API, which defines two methods `unmarshal` and `marshal`. These methods map between the `Employee` and `Person` classes, allowing us to convert between the two XML formats using a consistent interface.