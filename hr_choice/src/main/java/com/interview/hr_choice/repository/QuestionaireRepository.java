package com.interview.hr_choice.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.hr_choice.model.Questionaire;



@Repository
public interface QuestionaireRepository extends CrudRepository<Questionaire, Long> {

}
