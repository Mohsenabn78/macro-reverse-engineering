package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzg extends zza {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20563e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzg(BaseGmsClient baseGmsClient, @Nullable int i4, Bundle bundle) {
        super(baseGmsClient, i4, null);
        this.f20563e = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void c(ConnectionResult connectionResult) {
        if (this.f20563e.enableLocalFallback() && BaseGmsClient.zzo(this.f20563e)) {
            BaseGmsClient.zzk(this.f20563e, 16);
            return;
        }
        this.f20563e.zzc.onReportServiceBinding(connectionResult);
        this.f20563e.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean d() {
        this.f20563e.zzc.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
