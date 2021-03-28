package javabank.domain;

import java.io.Serializable;

public class Entity<ID> implements Serializable {
    private static final long serialVersionUID = 7331115341259248461L;
    private ID id;

    /**
     * @return ID, representing the ID of the Entity
     */
    public ID getId() {
        return id;
    }

    /**
     * @param id ID, representing the new ID of the Entity
     */
    public void setId(ID id) {
        this.id = id;
    }
}
