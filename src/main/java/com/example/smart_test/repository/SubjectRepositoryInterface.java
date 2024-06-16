package com.example.smart_test.repository;

import com.example.smart_test.domain.Subject;
import com.example.smart_test.dto.SubjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepositoryInterface extends JpaRepository<Subject, Long> {
    @Query(value = "SELECT идентификатор_предмет, название_предмета, описание_предмета, a.идентификатор_учитель_класс FROM(SELECT логин_пользователя, идентификатор_класс, идентификатор_учитель_класс  FROM пользователь inner join учитель_класс on пользователь.идентификатор_пользователя = учитель_класс.идентификатор_пользователя) as a inner join предмет on a.идентификатор_учитель_класс = предмет.идентификатор_учитель_класс where логин_пользователя = :login",
         nativeQuery = true)
    List<Subject> findByLogin(String login);

}
