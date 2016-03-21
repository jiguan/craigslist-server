package com.guan.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrettyPrint {
   static private ObjectMapper mapper = new ObjectMapper();

   static public String toJson(Object obj) {
      try {
         return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
         throw new RuntimeException("Parse objecto to json error");
      }
   }

}
