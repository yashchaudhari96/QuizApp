package com.quiz.demo.service;

import com.quiz.demo.Dao.QuestionDao;
import com.quiz.demo.Dao.QuizDao;
import com.quiz.demo.model.Question;
import com.quiz.demo.model.QuestionWrapper;
import com.quiz.demo.model.Quiz;
import com.quiz.demo.model.Resoponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);



    }

    public ResponseEntity<List<QuestionWrapper>>  getQuizQuestions(Integer id){

        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser=new ArrayList<>();

        for(Question q:questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
          questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Resoponse> resoponses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Resoponse response:resoponses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);


    }
}
