package com.odianyun.internship.service;

import com.odianyun.internship.model.PO.Poi;

import java.util.List;

/**
 * @author wxj
 * @date 2021/7/23 - 13:06
 */
public interface PoiService {
    String save(Poi poi);

    void batchsave(List<Poi> poiList);
}
