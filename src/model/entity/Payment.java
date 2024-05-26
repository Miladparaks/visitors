package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.enums.City;
import model.enums.Vtype;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class Payment {
    private int paymentId;
    private LocalDateTime paymentTime;
    private String paymentStatus;
    private Vtype paymentType;

    @Override
    public String toString() {
        Gson json = new Gson();
        return json.toJson(this);
    }
}
