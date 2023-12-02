package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "PlacesParamsCreator")
@SafeParcelable.Reserved({1000, 5})
/* loaded from: classes4.dex */
public final class zzau extends AbstractSafeParcelable {
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f21117a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f21118b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f21119c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f21120d;
    @SafeParcelable.Field(id = 6)

    /* renamed from: e  reason: collision with root package name */
    private final int f21121e;
    @SafeParcelable.Field(id = 7)

    /* renamed from: f  reason: collision with root package name */
    private final int f21122f;

    /* renamed from: g  reason: collision with root package name */
    private static final zzau f21116g = new zzau("com.google.android.gms", Locale.getDefault(), null);
    public static final Parcelable.Creator<zzau> CREATOR = new zzat();

    @SafeParcelable.Constructor
    public zzau(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 6) int i4, @SafeParcelable.Param(id = 7) int i5) {
        this.f21117a = str;
        this.f21118b = str2;
        this.f21119c = str3;
        this.f21120d = str4;
        this.f21121e = i4;
        this.f21122f = i5;
    }

    private static String b(Locale locale) {
        return locale.toLanguageTag();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzau)) {
            zzau zzauVar = (zzau) obj;
            if (this.f21121e == zzauVar.f21121e && this.f21122f == zzauVar.f21122f && this.f21118b.equals(zzauVar.f21118b) && this.f21117a.equals(zzauVar.f21117a) && Objects.equal(this.f21119c, zzauVar.f21119c) && Objects.equal(this.f21120d, zzauVar.f21120d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21117a, this.f21118b, this.f21119c, this.f21120d, Integer.valueOf(this.f21121e), Integer.valueOf(this.f21122f));
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return Objects.toStringHelper(this).add("clientPackageName", this.f21117a).add("locale", this.f21118b).add("accountName", this.f21119c).add("gCoreClientName", this.f21120d).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21117a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f21118b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f21119c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f21120d, false);
        SafeParcelWriter.writeInt(parcel, 6, this.f21121e);
        SafeParcelWriter.writeInt(parcel, 7, this.f21122f);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzau(String str, Locale locale, String str2) {
        this(str, b(locale), null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
    }

    public zzau(String str, Locale locale, String str2, String str3, int i4) {
        this(str, b(locale), str2, str3, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, i4);
    }
}
