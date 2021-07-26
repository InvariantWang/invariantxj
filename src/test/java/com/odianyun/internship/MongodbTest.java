package com.odianyun.internship;

import com.alibaba.fastjson.JSONObject;
import com.odianyun.internship.model.PO.Poi;
import com.odianyun.internship.startup.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * @author wxj
 * @date 2021/7/23 - 14:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class MongodbTest {
    @Resource
    private MongoTemplate mongoTemplate;
    @Test
    public void testFindById(){
        String id="60fa5ed62db4f21d285010d5";
        Poi poi=mongoTemplate.findById(id,Poi.class);
        System.out.println("poi:"+ JSONObject.toJSONString(poi));
    }
//    @Test
//    public void testFindByIndex(){
//       String name="金鸡湖";
//       Poi poi=mongoTemplate.findById(name,Poi.class);
//        System.ou t.println("poi:"+JSONObject.toJSONString(poi));
//    }
    @Test
public void testFindAll(){
    List<Poi> List = mongoTemplate.findAll(Poi.class);
    System.out.println("poiList :" + JSONObject.toJSONString(List));
}
@Test
    public void testFindWithWhere(){
    Query query=new Query(Criteria.where("_id").is("60fa5ed62db4f21d285010d5"));
    List<Poi> poiList=mongoTemplate.find(query,Poi.class);
    System.out.println("poilist:"+JSONObject.toJSONString(poiList));
    System.out.println("count:"+poiList.size());
}
    @Test
    public void testFindWithAnd() {

        Criteria criteria = new Criteria();
        criteria.and("name").is("狮子林");
        //criteria.and("type").is("景点");

        Query query = new Query(criteria);
        List<Poi> poiList = mongoTemplate.find(query, Poi.class);

        System.out.println("poiList == " + JSONObject.toJSONString(poiList));//如何将输出结果换行处理
        System.out.println("count == " + poiList.size());//23
    }
    @Test
    public void testFindWithOr() {
        Criteria criteria = new Criteria();

        // or
        criteria.orOperator(Criteria.where("name").is("狮子林"), Criteria.where("type").is("景点"));
        Query query = new Query(criteria);

        List<Poi> poiList = mongoTemplate.find(query, Poi.class);
        System.out.println("poiList == " + JSONObject.toJSONString(poiList));
        System.out.println("count == " + poiList.size());
    }
    @Test
    public void testFindWithNull() {
        Criteria criteria = new Criteria();
        // 值为null
        criteria.and("type").is(null);
        Query query = new Query(criteria);

        List<Poi> poiList = mongoTemplate.find(query, Poi.class);
        System.out.println("poiList == " + JSONObject.toJSONString(poiList));
        System.out.println("count == " + poiList.size());
    }

    @Test
    public void testFindWithRegex() {
        Criteria criteria = new Criteria();

        // 模糊查询
        String patternName = "金";
        Pattern pattern = Pattern.compile("^.*" + patternName + ".*$", Pattern.CASE_INSENSITIVE);
        criteria.and("name").regex(pattern);
        Query query = new Query(criteria);

        List<Poi> poiList = mongoTemplate.find(query, Poi.class);
        System.out.println("poiList == " + JSONObject.toJSONString(poiList));
        System.out.println("count == " + poiList.size());
    }


}
