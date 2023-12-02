package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReviewsItem.kt */
@Parcelize
@Entity(tableName = "ReviewsItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0007HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001a¨\u00068"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/ReviewsItem;", "Landroid/os/Parcelable;", "authorName", "", "profilePhotoUrl", "authorUrl", "rating", "", "language", "text", "time", "relativeTimeDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAuthorName", "()Ljava/lang/String;", "setAuthorName", "(Ljava/lang/String;)V", "getAuthorUrl", "setAuthorUrl", "getLanguage", "setLanguage", "getProfilePhotoUrl", "setProfilePhotoUrl", "getRating", "()Ljava/lang/Integer;", "setRating", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRelativeTimeDescription", "setRelativeTimeDescription", "getText", "setText", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/ReviewsItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class ReviewsItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("author_name")
    @Nullable
    private String authorName;
    @SerializedName("author_url")
    @Nullable
    private String authorUrl;
    @SerializedName("language")
    @Nullable
    private String language;
    @SerializedName("profile_photo_url")
    @Nullable
    private String profilePhotoUrl;
    @SerializedName("rating")
    @Nullable
    private Integer rating;
    @SerializedName("relative_time_description")
    @Nullable
    private String relativeTimeDescription;
    @SerializedName("text")
    @Nullable
    private String text;
    @SerializedName("time")
    @Nullable
    private Integer time;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Integer num;
            Integer num2;
            Intrinsics.checkParameterIsNotNull(in, "in");
            String readString = in.readString();
            String readString2 = in.readString();
            String readString3 = in.readString();
            if (in.readInt() != 0) {
                num = Integer.valueOf(in.readInt());
            } else {
                num = null;
            }
            String readString4 = in.readString();
            String readString5 = in.readString();
            if (in.readInt() != 0) {
                num2 = Integer.valueOf(in.readInt());
            } else {
                num2 = null;
            }
            return new ReviewsItem(readString, readString2, readString3, num, readString4, readString5, num2, in.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new ReviewsItem[i4];
        }
    }

    public ReviewsItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @NotNull
    public static /* synthetic */ ReviewsItem copy$default(ReviewsItem reviewsItem, String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, String str6, int i4, Object obj) {
        String str7;
        String str8;
        String str9;
        Integer num3;
        String str10;
        String str11;
        Integer num4;
        String str12;
        if ((i4 & 1) != 0) {
            str7 = reviewsItem.authorName;
        } else {
            str7 = str;
        }
        if ((i4 & 2) != 0) {
            str8 = reviewsItem.profilePhotoUrl;
        } else {
            str8 = str2;
        }
        if ((i4 & 4) != 0) {
            str9 = reviewsItem.authorUrl;
        } else {
            str9 = str3;
        }
        if ((i4 & 8) != 0) {
            num3 = reviewsItem.rating;
        } else {
            num3 = num;
        }
        if ((i4 & 16) != 0) {
            str10 = reviewsItem.language;
        } else {
            str10 = str4;
        }
        if ((i4 & 32) != 0) {
            str11 = reviewsItem.text;
        } else {
            str11 = str5;
        }
        if ((i4 & 64) != 0) {
            num4 = reviewsItem.time;
        } else {
            num4 = num2;
        }
        if ((i4 & 128) != 0) {
            str12 = reviewsItem.relativeTimeDescription;
        } else {
            str12 = str6;
        }
        return reviewsItem.copy(str7, str8, str9, num3, str10, str11, num4, str12);
    }

    @Nullable
    public final String component1() {
        return this.authorName;
    }

    @Nullable
    public final String component2() {
        return this.profilePhotoUrl;
    }

    @Nullable
    public final String component3() {
        return this.authorUrl;
    }

    @Nullable
    public final Integer component4() {
        return this.rating;
    }

    @Nullable
    public final String component5() {
        return this.language;
    }

    @Nullable
    public final String component6() {
        return this.text;
    }

    @Nullable
    public final Integer component7() {
        return this.time;
    }

    @Nullable
    public final String component8() {
        return this.relativeTimeDescription;
    }

    @NotNull
    public final ReviewsItem copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable String str6) {
        return new ReviewsItem(str, str2, str3, num, str4, str5, num2, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ReviewsItem) {
                ReviewsItem reviewsItem = (ReviewsItem) obj;
                if (!Intrinsics.areEqual(this.authorName, reviewsItem.authorName) || !Intrinsics.areEqual(this.profilePhotoUrl, reviewsItem.profilePhotoUrl) || !Intrinsics.areEqual(this.authorUrl, reviewsItem.authorUrl) || !Intrinsics.areEqual(this.rating, reviewsItem.rating) || !Intrinsics.areEqual(this.language, reviewsItem.language) || !Intrinsics.areEqual(this.text, reviewsItem.text) || !Intrinsics.areEqual(this.time, reviewsItem.time) || !Intrinsics.areEqual(this.relativeTimeDescription, reviewsItem.relativeTimeDescription)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getAuthorName() {
        return this.authorName;
    }

    @Nullable
    public final String getAuthorUrl() {
        return this.authorUrl;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getProfilePhotoUrl() {
        return this.profilePhotoUrl;
    }

    @Nullable
    public final Integer getRating() {
        return this.rating;
    }

    @Nullable
    public final String getRelativeTimeDescription() {
        return this.relativeTimeDescription;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final Integer getTime() {
        return this.time;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        String str = this.authorName;
        int i11 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i12 = i4 * 31;
        String str2 = this.profilePhotoUrl;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i13 = (i12 + i5) * 31;
        String str3 = this.authorUrl;
        if (str3 != null) {
            i6 = str3.hashCode();
        } else {
            i6 = 0;
        }
        int i14 = (i13 + i6) * 31;
        Integer num = this.rating;
        if (num != null) {
            i7 = num.hashCode();
        } else {
            i7 = 0;
        }
        int i15 = (i14 + i7) * 31;
        String str4 = this.language;
        if (str4 != null) {
            i8 = str4.hashCode();
        } else {
            i8 = 0;
        }
        int i16 = (i15 + i8) * 31;
        String str5 = this.text;
        if (str5 != null) {
            i9 = str5.hashCode();
        } else {
            i9 = 0;
        }
        int i17 = (i16 + i9) * 31;
        Integer num2 = this.time;
        if (num2 != null) {
            i10 = num2.hashCode();
        } else {
            i10 = 0;
        }
        int i18 = (i17 + i10) * 31;
        String str6 = this.relativeTimeDescription;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return i18 + i11;
    }

    public final void setAuthorName(@Nullable String str) {
        this.authorName = str;
    }

    public final void setAuthorUrl(@Nullable String str) {
        this.authorUrl = str;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setProfilePhotoUrl(@Nullable String str) {
        this.profilePhotoUrl = str;
    }

    public final void setRating(@Nullable Integer num) {
        this.rating = num;
    }

    public final void setRelativeTimeDescription(@Nullable String str) {
        this.relativeTimeDescription = str;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setTime(@Nullable Integer num) {
        this.time = num;
    }

    @NotNull
    public String toString() {
        return "ReviewsItem(authorName=" + this.authorName + ", profilePhotoUrl=" + this.profilePhotoUrl + ", authorUrl=" + this.authorUrl + ", rating=" + this.rating + ", language=" + this.language + ", text=" + this.text + ", time=" + this.time + ", relativeTimeDescription=" + this.relativeTimeDescription + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.authorName);
        parcel.writeString(this.profilePhotoUrl);
        parcel.writeString(this.authorUrl);
        Integer num = this.rating;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.language);
        parcel.writeString(this.text);
        Integer num2 = this.time;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.relativeTimeDescription);
    }

    public ReviewsItem(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable String str6) {
        this.authorName = str;
        this.profilePhotoUrl = str2;
        this.authorUrl = str3;
        this.rating = num;
        this.language = str4;
        this.text = str5;
        this.time = num2;
        this.relativeTimeDescription = str6;
    }

    public /* synthetic */ ReviewsItem(String str, String str2, String str3, Integer num, String str4, String str5, Integer num2, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : num, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? null : str5, (i4 & 64) != 0 ? null : num2, (i4 & 128) == 0 ? str6 : null);
    }
}
