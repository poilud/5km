package fr.poilud.fivekm.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.poilud.fivekm.core.domain.InternalUser;

@Repository
public interface InternalUserRepository extends JpaRepository<InternalUser, Long> {

}
