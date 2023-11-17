package jp.eightbit.exam.model;

public class QuestionResult {

	private String questionSentence;
	private String answerLabel;
	private String answerValue;
	private String userAnswerValue;
	private String userAnswerLabel;
	private boolean trueOrFalse;
	public String getQuestionSentence() {
		return questionSentence;
	}
	public void setQuestionSentence(String questionSentence) {
		this.questionSentence = questionSentence;
	}
	public String getAnswerLabel() {
		return answerLabel;
	}
	public void setAnswerLabel(String answerLabel) {
		this.answerLabel = answerLabel;
	}
	public String getAnswerValue() {
		return answerValue;
	}
	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}
	public String getUserAnswerValue() {
		return userAnswerValue;
	}
	public void setUserAnswerValue(String userAnswer) {
		this.userAnswerValue = userAnswer;
	}
	public boolean isTrueOrFalse() {
		return trueOrFalse;
	}
	public void setTrueOrFalse(boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}
	
	public String getUserAnswerLabel() {
		return userAnswerLabel;
	}
	public void setUserAnswerLabel(String userAnswerLabel) {
		this.userAnswerLabel = userAnswerLabel;
	}
	@Override
	public String toString() {
		return "QuestionResult [questionSentence=" + questionSentence + ", answerLabel=" + answerLabel
				+ ", answerValue=" + answerValue + ", userAnswerValue=" + userAnswerValue + ", trueOrFalse=" + trueOrFalse + "]";
	}

}
