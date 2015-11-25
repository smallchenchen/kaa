/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaaproject.kaa.client.context;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.kaaproject.kaa.client.channel.BootstrapTransport;
import org.kaaproject.kaa.client.channel.ConfigurationTransport;
import org.kaaproject.kaa.client.channel.EventTransport;
import org.kaaproject.kaa.client.channel.KaaChannelManager;
import org.kaaproject.kaa.client.channel.KaaTransport;
import org.kaaproject.kaa.client.channel.LogTransport;
import org.kaaproject.kaa.client.channel.MetaDataTransport;
import org.kaaproject.kaa.client.channel.NotificationTransport;
import org.kaaproject.kaa.client.channel.ProfileTransport;
import org.kaaproject.kaa.client.channel.RedirectionTransport;
import org.kaaproject.kaa.client.channel.UserTransport;
import org.kaaproject.kaa.client.persistence.KaaClientState;
import org.kaaproject.kaa.client.plugin.ExtensionId;
import org.kaaproject.kaa.client.plugin.PluginInstance;
import org.kaaproject.kaa.client.plugin.PluginInstanceAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TransportContext {

    private static final Logger LOG = LoggerFactory.getLogger(TransportContext.class);

    private final MetaDataTransport mdTransport;
    private final BootstrapTransport bootstrapTransport;
    private final ProfileTransport profileTransport;
    private final EventTransport eventTransport;
    private final NotificationTransport notificationTransport;
    private final ConfigurationTransport configurationTransport;
    private final UserTransport userTransport;
    private final RedirectionTransport redirectionTransport;
    private final LogTransport logTransport;
    private final Map<ExtensionId, PluginInstance<? extends PluginInstanceAPI>> pluginInstanceMap;

    public TransportContext(Map<ExtensionId, PluginInstance<? extends PluginInstanceAPI>> pluginInstanceMap, MetaDataTransport mdTransport,
            BootstrapTransport bootstrapTransport, ProfileTransport profileTransport, EventTransport eventTransport,
            NotificationTransport notificationTransport, ConfigurationTransport configurationTransport, UserTransport userTransport,
            RedirectionTransport redirectionTransport, LogTransport logTransport) {
        super();
        this.pluginInstanceMap = pluginInstanceMap;
        this.mdTransport = mdTransport;
        this.bootstrapTransport = bootstrapTransport;
        this.profileTransport = profileTransport;
        this.eventTransport = eventTransport;
        this.notificationTransport = notificationTransport;
        this.configurationTransport = configurationTransport;
        this.userTransport = userTransport;
        this.redirectionTransport = redirectionTransport;
        this.logTransport = logTransport;
    }

    public MetaDataTransport getMdTransport() {
        return mdTransport;
    }

    public BootstrapTransport getBootstrapTransport() {
        return bootstrapTransport;
    }

    public ProfileTransport getProfileTransport() {
        return profileTransport;
    }

    public EventTransport getEventTransport() {
        return eventTransport;
    }

    public NotificationTransport getNotificationTransport() {
        return notificationTransport;
    }

    public ConfigurationTransport getConfigurationTransport() {
        return configurationTransport;
    }

    public UserTransport getUserTransport() {
        return userTransport;
    }

    public RedirectionTransport getRedirectionTransport() {
        return redirectionTransport;
    }

    public LogTransport getLogTransport() {
        return logTransport;
    }
    
    public Map<ExtensionId, PluginInstance<? extends PluginInstanceAPI>> getPluginInstances() {
        return Collections.unmodifiableMap(pluginInstanceMap);
    }

    public PluginInstance<? extends PluginInstanceAPI> getPluginInstance(ExtensionId extensionId) {
        if (extensionId == null) {
            throw new IllegalArgumentException("Extension Id can't be null!");
        }
        PluginInstance<? extends PluginInstanceAPI> pluginInstance = pluginInstanceMap.get(extensionId);
        if (pluginInstance == null) {
            LOG.error("Can't find plugin instance for {}!", extensionId);
            throw new IllegalStateException("Plugin instance can't be null!");
        } else {
            return pluginInstance;
        }
    }

    public void initTransports(KaaChannelManager channelManager, KaaClientState clientState) {
        for (KaaTransport transport : Arrays.asList(bootstrapTransport, profileTransport, eventTransport, notificationTransport,
                configurationTransport, userTransport, logTransport)) {
            transport.setChannelManager(channelManager);
            transport.setClientState(clientState);
        }
    }
}
