/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.vysper.xmpp.server;

import org.apache.vysper.xmpp.authorization.SASLMechanism;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * switch configuration of optional server features
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Revision$ , $Date: 2009-04-21 13:13:19 +0530 (Tue, 21 Apr 2009) $
 */
public class ServerFeatures {

    private boolean startTLSRequired = true;

    private final List<SASLMechanism> authenticationMethods = new ArrayList<SASLMechanism>();

    /**
     * flag indicating whether message stanzas are relayed (sent to internal/external recipients)
     */
    private boolean relayMessages = true;

    /**
     * flag indicating whether message stanzas are relayed (sent to internal/external recipients)
     */
    private boolean relayPresence = true;

    /**
     * flag indicating whether stanzas are sent to remote servers or not
     */
    private boolean relayToFederationServers = false;

    /**
     * counter, how many times a session can try authentication before session is terminated
     */
    private int authenticationRetries = 3;

    public ServerFeatures() {
        // default constructor
    }

    public boolean isStartTLSRequired() {
        return startTLSRequired;
    }

    public void setStartTLSRequired(boolean startTLSRequired) {
        this.startTLSRequired = startTLSRequired;
    }

    public void setAuthenticationMethods(List<SASLMechanism> authenticationMethods) {
        this.authenticationMethods.addAll(authenticationMethods);
    }

    public List<SASLMechanism> getAuthenticationMethods() {
        return Collections.unmodifiableList(authenticationMethods);
    }

    public int getAuthenticationRetries() {
        return authenticationRetries;
    }

    public boolean isRelayingMessages() {
        return relayMessages;
    }

    public void setRelayingMessages(boolean relayMessages) {
        this.relayMessages = relayMessages;
    }

    public boolean isRelayingPresence() {
        return relayPresence;
    }

    public void setRelayingPresence(boolean relayPresence) {
        this.relayPresence = relayPresence;
    }

    public boolean isRelayingToFederationServers() {
        return relayToFederationServers;
    }

    public void setRelayingToFederationServers(boolean relayToFederationServers) {
        this.relayToFederationServers = relayToFederationServers;
    }
}