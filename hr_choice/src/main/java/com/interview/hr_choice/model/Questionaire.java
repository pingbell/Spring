package com.interview.hr_choice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_QUESTIONAIRE")
public class Questionaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="subject")
    private String subject;
    @Column(name="topic")
    private String topic;
    @Column(name="subtopic")
    private String subtopic;
    @Column(name="level")
    private String level;
    @Column(name="question")
    private String question;
    @Column(name="marks")
    private int marks;
	@Column(name="option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name="option4")
    private String option4;
    @Column(name="answer")
    private String answer;
    
    public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSubtopic() {
		return subtopic;
	}
	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Questionaire [id=" + id + ", subject=" + subject + ", topic=" + topic + ", subtopic=" + subtopic
				+ ", level=" + level + ", question=" + question + ", marks=" + marks + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + "]";
	}
}
