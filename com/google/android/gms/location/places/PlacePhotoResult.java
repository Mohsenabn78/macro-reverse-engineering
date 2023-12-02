package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PlacePhotoResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public class PlacePhotoResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoResult> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getStatus", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final Status f21039a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final BitmapTeleporter f21040b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f21041c;

    @SafeParcelable.Constructor
    public PlacePhotoResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) BitmapTeleporter bitmapTeleporter) {
        this.f21039a = status;
        this.f21040b = bitmapTeleporter;
        if (bitmapTeleporter != null) {
            this.f21041c = bitmapTeleporter.get();
        } else {
            this.f21041c = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f21041c;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f21039a;
    }

    public String toString() {
        return Objects.toStringHelper(this).add(NotificationCompat.CATEGORY_STATUS, this.f21039a).add("bitmap", this.f21041c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f21040b, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
