package com.example.creditMonitoringService.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private int id;
    private String rut;
    private String name;
    private String lastname;
    private int ingreso;
    private Date birthdate;
    private Boolean register;
}
