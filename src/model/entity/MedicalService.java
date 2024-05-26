package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.entity.enums.Status;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class MedicalService {
    private int serviceId;
    private String serviceName;
    private String serviceDescription;
    private String serviceType;
    private Status serviceStatus;


    @Override
    public String toString() {
        Gson json = new Gson();
        return json.toJson(this);
    }
}
