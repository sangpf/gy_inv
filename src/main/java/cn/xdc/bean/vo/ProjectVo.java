package cn.xdc.bean.vo;

import cn.xdc.bean.Project;

public class ProjectVo extends Project{

    private String managerName;  // 经理名
    private String supervisionName;  // 督导
    private String qualityIdName;  // 质检

    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getSupervisionName() {
        return supervisionName;
    }

    public void setSupervisionName(String supervisionName) {
        this.supervisionName = supervisionName;
    }

    public String getQualityIdName() {
        return qualityIdName;
    }

    public void setQualityIdName(String qualityIdName) {
        this.qualityIdName = qualityIdName;
    }
}
