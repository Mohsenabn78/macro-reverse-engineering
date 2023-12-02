package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhu extends zzhn {

    /* renamed from: b  reason: collision with root package name */
    private final zzca f22799b;

    public zzhu(BaseImplementation.ResultHolder resultHolder, zzca zzcaVar) {
        super(resultHolder);
        this.f22799b = (zzca) Preconditions.checkNotNull(zzcaVar);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzm(zzdt zzdtVar) {
        zzbv zzbvVar;
        if (zzdtVar.zzb != null) {
            zzbvVar = new zzbv(new ParcelFileDescriptor.AutoCloseOutputStream(zzdtVar.zzb));
            this.f22799b.zzc(new zzbu(zzbvVar));
        } else {
            zzbvVar = null;
        }
        a(new zzbp(new Status(zzdtVar.zza), zzbvVar));
    }
}
