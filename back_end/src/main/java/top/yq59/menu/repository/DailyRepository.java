package top.yq59.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.yq59.menu.model.entity.Daily;

import java.sql.Date;
import java.util.Set;

public interface DailyRepository extends JpaRepository<Daily,Integer>, JpaSpecificationExecutor<Daily> {
    Set<Daily> findAllByDay(Date day);
}
