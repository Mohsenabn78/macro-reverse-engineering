package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeaf extends zzeag {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcuk zzd;
    private final TelephonyManager zze;
    private final zzdzx zzf;
    private int zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzazm.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzazm zzazmVar = zzazm.CONNECTING;
        sparseArray.put(ordinal, zzazmVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzazmVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzazmVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzazm.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzazm zzazmVar2 = zzazm.DISCONNECTED;
        sparseArray.put(ordinal2, zzazmVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzazmVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzazmVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzazmVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzazmVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzazm.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzazmVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzazmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaf(Context context, zzcuk zzcukVar, zzdzx zzdzxVar, zzdzt zzdztVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzdztVar, zzgVar);
        this.zzc = context;
        this.zzd = zzcukVar;
        this.zzf = zzdzxVar;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzazd zza(zzeaf zzeafVar, Bundle bundle) {
        zzayw zza = zzazd.zza();
        int i4 = bundle.getInt("cnt", -2);
        int i5 = bundle.getInt("gnt", 0);
        int i6 = 2;
        if (i4 == -1) {
            zzeafVar.zzg = 2;
        } else {
            zzeafVar.zzg = 1;
            if (i4 != 0) {
                if (i4 != 1) {
                    zza.zzb(1);
                } else {
                    zza.zzb(3);
                }
            } else {
                zza.zzb(2);
            }
            switch (i5) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i6 = 3;
                    break;
                case 13:
                    i6 = 5;
                    break;
                default:
                    i6 = 1;
                    break;
            }
            zza.zza(i6);
        }
        return (zzazd) zza.zzal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzazm zzb(zzeaf zzeafVar, Bundle bundle) {
        return (zzazm) zzb.get(zzfat.zza(zzfat.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzazm.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ byte[] zze(zzeaf zzeafVar, boolean z3, ArrayList arrayList, zzazd zzazdVar, zzazm zzazmVar) {
        boolean z4;
        zzazh zzg = zzazi.zzg();
        zzg.zza(arrayList);
        boolean z5 = false;
        if (Settings.Global.getInt(zzeafVar.zzc.getContentResolver(), "airplane_mode_on", 0) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzg.zzi(zzg(z4));
        zzg.zzj(com.google.android.gms.ads.internal.zzt.zzq().zzj(zzeafVar.zzc, zzeafVar.zze));
        zzg.zzf(zzeafVar.zzf.zze());
        zzg.zze(zzeafVar.zzf.zzb());
        zzg.zzb(zzeafVar.zzf.zza());
        zzg.zzc(zzazmVar);
        zzg.zzd(zzazdVar);
        zzg.zzk(zzeafVar.zzg);
        zzg.zzl(zzg(z3));
        zzg.zzh(zzeafVar.zzf.zzd());
        zzg.zzg(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzeafVar.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z5 = true;
        }
        zzg.zzm(zzg(z5));
        return ((zzazi) zzg.zzal()).zzax();
    }

    private static final int zzg(boolean z3) {
        if (z3) {
            return 2;
        }
        return 1;
    }

    public final void zzd(boolean z3) {
        zzfwc.zzq(this.zzd.zzb(), new zzeae(this, z3), zzcae.zzf);
    }
}
