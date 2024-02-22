package com.luv2code.demo.rest;

public class StudentErrorResponse {

    private int status;
    private String massage;
    private long timeStamp;

    public StudentErrorResponse () {

    }

    public StudentErrorResponse(int status, String massage, long timeStamp) {
        this.status = status;
        this.massage = massage;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMassage() {
        return massage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
