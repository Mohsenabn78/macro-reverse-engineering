package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdvb implements zzdvz {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdub zzb;
    private final zzfwn zzc;
    private final zzfai zzd;
    private final ScheduledExecutorService zze;
    private final zzdzx zzf;
    private final zzffy zzg;
    private final Context zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdvb(Context context, zzfai zzfaiVar, zzdub zzdubVar, zzfwn zzfwnVar, ScheduledExecutorService scheduledExecutorService, zzdzx zzdzxVar, zzffy zzffyVar) {
        this.zzh = context;
        this.zzd = zzfaiVar;
        this.zzb = zzdubVar;
        this.zzc = zzfwnVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzdzxVar;
        this.zzg = zzffyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final zzfwm zzb(zzbue zzbueVar) {
        zzfwm zzb = this.zzb.zzb(zzbueVar);
        zzffn zza2 = zzffm.zza(this.zzh, 11);
        zzffx.zzd(zzb, zza2);
        zzfwm zzm = zzfwc.zzm(zzb, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzduy
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdvb.this.zzc((InputStream) obj);
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfl)).booleanValue()) {
            zzm = zzfwc.zzf(zzfwc.zzn(zzm, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzduz
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    TimeoutException timeoutException = (TimeoutException) obj;
                    return zzfwc.zzg(new zzdtx(5));
                }
            }, zzcae.zzf);
        }
        zzffx.zza(zzm, this.zzg, zza2);
        zzfwc.zzq(zzm, new zzdva(this), zzcae.zzf);
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(InputStream inputStream) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zzd), zzezy.zza(new InputStreamReader(inputStream))));
    }
}
