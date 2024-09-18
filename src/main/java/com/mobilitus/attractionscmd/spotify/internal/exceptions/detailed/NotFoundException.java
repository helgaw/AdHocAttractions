package com.mobilitus.attractionscmd.spotify.internal.exceptions.detailed;


import com.mobilitus.attractionscmd.spotify.internal.exceptions.SpotifyWebApiException;

/**
 * The requested resource could not be found. This error can be due to a temporary or permanent condition.
 */
public class NotFoundException extends SpotifyWebApiException
{

    public NotFoundException()
    {
        super();
    }


    public NotFoundException(String message)
    {
        super(message);
    }


    public NotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
