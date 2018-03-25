package cn.xdc.bean.vo;

import cn.xdc.bean.Investigation;

public class InvestigationVo extends Investigation {

    private String groupLeaderName;
    private String groupLeaderNum;

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
