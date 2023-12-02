package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbit implements zzbij {
    @Nullable
    private final com.google.android.gms.ads.internal.zzb zza;
    @Nullable
    private final zzdqa zzb;
    @Nullable
    private final zzfev zzc;
    @Nullable
    private final zzbqq zze;
    @Nullable
    private final zzeba zzf;
    private com.google.android.gms.ads.internal.overlay.zzx zzg = null;
    private final zzbzw zzd = new zzbzw(null);

    public zzbit(com.google.android.gms.ads.internal.zzb zzbVar, zzbqq zzbqqVar, zzeba zzebaVar, zzdqa zzdqaVar, zzfev zzfevVar) {
        this.zza = zzbVar;
        this.zze = zzbqqVar;
        this.zzf = zzebaVar;
        this.zzb = zzdqaVar;
        this.zzc = zzfevVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return 7;
            }
            if ("l".equalsIgnoreCase(str)) {
                return 6;
            }
            if (CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT.equalsIgnoreCase(str)) {
                return 14;
            }
            return -1;
        }
        return -1;
    }

    @VisibleForTesting
    static Uri zzc(Context context, zzaqs zzaqsVar, Uri uri, View view, @Nullable Activity activity) {
        if (zzaqsVar == null) {
            return uri;
        }
        try {
            if (zzaqsVar.zze(uri)) {
                return zzaqsVar.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzaqt unused) {
            return uri;
        } catch (Exception e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    @VisibleForTesting
    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e4) {
            zzbzr.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e4);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private final void zzh(Context context, String str, String str2) {
        this.zzf.zzc(str);
        zzdqa zzdqaVar = this.zzb;
        if (zzdqaVar != null) {
            zzebl.zzc(context, zzdqaVar, this.zzc, this.zzf, str, "dialog_not_shown", zzfsf.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00df, code lost:
        if (com.google.android.gms.internal.ads.zzbis.zzc(r11, r5, r6, r7) == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0122, code lost:
        r11 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzi(com.google.android.gms.ads.internal.client.zza r18, java.util.Map r19, boolean r20, java.lang.String r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbit.zzi(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean):void");
    }

    private final void zzj(boolean z3) {
        zzbqq zzbqqVar = this.zze;
        if (zzbqqVar != null) {
            zzbqqVar.zza(z3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
        if (r2 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzk(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbit.zzk(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(int i4) {
        if (this.zzb == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfev zzfevVar = this.zzc;
            String zza = zzbcm.zza(i4);
            zzfeu zzb = zzfeu.zzb("cct_action");
            zzb.zza("cct_open_status", zza);
            zzfevVar.zzb(zzb);
            return;
        }
        zzdpz zza2 = this.zzb.zza();
        zza2.zzb("action", "cct_action");
        zza2.zzb("cct_open_status", zzbcm.zza(i4));
        zza2.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    /* renamed from: zze */
    public final void zza(com.google.android.gms.ads.internal.client.zza zzaVar, Map map) {
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        HashMap hashMap;
        Object obj;
        zzcez zzcezVar = (zzcez) zzaVar;
        String zzc = zzbxy.zzc((String) map.get("u"), zzcezVar.getContext(), true);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzbzr.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar != null && !zzbVar.zzc()) {
            this.zza.zzb(zzc);
            return;
        }
        zzezn zzD = zzcezVar.zzD();
        zzezq zzP = zzcezVar.zzP();
        boolean z6 = false;
        if (zzD == null || zzP == null) {
            str = "";
            z3 = false;
        } else {
            z3 = zzD.zzaj;
            str = zzP.zzb;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjq)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) {
            z4 = false;
        } else {
            z4 = true;
        }
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcezVar.zzaA()) {
                zzbzr.zzj("Cannot expand WebView that is already expanded.");
                return;
            }
            zzj(false);
            ((zzcge) zzaVar).zzaF(zzf(map), zzb(map), z4);
        } else if ("webapp".equalsIgnoreCase(str2)) {
            zzj(false);
            if (zzc != null) {
                ((zzcge) zzaVar).zzaG(zzf(map), zzb(map), zzc, z4);
            } else {
                ((zzcge) zzaVar).zzaH(zzf(map), zzb(map), (String) map.get("html"), (String) map.get("baseurl"), z4);
            }
        } else if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcezVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzem)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzes)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                } else {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeq)).booleanValue()) {
                        z6 = true;
                        break;
                    }
                    String str3 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzer);
                    if (!str3.isEmpty() && context != null) {
                        String packageName = context.getPackageName();
                        for (String str4 : zzfpu.zzc(zzfos.zzc(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)).zzd(str3)) {
                            if (str4.equals(packageName)) {
                                z6 = true;
                                break;
                            }
                        }
                    }
                }
            }
            boolean zzg = zzbcn.zzg(zzcezVar.getContext());
            if (z6) {
                if (!zzg) {
                    zzl(4);
                } else {
                    zzj(true);
                    if (TextUtils.isEmpty(zzc)) {
                        zzbzr.zzj("Cannot open browser with null or empty url");
                        zzl(7);
                        return;
                    }
                    Uri zzd = zzd(zzc(zzcezVar.getContext(), zzcezVar.zzI(), Uri.parse(zzc), zzcezVar.zzF(), zzcezVar.zzi()));
                    if (z3 && this.zzf != null && zzk(zzaVar, zzcezVar.getContext(), zzd.toString(), str)) {
                        return;
                    }
                    this.zzg = new zzbiq(this);
                    ((zzcge) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(null, zzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z4);
                    return;
                }
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzi(zzaVar, map, z3, str, z4);
        } else if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzi(zzaVar, map, z3, str, z4);
        } else if ("open_app".equalsIgnoreCase(str2)) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhN)).booleanValue()) {
                return;
            }
            zzj(true);
            String str5 = (String) map.get("p");
            if (str5 == null) {
                zzbzr.zzj("Package name missing from open app action.");
            } else if (!z3 || this.zzf == null || !zzk(zzaVar, zzcezVar.getContext(), str5, str)) {
                PackageManager packageManager = zzcezVar.getContext().getPackageManager();
                if (packageManager == null) {
                    zzbzr.zzj("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                if (launchIntentForPackage != null) {
                    ((zzcge) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzg), z4);
                }
            }
        } else {
            zzj(true);
            String str6 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str6)) {
                try {
                    intent = Intent.parseUri(str6, 0);
                } catch (URISyntaxException e4) {
                    zzbzr.zzh("Error parsing the url: ".concat(String.valueOf(str6)), e4);
                }
            }
            Intent intent2 = intent;
            if (intent2 != null && intent2.getData() != null) {
                Uri data = intent2.getData();
                if (!Uri.EMPTY.equals(data)) {
                    Uri zzd2 = zzd(zzc(zzcezVar.getContext(), zzcezVar.zzI(), data, zzcezVar.zzF(), zzcezVar.zzi()));
                    if (!TextUtils.isEmpty(intent2.getType())) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhO)).booleanValue()) {
                            intent2.setDataAndType(zzd2, intent2.getType());
                        }
                    }
                    intent2.setData(zzd2);
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzic)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id")) {
                z5 = true;
            } else {
                z5 = false;
            }
            HashMap hashMap2 = new HashMap();
            if (z5) {
                hashMap = hashMap2;
                obj = "p";
                this.zzg = new zzbir(this, z4, zzaVar, hashMap2, map);
                z4 = false;
            } else {
                hashMap = hashMap2;
                obj = "p";
            }
            if (intent2 != null) {
                if (z3 && this.zzf != null && zzk(zzaVar, zzcezVar.getContext(), intent2.getData().toString(), str)) {
                    if (z5) {
                        HashMap hashMap3 = hashMap;
                        hashMap3.put((String) map.get("event_id"), Boolean.TRUE);
                        ((zzblc) zzaVar).zzd("openIntentAsync", hashMap3);
                        return;
                    }
                    return;
                }
                ((zzcge) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc(intent2, this.zzg), z4);
                return;
            }
            HashMap hashMap4 = hashMap;
            if (!TextUtils.isEmpty(zzc)) {
                zzc = zzd(zzc(zzcezVar.getContext(), zzcezVar.zzI(), Uri.parse(zzc), zzcezVar.zzF(), zzcezVar.zzi())).toString();
            }
            if (z3 && this.zzf != null && zzk(zzaVar, zzcezVar.getContext(), zzc, str)) {
                if (z5) {
                    hashMap4.put((String) map.get("event_id"), Boolean.TRUE);
                    ((zzblc) zzaVar).zzd("openIntentAsync", hashMap4);
                    return;
                }
                return;
            }
            ((zzcge) zzaVar).zzaD(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), zzc, (String) map.get("m"), (String) map.get(obj), (String) map.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT), (String) map.get("f"), (String) map.get("e"), this.zzg), z4);
        }
    }
}
