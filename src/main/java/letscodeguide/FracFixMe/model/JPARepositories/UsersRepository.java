package letscodeguide.FracFixMe.model.JPARepositories;

import letscodeguide.FracFixMe.model.tables.UsersTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Помимо "Find", "And" и "Or" можно использовать следующие ключевые слова:

//- "Find" - указывает на начало запроса по конкретному полю или нескольким полям.
//- "And" - используется для объединения условий в запросе, при котором оба условия должны быть выполнены.
//- "Or" - используется для объединения условий в запросе, при котором хотя бы одно из условий должно быть выполнено.
//- "By" - указывает на начало запроса по имени поля
//- "In" - указывает на вхождение значения в список значений
//- "Not" - указывает на отрицание условия
//- "IsNull" - указывает на проверку на null значение
//- "IsNotNull" - указывает на проверку на not null значение
//- "OrderBy" - указывает на сортировку результатов запроса
//- "Distinct" - указывает на получение уникальных результатов

//При составлении метода запроса, обязательно соблюдать точность написания названий колон, из базы данных

@Repository
public interface UsersRepository extends JpaRepository<UsersTable, Long> {


    Optional<UsersTable> findByUsernameAndPassword(String username, String password);



}