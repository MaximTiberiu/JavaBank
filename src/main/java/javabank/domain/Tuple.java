package javabank.domain;

import java.util.Objects;

/**
 * Define a Tuple of generic type entities
 * @param <E1>, tuple first entity type
 * @param <E2>, tuple second entity type
 */
public class Tuple<E1, E2> extends Entity<Long> {
    private E1 e1;
    private E2 e2;

    /**
     * Constructor that creates a new Tuple
     * @param e1 E1, representing the first entity of the Tuple
     * @param e2 E2, representing the second entity of the Tuple
     */
    public Tuple(E1 e1, E2 e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    /**
     * @return E1, representing the first entity of the Tuple
     */
    public E1 getLeftEntity() {
        return e1;
    }

    /**
     * @param e1 E1, representing the new first entity of the Tuple
     */
    public void setLeftEntity(E1 e1) {
        this.e1 = e1;
    }

    /**
     * @return E2, representing the second entity of the Tuple
     */
    public E2 getRightEntity() {
        return e2;
    }

    /**
     * @param e2 E2, representing the new second entity of the Tuple
     */
    public void setRightEntity(E2 e2) {
        this.e2 = e2;
    }

    /**
     * @return String, representing the serialization of a Tuple
     */
    @Override
    public String toString() {
        return "Tuple{" +
                "ID='" + getId() + '\'' +
                "e1=" + e1 +
                ", e2=" + e2 +
                '}';
    }

    /**
     * Method that verifies if two Tuple objects are equal
     * @param obj Object, representing the Object to be verified
     * @return  true,   if the first entity of the Tuple is equal to the first entity of the Object
     *                  and the second entity of the Tuple is equal to the second entity of the Object
     *          false,  otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tuple<?, ?> that = (Tuple<?, ?>) obj;
        return e1.equals(that.e1) && e2.equals(that.e2);
    }

    /**
     * Method that gets the hashCode of the Tuple
     * @return int, representing the hashCode of the Tuple
     */
    @Override
    public int hashCode() {
        return Objects.hash(e1, e2);
    }
}
