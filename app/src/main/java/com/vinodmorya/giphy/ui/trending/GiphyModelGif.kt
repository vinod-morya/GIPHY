package com.vinodmorya.giphy.ui.trending

import androidx.annotation.Nullable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "GifTable")
class GiphyModelGif {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: String = ""
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("bitly_gif_url")
    @Expose
    var bitlyGifUrl: String? = null
    @SerializedName("bitly_url")
    @Expose
    var bitlyUrl: String? = null
    @SerializedName("embed_url")
    @Expose
    var embedUrl: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("source")
    @Expose
    var source: String? = null
    @SerializedName("rating")
    @Expose
    var rating: String? = null
    @SerializedName("content_url")
    @Expose
    var contentUrl: String? = null
    @SerializedName("source_tld")
    @Expose
    var sourceTld: String? = null
    @SerializedName("source_post_url")
    @Expose
    var sourcePostUrl: String? = null
    @SerializedName("import_datetime")
    @Expose
    var importDatetime: String? = null
    @SerializedName("trending_datetime")
    @Expose
    var trendingDatetime: String? = null
    @SerializedName("user")
    @Expose
    @Ignore
    @Nullable
    var user: User? = null
    @SerializedName("images")
    @Expose
    @Embedded(prefix = "images_")
    var images: Images? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("_score")
    @Expose
    var score: String? = null
    @SerializedName("fixUrl", alternate = ["images_fixw_fixedUrl"])
    @Expose
    var fixedWidthURL: String? = null
    @SerializedName("checked")
    @Expose
    var checked: Boolean = false
    @SerializedName("searchTag")
    @Expose
    var searchTag: String = ""

    inner class User : Serializable {

        @SerializedName("avatar_url")
        @Expose
        var avatarUrl: String? = null
        @SerializedName("banner_url")
        @Expose
        var bannerUrl: String? = null
        @SerializedName("banner_image")
        @Expose
        var bannerImage: String? = null
        @SerializedName("profile_url")
        @Expose
        var profileUrl: String? = null
        @SerializedName("username")
        @Expose
        var username: String? = null
        @SerializedName("display_name")
        @Expose
        var displayName: String? = null
        @SerializedName("is_verified")
        @Expose
        var isVerified: Boolean? = null

    }


        inner class Downsized : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null


        }

        inner class DownsizedLarge : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null

        }

        inner class DownsizedMedium : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null


        }

        inner class DownsizedSmall : Serializable {

            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null


        }

        inner class DownsizedStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null


        }

        inner class FixedHeight : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null


        }

        inner class FixedHeightDownsampled : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null


        }

        inner class FixedHeightSmall : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null


        }

        inner class FixedHeightSmallStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null


        }

        inner class FixedHeightStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null


        }



        inner class FixedWidthDownsampled : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null


        }

        inner class FixedWidthSmall : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null

        }

        inner class FixedWidthSmallStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null

        }

        inner class FixedWidthStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null

        }

        inner class Looping : Serializable {

            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null
        }

        inner class Original : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
            @SerializedName("frames")
            @Expose
            var frames: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null
            @SerializedName("webp")
            @Expose
            var webp: String? = null
            @SerializedName("webp_size")
            @Expose
            var webpSize: String? = null

        }

        inner class OriginalMp4 : Serializable {

            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null

        }

        inner class OriginalStill : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null


        }

        inner class Preview : Serializable {

            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("mp4")
            @Expose
            var mp4: String? = null
            @SerializedName("mp4_size")
            @Expose
            var mp4Size: String? = null

        }

        inner class PreviewGif : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null
        }

        inner class PreviewWebp : Serializable {

            @SerializedName("url")
            @Expose
            var url: String? = null
            @SerializedName("width")
            @Expose
            var width: String? = null
            @SerializedName("height")
            @Expose
            var height: String? = null
            @SerializedName("size")
            @Expose
            var size: String? = null

        }
    }

