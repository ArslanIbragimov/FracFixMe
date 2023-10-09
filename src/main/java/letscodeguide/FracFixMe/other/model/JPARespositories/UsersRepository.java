package letscodeguide.FracFixMe.other.model.JPARespositories;

import letscodeguide.FracFixMe.other.model.tables.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Методы запросов
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation




@Repository
public interface UsersRepository extends JpaRepository<UsersTable, Long> {

    UsersTable findByUsernameAndPassword(String username, String password);

}