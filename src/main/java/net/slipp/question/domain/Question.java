package net.slipp.question.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.slipp.answer.domain.Answer;
import net.slipp.common.domain.AbstractEntity;
import net.slipp.member.domain.Member;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question extends AbstractEntity {
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	@JsonProperty
	private Member writer;

	@JsonProperty
	private String title;
	
	@Lob
	@JsonProperty
	private String contents;
	
	@JsonProperty
	private Integer countOfAnswer = 0;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question")
	@OrderBy("id DESC")
	@JsonBackReference
	private List<Answer> answers;
	
	public Question() {}

	public Question(Member writer, String title, String contents) {
		super();
		this.writer = writer;
		this.title = title;
		this.contents = contents;
	}
	
	public void update(String newTitle, String newContents) {
		this.title = newTitle;
		this.contents = newContents;
	}
	
	public boolean isSameWriter(Member loginMember) {
		return this.writer.equals(loginMember);
	}
	
	public void addAnswer() {
		this.countOfAnswer += 1;
	}
	
	public void deleteAnswer() {
		this.countOfAnswer -= 1;
	}
	
	public Member getWriter() {
		return writer;
	}

	public void setWriter(Member writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Integer getCountOfAnswer() {
		return countOfAnswer;
	}

	public void setCountOfAnswer(Integer countOfAnswer) {
		this.countOfAnswer = countOfAnswer;
	}
	
	@Override
	public String toString() {
		return "Question [" + super.toString() + ", writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}
}
