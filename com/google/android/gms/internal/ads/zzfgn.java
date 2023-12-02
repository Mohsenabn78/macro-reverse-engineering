package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgn {
    private final zzefr zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final Context zze;
    private final zzfaa zzf;
    private final zzfab zzg;
    private final Clock zzh;
    private final zzaqs zzi;

    public zzfgn(zzefr zzefrVar, zzbzx zzbzxVar, String str, String str2, Context context, @Nullable zzfaa zzfaaVar, @Nullable zzfab zzfabVar, Clock clock, zzaqs zzaqsVar) {
        this.zza = zzefrVar;
        this.zzb = zzbzxVar.zza;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = zzfaaVar;
        this.zzg = zzfabVar;
        this.zzh = clock;
        this.zzi = zzaqsVar;
    }

    public static final List zzf(int i4, int i5, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzi((String) it.next(), "@gw_mpe@", "2." + i5));
        }
        return arrayList;
    }

    public static final List zzg(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzi((String) it.next(), "@gw_adnetstatus@", str));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String zzh(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (zzbzq.zzk()) {
            return "fakeForAdDebugLog";
        }
        return str;
    }

    private static String zzi(String str, String str2, @Nullable String str3) {
        if (true == TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public final List zzc(zzezz zzezzVar, zzezn zzeznVar, List list) {
        return zzd(zzezzVar, zzeznVar, false, "", "", list);
    }

    public final List zzd(zzezz zzezzVar, @Nullable zzezn zzeznVar, boolean z3, @Nullable String str, @Nullable String str2, List list) {
        String str3;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            boolean z4 = true;
            if (true != z3) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            String zzi = zzi(zzi(zzi((String) it.next(), "@gw_adlocid@", zzezzVar.zza.zza.zzf), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzb);
            if (zzeznVar != null) {
                zzi = zzbxy.zzc(zzi(zzi(zzi(zzi, "@gw_qdata@", zzeznVar.zzz), "@gw_adnetid@", zzeznVar.zzy), "@gw_allocid@", zzeznVar.zzx), this.zze, zzeznVar.zzX);
            }
            String zzi2 = zzi(zzi(zzi(zzi, "@gw_adnetstatus@", this.zza.zzf()), "@gw_seqnum@", this.zzc), "@gw_sessid@", this.zzd);
            boolean z5 = false;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdg)).booleanValue() && !TextUtils.isEmpty(str)) {
                z5 = true;
            }
            boolean z6 = !TextUtils.isEmpty(str2);
            if (!z5) {
                if (!z6) {
                    arrayList.add(zzi2);
                }
            } else {
                z4 = z6;
            }
            if (this.zzi.zzf(Uri.parse(zzi2))) {
                Uri.Builder buildUpon = Uri.parse(zzi2).buildUpon();
                if (z5) {
                    buildUpon = buildUpon.appendQueryParameter(TranslateLanguage.MALAY, str);
                }
                if (z4) {
                    buildUpon = buildUpon.appendQueryParameter("attok", str2);
                }
                zzi2 = buildUpon.build().toString();
            }
            arrayList.add(zzi2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[LOOP:0: B:13:0x0059->B:15:0x005f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zze(com.google.android.gms.internal.ads.zzezn r10, java.util.List r11, com.google.android.gms.internal.ads.zzbuu r12) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.common.util.Clock r1 = r9.zzh
            long r1 = r1.currentTimeMillis()
            java.lang.String r3 = r12.zzc()     // Catch: android.os.RemoteException -> La8
            int r12 = r12.zzb()     // Catch: android.os.RemoteException -> La8
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch: android.os.RemoteException -> La8
            com.google.android.gms.internal.ads.zzbbe r4 = com.google.android.gms.internal.ads.zzbbm.zzdh
            com.google.android.gms.internal.ads.zzbbk r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L35
            com.google.android.gms.internal.ads.zzfab r4 = r9.zzg
            if (r4 != 0) goto L32
            com.google.android.gms.internal.ads.zzfpd r4 = com.google.android.gms.internal.ads.zzfpd.zzc()
            goto L3b
        L32:
            com.google.android.gms.internal.ads.zzfaa r4 = r4.zza
            goto L37
        L35:
            com.google.android.gms.internal.ads.zzfaa r4 = r9.zzf
        L37:
            com.google.android.gms.internal.ads.zzfpd r4 = com.google.android.gms.internal.ads.zzfpd.zzd(r4)
        L3b:
            com.google.android.gms.internal.ads.zzfgl r5 = new com.google.android.gms.internal.ads.zzfov() { // from class: com.google.android.gms.internal.ads.zzfgl
                static {
                    /*
                        com.google.android.gms.internal.ads.zzfgl r0 = new com.google.android.gms.internal.ads.zzfgl
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:com.google.android.gms.internal.ads.zzfgl) com.google.android.gms.internal.ads.zzfgl.zza com.google.android.gms.internal.ads.zzfgl
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgl.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgl.<init>():void");
                }

                @Override // com.google.android.gms.internal.ads.zzfov
                public final java.lang.Object apply(java.lang.Object r1) {
                    /*
                        r0 = this;
                        com.google.android.gms.internal.ads.zzfaa r1 = (com.google.android.gms.internal.ads.zzfaa) r1
                        java.lang.String r1 = com.google.android.gms.internal.ads.zzfgn.zza(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgl.apply(java.lang.Object):java.lang.Object");
                }
            }
            com.google.android.gms.internal.ads.zzfpd r5 = r4.zza(r5)
            java.lang.String r6 = ""
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzfgm r7 = new com.google.android.gms.internal.ads.zzfov() { // from class: com.google.android.gms.internal.ads.zzfgm
                static {
                    /*
                        com.google.android.gms.internal.ads.zzfgm r0 = new com.google.android.gms.internal.ads.zzfgm
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:com.google.android.gms.internal.ads.zzfgm) com.google.android.gms.internal.ads.zzfgm.zza com.google.android.gms.internal.ads.zzfgm
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgm.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgm.<init>():void");
                }

                @Override // com.google.android.gms.internal.ads.zzfov
                public final java.lang.Object apply(java.lang.Object r1) {
                    /*
                        r0 = this;
                        com.google.android.gms.internal.ads.zzfaa r1 = (com.google.android.gms.internal.ads.zzfaa) r1
                        java.lang.String r1 = com.google.android.gms.internal.ads.zzfgn.zzb(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgm.apply(java.lang.Object):java.lang.Object");
                }
            }
            com.google.android.gms.internal.ads.zzfpd r4 = r4.zza(r7)
            java.lang.Object r4 = r4.zzb(r6)
            java.lang.String r4 = (java.lang.String) r4
            java.util.Iterator r11 = r11.iterator()
        L59:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto La7
            java.lang.Object r6 = r11.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = android.net.Uri.encode(r5)
            java.lang.String r8 = "@gw_rwd_userid@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r4)
            java.lang.String r8 = "@gw_rwd_custom_data@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = java.lang.Long.toString(r1)
            java.lang.String r8 = "@gw_tmstmp@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = android.net.Uri.encode(r3)
            java.lang.String r8 = "@gw_rwd_itm@"
            java.lang.String r6 = zzi(r6, r8, r7)
            java.lang.String r7 = "@gw_rwd_amt@"
            java.lang.String r6 = zzi(r6, r7, r12)
            java.lang.String r7 = r9.zzb
            java.lang.String r8 = "@gw_sdkver@"
            java.lang.String r6 = zzi(r6, r8, r7)
            android.content.Context r7 = r9.zze
            boolean r8 = r10.zzX
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbxy.zzc(r6, r7, r8)
            r0.add(r6)
            goto L59
        La7:
            return r0
        La8:
            r10 = move-exception
            java.lang.String r11 = "Unable to determine award type and amount."
            com.google.android.gms.internal.ads.zzbzr.zzh(r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgn.zze(com.google.android.gms.internal.ads.zzezn, java.util.List, com.google.android.gms.internal.ads.zzbuu):java.util.List");
    }
}
