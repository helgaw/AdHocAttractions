package com.mobilitus.attractionscmd.spotify.internal.exceptions.detailed;


import com.mobilitus.attractionscmd.spotify.internal.exceptions.SpotifyWebApiException;

/**
 * The request could not be understood by the server due to malformed syntax.
 */
public class BadRequestException extends SpotifyWebApiException
{

    public BadRequestException()
    {
        super();
    }


    public BadRequestException(String message)
    {
        super(message);
    }


    public BadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
