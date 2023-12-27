package ch.wiss.lb.controller;

import ch.wiss.lb.teams.repositories.Team;
import java.time.LocalDate;

public record TeamDto
        (
                Long id,
                String name,
                String country,
                LocalDate createdAt,
                LocalDate updatedAt
                ) {
    public static TeamDto fromDomain(Team t) {
        return new TeamDto(
                t.getId(),
                t.getName(),
                t.getCountry(),
                t.getCreatedAt(),
                t.getUpdatedAt()
        );
    }
    public static Team toDomain(TeamDto dto) {
        Team team = new Team();
        team.setName(dto.name());
        team.setCountry(dto.country());
        team.setCreatedAt(dto.createdAt());
        team.setUpdatedAt(dto.updatedAt);

        return team;
    }
}