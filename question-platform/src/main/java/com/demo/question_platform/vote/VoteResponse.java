package com.demo.question_platform.vote;

public class VoteResponse {
    private int voteCount;
    private boolean isCorrect;

    // Constructor
    public VoteResponse(int voteCount, boolean isCorrect) {
        this.voteCount = voteCount;
        this.isCorrect = isCorrect;
    }

    // Getters and Setters
    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "VoteResponse{" +
                "voteCount=" + voteCount +
                ", isCorrect=" + isCorrect +
                '}';
    }
}

