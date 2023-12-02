package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzit extends zzez {

    /* renamed from: a  reason: collision with root package name */
    private ListenerHolder f22836a;

    /* renamed from: b  reason: collision with root package name */
    private ListenerHolder f22837b;

    /* renamed from: c  reason: collision with root package name */
    private ListenerHolder f22838c;

    /* renamed from: d  reason: collision with root package name */
    private ListenerHolder f22839d;

    /* renamed from: e  reason: collision with root package name */
    private ListenerHolder f22840e;

    /* renamed from: f  reason: collision with root package name */
    private final IntentFilter[] f22841f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f22842g;

    private zzit(IntentFilter[] intentFilterArr, @Nullable String str) {
        this.f22841f = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        this.f22842g = str;
    }

    private static void c(ListenerHolder listenerHolder) {
        if (listenerHolder != null) {
            listenerHolder.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(zzev zzevVar, boolean z3, byte[] bArr) {
        try {
            zzevVar.zzd(z3, bArr);
        } catch (RemoteException e4) {
            Log.e("WearableListenerStub", "Failed to send a response back", e4);
        }
    }

    public static zzit zzk(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, null);
        zzitVar.f22840e = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    public static zzit zzm(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, null);
        zzitVar.f22839d = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    public static zzit zzn(ListenerHolder listenerHolder, String str, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, (String) Preconditions.checkNotNull(str));
        zzitVar.f22839d = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    public static zzit zzo(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, null);
        zzitVar.f22836a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    public static zzit zzp(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, null);
        zzitVar.f22837b = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    public static zzit zzq(ListenerHolder listenerHolder, IntentFilter[] intentFilterArr) {
        zzit zzitVar = new zzit(intentFilterArr, null);
        zzitVar.f22838c = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        return zzitVar;
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzb(zzbf zzbfVar) {
        ListenerHolder listenerHolder = this.f22839d;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzis(zzbfVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzc(zzao zzaoVar) {
        ListenerHolder listenerHolder = this.f22840e;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzin(zzaoVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zze(DataHolder dataHolder) {
        ListenerHolder listenerHolder = this.f22836a;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzio(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzg(zzfx zzfxVar) {
        ListenerHolder listenerHolder = this.f22837b;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzip(zzfxVar));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzl(zzfx zzfxVar, zzev zzevVar) {
        ListenerHolder listenerHolder = this.f22838c;
        if (listenerHolder != null) {
            listenerHolder.notifyListener(new zzir(zzfxVar, zzevVar, null));
        }
    }

    @Nullable
    public final String zzr() {
        return this.f22842g;
    }

    public final void zzs() {
        c(this.f22836a);
        this.f22836a = null;
        c(this.f22837b);
        this.f22837b = null;
        c(this.f22838c);
        this.f22838c = null;
        c(this.f22839d);
        this.f22839d = null;
        c(this.f22840e);
        this.f22840e = null;
    }

    public final IntentFilter[] zzt() {
        return this.f22841f;
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzd(List list) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzf(zzi zziVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzh(zzl zzlVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzi(zzgm zzgmVar) {
    }

    @Override // com.google.android.gms.wearable.internal.zzfa
    public final void zzj(zzgm zzgmVar) {
    }
}
