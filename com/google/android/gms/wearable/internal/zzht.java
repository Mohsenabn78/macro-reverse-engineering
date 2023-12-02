package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzht extends zzhn {

    /* renamed from: b  reason: collision with root package name */
    private final zzca f22798b;

    public zzht(BaseImplementation.ResultHolder resultHolder, zzca zzcaVar) {
        super(resultHolder);
        this.f22798b = (zzca) Preconditions.checkNotNull(zzcaVar);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzl(zzdr zzdrVar) {
        zzbt zzbtVar;
        if (zzdrVar.zzb != null) {
            zzbtVar = new zzbt(new ParcelFileDescriptor.AutoCloseInputStream(zzdrVar.zzb));
            this.f22798b.zzc(new zzbs(zzbtVar));
        } else {
            zzbtVar = null;
        }
        a(new zzbo(new Status(zzdrVar.zza), zzbtVar));
    }
}
