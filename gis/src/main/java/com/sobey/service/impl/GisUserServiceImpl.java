package com.sobey.service.impl;
import com.sobey.dao.GisUserDao;
import com.sobey.model.GisUesr;
import com.sobey.service.IGisUserService;
import com.sobey.util.Dates;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GisUserServiceImpl implements IGisUserService{

    @Autowired
    private GisUserDao gisUserDao;

    @Override
    public Object getReports() throws Exception {
        List<GisUesr> list = gisUserDao.search();
        return ReturnInfo.success(list);
    }

    @Transactional
    @Override
    public Object insertReport(GisUesr user) throws Exception {
        int count = gisUserDao.count(user.getUsercode());
        user.setLstatus("1");
        user.setUpdatetime(Dates.getDate(System.currentTimeMillis()));
        if(count > 0){
            gisUserDao.update(user);
        }
        if(count == 0){
            gisUserDao.insertuser(user);
        }
        return ReturnInfo.success();
    }
}
