package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;

/* loaded from: classes4.dex */
final class zzo extends com.google.android.gms.maps.internal.zzw {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ GoogleMap.OnCircleClickListener f21404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(GoogleMap googleMap, GoogleMap.OnCircleClickListener onCircleClickListener) {
        this.f21404a = onCircleClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzv
    public final void zza(com.google.android.gms.internal.maps.zzh zzhVar) {
        this.f21404a.onCircleClick(new Circle(zzhVar));
    }
}
