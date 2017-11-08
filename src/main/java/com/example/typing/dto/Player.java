package com.example.typing.dto;

import java.io.Serializable;
import java.util.Date;

public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private String department;

    private String id;

    private String name;

    private String handleName;

    private boolean displayNameEnable;

    private int score;

    private int challengeCount;

    private boolean adminFlg;

    private Date lastPlayTime;

    private String ipAddress;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public boolean isDisplayNameEnable() {
        return displayNameEnable;
    }

    public void setDisplayNameEnable(boolean displayNameEnable) {
        this.displayNameEnable = displayNameEnable;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getChallengeCount() {
        return challengeCount;
    }

    public void setChallengeCount(int challengeCount) {
        this.challengeCount = challengeCount;
    }

    public boolean getAdminFlg() {
        return adminFlg;
    }

    public void setAdminFlg(boolean adminFlg) {
        this.adminFlg = adminFlg;
    }

    public Date getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(Date lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }



}
