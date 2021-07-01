package com.netflix.rest.utils.constants;

// TODO: Auto-generated Javadoc
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

	/** The Constant RESOURCE_AWARD. */
	public static final String RESOURCE_AWARD = "/award";
	
	/** The Constant RESOURCE_TV_SHOW_SEASON_CHARAPTER. */
	public static final String RESOURCE_TV_SHOW_SEASON_CHARAPTER = "/{tvShowId}/season/{seasonNumber}/chapter";

	/** The Constant RESOURCE_SEASON_CHARAPTER. */
	public static final String RESOURCE_SEASON_CHARAPTER = "/{tvShowId}/season/{seasonNumber}/chapter/{chapterNumber}";

	/** The Constant RESOURCE_TV_SHOW_UPDATE_NAME. */
	public static final String RESOURCE_TV_SHOW_UPDATE_NAME = "/{tvShowId}/name/{tvShowName}";

	/** The Constant RESOURCE_ACTOR_UPDATE. */
	public static final String RESOURCE_ACTOR_UPDATE = "/{id}/actorId/{actorId}/name/{actorName}/year/{year}";

	/** The Constant RESOURCE_SEASON. */
	public static final String RESOURCE_SEASON = "/{tvShowId}/season";

	/** The Constant RESOURCE_SEASON_NUMBER. */
	public static final String RESOURCE_SEASON_NUMBER = "/{tvShowId}/season/{seasonNumber}";

	/** The Constant RESOURCE_CHAPTER. */
	public static final String RESOURCE_CHAPTER = "/{tvShowId}/season/{seasonNumber}/chapter";

	/** The Constant RESOURCE_ACTOR. */
	public static final String RESOURCE_ACTOR = "/actor";

	/** The Constant RESOURCE_TV_SHOW_UPDATE_NAME. */
	public static final String RESOURCE_CHAPTER_UPDATE_NAME = "/{chapterId}/name/{chapterName}";

	/** The Constant RESOURCE_ID. */
	public static final String RESOURCE_ID = "/{id}";
	
	/** The Constant RESOURCE_TVSHOW_ID. */
	public static final String RESOURCE_TVSHOW_ID = "/{tvShowId}";

	/** The Constant RESOURCE_ID_CATEGORY. */
	public static final String RESOURCE_ID_CATEGORY = "/category/{categoryId}";

	/** The Constant RESOURCE_NUMBER. */
	public static final String RESOURCE_NUMBER = "/{number}";

	/** The Constant PARAMETER_CATEGORY. */
	public static final String PARAMETER_CATEGORY = "category";
	
	/** The Constant RESOURCE_DELETE. */
	public static final String RESOURCE_DELETE = "/detete/";
	
	/** The Constant RESOURCE_ADD. */
	public static final String RESOURCE_ADD = "/add/";

	/**
	 * Instantiates a new rest constants.
	 */
	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
