package com.bishe.main.dto;

import java.util.List;

public class ProblemJudgeDTO {
	private String runId;
	private float correctRate;
	private List<ProblemJudgeResultDTO> problemJudgeResultItems;

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public float getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(float correctRate) {
		this.correctRate = correctRate;
	}

	public List<ProblemJudgeResultDTO> getProblemJudgeResultItems() {
		return problemJudgeResultItems;
	}

	public void setProblemJudgeResultItems(
			List<ProblemJudgeResultDTO> problemJudgeResultItems) {
		this.problemJudgeResultItems = problemJudgeResultItems;
	}

	@Override
	public String toString() {
		return "ProblemJudgeResult [runId=" + runId + ", correctRate="
				+ correctRate + ", problemJudgeResultItems="
				+ problemJudgeResultItems + "]";
	}

}
