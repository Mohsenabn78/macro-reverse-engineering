package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzas extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();
    @SafeParcelable.Field(getter = "z", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f21484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzas(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f21484a = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double c(String str) {
        return Double.valueOf(this.f21484a.getDouble("value"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long d(String str) {
        return Long.valueOf(this.f21484a.getLong("value"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object e(String str) {
        return this.f21484a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f(String str) {
        return this.f21484a.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzar(this);
    }

    public final String toString() {
        return this.f21484a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzc(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.f21484a.size();
    }

    public final Bundle zzc() {
        return new Bundle(this.f21484a);
    }
}
