package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbke implements zzald {
    private volatile zzbjr zza;
    private final Context zzb;

    public zzbke(Context context) {
        this.zzb = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzc(zzbke zzbkeVar) {
        if (zzbkeVar.zza == null) {
            return;
        }
        zzbkeVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    @Nullable
    public final zzalg zza(zzalk zzalkVar) throws zzalt {
        Parcelable.Creator<zzbjs> creator = zzbjs.CREATOR;
        Map zzl = zzalkVar.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i4 = 0;
        int i5 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i5] = (String) entry.getKey();
            strArr2[i5] = (String) entry.getValue();
            i5++;
        }
        zzbjs zzbjsVar = new zzbjs(zzalkVar.zzk(), strArr, strArr2);
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        try {
            zzcaj zzcajVar = new zzcaj();
            this.zza = new zzbjr(this.zzb, com.google.android.gms.ads.internal.zzt.zzt().zzb(), new zzbkc(this, zzcajVar), new zzbkd(this, zzcajVar));
            this.zza.checkAvailabilityAndConnect();
            zzbka zzbkaVar = new zzbka(this, zzbjsVar);
            zzfwn zzfwnVar = zzcae.zza;
            zzfwm zzn = zzfwc.zzn(zzfwc.zzm(zzcajVar, zzbkaVar, zzfwnVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzei)).intValue(), TimeUnit.MILLISECONDS, zzcae.zzd);
            zzn.zzc(new zzbkb(this), zzfwnVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzn.get();
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime;
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + elapsedRealtime2 + TranslateLanguage.MALAY);
            zzbju zzbjuVar = (zzbju) new zzbuc(parcelFileDescriptor).zza(zzbju.CREATOR);
            if (zzbjuVar == null) {
                return null;
            }
            if (!zzbjuVar.zza) {
                if (zzbjuVar.zze.length != zzbjuVar.zzf.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbjuVar.zze;
                    if (i4 < strArr3.length) {
                        hashMap.put(strArr3[i4], zzbjuVar.zzf[i4]);
                        i4++;
                    } else {
                        return new zzalg(zzbjuVar.zzc, zzbjuVar.zzd, hashMap, zzbjuVar.zzg, zzbjuVar.zzh);
                    }
                }
            } else {
                throw new zzalt(zzbjuVar.zzb);
            }
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime) + TranslateLanguage.MALAY);
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - elapsedRealtime) + TranslateLanguage.MALAY);
            throw th;
        }
    }
}
