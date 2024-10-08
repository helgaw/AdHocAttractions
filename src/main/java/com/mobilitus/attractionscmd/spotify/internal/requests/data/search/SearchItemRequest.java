package com.mobilitus.attractionscmd.spotify.internal.requests.data.search;


import com.mobilitus.attractionscmd.spotify.internal.exceptions.SpotifyWebApiException;
import com.mobilitus.attractionscmd.spotify.internal.model_objects.special.SearchResult;
import com.mobilitus.attractionscmd.spotify.internal.requests.data.AbstractDataRequest;
import com.mobilitus.util.hexia.location.CountryCode;

import java.io.IOException;

/**
 * Get Spotify catalog information about artists, albums, tracks or playlists that match a keyword string.
 */
public class SearchItemRequest extends AbstractDataRequest
{

    /**
     * The private {@link SearchItemRequest} constructor.
     *
     * @param builder A {@link Builder}.
     */
    private SearchItemRequest(final Builder builder)
    {
        super(builder);
    }


    /**
     * Search for an item.
     *
     * @return A {@link SearchResult}.
     *
     * @throws IOException            In case of networking issues.
     * @throws SpotifyWebApiException The Web API returned an error further specified in this exception's root cause.
     */
    @SuppressWarnings("unchecked")
    public SearchResult execute() throws
                                  IOException,
                                  SpotifyWebApiException
    {
        return new SearchResult.JsonUtil().createModelObject(getJson());
    }


    /**
     * Builder class for building a {@link SearchItemRequest}.
     */
    public static final class Builder extends AbstractDataRequest.Builder<Builder>
    {

        /**
         * Create a new {@link Builder}.
         *
         * @param accessToken Required. A valid access token from the Spotify Accounts service.
         */
        public Builder(final String accessToken)
        {
            super(accessToken);
        }


        /**
         * The search query setter.
         *
         * @param q Required. The search query's keywords (and optional field filters and operators).
         *
         * @return A {@link Builder}.
         *
         * @see <a href="https://developer.spotify.com/web-api/search-item/#tablepress-47">Spotify: Search Query Options</a>
         */
        public Builder q(final String q)
        {
            assert (q != null);
            assert (!q.equals(""));
            return setQueryParameter("q", q);
        }


        /**
         * The type setter.
         *
         * @param type Required. A comma-separated list of item types to search across. Valid types are: {@code album},
         *             {@code artist}, {@code playlist}, and {@code track}.
         *
         * @return A {@link Builder}.
         */
        public Builder type(final String type)
        {
            assert (type != null);
            assert (type.matches("((^|,)(album|artist|playlist|track))+$"));
            return setQueryParameter("type", type);
        }


        /**
         * The market country code setter.
         *
         * @param market Optional. An ISO 3166-1 alpha-2 country code. If a country code is given, only artists,
         *               albums, and tracks with content playable in that market will be returned. (Playlist
         *               results are not affected by the market parameter.)
         *
         * @return A {@link Builder}.
         *
         * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">Wikipedia: ISO 3166-1 alpha-2 country codes</a>
         */
        public Builder market(final CountryCode market)
        {
            assert (market != null);
            return setQueryParameter("market", market);
        }


        /**
         * The limit setter.
         *
         * @param limit Optional. The maximum number of results to return. Default: 20. Minimum: 1. Maximum: 50.
         *
         * @return A {@link Builder}.
         */
        public Builder limit(final Integer limit)
        {
            assert (limit != null);
            assert (1 <= limit && limit <= 50);
            return setQueryParameter("limit", limit);
        }


        /**
         * The offset setter.
         *
         * @param offset Optional. The index of the first result to return. Default: 0 (i.e., the first result). Maximum
         *               offset: 100.000. Use with {@link #limit(Integer)} to get the next page of search results.
         *
         * @return A {@link Builder}.
         */
        public Builder offset(final Integer offset)
        {
            assert (offset != null);
            assert (0 <= offset && offset <= 100000);
            return setQueryParameter("offset", offset);
        }


        /**
         * The request build method.
         *
         * @return A {@link Builder}.
         */
        @Override
        public SearchItemRequest build()
        {
            setPath("/v1/search");
            return new SearchItemRequest(this);
        }
    }
}
