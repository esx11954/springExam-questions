package jp.eightbit.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.eightbit.exam.entity.Questions;
import jp.eightbit.exam.mapper.QuestionMapper;
import jp.eightbit.exam.model.QuestionModel;
import jp.eightbit.exam.model.QuestionResult;
import jp.eightbit.exam.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionMapper questionMapper;
	//private QuestionRepository questionRepo;
	
	
	public Questions getQuestion(Integer index) {
//		Questions q = questionRepo.getReferenceById(index.longValue());
		Questions q = questionMapper.findOne(index.longValue());
		System.out.println(q.toString());

		return q;
	}
	
	public List<QuestionResult> getResult(QuestionModel questionModel){
		List<Questions> questionList = questionMapper.findAll();
		QuestionResult qr = null;
		List<QuestionResult> resultList = new ArrayList<>();
		for(int i = 0; i < questionList.size(); i++) {
			Questions q = questionList.get(i);
			qr = new QuestionResult();
			qr.setQuestionSentence(q.getQuestionSentence());
			String answer = q.getAnswer();
			qr.setAnswerValue(answer);
			qr.setAnswerLabel(this.getAnswerLabel(answer, q));
			qr.setUserAnswerValue(this.getUserAnswerValue(i, questionModel));
			qr.setTrueOrFalse(answer.equals(qr.getUserAnswerValue()));
			qr.setUserAnswerLabel(this.getUserAnswerLabel(q, qr.getUserAnswerValue()));
			resultList.add(qr);
		}
		return resultList;
	}
	
	private String getAnswerLabel(String answer, Questions q) {
		String answerLable;
		if (answer.equals(q.getOption1Value())) {
			answerLable = q.getOption1Label();
		}else if(answer.equals(q.getOption2Value())) {
			answerLable = q.getOption2Label();
		}else if(answer.equals(q.getOption3Value())) {
			answerLable = q.getOption3Label();
		}else {
			answerLable = q.getOption4Label();
		}
		return answerLable;
	}
	private String getUserAnswerValue(int i, QuestionModel questionModel){
		String userAnswer;
		switch (i) {
		case 0:
			userAnswer = questionModel.getAnswer1();
			break;
		case 1:
			userAnswer = questionModel.getAnswer2();
			break;
		default:
			userAnswer = questionModel.getAnswer3();
		}
		return userAnswer;
	}
	private String getUserAnswerLabel(Questions q, String userAnswerValue){
		String userAnswerLabel;
		if (q.getOption1Value().equals(userAnswerValue)) {
			userAnswerLabel = q.getOption1Label();
		}else if (q.getOption2Value().equals(userAnswerValue)) {
			userAnswerLabel = q.getOption2Label();
		}else if (q.getOption3Value().equals(userAnswerValue)) {
			userAnswerLabel = q.getOption3Label();
		}else {
			userAnswerLabel = q.getOption4Label();
		}
		
		return userAnswerLabel;
	}
	public int getCorrectCount(List<QuestionResult> qrList) {
		int count = 0;
		for(QuestionResult qr: qrList) {
			if(qr.isTrueOrFalse()) count++;			
		}
		return count;
	}
	
}
