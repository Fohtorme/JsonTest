/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author jonas
 */
public class JsonTest {

    public static String TEST_XML_STRING
            = "<test attrib=\"moretest\">"
            + "<test attrib=\"moretest\">"
            + "<test attrib=\"moretest\">Turn this to JSON</test>"
            + "</test>"
            + "</test>"
            + "<test attrib=\"moretest\">"
            + "<test attrib=\"moretest\">"
            + "<test attrib=\"moretest\">Turn this to JSON</test>"
            + "</test>"
            + "</test>";

    JSONObject jsonObject;

    JsonTest() {
        this.jsonObject = XML.toJSONObject(TEST_XML_STRING);
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }

    public void sequentialReaderNext() {
        sequentialReaderNext(jsonObject.toMap());
    }

    public void sequentialReaderNext(Object o) {
        if (o instanceof Map) {
            sequentialReaderNext((Map) o);
        } else if (o instanceof ArrayList) {
            sequentialReaderNext((ArrayList) o);
        } else {
            System.out.println(o);
        }
    }

    public void sequentialReaderNext(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sequentialReaderNext(entry.getValue());
        }
    }

    public void sequentialReaderNext(ArrayList array) {
        for (Object o : array) {
            sequentialReaderNext(o);
        }
    }
}
