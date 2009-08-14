package org.apache.vysper.xmpp.modules.extension.xep0045_muc.handler;

import junit.framework.TestCase;

import org.apache.vysper.TestUtil;
import org.apache.vysper.xmpp.addressing.Entity;
import org.apache.vysper.xmpp.delivery.StanzaReceiverQueue;
import org.apache.vysper.xmpp.delivery.StanzaReceiverRelay;
import org.apache.vysper.xmpp.modules.extension.xep0045_muc.model.Conference;
import org.apache.vysper.xmpp.server.TestSessionContext;

/**
 */
public abstract class AbstractMUCPresenceHandlerTestCase extends TestCase {
    
    protected TestSessionContext sessionContext;

    protected Entity room1Jid = TestUtil.parseUnchecked("room1@vysper.org");
    protected Entity room2Jid = TestUtil.parseUnchecked("room2@vysper.org");

    protected Entity room1JidWithNick = TestUtil.parseUnchecked("room1@vysper.org/nick");
    protected Entity room2JidWithNick = TestUtil.parseUnchecked("room2@vysper.org/nick");
    
    protected Entity occupant1Jid = TestUtil.parseUnchecked("user1@vysper.org");
    protected Entity occupant2Jid = TestUtil.parseUnchecked("user2@vysper.org");
    protected MUCPresenceHandler handler;

    protected Conference conference = new Conference("foo");

    protected StanzaReceiverQueue occupant1Queue = new StanzaReceiverQueue();

    protected StanzaReceiverQueue occupant2Queue = new StanzaReceiverQueue();
    
    @Override
    protected void setUp() throws Exception {
        sessionContext = TestSessionContext.createWithStanzaReceiverRelayAuthenticated();
        sessionContext.setInitiatingEntity(occupant1Jid);
        
        StanzaReceiverRelay stanzaRelay = (StanzaReceiverRelay) sessionContext.getServerRuntimeContext().getStanzaRelay();
        stanzaRelay.add(occupant1Jid, occupant1Queue);
        stanzaRelay.add(occupant2Jid, occupant2Queue);
        
        conference.createRoom(room1Jid, "Room 1");
        
        handler = new MUCPresenceHandler(conference);
    }
}