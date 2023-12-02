package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

/* loaded from: classes4.dex */
public final class zzas extends zzaw implements PlacePhotoMetadata {

    /* renamed from: d  reason: collision with root package name */
    private final String f21115d;

    public zzas(DataHolder dataHolder, int i4) {
        super(dataHolder, i4);
        this.f21115d = e("photo_fife_url");
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ PlacePhotoMetadata freeze() {
        return new zzap(this.f21115d, getMaxWidth(), getMaxHeight(), getAttributions(), this.f20369b);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final CharSequence getAttributions() {
        return j("photo_attributions", null);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxHeight() {
        return n("photo_max_height", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final int getMaxWidth() {
        return n("photo_max_width", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public final PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, int i4, int i5) {
        return ((PlacePhotoMetadata) freeze()).getScaledPhoto(googleApiClient, i4, i5);
    }
}
