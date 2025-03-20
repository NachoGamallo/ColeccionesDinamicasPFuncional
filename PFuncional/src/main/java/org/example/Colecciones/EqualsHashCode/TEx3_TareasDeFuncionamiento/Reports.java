package org.example.Colecciones.EqualsHashCode.TEx3_TareasDeFuncionamiento;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString

public class Reports {
    
    private int code;
    private String description;
    private Type type;
    
    public Reports (int code, String description, Type type){

        this.code = code;
        this.description = description;
        this.type = type;
        AppFunctions.reportsStack.push(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reports)) return false;
        Reports reports = (Reports) o;
        return code == reports.code && Objects.equals(description, reports.description) && type == reports.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, type);
    }
}
