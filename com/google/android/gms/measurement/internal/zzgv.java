package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzgv extends zzei {

    /* renamed from: a  reason: collision with root package name */
    private final zzlh f21731a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f21732b;

    /* renamed from: c  reason: collision with root package name */
    private String f21733c;

    public zzgv(zzlh zzlhVar, String str) {
        Preconditions.checkNotNull(zzlhVar);
        this.f21731a = zzlhVar;
        this.f21733c = null;
    }

    private final void a(zzau zzauVar, zzq zzqVar) {
        this.f21731a.a();
        this.f21731a.e(zzauVar, zzqVar);
    }

    @BinderThread
    private final void g(zzq zzqVar, boolean z3) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        h(zzqVar.zza, false);
        this.f21731a.zzv().q(zzqVar.zzb, zzqVar.zzq);
    }

    @BinderThread
    private final void h(String str, boolean z3) {
        boolean z4;
        if (!TextUtils.isEmpty(str)) {
            if (z3) {
                try {
                    if (this.f21732b == null) {
                        if (!"com.google.android.gms".equals(this.f21733c) && !UidVerifier.isGooglePlayServicesUid(this.f21731a.zzaw(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.f21731a.zzaw()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z4 = false;
                            this.f21732b = Boolean.valueOf(z4);
                        }
                        z4 = true;
                        this.f21732b = Boolean.valueOf(z4);
                    }
                    if (this.f21732b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e4) {
                    this.f21731a.zzaA().zzd().zzb("Measurement Service called with invalid calling package. appId", zzet.f(str));
                    throw e4;
                }
            }
            if (this.f21733c == null && GooglePlayServicesUtilLight.uidHasPackageName(this.f21731a.zzaw(), Binder.getCallingUid(), str)) {
                this.f21733c = str;
            }
            if (str.equals(this.f21733c)) {
                return;
            }
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
        this.f21731a.zzaA().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzau b(zzau zzauVar, zzq zzqVar) {
        zzas zzasVar;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzauVar.zza) && (zzasVar = zzauVar.zzb) != null && zzasVar.zza() != 0) {
            String f4 = zzauVar.zzb.f("_cis");
            if ("referrer broadcast".equals(f4) || "referrer API".equals(f4)) {
                this.f21731a.zzaA().zzi().zzb("Event has been filtered ", zzauVar.toString());
                return new zzau("_cmpx", zzauVar.zzb, zzauVar.zzc, zzauVar.zzd);
            }
        }
        return zzauVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(zzau zzauVar, zzq zzqVar) {
        com.google.android.gms.internal.measurement.zzc zzcVar;
        if (!this.f21731a.zzm().zzo(zzqVar.zza)) {
            a(zzauVar, zzqVar);
            return;
        }
        this.f21731a.zzaA().zzj().zzb("EES config found for", zzqVar.zza);
        zzfu zzm = this.f21731a.zzm();
        String str = zzqVar.zza;
        if (TextUtils.isEmpty(str)) {
            zzcVar = null;
        } else {
            zzcVar = (com.google.android.gms.internal.measurement.zzc) zzm.f21630j.get(str);
        }
        if (zzcVar != null) {
            try {
                Map B = this.f21731a.zzu().B(zzauVar.zzb.zzc(), true);
                String zza = zzhc.zza(zzauVar.zza);
                if (zza == null) {
                    zza = zzauVar.zza;
                }
                if (zzcVar.zze(new com.google.android.gms.internal.measurement.zzaa(zza, zzauVar.zzd, B))) {
                    if (zzcVar.zzg()) {
                        this.f21731a.zzaA().zzj().zzb("EES edited event", zzauVar.zza);
                        a(this.f21731a.zzu().t(zzcVar.zza().zzb()), zzqVar);
                    } else {
                        a(zzauVar, zzqVar);
                    }
                    if (zzcVar.zzf()) {
                        for (com.google.android.gms.internal.measurement.zzaa zzaaVar : zzcVar.zza().zzc()) {
                            this.f21731a.zzaA().zzj().zzb("EES logging created event", zzaaVar.zzd());
                            a(this.f21731a.zzu().t(zzaaVar), zzqVar);
                        }
                        return;
                    }
                    return;
                }
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                this.f21731a.zzaA().zzd().zzc("EES error. appId, eventName", zzqVar.zzb, zzauVar.zza);
            }
            this.f21731a.zzaA().zzj().zzb("EES was not applied to event", zzauVar.zza);
            a(zzauVar, zzqVar);
            return;
        }
        this.f21731a.zzaA().zzj().zzb("EES not loaded for", zzqVar.zza);
        a(zzauVar, zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(String str, Bundle bundle) {
        zzak zzh = this.f21731a.zzh();
        zzh.zzg();
        zzh.a();
        byte[] zzbx = zzh.f22016b.zzu().u(new zzap(zzh.f21734a, "", str, "dep", 0L, 0L, bundle)).zzbx();
        zzh.f21734a.zzaA().zzj().zzc("Saving default event parameters, appId, data size", zzh.f21734a.zzj().d(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbx);
        try {
            if (zzh.G().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzh.f21734a.zzaA().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzet.f(str));
            }
        } catch (SQLiteException e4) {
            zzh.f21734a.zzaA().zzd().zzc("Error storing default event parameters. appId", zzet.f(str), e4);
        }
    }

    @VisibleForTesting
    final void f(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.f21731a.zzaB().zzs()) {
            runnable.run();
        } else {
            this.f21731a.zzaB().zzp(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final String zzd(zzq zzqVar) {
        g(zzqVar, false);
        return this.f21731a.R(zzqVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final List zze(zzq zzqVar, boolean z3) {
        g(zzqVar, false);
        String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzlm> list = (List) this.f21731a.zzaB().zzh(new zzgs(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlmVar : list) {
                if (z3 || !zzlp.B(zzlmVar.f22070c)) {
                    arrayList.add(new zzlk(zzlmVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzc("Failed to get user properties. appId", zzet.f(zzqVar.zza), e4);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final List zzf(String str, String str2, zzq zzqVar) {
        g(zzqVar, false);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.f21731a.zzaB().zzh(new zzgj(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzb("Failed to get conditional user properties", e4);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final List zzg(String str, String str2, String str3) {
        h(str, true);
        try {
            return (List) this.f21731a.zzaB().zzh(new zzgk(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzb("Failed to get conditional user properties as", e4);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final List zzh(String str, String str2, boolean z3, zzq zzqVar) {
        g(zzqVar, false);
        String str3 = zzqVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzlm> list = (List) this.f21731a.zzaB().zzh(new zzgh(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlmVar : list) {
                if (z3 || !zzlp.B(zzlmVar.f22070c)) {
                    arrayList.add(new zzlk(zzlmVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzc("Failed to query user properties. appId", zzet.f(zzqVar.zza), e4);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final List zzi(String str, String str2, String str3, boolean z3) {
        h(str, true);
        try {
            List<zzlm> list = (List) this.f21731a.zzaB().zzh(new zzgi(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlmVar : list) {
                if (z3 || !zzlp.B(zzlmVar.f22070c)) {
                    arrayList.add(new zzlk(zzlmVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzc("Failed to get user properties as. appId", zzet.f(str), e4);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzj(zzq zzqVar) {
        g(zzqVar, false);
        f(new zzgt(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzk(zzau zzauVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzauVar);
        g(zzqVar, false);
        f(new zzgo(this, zzauVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzl(zzau zzauVar, String str, String str2) {
        Preconditions.checkNotNull(zzauVar);
        Preconditions.checkNotEmpty(str);
        h(str, true);
        f(new zzgp(this, zzauVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzm(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        h(zzqVar.zza, false);
        f(new zzgl(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzn(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        g(zzqVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zzqVar.zza;
        f(new zzgf(this, zzacVar2, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzo(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zza);
        h(zzacVar.zza, true);
        f(new zzgg(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzp(zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        Preconditions.checkNotNull(zzqVar.zzv);
        zzgn zzgnVar = new zzgn(this, zzqVar);
        Preconditions.checkNotNull(zzgnVar);
        if (this.f21731a.zzaB().zzs()) {
            zzgnVar.run();
        } else {
            this.f21731a.zzaB().zzq(zzgnVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzq(long j4, String str, String str2, String str3) {
        f(new zzgu(this, str2, str3, str, j4));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzr(final Bundle bundle, zzq zzqVar) {
        g(zzqVar, false);
        final String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        f(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzge
            @Override // java.lang.Runnable
            public final void run() {
                zzgv.this.e(str, bundle);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzs(zzq zzqVar) {
        g(zzqVar, false);
        f(new zzgm(this, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final void zzt(zzlk zzlkVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzlkVar);
        g(zzqVar, false);
        f(new zzgr(this, zzlkVar, zzqVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzej
    @BinderThread
    public final byte[] zzu(zzau zzauVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzauVar);
        h(str, true);
        this.f21731a.zzaA().zzc().zzb("Log and bundle. event", this.f21731a.zzi().d(zzauVar.zza));
        long nanoTime = this.f21731a.zzax().nanoTime() / AnimationKt.MillisToNanos;
        try {
            byte[] bArr = (byte[]) this.f21731a.zzaB().zzi(new zzgq(this, zzauVar, str)).get();
            if (bArr == null) {
                this.f21731a.zzaA().zzd().zzb("Log and bundle returned null. appId", zzet.f(str));
                bArr = new byte[0];
            }
            this.f21731a.zzaA().zzc().zzd("Log and bundle processed. event, size, time_ms", this.f21731a.zzi().d(zzauVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.f21731a.zzax().nanoTime() / AnimationKt.MillisToNanos) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e4) {
            this.f21731a.zzaA().zzd().zzd("Failed to log and bundle. appId, event, error", zzet.f(str), this.f21731a.zzi().d(zzauVar.zza), e4);
            return null;
        }
    }
}
