package net.slipp.answer.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.slipp.common.domain.AbstractEntity;
import net.slipp.member.domain.Member;
import net.slipp.question.domain.Question;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	@JsonProperty
	private Member writer;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
	@JsonProperty
	@JsonManagedReference
	private Question question;
	
	@Lob
	@JsonProperty
	private String contents;
	
	private LocalDateTime createDate;
	
	public Answer() {}
	
	public Answer(Member writer, Question question, String contents) {
		this.writer = writer;
		this.question = question;
		this.contents = contents;
		this.createDate = LocalDateTime.now();
	}
	
	public boolean isSameWriter(Member loginMember) {
		return loginMember.equals(this.writer);
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

	public Member getWriter() {
		return writer;
	}

	public void setWriter(Member writer) {
		this.writer = writer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Answer [" + super.toString() + "writer=" + writer + ", question=" + question + ", contents=" + contents + ", createDate=" + createDate + "]";
	}

}
