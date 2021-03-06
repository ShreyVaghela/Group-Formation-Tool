package CSCI5308.GroupFormationTool.Questions;

import java.util.List;

public class Question implements IQuestion {
	private int questionID;
	private long instructorID;
	private String questionTitle;
	private String questionText;
	private String questionType;
	private String questionDateTime;
	private String type;
	private int value;

	private List<IQuestionOption> questionOptions;

	public Question() {
		setDefaults();
	}

	private void setDefaults() {
		questionID = -1;
		instructorID = -1;
		questionTitle = "";
		questionText = "";
		questionType = "";
		questionDateTime = "";
		type = "";
		value = -1;
	}

	public Question(IQuestionPersistence questionDB, long questionID) {
		questionDB.loadQuestionByID(this, questionID);
	}

	public long getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(long instructorID) {
		this.instructorID = instructorID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int quesID) {
		this.questionID = quesID;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String quesTitle) {
		this.questionTitle = quesTitle;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String quesType) {
		this.questionType = quesType;
	}

	public String getQuestionDateTime() {
		return questionDateTime;
	}

	public void setQuestionDateTime(String quesDateTime) {
		this.questionDateTime = quesDateTime;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String quesText) {
		this.questionText = quesText;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean deleteQuestion(IQuestionPersistence questionDB) {
		return questionDB.deleteQuestion(questionID);
	}

	public List<IQuestionResponse> getAllResponses(IQuestionResponsePersistence responseDB) {
		return responseDB.getAllResponsesOfQuestion(questionID);
	}

	public boolean checkIfQuestionHasResponse() {
		List<IQuestionResponse> responseList = getAllResponses(QuestionsSystemConfig.instance().getReponseDB());
		if (null == responseList || responseList.size() == 0) {
			return false;
		}
		return true;
	}

	public long createQuestion(IQuestionPersistence questionDB) {
		return questionDB.createQuestion(this);
	}

	public List<IQuestionOption> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<IQuestionOption> questionOptions) {
		this.questionOptions = questionOptions;
	}
}