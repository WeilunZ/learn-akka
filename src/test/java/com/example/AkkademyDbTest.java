package com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.example.model.SetRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @program: akka-quickstart-java
 * @description:
 * @author: wl.zhou
 * @create: 2020-02-20 19:17
 **/
public class AkkademyDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMesssageIntoMap(){
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new SetRequest("key","value"), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        Assert.assertEquals(akkademyDb.map.get("key"),"value");
    }
}
