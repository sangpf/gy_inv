package cn.xdc.service;

import cn.xdc.bean.Option;
import cn.xdc.bean.query.OptionQuery;
import cn.xdc.dao.OptionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OptionServiceImpl implements OptionService{

    @Resource
    private OptionDao optionDao;

    public void addOption(Option option) {
        optionDao.addOption(option);
    }

    public void deleteOptionByKey(Integer id) {
        optionDao.deleteOptionByKey(id);
    }

    public void deleteOptionByKeys(Integer[] ids) {
        optionDao.deleteOptionByKeys(ids);
    }

    public void updateOptionByKey(Option option) {
        optionDao.updateOptionByKey(option);
    }

    public Option getOptionByKey(Integer id) {
        return optionDao.getOptionByKey(id);
    }

    public List<Option> getOptionList(OptionQuery optionQuery) {
        return optionDao.getOptionList(optionQuery);
    }
}
