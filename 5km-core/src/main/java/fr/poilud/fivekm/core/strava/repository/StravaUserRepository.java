package fr.poilud.fivekm.core.strava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.poilud.fivekm.core.strava.StravaUser;

@Repository
public interface StravaUserRepository extends JpaRepository<StravaUser, Long> {

}
