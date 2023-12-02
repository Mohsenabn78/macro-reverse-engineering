package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
abstract class zza extends zzc {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20547d;
    public final int zza;
    @Nullable
    public final Bundle zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zza(BaseGmsClient baseGmsClient, @Nullable int i4, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        this.f20547d = baseGmsClient;
        this.zza = i4;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        PendingIntent pendingIntent = null;
        if (this.zza != 0) {
            this.f20547d.zzp(1, null);
            Bundle bundle = this.zzb;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
            }
            c(new ConnectionResult(this.zza, pendingIntent));
        } else if (!d()) {
            this.f20547d.zzp(1, null);
            c(new ConnectionResult(8, null));
        }
    }

    protected abstract void c(ConnectionResult connectionResult);

    protected abstract boolean d();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzc
    public final void b() {
    }
}
