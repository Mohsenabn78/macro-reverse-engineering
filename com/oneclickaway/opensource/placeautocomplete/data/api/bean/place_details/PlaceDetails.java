package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.getpebble.android.kit.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PlaceDetails.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b]\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010#J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010XJ\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010XJ\u0013\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0007HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010IJ\u0013\u0010v\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0007HÆ\u0003J\u0013\u0010w\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0007HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÂ\u0002\u0010y\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00072\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010zJ\t\u0010{\u001a\u00020\u0003HÖ\u0001J\u0013\u0010|\u001a\u00020}2\b\u0010~\u001a\u0004\u0018\u00010\u007fHÖ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0081\u0001\u001a\u00020\u0005HÖ\u0001J\u001e\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0003HÖ\u0001R(\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010)\"\u0004\bN\u0010+R(\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010%\"\u0004\bP\u0010'R \u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010)\"\u0004\bR\u0010+R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010%\"\u0004\bT\u0010'R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010)\"\u0004\bV\u0010+R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010[\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010)\"\u0004\ba\u0010+¨\u0006\u0087\u0001"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "Landroid/os/Parcelable;", "utcOffset", "", "formattedAddress", "", "types", "", "website", Constants.CUST_ICON, "rating", "", "addressComponents", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/AddressComponentsItem;", "photos", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PhotosItem;", ImagesContract.URL, "reference", "userRatingsTotal", "reviews", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/ReviewsItem;", "scope", "name", "openingHours", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;", "geometry", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;", "vicinity", "id", "adrAddress", "plusCode", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;", "formattedPhoneNumber", "internationalPhoneNumber", "placeId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddressComponents", "()Ljava/util/List;", "setAddressComponents", "(Ljava/util/List;)V", "getAdrAddress", "()Ljava/lang/String;", "setAdrAddress", "(Ljava/lang/String;)V", "getFormattedAddress", "setFormattedAddress", "getFormattedPhoneNumber", "setFormattedPhoneNumber", "getGeometry", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;", "setGeometry", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;)V", "getIcon", "setIcon", "getId", "setId", "getInternationalPhoneNumber", "setInternationalPhoneNumber", "getName", "setName", "getOpeningHours", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;", "setOpeningHours", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;)V", "getPhotos", "setPhotos", "getPlaceId", "setPlaceId", "getPlusCode", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;", "setPlusCode", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;)V", "getRating", "()Ljava/lang/Double;", "setRating", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getReference", "setReference", "getReviews", "setReviews", "getScope", "setScope", "getTypes", "setTypes", "getUrl", "setUrl", "getUserRatingsTotal", "()Ljava/lang/Integer;", "setUserRatingsTotal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUtcOffset", "setUtcOffset", "getVicinity", "setVicinity", "getWebsite", "setWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PlaceDetails implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("address_components")
    @Nullable
    private List<AddressComponentsItem> addressComponents;
    @SerializedName("adr_address")
    @Nullable
    private String adrAddress;
    @SerializedName("formatted_address")
    @Nullable
    private String formattedAddress;
    @SerializedName("formatted_phone_number")
    @Nullable
    private String formattedPhoneNumber;
    @SerializedName("geometry")
    @Nullable
    private Geometry geometry;
    @SerializedName(Constants.CUST_ICON)
    @Nullable
    private String icon;
    @SerializedName("id")
    @Nullable
    private String id;
    @SerializedName("international_phone_number")
    @Nullable
    private String internationalPhoneNumber;
    @SerializedName("name")
    @Nullable
    private String name;
    @SerializedName("opening_hours")
    @Nullable
    private OpeningHours openingHours;
    @SerializedName("photos")
    @Nullable
    private List<PhotosItem> photos;
    @SerializedName("place_id")
    @Nullable
    private String placeId;
    @SerializedName("plus_code")
    @Nullable
    private PlusCode plusCode;
    @SerializedName("rating")
    @Nullable
    private Double rating;
    @SerializedName("reference")
    @Nullable
    private String reference;
    @SerializedName("reviews")
    @Nullable
    private List<ReviewsItem> reviews;
    @SerializedName("scope")
    @Nullable
    private String scope;
    @SerializedName("types")
    @Nullable
    private List<String> types;
    @SerializedName(ImagesContract.URL)
    @Nullable
    private String url;
    @SerializedName("user_ratings_total")
    @Nullable
    private Integer userRatingsTotal;
    @SerializedName("utc_offset")
    @Nullable
    private Integer utcOffset;
    @SerializedName("vicinity")
    @Nullable
    private String vicinity;
    @SerializedName("website")
    @Nullable
    private String website;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Integer num;
            Double d4;
            ArrayList arrayList;
            ArrayList arrayList2;
            Integer num2;
            ArrayList arrayList3;
            OpeningHours openingHours;
            Geometry geometry;
            PlusCode plusCode;
            ReviewsItem reviewsItem;
            PhotosItem photosItem;
            AddressComponentsItem addressComponentsItem;
            Intrinsics.checkParameterIsNotNull(in, "in");
            if (in.readInt() != 0) {
                num = Integer.valueOf(in.readInt());
            } else {
                num = null;
            }
            String readString = in.readString();
            ArrayList<String> createStringArrayList = in.createStringArrayList();
            String readString2 = in.readString();
            String readString3 = in.readString();
            if (in.readInt() != 0) {
                d4 = Double.valueOf(in.readDouble());
            } else {
                d4 = null;
            }
            if (in.readInt() != 0) {
                int readInt = in.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    if (in.readInt() != 0) {
                        addressComponentsItem = (AddressComponentsItem) AddressComponentsItem.CREATOR.createFromParcel(in);
                    } else {
                        addressComponentsItem = null;
                    }
                    arrayList.add(addressComponentsItem);
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (in.readInt() != 0) {
                int readInt2 = in.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    if (in.readInt() != 0) {
                        photosItem = (PhotosItem) PhotosItem.CREATOR.createFromParcel(in);
                    } else {
                        photosItem = null;
                    }
                    arrayList2.add(photosItem);
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            String readString4 = in.readString();
            String readString5 = in.readString();
            if (in.readInt() != 0) {
                num2 = Integer.valueOf(in.readInt());
            } else {
                num2 = null;
            }
            if (in.readInt() != 0) {
                int readInt3 = in.readInt();
                arrayList3 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    if (in.readInt() != 0) {
                        reviewsItem = (ReviewsItem) ReviewsItem.CREATOR.createFromParcel(in);
                    } else {
                        reviewsItem = null;
                    }
                    arrayList3.add(reviewsItem);
                    readInt3--;
                }
            } else {
                arrayList3 = null;
            }
            String readString6 = in.readString();
            String readString7 = in.readString();
            if (in.readInt() != 0) {
                openingHours = (OpeningHours) OpeningHours.CREATOR.createFromParcel(in);
            } else {
                openingHours = null;
            }
            if (in.readInt() != 0) {
                geometry = (Geometry) Geometry.CREATOR.createFromParcel(in);
            } else {
                geometry = null;
            }
            String readString8 = in.readString();
            String readString9 = in.readString();
            String readString10 = in.readString();
            if (in.readInt() != 0) {
                plusCode = (PlusCode) PlusCode.CREATOR.createFromParcel(in);
            } else {
                plusCode = null;
            }
            return new PlaceDetails(num, readString, createStringArrayList, readString2, readString3, d4, arrayList, arrayList2, readString4, readString5, num2, arrayList3, readString6, readString7, openingHours, geometry, readString8, readString9, readString10, plusCode, in.readString(), in.readString(), in.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new PlaceDetails[i4];
        }
    }

    public PlaceDetails() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ItemViewTypeComposer.MAX_WRAPPED_VIEW_TYPE, null);
    }

    @Nullable
    public final Integer component1() {
        return this.utcOffset;
    }

    @Nullable
    public final String component10() {
        return this.reference;
    }

    @Nullable
    public final Integer component11() {
        return this.userRatingsTotal;
    }

    @Nullable
    public final List<ReviewsItem> component12() {
        return this.reviews;
    }

    @Nullable
    public final String component13() {
        return this.scope;
    }

    @Nullable
    public final String component14() {
        return this.name;
    }

    @Nullable
    public final OpeningHours component15() {
        return this.openingHours;
    }

    @Nullable
    public final Geometry component16() {
        return this.geometry;
    }

    @Nullable
    public final String component17() {
        return this.vicinity;
    }

    @Nullable
    public final String component18() {
        return this.id;
    }

    @Nullable
    public final String component19() {
        return this.adrAddress;
    }

    @Nullable
    public final String component2() {
        return this.formattedAddress;
    }

    @Nullable
    public final PlusCode component20() {
        return this.plusCode;
    }

    @Nullable
    public final String component21() {
        return this.formattedPhoneNumber;
    }

    @Nullable
    public final String component22() {
        return this.internationalPhoneNumber;
    }

    @Nullable
    public final String component23() {
        return this.placeId;
    }

    @Nullable
    public final List<String> component3() {
        return this.types;
    }

    @Nullable
    public final String component4() {
        return this.website;
    }

    @Nullable
    public final String component5() {
        return this.icon;
    }

    @Nullable
    public final Double component6() {
        return this.rating;
    }

    @Nullable
    public final List<AddressComponentsItem> component7() {
        return this.addressComponents;
    }

    @Nullable
    public final List<PhotosItem> component8() {
        return this.photos;
    }

    @Nullable
    public final String component9() {
        return this.url;
    }

    @NotNull
    public final PlaceDetails copy(@Nullable Integer num, @Nullable String str, @Nullable List<String> list, @Nullable String str2, @Nullable String str3, @Nullable Double d4, @Nullable List<AddressComponentsItem> list2, @Nullable List<PhotosItem> list3, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable List<ReviewsItem> list4, @Nullable String str6, @Nullable String str7, @Nullable OpeningHours openingHours, @Nullable Geometry geometry, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable PlusCode plusCode, @Nullable String str11, @Nullable String str12, @Nullable String str13) {
        return new PlaceDetails(num, str, list, str2, str3, d4, list2, list3, str4, str5, num2, list4, str6, str7, openingHours, geometry, str8, str9, str10, plusCode, str11, str12, str13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PlaceDetails) {
                PlaceDetails placeDetails = (PlaceDetails) obj;
                if (!Intrinsics.areEqual(this.utcOffset, placeDetails.utcOffset) || !Intrinsics.areEqual(this.formattedAddress, placeDetails.formattedAddress) || !Intrinsics.areEqual(this.types, placeDetails.types) || !Intrinsics.areEqual(this.website, placeDetails.website) || !Intrinsics.areEqual(this.icon, placeDetails.icon) || !Intrinsics.areEqual((Object) this.rating, (Object) placeDetails.rating) || !Intrinsics.areEqual(this.addressComponents, placeDetails.addressComponents) || !Intrinsics.areEqual(this.photos, placeDetails.photos) || !Intrinsics.areEqual(this.url, placeDetails.url) || !Intrinsics.areEqual(this.reference, placeDetails.reference) || !Intrinsics.areEqual(this.userRatingsTotal, placeDetails.userRatingsTotal) || !Intrinsics.areEqual(this.reviews, placeDetails.reviews) || !Intrinsics.areEqual(this.scope, placeDetails.scope) || !Intrinsics.areEqual(this.name, placeDetails.name) || !Intrinsics.areEqual(this.openingHours, placeDetails.openingHours) || !Intrinsics.areEqual(this.geometry, placeDetails.geometry) || !Intrinsics.areEqual(this.vicinity, placeDetails.vicinity) || !Intrinsics.areEqual(this.id, placeDetails.id) || !Intrinsics.areEqual(this.adrAddress, placeDetails.adrAddress) || !Intrinsics.areEqual(this.plusCode, placeDetails.plusCode) || !Intrinsics.areEqual(this.formattedPhoneNumber, placeDetails.formattedPhoneNumber) || !Intrinsics.areEqual(this.internationalPhoneNumber, placeDetails.internationalPhoneNumber) || !Intrinsics.areEqual(this.placeId, placeDetails.placeId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final List<AddressComponentsItem> getAddressComponents() {
        return this.addressComponents;
    }

    @Nullable
    public final String getAdrAddress() {
        return this.adrAddress;
    }

    @Nullable
    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    @Nullable
    public final String getFormattedPhoneNumber() {
        return this.formattedPhoneNumber;
    }

    @Nullable
    public final Geometry getGeometry() {
        return this.geometry;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getInternationalPhoneNumber() {
        return this.internationalPhoneNumber;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final OpeningHours getOpeningHours() {
        return this.openingHours;
    }

    @Nullable
    public final List<PhotosItem> getPhotos() {
        return this.photos;
    }

    @Nullable
    public final String getPlaceId() {
        return this.placeId;
    }

    @Nullable
    public final PlusCode getPlusCode() {
        return this.plusCode;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final String getReference() {
        return this.reference;
    }

    @Nullable
    public final List<ReviewsItem> getReviews() {
        return this.reviews;
    }

    @Nullable
    public final String getScope() {
        return this.scope;
    }

    @Nullable
    public final List<String> getTypes() {
        return this.types;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Integer getUserRatingsTotal() {
        return this.userRatingsTotal;
    }

    @Nullable
    public final Integer getUtcOffset() {
        return this.utcOffset;
    }

    @Nullable
    public final String getVicinity() {
        return this.vicinity;
    }

    @Nullable
    public final String getWebsite() {
        return this.website;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        Integer num = this.utcOffset;
        int i26 = 0;
        if (num != null) {
            i4 = num.hashCode();
        } else {
            i4 = 0;
        }
        int i27 = i4 * 31;
        String str = this.formattedAddress;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i28 = (i27 + i5) * 31;
        List<String> list = this.types;
        if (list != null) {
            i6 = list.hashCode();
        } else {
            i6 = 0;
        }
        int i29 = (i28 + i6) * 31;
        String str2 = this.website;
        if (str2 != null) {
            i7 = str2.hashCode();
        } else {
            i7 = 0;
        }
        int i30 = (i29 + i7) * 31;
        String str3 = this.icon;
        if (str3 != null) {
            i8 = str3.hashCode();
        } else {
            i8 = 0;
        }
        int i31 = (i30 + i8) * 31;
        Double d4 = this.rating;
        if (d4 != null) {
            i9 = d4.hashCode();
        } else {
            i9 = 0;
        }
        int i32 = (i31 + i9) * 31;
        List<AddressComponentsItem> list2 = this.addressComponents;
        if (list2 != null) {
            i10 = list2.hashCode();
        } else {
            i10 = 0;
        }
        int i33 = (i32 + i10) * 31;
        List<PhotosItem> list3 = this.photos;
        if (list3 != null) {
            i11 = list3.hashCode();
        } else {
            i11 = 0;
        }
        int i34 = (i33 + i11) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i12 = str4.hashCode();
        } else {
            i12 = 0;
        }
        int i35 = (i34 + i12) * 31;
        String str5 = this.reference;
        if (str5 != null) {
            i13 = str5.hashCode();
        } else {
            i13 = 0;
        }
        int i36 = (i35 + i13) * 31;
        Integer num2 = this.userRatingsTotal;
        if (num2 != null) {
            i14 = num2.hashCode();
        } else {
            i14 = 0;
        }
        int i37 = (i36 + i14) * 31;
        List<ReviewsItem> list4 = this.reviews;
        if (list4 != null) {
            i15 = list4.hashCode();
        } else {
            i15 = 0;
        }
        int i38 = (i37 + i15) * 31;
        String str6 = this.scope;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i39 = (i38 + i16) * 31;
        String str7 = this.name;
        if (str7 != null) {
            i17 = str7.hashCode();
        } else {
            i17 = 0;
        }
        int i40 = (i39 + i17) * 31;
        OpeningHours openingHours = this.openingHours;
        if (openingHours != null) {
            i18 = openingHours.hashCode();
        } else {
            i18 = 0;
        }
        int i41 = (i40 + i18) * 31;
        Geometry geometry = this.geometry;
        if (geometry != null) {
            i19 = geometry.hashCode();
        } else {
            i19 = 0;
        }
        int i42 = (i41 + i19) * 31;
        String str8 = this.vicinity;
        if (str8 != null) {
            i20 = str8.hashCode();
        } else {
            i20 = 0;
        }
        int i43 = (i42 + i20) * 31;
        String str9 = this.id;
        if (str9 != null) {
            i21 = str9.hashCode();
        } else {
            i21 = 0;
        }
        int i44 = (i43 + i21) * 31;
        String str10 = this.adrAddress;
        if (str10 != null) {
            i22 = str10.hashCode();
        } else {
            i22 = 0;
        }
        int i45 = (i44 + i22) * 31;
        PlusCode plusCode = this.plusCode;
        if (plusCode != null) {
            i23 = plusCode.hashCode();
        } else {
            i23 = 0;
        }
        int i46 = (i45 + i23) * 31;
        String str11 = this.formattedPhoneNumber;
        if (str11 != null) {
            i24 = str11.hashCode();
        } else {
            i24 = 0;
        }
        int i47 = (i46 + i24) * 31;
        String str12 = this.internationalPhoneNumber;
        if (str12 != null) {
            i25 = str12.hashCode();
        } else {
            i25 = 0;
        }
        int i48 = (i47 + i25) * 31;
        String str13 = this.placeId;
        if (str13 != null) {
            i26 = str13.hashCode();
        }
        return i48 + i26;
    }

    public final void setAddressComponents(@Nullable List<AddressComponentsItem> list) {
        this.addressComponents = list;
    }

    public final void setAdrAddress(@Nullable String str) {
        this.adrAddress = str;
    }

    public final void setFormattedAddress(@Nullable String str) {
        this.formattedAddress = str;
    }

    public final void setFormattedPhoneNumber(@Nullable String str) {
        this.formattedPhoneNumber = str;
    }

    public final void setGeometry(@Nullable Geometry geometry) {
        this.geometry = geometry;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setInternationalPhoneNumber(@Nullable String str) {
        this.internationalPhoneNumber = str;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setOpeningHours(@Nullable OpeningHours openingHours) {
        this.openingHours = openingHours;
    }

    public final void setPhotos(@Nullable List<PhotosItem> list) {
        this.photos = list;
    }

    public final void setPlaceId(@Nullable String str) {
        this.placeId = str;
    }

    public final void setPlusCode(@Nullable PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public final void setRating(@Nullable Double d4) {
        this.rating = d4;
    }

    public final void setReference(@Nullable String str) {
        this.reference = str;
    }

    public final void setReviews(@Nullable List<ReviewsItem> list) {
        this.reviews = list;
    }

    public final void setScope(@Nullable String str) {
        this.scope = str;
    }

    public final void setTypes(@Nullable List<String> list) {
        this.types = list;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setUserRatingsTotal(@Nullable Integer num) {
        this.userRatingsTotal = num;
    }

    public final void setUtcOffset(@Nullable Integer num) {
        this.utcOffset = num;
    }

    public final void setVicinity(@Nullable String str) {
        this.vicinity = str;
    }

    public final void setWebsite(@Nullable String str) {
        this.website = str;
    }

    @NotNull
    public String toString() {
        return "PlaceDetails(utcOffset=" + this.utcOffset + ", formattedAddress=" + this.formattedAddress + ", types=" + this.types + ", website=" + this.website + ", icon=" + this.icon + ", rating=" + this.rating + ", addressComponents=" + this.addressComponents + ", photos=" + this.photos + ", url=" + this.url + ", reference=" + this.reference + ", userRatingsTotal=" + this.userRatingsTotal + ", reviews=" + this.reviews + ", scope=" + this.scope + ", name=" + this.name + ", openingHours=" + this.openingHours + ", geometry=" + this.geometry + ", vicinity=" + this.vicinity + ", id=" + this.id + ", adrAddress=" + this.adrAddress + ", plusCode=" + this.plusCode + ", formattedPhoneNumber=" + this.formattedPhoneNumber + ", internationalPhoneNumber=" + this.internationalPhoneNumber + ", placeId=" + this.placeId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Integer num = this.utcOffset;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.formattedAddress);
        parcel.writeStringList(this.types);
        parcel.writeString(this.website);
        parcel.writeString(this.icon);
        Double d4 = this.rating;
        if (d4 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d4.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        List<AddressComponentsItem> list = this.addressComponents;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (AddressComponentsItem addressComponentsItem : list) {
                if (addressComponentsItem != null) {
                    parcel.writeInt(1);
                    addressComponentsItem.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        List<PhotosItem> list2 = this.photos;
        if (list2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (PhotosItem photosItem : list2) {
                if (photosItem != null) {
                    parcel.writeInt(1);
                    photosItem.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.url);
        parcel.writeString(this.reference);
        Integer num2 = this.userRatingsTotal;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        List<ReviewsItem> list3 = this.reviews;
        if (list3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list3.size());
            for (ReviewsItem reviewsItem : list3) {
                if (reviewsItem != null) {
                    parcel.writeInt(1);
                    reviewsItem.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.scope);
        parcel.writeString(this.name);
        OpeningHours openingHours = this.openingHours;
        if (openingHours != null) {
            parcel.writeInt(1);
            openingHours.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Geometry geometry = this.geometry;
        if (geometry != null) {
            parcel.writeInt(1);
            geometry.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.vicinity);
        parcel.writeString(this.id);
        parcel.writeString(this.adrAddress);
        PlusCode plusCode = this.plusCode;
        if (plusCode != null) {
            parcel.writeInt(1);
            plusCode.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.formattedPhoneNumber);
        parcel.writeString(this.internationalPhoneNumber);
        parcel.writeString(this.placeId);
    }

    public PlaceDetails(@Nullable Integer num, @Nullable String str, @Nullable List<String> list, @Nullable String str2, @Nullable String str3, @Nullable Double d4, @Nullable List<AddressComponentsItem> list2, @Nullable List<PhotosItem> list3, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable List<ReviewsItem> list4, @Nullable String str6, @Nullable String str7, @Nullable OpeningHours openingHours, @Nullable Geometry geometry, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable PlusCode plusCode, @Nullable String str11, @Nullable String str12, @Nullable String str13) {
        this.utcOffset = num;
        this.formattedAddress = str;
        this.types = list;
        this.website = str2;
        this.icon = str3;
        this.rating = d4;
        this.addressComponents = list2;
        this.photos = list3;
        this.url = str4;
        this.reference = str5;
        this.userRatingsTotal = num2;
        this.reviews = list4;
        this.scope = str6;
        this.name = str7;
        this.openingHours = openingHours;
        this.geometry = geometry;
        this.vicinity = str8;
        this.id = str9;
        this.adrAddress = str10;
        this.plusCode = plusCode;
        this.formattedPhoneNumber = str11;
        this.internationalPhoneNumber = str12;
        this.placeId = str13;
    }

    public /* synthetic */ PlaceDetails(Integer num, String str, List list, String str2, String str3, Double d4, List list2, List list3, String str4, String str5, Integer num2, List list4, String str6, String str7, OpeningHours openingHours, Geometry geometry, String str8, String str9, String str10, PlusCode plusCode, String str11, String str12, String str13, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : num, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : list, (i4 & 8) != 0 ? null : str2, (i4 & 16) != 0 ? null : str3, (i4 & 32) != 0 ? null : d4, (i4 & 64) != 0 ? null : list2, (i4 & 128) != 0 ? null : list3, (i4 & 256) != 0 ? null : str4, (i4 & 512) != 0 ? null : str5, (i4 & 1024) != 0 ? null : num2, (i4 & 2048) != 0 ? null : list4, (i4 & 4096) != 0 ? null : str6, (i4 & 8192) != 0 ? null : str7, (i4 & 16384) != 0 ? null : openingHours, (i4 & 32768) != 0 ? null : geometry, (i4 & 65536) != 0 ? null : str8, (i4 & 131072) != 0 ? null : str9, (i4 & 262144) != 0 ? null : str10, (i4 & 524288) != 0 ? null : plusCode, (i4 & 1048576) != 0 ? null : str11, (i4 & 2097152) != 0 ? null : str12, (i4 & 4194304) != 0 ? null : str13);
    }
}