class Images : Serializable {
    @SerializedName("fixed_height_still")
    @Expose
    @Ignore
    var fixedHeightStill: GiphyModelGif.FixedHeightStill? = null
    @SerializedName("original_still")
    @Expose
    @Ignore
    var originalStill: GiphyModelGif.OriginalStill? = null
    @SerializedName("fixed_width")
    @Expose
    @Embedded(prefix = "fixw_")
    var fixedWidth: FixedWidth? = null
    @SerializedName("fixed_height_small_still")
    @Expose
    @Ignore
    var fixedHeightSmallStill: GiphyModelGif.FixedHeightSmallStill? = null
    @SerializedName("fixed_height_downsampled")
    @Expose
    @Ignore
    var fixedHeightDownsampled: GiphyModelGif.FixedHeightDownsampled? = null
    @SerializedName("preview")
    @Expose
    @Ignore
    var preview: GiphyModelGif.Preview? = null
    @SerializedName("fixed_height_small")
    @Expose
    @Ignore
    var fixedHeightSmall: GiphyModelGif.FixedHeightSmall? = null
    @SerializedName("downsized_still")
    @Expose
    @Ignore
    var downsizedStill: GiphyModelGif.DownsizedStill? = null
    @SerializedName("downsized")
    @Expose
    @Ignore
    var downsized: GiphyModelGif.Downsized? = null
    @SerializedName("downsized_large")
    @Expose
    @Ignore
    var downsizedLarge: GiphyModelGif.DownsizedLarge? = null
    @SerializedName("fixed_width_small_still")
    @Expose
    @Ignore
    var fixedWidthSmallStill: GiphyModelGif.FixedWidthSmallStill? = null
    @SerializedName("preview_webp")
    @Expose
    @Ignore
    var previewWebp: GiphyModelGif.PreviewWebp? = null
    @SerializedName("fixed_width_still")
    @Expose
    @Ignore
    var fixedWidthStill: GiphyModelGif.FixedWidthStill? = null
    @SerializedName("fixed_width_small")
    @Expose
    @Ignore
    var fixedWidthSmall: GiphyModelGif.FixedWidthSmall? = null
    @SerializedName("downsized_small")
    @Expose
    @Ignore
    var downsizedSmall: GiphyModelGif.DownsizedSmall? = null
    @SerializedName("fixed_width_downsampled")
    @Expose
    @Ignore
    var fixedWidthDownsampled: GiphyModelGif.FixedWidthDownsampled? = null
    @SerializedName("downsized_medium")
    @Expose
    @Ignore
    var downsizedMedium: GiphyModelGif.DownsizedMedium? = null
    @SerializedName("original")
    @Expose
    @Ignore
    var original: GiphyModelGif.Original? = null
    @SerializedName("fixed_height")
    @Expose
    @Ignore
    var fixedHeight: GiphyModelGif.FixedHeight? = null
    @SerializedName("looping")
    @Expose
    @Ignore
    var looping: GiphyModelGif.Looping? = null
    @SerializedName("original_mp4")
    @Expose
    @Ignore
    var originalMp4: GiphyModelGif.OriginalMp4? = null
    @SerializedName("preview_gif")
    @Expose
    @Ignore
    var previewGif: GiphyModelGif.PreviewGif? = null

}

 class FixedWidth : Serializable {
    @SerializedName("url")
    @Expose
    var fixedUrl: String? = null
    @SerializedName("width")
    @Expose
    @Ignore
    var width: String? = null
    @SerializedName("height")
    @Expose
    @Ignore
    var height: String? = null
    @SerializedName("size")
    @Expose
    @Ignore
    var size: String? = null
    @SerializedName("mp4")
    @Expose
    @Ignore
    var mp4: String? = null
    @SerializedName("mp4_size")
    @Expose
    @Ignore
    var mp4Size: String? = null
    @SerializedName("webp")
    @Expose
    @Ignore
    var webp: String? = null
    @SerializedName("webp_size")
    @Expose
    @Ignore
    var webpSize: String? = null


}

