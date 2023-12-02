package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzjz extends zzf {

    /* renamed from: c  reason: collision with root package name */
    private final zzjy f21971c;

    /* renamed from: d  reason: collision with root package name */
    private zzej f21972d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f21973e;

    /* renamed from: f  reason: collision with root package name */
    private final zzan f21974f;

    /* renamed from: g  reason: collision with root package name */
    private final zzkq f21975g;

    /* renamed from: h  reason: collision with root package name */
    private final List f21976h;

    /* renamed from: i  reason: collision with root package name */
    private final zzan f21977i;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjz(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21976h = new ArrayList();
        this.f21975g = new zzkq(zzgdVar.zzax());
        this.f21971c = new zzjy(this);
        this.f21974f = new zzjj(this, zzgdVar);
        this.f21977i = new zzjl(this, zzgdVar);
    }

    @WorkerThread
    private final zzq o(boolean z3) {
        Pair zza;
        this.f21734a.zzay();
        zzek zzh = this.f21734a.zzh();
        String str = null;
        if (z3) {
            zzet zzaA = this.f21734a.zzaA();
            if (zzaA.f21734a.zzm().f21592d != null && (zza = zzaA.f21734a.zzm().f21592d.zza()) != null && zza != zzfi.f21590y) {
                str = String.valueOf(zza.second) + ":" + ((String) zza.first);
            }
        }
        return zzh.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void p() {
        zzg();
        this.f21734a.zzaA().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.f21976h.size()));
        for (Runnable runnable : this.f21976h) {
            try {
                runnable.run();
            } catch (RuntimeException e4) {
                this.f21734a.zzaA().zzd().zzb("Task exception while flushing queue", e4);
            }
        }
        this.f21976h.clear();
        this.f21977i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void q() {
        zzg();
        this.f21975g.b();
        zzan zzanVar = this.f21974f;
        this.f21734a.zzf();
        zzanVar.d(((Long) zzeg.zzJ.zza(null)).longValue());
    }

    @WorkerThread
    private final void r(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        this.f21734a.zzf();
        if (this.f21976h.size() >= 1000) {
            this.f21734a.zzaA().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.f21976h.add(runnable);
        this.f21977i.d(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        B();
    }

    private final boolean s() {
        this.f21734a.zzay();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void y(zzjz zzjzVar, ComponentName componentName) {
        zzjzVar.zzg();
        if (zzjzVar.f21972d != null) {
            zzjzVar.f21972d = null;
            zzjzVar.f21734a.zzaA().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjzVar.zzg();
            zzjzVar.B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void A() {
        zzg();
        zza();
        zzq o4 = o(true);
        this.f21734a.zzi().zzk();
        r(new zzjg(this, o4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void B() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (!n()) {
            if (!this.f21734a.zzf().h()) {
                this.f21734a.zzay();
                List<ResolveInfo> queryIntentServices = this.f21734a.zzaw().getPackageManager().queryIntentServices(new Intent().setClassName(this.f21734a.zzaw(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzaw = this.f21734a.zzaw();
                    this.f21734a.zzay();
                    intent.setComponent(new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.f21971c.zzb(intent);
                    return;
                }
                this.f21734a.zzaA().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            return;
        }
        this.f21971c.zzc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void C(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2) {
        zzg();
        zza();
        r(new zzjr(this, str, str2, o(false), zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void D(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        r(new zzjq(this, atomicReference, null, str2, str3, o(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void E(AtomicReference atomicReference, boolean z3) {
        zzg();
        zza();
        r(new zzjb(this, atomicReference, o(false), z3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void F(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z3) {
        zzg();
        zza();
        r(new zzja(this, str, str2, o(false), z3, zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void G(AtomicReference atomicReference, String str, String str2, String str3, boolean z3) {
        zzg();
        zza();
        r(new zzjs(this, atomicReference, null, str2, str3, o(false), z3));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void d(zzau zzauVar, String str) {
        Preconditions.checkNotNull(zzauVar);
        zzg();
        zza();
        s();
        r(new zzjo(this, true, o(true), this.f21734a.zzi().zzo(zzauVar), zzauVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void e() {
        zzg();
        zza();
        zzq o4 = o(false);
        s();
        this.f21734a.zzi().zzj();
        r(new zzjd(this, o4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void f(zzej zzejVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int i4;
        zzg();
        zza();
        s();
        this.f21734a.zzf();
        int i5 = 0;
        int i6 = 100;
        while (i5 < 1001 && i6 == 100) {
            ArrayList arrayList = new ArrayList();
            List zzi = this.f21734a.zzi().zzi(100);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i4 = zzi.size();
            } else {
                i4 = 0;
            }
            if (abstractSafeParcelable != null && i4 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i7);
                if (abstractSafeParcelable2 instanceof zzau) {
                    try {
                        zzejVar.zzk((zzau) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e4) {
                        this.f21734a.zzaA().zzd().zzb("Failed to send event to the service", e4);
                    }
                } else if (abstractSafeParcelable2 instanceof zzlk) {
                    try {
                        zzejVar.zzt((zzlk) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e5) {
                        this.f21734a.zzaA().zzd().zzb("Failed to send user property to the service", e5);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzejVar.zzn((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e6) {
                        this.f21734a.zzaA().zzd().zzb("Failed to send conditional user property to the service", e6);
                    }
                } else {
                    this.f21734a.zzaA().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i5++;
            i6 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void g(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzg();
        zza();
        this.f21734a.zzay();
        r(new zzjp(this, true, o(true), this.f21734a.zzi().zzn(zzacVar), new zzac(zzacVar), zzacVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void h(boolean z3) {
        zzg();
        zza();
        if (z3) {
            s();
            this.f21734a.zzi().zzj();
        }
        if (m()) {
            r(new zzjn(this, o(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void i(zzir zzirVar) {
        zzg();
        zza();
        r(new zzjh(this, zzirVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void j() {
        zzg();
        zza();
        r(new zzjm(this, o(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final void k(zzej zzejVar) {
        zzg();
        Preconditions.checkNotNull(zzejVar);
        this.f21972d = zzejVar;
        q();
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void l(zzlk zzlkVar) {
        zzg();
        zza();
        s();
        r(new zzjc(this, o(true), this.f21734a.zzi().zzp(zzlkVar), zzlkVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean m() {
        zzg();
        zza();
        if (!n() || this.f21734a.zzv().zzm() >= ((Integer) zzeg.zzah.zza(null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean n() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjz.n():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean v() {
        return this.f21973e;
    }

    @WorkerThread
    public final void zzB(com.google.android.gms.internal.measurement.zzcf zzcfVar, zzau zzauVar, String str) {
        zzg();
        zza();
        if (this.f21734a.zzv().zzo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.f21734a.zzaA().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.f21734a.zzv().zzT(zzcfVar, new byte[0]);
            return;
        }
        r(new zzjk(this, zzauVar, str, zzcfVar));
    }

    @WorkerThread
    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        r(new zzji(this, o(false), bundle));
    }

    @WorkerThread
    public final boolean zzL() {
        zzg();
        zza();
        if (this.f21972d != null) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final void zzs() {
        zzg();
        zza();
        this.f21971c.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.f21734a.zzaw(), this.f21971c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f21972d = null;
    }

    @WorkerThread
    public final void zzt(com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        zzg();
        zza();
        r(new zzjf(this, o(false), zzcfVar));
    }

    @WorkerThread
    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        r(new zzje(this, atomicReference, o(false)));
    }
}
