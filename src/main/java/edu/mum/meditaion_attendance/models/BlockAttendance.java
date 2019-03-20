package edu.mum.meditaion_attendance.models;

public class BlockAttendance {

    private Integer sessionsInBlock;
    private Integer daysPresent;
    private Double percentageAttended;
    private Double extraCreditPoints;

    public Integer getSessionsInBlock() {
        return sessionsInBlock;
    }

    public void setSessionsInBlock(Integer sessionsInBlock) {
        this.sessionsInBlock = sessionsInBlock;
    }

    public Integer getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(Integer daysPresent) {
        this.daysPresent = daysPresent;
    }

    public Double getPercentageAttended() {
        return percentageAttended;
    }

    public void setPercentageAttended(Double percentageAttended) {
        this.percentageAttended = percentageAttended;
    }

    public Double getExtraCreditPoints() {
        return extraCreditPoints;
    }

    public void setExtraCreditPoints(Double extraCreditPoints) {
        this.extraCreditPoints = extraCreditPoints;
    }
}
