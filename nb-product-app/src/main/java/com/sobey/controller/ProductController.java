package com.sobey.controller;
import com.sobey.dao.ProductAppDao;
import com.sobey.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductController {

    @Autowired
    private ProductAppDao productAppDao;

    @GetMapping(value = "/product/app/search")
    public Object getProduct(Integer type){
        Object obj = ReturnInfo.success(productAppDao.find(type));
        return obj;
    }
}
