package com.odianyun.internship.web;

import com.odianyun.internship.model.PO.Poi;
import com.odianyun.internship.service.PoiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wxj
 * @date 2021/7/23 - 13:03
 */
@RestController
@RequestMapping("poi")
public class PoiController {
    @Resource
    private PoiService poiService;
    @PostMapping("save")
    public String save(@RequestBody Poi poi){
        return poiService.save(poi);
    }
    @PostMapping("batchsave")
    public void batchsave(@RequestBody List<Poi>poiList){
        poiService.batchsave(poiList);
    }
}

