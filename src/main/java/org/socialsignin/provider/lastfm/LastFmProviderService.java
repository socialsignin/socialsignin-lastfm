package org.socialsignin.provider.lastfm;

import org.socialsignin.provider.AbstractProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.lastfm.api.LastFm;
import org.springframework.social.lastfm.api.impl.LastFmTemplate;
import org.springframework.stereotype.Service;

@Service
public class LastFmProviderService extends AbstractProviderService<LastFm,LastFmProviderConfig> {

	public LastFmProviderService() {
		super();
	}

	public LastFmProviderService(LastFmProviderConfig providerConfig) {
		super(providerConfig);
	}

	@Override
	public LastFm getUnauthenticatedApi() {
		return new LastFmTemplate(providerConfig.getLastfmConsumerKey());
	}

}
