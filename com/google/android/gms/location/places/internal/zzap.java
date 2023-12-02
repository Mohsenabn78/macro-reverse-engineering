package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;

/* loaded from: classes4.dex */
public final class zzap implements PlacePhotoMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final String f21108a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21109b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21110c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f21111d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21112e;

    public zzap(String str, int i4, int i5, CharSequence charSequence, int i6) {
        this.f21108a = str;
        this.f21109b = i4;
        this.f21110c = i5;
        this.f21111d = charSequence;
        this.f21112e = i6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzap)) {
            return false;
        }
        zzap zzapVar = (zzap) obj;
        if (zzapVar.f21109b == this.f21109b && zzapVar.f21110c == this.f21110c && Objects.equal(zzapVar.f21108a, this.f21108a) && Objects.equal(zzapVar.f21111d, this.f21111d)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final CharSequence getAttributions() {
        return this.f21111d;
    }

    public final int getIndex() {
        return this.f21112e;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxHeight() {
        return this.f21110c;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxWidth() {
        return this.f21109b;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, int i4, int i5) {
        return ((zzh) Places.GeoDataApi).zzb(googleApiClient, this, i4, i5);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21109b), Integer.valueOf(this.f21110c), this.f21108a, this.f21111d);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String zzk() {
        return this.f21108a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlacePhotoMetadata freeze() {
        return this;
    }
}
