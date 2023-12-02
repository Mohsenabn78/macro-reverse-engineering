package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "WebImageCreator")
/* loaded from: classes4.dex */
public final class WebImage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20403a;
    @SafeParcelable.Field(getter = "getUrl", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final Uri f20404b;
    @SafeParcelable.Field(getter = "getWidth", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20405c;
    @SafeParcelable.Field(getter = "getHeight", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f20406d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public WebImage(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) int i6) {
        this.f20403a = i4;
        this.f20404b = uri;
        this.f20405c = i5;
        this.f20406d = i6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.equal(this.f20404b, webImage.f20404b) && this.f20405c == webImage.f20405c && this.f20406d == webImage.f20406d) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f20406d;
    }

    @NonNull
    public Uri getUrl() {
        return this.f20404b;
    }

    public int getWidth() {
        return this.f20405c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f20404b, Integer.valueOf(this.f20405c), Integer.valueOf(this.f20406d));
    }

    @NonNull
    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagesContract.URL, this.f20404b.toString());
            jSONObject.put("width", this.f20405c);
            jSONObject.put("height", this.f20406d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f20405c), Integer.valueOf(this.f20406d), this.f20404b.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20403a);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i4, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebImage(@NonNull Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(@NonNull Uri uri, int i4, int i5) throws IllegalArgumentException {
        this(1, uri, i4, i5);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i4 < 0 || i5 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WebImage(@androidx.annotation.NonNull org.json.JSONObject r5) throws java.lang.IllegalArgumentException {
        /*
            r4 = this;
            android.net.Uri r0 = android.net.Uri.EMPTY
            java.lang.String r1 = "url"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L12
            java.lang.String r1 = r5.getString(r1)     // Catch: org.json.JSONException -> L12
            android.net.Uri r0 = android.net.Uri.parse(r1)     // Catch: org.json.JSONException -> L12
        L12:
            java.lang.String r1 = "width"
            r2 = 0
            int r1 = r5.optInt(r1, r2)
            java.lang.String r3 = "height"
            int r5 = r5.optInt(r3, r2)
            r4.<init>(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.WebImage.<init>(org.json.JSONObject):void");
    }
}
