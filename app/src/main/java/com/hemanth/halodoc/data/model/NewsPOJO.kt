package com.hemanth.halodoc.data.model


import com.google.gson.annotations.SerializedName

data class NewsPOJO(
    @SerializedName("exhaustiveNbHits")
    var exhaustiveNbHits: Boolean,
    @SerializedName("hits")
    var hits: List<Hit>,
    @SerializedName("hitsPerPage")
    var hitsPerPage: Int,
    @SerializedName("nbHits")
    var nbHits: Int,
    @SerializedName("nbPages")
    var nbPages: Int,
    @SerializedName("page")
    var page: Int,
    @SerializedName("params")
    var params: String,
    @SerializedName("processingTimeMS")
    var processingTimeMS: Int,
    @SerializedName("query")
    var query: String
) {
    data class Hit(
        @SerializedName("author")
        var author: String,
        @SerializedName("comment_text")
        var commentText: Any,
        @SerializedName("created_at")
        var createdAt: String,
        @SerializedName("created_at_i")
        var createdAtI: Int,
        @SerializedName("_highlightResult")
        var highlightResult: HighlightResult,
        @SerializedName("num_comments")
        var numComments: Int,
        @SerializedName("objectID")
        var objectID: String,
        @SerializedName("parent_id")
        var parentId: Any,
        @SerializedName("points")
        var points: Int,
        @SerializedName("relevancy_score")
        var relevancyScore: Int,
        @SerializedName("story_id")
        var storyId: Any,
        @SerializedName("story_text")
        var storyText: String,
        @SerializedName("story_title")
        var storyTitle: Any,
        @SerializedName("story_url")
        var storyUrl: Any,
        @SerializedName("_tags")
        var tags: List<String>,
        @SerializedName("title")
        var title: String,
        @SerializedName("url")
        var url: String
    ) {
        data class HighlightResult(
            @SerializedName("author")
            var author: Author,
            @SerializedName("story_text")
            var storyText: StoryText,
            @SerializedName("title")
            var title: Title,
            @SerializedName("url")
            var url: Url
        ) {
            data class Author(
                @SerializedName("matchLevel")
                var matchLevel: String,
                @SerializedName("matchedWords")
                var matchedWords: List<Any>,
                @SerializedName("value")
                var value: String
            )

            data class StoryText(
                @SerializedName("matchLevel")
                var matchLevel: String,
                @SerializedName("matchedWords")
                var matchedWords: List<Any>,
                @SerializedName("value")
                var value: String
            )

            data class Title(
                @SerializedName("fullyHighlighted")
                var fullyHighlighted: Boolean,
                @SerializedName("matchLevel")
                var matchLevel: String,
                @SerializedName("matchedWords")
                var matchedWords: List<String>,
                @SerializedName("value")
                var value: String
            )

            data class Url(
                @SerializedName("fullyHighlighted")
                var fullyHighlighted: Boolean,
                @SerializedName("matchLevel")
                var matchLevel: String,
                @SerializedName("matchedWords")
                var matchedWords: List<String>,
                @SerializedName("value")
                var value: String
            )
        }
    }
}
