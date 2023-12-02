package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PhotosItem.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005HÖ\u0001R\"\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006+"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PhotosItem;", "Landroid/os/Parcelable;", "photoReference", "", "width", "", "htmlAttributions", "", "height", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHtmlAttributions", "()Ljava/util/List;", "setHtmlAttributions", "(Ljava/util/List;)V", "getPhotoReference", "()Ljava/lang/String;", "setPhotoReference", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PhotosItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PhotosItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("height")
    @Nullable
    private Integer height;
    @SerializedName("html_attributions")
    @Nullable
    private List<String> htmlAttributions;
    @SerializedName("photo_reference")
    @Nullable
    private String photoReference;
    @SerializedName("width")
    @Nullable
    private Integer width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Integer num;
            Intrinsics.checkParameterIsNotNull(in, "in");
            String readString = in.readString();
            Integer num2 = null;
            if (in.readInt() != 0) {
                num = Integer.valueOf(in.readInt());
            } else {
                num = null;
            }
            ArrayList<String> createStringArrayList = in.createStringArrayList();
            if (in.readInt() != 0) {
                num2 = Integer.valueOf(in.readInt());
            }
            return new PhotosItem(readString, num, createStringArrayList, num2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new PhotosItem[i4];
        }
    }

    public PhotosItem() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ PhotosItem copy$default(PhotosItem photosItem, String str, Integer num, List list, Integer num2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = photosItem.photoReference;
        }
        if ((i4 & 2) != 0) {
            num = photosItem.width;
        }
        if ((i4 & 4) != 0) {
            list = photosItem.htmlAttributions;
        }
        if ((i4 & 8) != 0) {
            num2 = photosItem.height;
        }
        return photosItem.copy(str, num, list, num2);
    }

    @Nullable
    public final String component1() {
        return this.photoReference;
    }

    @Nullable
    public final Integer component2() {
        return this.width;
    }

    @Nullable
    public final List<String> component3() {
        return this.htmlAttributions;
    }

    @Nullable
    public final Integer component4() {
        return this.height;
    }

    @NotNull
    public final PhotosItem copy(@Nullable String str, @Nullable Integer num, @Nullable List<String> list, @Nullable Integer num2) {
        return new PhotosItem(str, num, list, num2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PhotosItem) {
                PhotosItem photosItem = (PhotosItem) obj;
                if (!Intrinsics.areEqual(this.photoReference, photosItem.photoReference) || !Intrinsics.areEqual(this.width, photosItem.width) || !Intrinsics.areEqual(this.htmlAttributions, photosItem.htmlAttributions) || !Intrinsics.areEqual(this.height, photosItem.height)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final List<String> getHtmlAttributions() {
        return this.htmlAttributions;
    }

    @Nullable
    public final String getPhotoReference() {
        return this.photoReference;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        String str = this.photoReference;
        int i7 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = i4 * 31;
        Integer num = this.width;
        if (num != null) {
            i5 = num.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (i8 + i5) * 31;
        List<String> list = this.htmlAttributions;
        if (list != null) {
            i6 = list.hashCode();
        } else {
            i6 = 0;
        }
        int i10 = (i9 + i6) * 31;
        Integer num2 = this.height;
        if (num2 != null) {
            i7 = num2.hashCode();
        }
        return i10 + i7;
    }

    public final void setHeight(@Nullable Integer num) {
        this.height = num;
    }

    public final void setHtmlAttributions(@Nullable List<String> list) {
        this.htmlAttributions = list;
    }

    public final void setPhotoReference(@Nullable String str) {
        this.photoReference = str;
    }

    public final void setWidth(@Nullable Integer num) {
        this.width = num;
    }

    @NotNull
    public String toString() {
        return "PhotosItem(photoReference=" + this.photoReference + ", width=" + this.width + ", htmlAttributions=" + this.htmlAttributions + ", height=" + this.height + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.photoReference);
        Integer num = this.width;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeStringList(this.htmlAttributions);
        Integer num2 = this.height;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
            return;
        }
        parcel.writeInt(0);
    }

    public PhotosItem(@Nullable String str, @Nullable Integer num, @Nullable List<String> list, @Nullable Integer num2) {
        this.photoReference = str;
        this.width = num;
        this.htmlAttributions = list;
        this.height = num2;
    }

    public /* synthetic */ PhotosItem(String str, Integer num, List list, Integer num2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? null : list, (i4 & 8) != 0 ? null : num2);
    }
}
