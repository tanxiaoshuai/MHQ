package com.sobey.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sobey.dao.RatingsDao;
import com.sobey.entity.CutPage;
import com.sobey.model.Ratings;
import com.sobey.util.CutPageUtil;
import com.sobey.util.ReturnInfo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class RatingServiceImpl implements IRatingService {

    public static Logger LOGGER = LoggerFactory.getLogger(RatingServiceImpl.class);

    @Autowired
    private RatingsDao dao;

    @Transactional
    @Override
    public Object insert(String body) throws Exception {
        dao.delete();
        JSONArray array = JSONArray.parseArray(body);
        for(int i = 0 ; i < array.size() ; i++){
            JSONObject object = array.getJSONObject(i);
            String name = object.getString("name");
            String type = object.getString("type");
            Double ratings = object.getDouble("ratings");
            Integer trend = object.getInteger("trend");
            dao.insertratings(name , type , ratings , trend);
        }
        return ReturnInfo.success();
    }

    @Override
    public Object search_list(String body) throws Exception {
        LOGGER.info("收视率请求参数：" + body);
        JSONObject object = JSONObject.parseObject(body);
        Long page = object.getLong("page");
        Integer size = object.getInteger("size");
        List list = dao.search_list((page - 1) * size , size);
        Long count = dao.count();
        CutPage<Ratings> cutPage = CutPageUtil.getCutPage(list , count , size);
        return ReturnInfo.success(cutPage);
    }

    @Override
    public Object ecxelInsert(MultipartFile file) throws Exception {
        dao.delete();
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        HSSFSheet sheet = workbook.getSheet(workbook.getSheetAt(0).getSheetName());
        int lineCout = sheet.getLastRowNum();
        for(int i = 2 ; i < lineCout + 1 ; i++){
            HSSFRow row = sheet.getRow(i);
            //名称
            String name = null;
            String type = null;
            Double ratings = null;
            Integer trend = null;
            String trendstr = null;
            try {
                name = row.getCell(0).getStringCellValue();
                type = row.getCell(1).getStringCellValue();
                ratings = row.getCell(2).getNumericCellValue();
                trendstr = row.getCell(3).getStringCellValue();
                if("上升".equals(trendstr)){
                    trend = 1;
                }
                if("下降".equals(trendstr)){
                    trend = 0;
                }
                dao.insertratings(name , type , ratings , trend);
            }catch (Exception e){
                continue;
            }
        }
        return ReturnInfo.success();
    }


}
