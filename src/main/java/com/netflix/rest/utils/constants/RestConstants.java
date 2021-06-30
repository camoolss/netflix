package com.netflix.rest.utils.constants;

/**
 * The Class RestConstants.
 */
public class RestConstants {

	/** The Constant APPLICATION_NAME. */
	public static final String APPLICATION_NAME = "/netflix";

	/** The Constant API_VERSION_1. */
	public static final String API_VERSION_1 = "/v1";

	/** The Constant SUCCESS. */
	public static final String SUCCESS = "Success";

	/** The Constant RESOURCE_CATEGORY. */
	public static final String RESOURCE_CATEGORY = "/category";

	/** The Constant RESOURCE_TV_SHOW. */
	public static final String RESOURCE_TV_SHOW = "/tvShow";

	
	public static final String RESOURCE_TV_SHOW_SEASON_CHARAPTER = "/tvShow/{tvShowId}/season/{seasonNumber}/chapter";

	public static final String RESOURCE_SEASON_CHARAPTER = "/tvShow/{tvShowId}/season/{seasonNumber}/chapter/{chapterNumber}";

	/** The Constant RESOURCE_TV_SHOW_UPDATE_NAME. */
	public static final String RESOURCE_TV_SHOW_UPDATE_NAME = "/{tvShowId}/name/{tvShowName}";

	/** The Constant RESOURCE_ACTOR_UPDATE. */
	public static final String RESOURCE_ACTOR_UPDATE = "/{id}/actorId/{actorId}/name/{actorName}/year/{year}";

	/** The Constant RESOURCE_SEASON. */
	public static final String RESOURCE_SEASON = "/tv-show/{tvShowId}/season";

	public static final String RESOURCE_SEASON_NUMBER = "/tv-show/{tvShowId}/season/{seasonNumber}";

	/** The Constant RESOURCE_CHAPTER. */
	public static final String RESOURCE_CHAPTER = "/tv-show/{tvShowId}/season/{seasonNumber}/chapter";

	/** The Constant RESOURCE_ACTOR. */
	public static final String RESOURCE_ACTOR = "/actor";

	/** The Constant RESOURCE_TV_SHOW_UPDATE_NAME. */
	public static final String RESOURCE_CHAPTER_UPDATE_NAME = "/chapter/{chapterId}/name/{chapterName}";

	/** The Constant RESOURCE_ID. */
	public static final String RESOURCE_ID = "/{id}";

	public static final String RESOURCE_ID_CATEGORY = "/category/{categoryId}";

	/** The Constant RESOURCE_NUMBER. */
	public static final String RESOURCE_NUMBER = "/{number}";

	/** The Constant PARAMETER_CATEGORY. */
	public static final String PARAMETER_CATEGORY = "category";
	
	public static final String RESOURCE_DELETE = "/detete/";
	
	public static final String RESOURCE_ADD = "/add/";

	/**
	 * Instantiates a new rest constants.
	 */
	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
