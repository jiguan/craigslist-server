package com.guan.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;

import com.guan.domain.Post;

//http://www.baeldung.com/cascading-with-dbref-and-lifecycle-events-in-spring-data-mongodb
public class PostCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
   @Autowired
   private MongoOperations mongoOperations;

//   @Override
//   public void onBeforeConvert(final Object source) {
//       if (source instanceof Post && ((Post) source).getCategory() != null) {
//           mongoOperations.save(((User) source).getEmailAddress());
//       }
//   }
}
