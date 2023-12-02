package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbii {
    public static final zzbij zza = new zzbij() { // from class: com.google.android.gms.internal.ads.zzbhn
        @Override // com.google.android.gms.internal.ads.zzbij
        public final void zza(Object obj, Map map) {
            String str;
            zzcga zzcgaVar = (zzcga) obj;
            zzbij zzbijVar = zzbii.zza;
            String str2 = (String) map.get("urls");
            if (TextUtils.isEmpty(str2)) {
                zzbzr.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str2.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzcgaVar.getContext().getPackageManager();
            for (String str3 : split) {
                String[] split2 = str3.split(";", 2);
                String trim = split2[0].trim();
                boolean z3 = true;
                if (split2.length > 1) {
                    str = split2[1].trim();
                } else {
                    str = "android.intent.action.VIEW";
                }
                if (packageManager.resolveActivity(new Intent(str, Uri.parse(trim)), 65536) == null) {
                    z3 = false;
                }
                Boolean valueOf = Boolean.valueOf(z3);
                hashMap.put(str3, valueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str3 + ";" + valueOf);
            }
            ((zzblc) zzcgaVar).zzd("openableURLs", hashMap);
        }
    };
    public static final zzbij zzb = new zzbij() { // from class: com.google.android.gms.internal.ads.zzbho
        @Override // com.google.android.gms.internal.ads.zzbij
        public final void zza(Object obj, Map map) {
            boolean z3;
            zzcga zzcgaVar = (zzcga) obj;
            zzbij zzbijVar = zzbii.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhN)).booleanValue()) {
                zzbzr.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                zzbzr.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap hashMap = new HashMap();
            if (zzcgaVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Boolean valueOf = Boolean.valueOf(z3);
            hashMap.put(str, valueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + valueOf);
            ((zzblc) zzcgaVar).zzd("openableApp", hashMap);
        }
    };
    public static final zzbij zzc = new zzbij() { // from class: com.google.android.gms.internal.ads.zzbhg
        @Override // com.google.android.gms.internal.ads.zzbij
        public final void zza(Object obj, Map map) {
            zzbii.zzb((zzcga) obj, map);
        }
    };
    public static final zzbij zzd = new zzbia();
    public static final zzbij zze = new zzbib();
    public static final zzbij zzf = new zzbij() { // from class: com.google.android.gms.internal.ads.zzbhm
        @Override // com.google.android.gms.internal.ads.zzbij
        public final void zza(Object obj, Map map) {
            zzcga zzcgaVar = (zzcga) obj;
            zzbij zzbijVar = zzbii.zza;
            String str = (String) map.get("u");
            if (str == null) {
                zzbzr.zzj("URL missing from httpTrack GMSG.");
            } else {
                new com.google.android.gms.ads.internal.util.zzby(zzcgaVar.getContext(), ((zzcgi) zzcgaVar).zzn().zza, str).zzb();
            }
        }
    };
    public static final zzbij zzg = new zzbic();
    public static final zzbij zzh = new zzbid();
    public static final zzbij zzi = new zzbij() { // from class: com.google.android.gms.internal.ads.zzbhl
        @Override // com.google.android.gms.internal.ads.zzbij
        public final void zza(Object obj, Map map) {
            zzcgh zzcghVar = (zzcgh) obj;
            zzbij zzbijVar = zzbii.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzaqs zzI = zzcghVar.zzI();
                if (zzI != null) {
                    zzI.zzc().zzl(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException unused) {
                zzbzr.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbij zzj = new zzbie();
    public static final zzbij zzk = new zzbif();
    public static final zzbij zzl = new zzccz();
    public static final zzbij zzm = new zzcda();
    public static final zzbij zzn = new zzbhf();
    public static final zzbix zzo = new zzbix();
    public static final zzbij zzp = new zzbig();
    public static final zzbij zzq = new zzbih();
    public static final zzbij zzr = new zzbhp();
    public static final zzbij zzs = new zzbhq();
    public static final zzbij zzt = new zzbhr();
    public static final zzbij zzu = new zzbhs();
    public static final zzbij zzv = new zzbht();
    public static final zzbij zzw = new zzbhu();
    public static final zzbij zzx = new zzbhv();
    public static final zzbij zzy = new zzbhw();
    public static final zzbij zzz = new zzbhx();
    public static final zzbij zzA = new zzbhy();

    public static zzfwm zza(zzcez zzcezVar, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzaqs zzI = zzcezVar.zzI();
            if (zzI != null && zzI.zzf(parse)) {
                parse = zzI.zza(parse, zzcezVar.getContext(), zzcezVar.zzF(), zzcezVar.zzi());
            }
        } catch (zzaqt unused) {
            zzbzr.zzj("Unable to append parameter to URL: ".concat(str));
        }
        final String zzb2 = zzbxy.zzb(parse, zzcezVar.getContext());
        long longValue = ((Long) zzbde.zze.zze()).longValue();
        if (longValue > 0 && longValue <= 232400000) {
            zzfvt zzv2 = zzfvt.zzv(zzcezVar.zzR());
            zzbhh zzbhhVar = new zzfov() { // from class: com.google.android.gms.internal.ads.zzbhh
                @Override // com.google.android.gms.internal.ads.zzfov
                public final Object apply(Object obj) {
                    Throwable th = (Throwable) obj;
                    zzbij zzbijVar = zzbii.zza;
                    if (((Boolean) zzbde.zzk.zze()).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "prepareClickUrl.attestation1");
                        return "failure_click_attok";
                    }
                    return "failure_click_attok";
                }
            };
            zzfwn zzfwnVar = zzcae.zzf;
            return zzfwc.zze(zzfwc.zzl(zzfwc.zze(zzv2, Throwable.class, zzbhhVar, zzfwnVar), new zzfov() { // from class: com.google.android.gms.internal.ads.zzbhi
                @Override // com.google.android.gms.internal.ads.zzfov
                public final Object apply(Object obj) {
                    String str2 = zzb2;
                    String str3 = (String) obj;
                    zzbij zzbijVar = zzbii.zza;
                    if (str3 != null) {
                        if (((Boolean) zzbde.zzf.zze()).booleanValue()) {
                            String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                            String host = Uri.parse(str2).getHost();
                            for (int i4 = 0; i4 < 3; i4++) {
                                if (!host.endsWith(strArr[i4])) {
                                }
                            }
                        }
                        String str4 = (String) zzbde.zza.zze();
                        String str5 = (String) zzbde.zzb.zze();
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str2.replace(str4, str3);
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            Uri parse2 = Uri.parse(str2);
                            if (TextUtils.isEmpty(parse2.getQueryParameter(str5))) {
                                return parse2.buildUpon().appendQueryParameter(str5, str3).toString();
                            }
                        }
                    }
                    return str2;
                }
            }, zzfwnVar), Throwable.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzbhj
                @Override // com.google.android.gms.internal.ads.zzfov
                public final Object apply(Object obj) {
                    String str2 = zzb2;
                    Throwable th = (Throwable) obj;
                    zzbij zzbijVar = zzbii.zza;
                    if (((Boolean) zzbde.zzk.zze()).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzu(th, "prepareClickUrl.attestation2");
                    }
                    return str2;
                }
            }, zzfwnVar);
        }
        return zzfwc.zzh(zzb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:(3:10|11|12)|(12:50|51|15|(10:17|(1:19)|20|(1:22)|23|(1:25)|26|(1:28)|29|(2:31|(1:33)))|34|35|36|(1:38)|39|40|42|43)|14|15|(0)|34|35|36|(0)|39|40|42|43|8) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
        com.google.android.gms.ads.internal.zzt.zzo().zzu(r0, r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00df, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e0, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzh("Error constructing openable urls response.", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzcga r16, java.util.Map r17) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbii.zzb(com.google.android.gms.internal.ads.zzcga, java.util.Map):void");
    }

    public static void zzc(Map map, zzdcu zzdcuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjr)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdcuVar != null) {
            zzdcuVar.zzr();
        }
    }
}
