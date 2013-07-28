/*
 * Copyright 2011 the original author or authors.
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
package org.socialsignin.provider.lastfm;

import org.socialsignin.provider.AbstractProviderConfig;
import org.socialsignin.springsocial.security.LastFmConnectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.lastfm.api.LastFm;
import org.springframework.social.lastfm.api.impl.LastFmTemplate;
import org.springframework.social.lastfm.auth.LastFmAccessGrant;
import org.springframework.social.lastfm.pseudooauth2.connect.LastFmPseudoOAuth2ConnectionFactory;

/** 
* @author Michael Lavelle
*/
@Configuration
public class LastFmProviderConfig extends AbstractProviderConfig<LastFm> {

	public String getLastfmConsumerKey() {
		return lastfmConsumerKey;
	}

	public String getLastfmConsumerSecret() {
		return lastfmConsumerSecret;
	}

	@Autowired(required=false)
	private LastFmConnectInterceptor lastFmConnectInterceptor;

	@Value("${lastfm.consumerKey}")
	private String lastfmConsumerKey;

	@Value("${lastfm.consumerSecret}")
	private String lastfmConsumerSecret;
	
	public LastFmProviderConfig() {
		super();
	}
	
	public LastFmProviderConfig(String lastfmConsumerKey) {
		this.lastfmConsumerKey = lastfmConsumerKey;
	}
	
	public LastFmProviderConfig(String lastfmConsumerKey,
			LastFm authenticatedApi) {
		super(authenticatedApi);
		this.lastfmConsumerKey = lastfmConsumerKey;
	}
	public LastFmProviderConfig(String lastfmConsumerKey,String lastfmConsumerSecret,String token,String sessionKey) {
		super(new LastFmTemplate(new LastFmAccessGrant(token,sessionKey),lastfmConsumerKey,lastfmConsumerSecret));
		this.lastfmConsumerKey = lastfmConsumerKey;
		this.lastfmConsumerSecret = lastfmConsumerSecret;
	}
	
	public LastFmProviderConfig(String lastfmConsumerKey,String lastfmConsumerSecret,ConnectionRepository connectionRepository) {
		super(connectionRepository);
		this.lastfmConsumerSecret = lastfmConsumerSecret;
		this.lastfmConsumerSecret  = lastfmConsumerSecret;
	}

	public LastFmProviderConfig(String lastfmConsumerKey,String lastfmConsumerSecret,ConnectionRepository connectionRepository,
			UsersConnectionRepository usersConnectionRepository) {
		super(connectionRepository, usersConnectionRepository);
		this.lastfmConsumerKey = lastfmConsumerSecret;
		this.lastfmConsumerSecret  = lastfmConsumerSecret;
	}
	
	public LastFmProviderConfig(String lastfmConsumerKey,String lastfmConsumerSecret,String userId,	UsersConnectionRepository usersConnectionRepository) {
		super(userId,usersConnectionRepository);
		this.lastfmConsumerKey = lastfmConsumerKey;
		this.lastfmConsumerSecret  = lastfmConsumerSecret;
	}


	public void setLastfmConsumerKey(String lastfmConsumerKey) {
		this.lastfmConsumerKey = lastfmConsumerKey;
	}

	public void setLastfmConsumerSecret(String lastfmConsumerSecret) {
		this.lastfmConsumerSecret = lastfmConsumerSecret;
	}


	@Override
	protected ConnectInterceptor<LastFm> getConnectInterceptor() {
		return lastFmConnectInterceptor;
	}

	@Override
	public Class<LastFm> getApiClass() {
		return LastFm.class;
	}

}
