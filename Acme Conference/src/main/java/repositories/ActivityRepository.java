
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	@Query("select a from Activity a where a.actor.id = ?1")
	Collection<Activity> findByActor(Integer actorId);

	@Query("select a from Activity a where a.comment.id = ?1")
	Activity findByComment(Integer commentId);

	@Query("select a from Activity a where a.conference.id = ?1")
	Collection<Activity> findByConference(Integer conferenceId);

}
