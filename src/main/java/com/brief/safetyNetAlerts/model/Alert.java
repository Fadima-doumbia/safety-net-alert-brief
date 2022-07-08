package com.brief.safetyNetAlerts.model;

import com.brief.safetyNetAlerts.model.emunModel.EStatus;
import com.brief.safetyNetAlerts.model.emunModel.ETypes;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(	name = "alert")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ETypes alertType;
    private EStatus alertStatus;
    private String address;
}
