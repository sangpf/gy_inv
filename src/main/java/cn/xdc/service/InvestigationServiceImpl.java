package cn.xdc.service;

import cn.xdc.bean.Investigation;
import cn.xdc.bean.query.InvestigationQuery;
import cn.xdc.bean.vo.InvestigationVo;
import cn.xdc.common.page.Pagination;
import cn.xdc.dao.InvestigationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class InvestigationServiceImpl implements InvestigationService{

    @Resource
    private InvestigationDao investigationDao;

    public void addInvestigation(Investigation investigation) {
        investigationDao.addInvestigation(investigation);
    }

    public void deleteInvestigationByKey(Integer id) {
        investigationDao.deleteInvestigationByKey(id);
    }

    public void deleteInvestigationByKeys(Integer[] ids) {
        investigationDao.deleteInvestigationByKeys(ids);
    }

    public void updateInvestigationByKey(Investigation investigation) {
        investigationDao.updateInvestigationByKey(investigation);
    }

    public Investigation getInvestigationByKey(Integer id) {
        return investigationDao.getInvestigationByKey(id);
    }

    @Transactional(readOnly = true)
    public List<InvestigationVo> getInvestigationList(InvestigationQuery investigationQuery) {
        return investigationDao.getInvestigationList(investigationQuery);
    }

    @Transactional(readOnly = true)
    public Pagination getInvestigationListWithPage(InvestigationQuery investigationQuery) {
        Pagination p = new Pagination(investigationQuery.getPageNo(),investigationQuery.getPageSize(),investigationDao.getInvestigationListCount(investigationQuery));
        List<InvestigationVo> investigations = investigationDao.getInvestigationListWithPage(investigationQuery);

        p.setList(investigations);
        return p;
    }

}
