package com.example.hotelsapp.data.remote.dto.responses.gethoteldetails


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("accessibleTags")
    val accessibleTags: Any?,
    @SerializedName("adSizes")
    val adSizes: List<String>?,
    @SerializedName("adUnitId")
    val adUnitId: String?,
    @SerializedName("address")
    val address: Address?,
    @SerializedName("anchor")
    val anchor: Anchor?,
    @SerializedName("background")
    val background: Any?,
    @SerializedName("badge")
    val badge: Any?,
    @SerializedName("bookViaHotelWebsite")
    val bookViaHotelWebsite: Any?,
    @SerializedName("bookViaHotelWebsiteSubtitle")
    val bookViaHotelWebsiteSubtitle: Any?,
    @SerializedName("byProviderLink")
    val byProviderLink: Any?,
    @SerializedName("center")
    val center: Center?,
    @SerializedName("clusterId")
    val clusterId: String?,
    @SerializedName("contactLinks")
    val contactLinks: List<ContactLink>?,
    @SerializedName("datePicker")
    val datePicker: DatePicker?,
    @SerializedName("distance")
    val distance: Any?,
    @SerializedName("divider")
    val divider: Any?,
    @SerializedName("galleryLink")
    val galleryLink: GalleryLink?,
    @SerializedName("gettingThere")
    val gettingThere: GettingThere?,
    @SerializedName("heroContent")
    val heroContent: List<HeroContent>?,
    @SerializedName("hotelCommerceInfo")
    val hotelCommerceInfo: HotelCommerceInfo?,
    @SerializedName("hotelWebsite")
    val hotelWebsite: Any?,
    @SerializedName("improveThisListingRoute")
    val improveThisListingRoute: ImproveThisListingRoute?,
    @SerializedName("isLarge")
    val isLarge: Boolean?,
    @SerializedName("isReviewCountUnderlined")
    val isReviewCountUnderlined: Any?,
    @SerializedName("labels")
    val labels: List<Any>?,
    @SerializedName("link")
    val link: Any?,
    @SerializedName("managementCenterRoute")
    val managementCenterRoute: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("neighborhood")
    val neighborhood: Any?,
    @SerializedName("nonNullContent")
    val nonNullContent: List<NonNullContent>?,
    @SerializedName("nullableContent")
    val nullableContent: List<NullableContent>?,
    @SerializedName("nullableText")
    val nullableText: NullableText?,
    @SerializedName("numberReviews")
    val numberReviews: Int?,
    @SerializedName("ownerStatus")
    val ownerStatus: Any?,
    @SerializedName("photoCTA")
    val photoCTA: PhotoCTA?,
    @SerializedName("photoCount")
    val photoCount: Int?,
    @SerializedName("pins")
    val pins: List<Pin>?,
    @SerializedName("plusOfferNoLongerAvailableNotice")
    val plusOfferNoLongerAvailableNotice: Any?,
    @SerializedName("primaryOfferV2")
    val primaryOfferV2: PrimaryOfferV2?,
    @SerializedName("productLabel")
    val productLabel: Any?,
    @SerializedName("rankingDetailsV2")
    val rankingDetailsV2: RankingDetailsV2?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("reviewCTA")
    val reviewCTA: ReviewCTA?,
    @SerializedName("reviewsLink")
    val reviewsLink: ReviewsLink?,
    @SerializedName("route")
    val route: RouteXXXXXXXX?,
    @SerializedName("sectionDescription")
    val sectionDescription: SectionDescription?,
    @SerializedName("sectionTitle")
    val sectionTitle: SectionTitleX?,
    @SerializedName("sectionType")
    val sectionType: String?,
    @SerializedName("showMore")
    val showMore: ShowMore?,
    @SerializedName("similarHotels")
    val similarHotels: Any?,
    @SerializedName("spacing")
    val spacing: String?,
    @SerializedName("sponsoredBy")
    val sponsoredBy: Any?,
    @SerializedName("stableDiffingType")
    val stableDiffingType: String,
    @SerializedName("state")
    val state: String?,
    @SerializedName("tabs")
    val tabs: List<Tab>?,
    @SerializedName("tagsSubsection")
    val tagsSubsection: TagsSubsection?,
    @SerializedName("tagsV2")
    val tagsV2: Any?,
    @SerializedName("targetingParams")
    val targetingParams: List<TargetingParam>?,
    @SerializedName("tooltip")
    val tooltip: Any?,
    @SerializedName("trackingKey")
    val trackingKey: String?,
    @SerializedName("trackingTitle")
    val trackingTitle: String?,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("viewAll")
    val viewAll: ViewAll?
)