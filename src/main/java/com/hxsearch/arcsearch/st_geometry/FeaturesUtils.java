package com.hxsearch.arcsearch.st_geometry;



import org.geotools.geojson.geom.GeometryJSON;

import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;

/**
 * 功能描述：
 *
 * @Author: ddw
 * @Date: 2021/8/18 16:43
 */
public  class FeaturesUtils {

    public static String ClobToString(Clob clob) throws SQLException, IOException, IOException, SQLException {
        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            s = br.readLine();
        }

        reString = sb.toString();
        return reString;
    }
  public static  String ConvertWktToGeojson(String strwkt){
        String json = null;
        try{

            try {
                WKTReader reader=new WKTReader();
                Geometry geometry = reader.read(strwkt);
                StringWriter writer = new StringWriter();
                GeometryJSON g = new GeometryJSON(20);
                g.write(geometry,writer);
                json = writer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;

        }catch (Exception ex){
            System.out.println("wkt转换成Geojson出错 "+ex.getMessage());
        }

        return json;
  }
}
