package cn.xdc.bean.vo;

import cn.xdc.bean.Inv_user;
import cn.xdc.utils.DateUtil;

import java.util.Date;

public class Inv_userVo extends Inv_user {

    private String projectName; // 项目名称
    private Integer invId;
    private String invName; // 调查名称
    private Integer totalNum;  // 调查 目标分数
    private Integer distributionNum;  // 任务分配数量
    private Integer completedNum;  // 已完成数量
    private Date bTime;
    private Date eTime;
    private String groupLeaderName; // 组长
    private String userName; // 调查员姓名


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public Integer getInvId() {
        return invId;
    }

    @Override
    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Override
    public Integer getDistributionNum() {
        return distributionNum;
    }

    @Override
    public void setDistributionNum(Integer distributionNum) {
        this.distributionNum = distributionNum;
    }

    public Integer getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(Integer completedNum) {
        this.completedNum = completedNum;
    }

    public String getbTime() {
        return DateUtil.getStringByDateFormat(bTime);
    }
    public Date getDate_bTime(){
        return bTime;
    }
    public void setbTime(Date bTime) {
        this.bTime = bTime;
    }

    public String geteTime() {
        return DateUtil.getStringByDateFormat(eTime);
    }
    public Date getDate_eTime(){
        return eTime;
    }

    public void seteTime(Date eTime) {
        this.eTime = eTime;
    }

    public String getGroupLeaderName() {
        return groupLeaderName;
    }

    public void setGroupLeaderName(String groupLeaderName) {
        this.groupLeaderName = groupLeaderName;
    }
}
