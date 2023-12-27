package ch.wiss.lb.teams.repositories;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Players")
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nickname;
    private String country;
    private int age;
    private LocalDate created_at;
    private LocalDate updated_at;

}
