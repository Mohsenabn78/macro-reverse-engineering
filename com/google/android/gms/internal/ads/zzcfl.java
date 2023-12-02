package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcfl {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcez] */
    public static final zzcez zza(final Context context, final zzcgo zzcgoVar, final String str, final boolean z3, final boolean z4, @Nullable final zzaqs zzaqsVar, @Nullable final zzbco zzbcoVar, final zzbzx zzbzxVar, @Nullable zzbce zzbceVar, @Nullable final com.google.android.gms.ads.internal.zzl zzlVar, @Nullable final com.google.android.gms.ads.internal.zza zzaVar, final zzawz zzawzVar, @Nullable final zzezn zzeznVar, @Nullable final zzezq zzezqVar, @Nullable final zzebl zzeblVar) throws zzcfk {
        zzbbm.zza(context);
        try {
            zzfpx zzfpxVar = new zzfpx(context, zzcgoVar, str, z3, z4, zzaqsVar, zzbcoVar, zzbzxVar, null, zzlVar, zzaVar, zzawzVar, zzeznVar, zzezqVar, zzeblVar) { // from class: com.google.android.gms.internal.ads.zzcfh
                public final /* synthetic */ Context zza;
                public final /* synthetic */ zzcgo zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ boolean zzd;
                public final /* synthetic */ boolean zze;
                public final /* synthetic */ zzaqs zzf;
                public final /* synthetic */ zzbco zzg;
                public final /* synthetic */ zzbzx zzh;
                public final /* synthetic */ com.google.android.gms.ads.internal.zzl zzi;
                public final /* synthetic */ com.google.android.gms.ads.internal.zza zzj;
                public final /* synthetic */ zzawz zzk;
                public final /* synthetic */ zzezn zzl;
                public final /* synthetic */ zzezq zzm;
                public final /* synthetic */ zzebl zzn;

                {
                    this.zzi = zzlVar;
                    this.zzj = zzaVar;
                    this.zzk = zzawzVar;
                    this.zzl = zzeznVar;
                    this.zzm = zzezqVar;
                    this.zzn = zzeblVar;
                }

                @Override // com.google.android.gms.internal.ads.zzfpx
                public final Object zza() {
                    Context context2 = this.zza;
                    zzcgo zzcgoVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z5 = this.zzd;
                    boolean z6 = this.zze;
                    zzaqs zzaqsVar2 = this.zzf;
                    zzbco zzbcoVar2 = this.zzg;
                    zzbzx zzbzxVar2 = this.zzh;
                    com.google.android.gms.ads.internal.zzl zzlVar2 = this.zzi;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzj;
                    zzawz zzawzVar2 = this.zzk;
                    zzezn zzeznVar2 = this.zzl;
                    zzezq zzezqVar2 = this.zzm;
                    zzebl zzeblVar2 = this.zzn;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i4 = zzcfs.zza;
                        zzcfo zzcfoVar = new zzcfo(new zzcfs(new zzcgn(context2), zzcgoVar2, str2, z5, z6, zzaqsVar2, zzbcoVar2, zzbzxVar2, null, zzlVar2, zzaVar2, zzawzVar2, zzeznVar2, zzezqVar2));
                        zzcfoVar.setWebViewClient(com.google.android.gms.ads.internal.zzt.zzq().zzd(zzcfoVar, zzawzVar2, z6, zzeblVar2));
                        zzcfoVar.setWebChromeClient(new zzcey(zzcfoVar));
                        return zzcfoVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ?? zza = zzfpxVar.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza;
        } catch (Throwable th) {
            throw new zzcfk("Webview initialization failed.", th);
        }
    }
}
