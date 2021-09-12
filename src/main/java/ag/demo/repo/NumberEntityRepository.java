package ag.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ag.demo.model.NumberEntity;

@Repository
public interface NumberEntityRepository extends JpaRepository<NumberEntity, Long> {
	List<NumberEntity> findByNumberLessThanEqual(int num);
}