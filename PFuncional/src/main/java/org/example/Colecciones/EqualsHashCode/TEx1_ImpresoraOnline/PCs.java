package org.example.Colecciones.EqualsHashCode.TEx1_ImpresoraOnline;

import java.util.LinkedHashSet;
import java.util.Objects;

public class PCs {

    private String id;
    private String name;

    public PCs(String id, String name) {

        this.id = id;
        this.name = name;

    }


    @Override
    public String toString() {
        return "PCs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PCs pCs)) return false;
        return Objects.equals(id, pCs.id) && Objects.equals(name, pCs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
