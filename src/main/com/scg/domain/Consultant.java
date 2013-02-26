package com.scg.domain;

import com.scg.util.Name;

import java.io.*;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/12/13
 * Time: 5:38 PM
 * <p/>
 * A Consultant
 */
@SuppressWarnings({"serial", "unchecked"})
public class Consultant implements Comparable<Consultant>, Serializable, ObjectInputValidation {
    private static final Logger logger = Logger.getLogger("Consultant.class");
    private static final long serialVersionUID  = 8618148641066813998l;

    private final Name name;

    /**
     * Creates a new instance of Consultant.
     *
     * @param name - consultant name
     */
    public Consultant(Name name) {
        this.name = name;
    }

    /**
     * Getter for the name property.
     *
     * @return value of consultant name
     */
    public Name getName() {
        return name;
    }

    @Override
    /**
     * Returns the string representation of the consultant's name.
     */
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Consultant o) {
        return name.toString().compareTo(o.getName().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consultant)) return false;

        Consultant that = (Consultant) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        if (name == null) {
            throw new InvalidObjectException("Consultant name cannot be null");
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.registerValidation(this, 0);
        ois.defaultReadObject();
    }

    private Object writeReplace() {
        logger.info(String.format("Serializing: %s", name));
        return new SerializationProxy(this);
    }

    private static class SerializationProxy implements Serializable {
        private Name name;

        private SerializationProxy(final Consultant consultant) {
            this.name = consultant.name;
        }

        private Object readResolve() {
            logger.info(String.format("De-serializing consultant: %s", name));
            return new Consultant(name);
        }
    }
}
