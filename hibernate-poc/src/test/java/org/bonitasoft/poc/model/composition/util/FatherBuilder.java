package org.bonitasoft.poc.model.composition.util;

import org.bonitasoft.poc.model.composition.Child;
import org.bonitasoft.poc.model.composition.Father;


public class FatherBuilder {

    private Father father = new Father("aFather");
    
    public static FatherBuilder aFather() {
        return new FatherBuilder();
    }

    public Father build() {
        return father;
    }
    
    public FatherBuilder withChild(Child child) {
        father.addChild(child);
        return this;
    }
    
    public FatherBuilder withChild(String childName) {
        father.addChild(new Child(childName));
        return this;
    }
}