package fr.poilud.fivekm.core.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.poilud.fivekm.core.common.UserDescription;
import fr.poilud.fivekm.core.configuration.H2JpaConfig;
import fr.poilud.fivekm.core.strava.StravaUser;
import fr.poilud.fivekm.core.strava.repository.StravaUserRepository;

/**
 * Integration tests for {@link StravaUserRepository}
 * 
 * @author poilud
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {H2JpaConfig.class})
public class StravaUserRepositoryTest {

	@Autowired
	private StravaUserRepository repository;
	
	@AfterEach
	public void endOfTest() {
		repository.deleteAll();
	}
	
	@Test
	public void given_user_when_save_then_persist_object() {
		UserDescription usrDescription = UserDescription.builder()
				.firstname("firstname")
				.lastname("lastname")
				.build();
		
		StravaUser user = StravaUser.builder()
				.code("123456789")
				.userDescription(usrDescription)
				.build();
		
		StravaUser result = repository.save(user);
		
		assertThat(result).isNotNull();
		assertThat(result).isEqualToComparingFieldByField(user);		
	}
	
	@Test
	public void given_userId_when_find_then_return_an_object() {
		// before test
		UserDescription usrDescription = UserDescription.builder()
				.firstname("firstname")
				.lastname("lastname")
				.build();
		StravaUser user = StravaUser.builder()
				.userDescription(usrDescription)
				.build();
		user = repository.save(user);
		
		// given
		Long identifier  = user.getId();
		
		// When
		Optional<StravaUser> result = repository.findById(identifier);
		
		// Then
		assertThat(result.isPresent()).isEqualTo(true);
	}
}
