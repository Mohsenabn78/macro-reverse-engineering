package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@SafeParcelable.Class(creator = "PlaceReportCreator")
/* loaded from: classes4.dex */
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f21042a;
    @SafeParcelable.Field(getter = "getPlaceId", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f21043b;
    @SafeParcelable.Field(getter = "getTag", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f21044c;
    @SafeParcelable.Field(getter = "getSource", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f21045d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlaceReport(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        this.f21042a = i4;
        this.f21043b = str;
        this.f21044c = str2;
        this.f21045d = str3;
    }

    @VisibleForTesting
    public static PlaceReport create(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(EnvironmentCompat.MEDIA_UNKNOWN);
        Preconditions.checkArgument(true, "Invalid source");
        return new PlaceReport(1, str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        if (!Objects.equal(this.f21043b, placeReport.f21043b) || !Objects.equal(this.f21044c, placeReport.f21044c) || !Objects.equal(this.f21045d, placeReport.f21045d)) {
            return false;
        }
        return true;
    }

    public String getPlaceId() {
        return this.f21043b;
    }

    public String getTag() {
        return this.f21044c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f21043b, this.f21044c, this.f21045d);
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("placeId", this.f21043b);
        stringHelper.add("tag", this.f21044c);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.f21045d)) {
            stringHelper.add("source", this.f21045d);
        }
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21042a);
        SafeParcelWriter.writeString(parcel, 2, getPlaceId(), false);
        SafeParcelWriter.writeString(parcel, 3, getTag(), false);
        SafeParcelWriter.writeString(parcel, 4, this.f21045d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
