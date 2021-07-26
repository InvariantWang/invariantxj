package com.odianyun.internship.service.impl;

import com.odianyun.internship.model.PO.Poi;
import com.odianyun.internship.service.PoiService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wxj
 * @date 2021/7/23 - 13:06
 */
@Service
public class PoiServiceImpl implements PoiService {

    @Resource
   private MongoTemplate mongoTemplate;

    @Override
    public String save(Poi poi) {
        mongoTemplate.save(poi);
        return poi.getId();
    }

    @Override
    public void batchsave(List<Poi> poiList) {
        mongoTemplate.insertAll(poiList);
    }
}
