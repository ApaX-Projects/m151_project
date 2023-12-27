package ch.wiss.lb.controller;

import ch.wiss.lb.teams.repositories.Team;
import ch.wiss.lb.teams.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/team")
public class TeamRestController
{
    final TeamRepository teams;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public TeamRestController(TeamRepository teams)
    {
        this.teams = teams;
    }

    @GetMapping
    public ResponseEntity<?> teams()
    {
        return ResponseEntity.ok(teams.findAll().stream().map(TeamDto::fromDomain).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id)
    {
        Optional<TeamDto> maybeTeamDto =
                teams.findById(id).map(TeamDto::fromDomain);

        return ResponseEntity.of(maybeTeamDto);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TeamDto teamDto)
    {
        if (teamDto.id() != null)
            return ResponseEntity.badRequest().body("ID of team must be null");
        Team newTeam = new Team(teamDto.name(), teamDto.country(), teamDto.createdAt(), teamDto.updatedAt());
        newTeam = teams.save(newTeam);
        return ResponseEntity.created(URI.create("/api/team/" + newTeam.getId())) .body(TeamDto.fromDomain(newTeam));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id)
    {
        if (!teams.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        teams.deleteById(id);
        log.info("delete resource {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody TeamDto teamDto)
    {
        if (teamDto.id() != null && teamDto.id() != id)
            return new ResponseEntity<>("Path variable of id is not equal to team id", HttpStatus.CONFLICT);
        Optional<Team> maybeTeam = teams.findById(id);
        if (maybeTeam.isEmpty())
            return new ResponseEntity<>("Unable to update team with given id " + id, HttpStatus.NOT_FOUND);
        Team team = maybeTeam.get();
        team.setName(teamDto.name());
        team.setCountry(teamDto.country());
        team.setCreatedAt(teamDto.createdAt());
        team.setUpdatedAt(teamDto.updatedAt());
        team = teams.save(team);
        return ResponseEntity.ok(TeamDto.fromDomain(team));
    }

}