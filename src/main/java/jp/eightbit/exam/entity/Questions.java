package jp.eightbit.exam.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
@Table(name = "questions")
public class Questions {

//	@Id
//	@Column(name = "id")
	private long questionId;
//	@Column(name = "sentence")
	private String questionSentence;
//	@Column(name = "option1_value")
	private String option1Value;
//	@Column(name = "option1_label")
	private String option1Label;
//	@Column(name = "option2_value")
	private String option2Value;
//	@Column(name = "option2_label")
	private String option2Label;
//	@Column(name = "option3_value")
	private String option3Value;
//	@Column(name = "option3_label")
	private String option3Label;
//	@Column(name = "option4_value")
	private String option4Value;
//	@Column(name = "option4_label")
	private String option4Label;
//	@Column(name = "answer")
	private String answer;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionSentence() {
		return questionSentence;
	}
	public void setQuestionSentence(String questionSentence) {
		this.questionSentence = questionSentence;
	}
	public String getOption1Value() {
		return option1Value;
	}
	public void setOption1Value(String option1Value) {
		this.option1Value = option1Value;
	}
	public String getOption1Label() {
		return option1Label;
	}
	public void setOption1Label(String option1Label) {
		this.option1Label = option1Label;
	}
	public String getOption2Value() {
		return option2Value;
	}
	public void setOption2Value(String option2Value) {
		this.option2Value = option2Value;
	}
	public String getOption2Label() {
		return option2Label;
	}
	public void setOption2Label(String option2Label) {
		this.option2Label = option2Label;
	}
	public String getOption3Value() {
		return option3Value;
	}
	public void setOption3Value(String option3Value) {
		this.option3Value = option3Value;
	}
	public String getOption3Label() {
		return option3Label;
	}
	public void setOption3Label(String option3Label) {
		this.option3Label = option3Label;
	}
	public String getOption4Value() {
		return option4Value;
	}
	public void setOption4Value(String option4Value) {
		this.option4Value = option4Value;
	}
	public String getOption4Label() {
		return option4Label;
	}
	public void setOption4Label(String option4Label) {
		this.option4Label = option4Label;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionSentence=" + questionSentence + ", option1Value="
				+ option1Value + ", option1Label=" + option1Label + ", option2Value=" + option2Value + ", option2Label="
				+ option2Label + ", option3Value=" + option3Value + ", option3Label=" + option3Label + ", option4Value="
				+ option4Value + ", option4Label=" + option4Label + ", answer=" + answer + "]";
	}
	
	
}
