
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Integer> {

	@Query("select s from Submission s where s.author.id = ?1")
	Collection<Submission> findByReviewer(Integer authorId);

	@Query("select s from Submission s where s.paper.id = ?1")
	Submission findByPaper(Integer paperId);

	@Query("select s from Submission s where s.presentation.id = ?1")
	Collection<Submission> findByPresentation(Integer presentationId);

}
