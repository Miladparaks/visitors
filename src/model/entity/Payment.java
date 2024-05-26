package model.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.entity.enums.VisitType;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class Payment {
    private int paymentId;
    private LocalDateTime paymentTime;
    private String paymentStatus;
    private VisitType paymentType;

    @Override
    public String toString() {
        Gson json = new Gson();
        return json.toJson(this);
    }
}
