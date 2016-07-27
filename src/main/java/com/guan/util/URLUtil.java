package com.guan.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.CharEncoding;

public class URLUtil {
    public static String encode(String s) {
        try {
            return URLEncoder.encode(s, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public static String decode(String s) {
        try {
            return URLDecoder.decode(s, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
