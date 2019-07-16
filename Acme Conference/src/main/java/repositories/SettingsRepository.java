
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Settings;

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {

	@Query("select s from Settings s")
	Settings findSettings();

}
