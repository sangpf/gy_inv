package cn.xdc.bean.vo;

import cn.xdc.bean.Investigation;

public class InvestigationVo extends Investigation {

    private String groupLeaderName;
    private String groupLeaderNum;
    private String projectName;

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getGroupLeaderName() {
        return groupLeaderName;
    }
    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }
    public String getGroupLeaderNum() {
        return groupLeaderNum;
    }
    public void setGroupLeaderNum(String groupLeaderNum) {
        this.groupLeaderNum = groupLeaderNum;
    }
}
