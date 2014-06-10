package org.bonitasoft.poc.lazy;

public interface Employee {
    long getId();
    void setId(long id);
    
    void setName(String name);
    void setAddress(Address address);
    String getName();
    
    @Lazy Address getAddress();
}