package com.example.football.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Players extends RepresentationModel<Players> implements Serializable {
private static final long serialVersionUID = 1L;
int id;
private String playersId;
private String footballId;
private String name;
private String position;
private String dateOfBirth;
private String height;
private String weight;
}