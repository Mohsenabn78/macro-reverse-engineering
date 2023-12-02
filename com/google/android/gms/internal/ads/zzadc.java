package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzadc extends zzade {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzadc() {
        super(new zzaav());
        this.zzb = -9223372036854775807L;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzfa zzfaVar) {
        return Double.valueOf(Double.longBitsToDouble(zzfaVar.zzr()));
    }

    @Nullable
    private static Object zzh(zzfa zzfaVar, int i4) {
        if (i4 != 0) {
            boolean z3 = false;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 8) {
                            if (i4 != 10) {
                                if (i4 != 11) {
                                    return null;
                                }
                                Date date = new Date((long) zzg(zzfaVar).doubleValue());
                                zzfaVar.zzG(2);
                                return date;
                            }
                            int zzn = zzfaVar.zzn();
                            ArrayList arrayList = new ArrayList(zzn);
                            for (int i5 = 0; i5 < zzn; i5++) {
                                Object zzh = zzh(zzfaVar, zzfaVar.zzk());
                                if (zzh != null) {
                                    arrayList.add(zzh);
                                }
                            }
                            return arrayList;
                        }
                        return zzj(zzfaVar);
                    }
                    HashMap hashMap = new HashMap();
                    while (true) {
                        String zzi = zzi(zzfaVar);
                        int zzk = zzfaVar.zzk();
                        if (zzk == 9) {
                            return hashMap;
                        }
                        Object zzh2 = zzh(zzfaVar, zzk);
                        if (zzh2 != null) {
                            hashMap.put(zzi, zzh2);
                        }
                    }
                } else {
                    return zzi(zzfaVar);
                }
            } else {
                if (zzfaVar.zzk() == 1) {
                    z3 = true;
                }
                return Boolean.valueOf(z3);
            }
        } else {
            return zzg(zzfaVar);
        }
    }

    private static String zzi(zzfa zzfaVar) {
        int zzo = zzfaVar.zzo();
        int zzc = zzfaVar.zzc();
        zzfaVar.zzG(zzo);
        return new String(zzfaVar.zzH(), zzc, zzo);
    }

    private static HashMap zzj(zzfa zzfaVar) {
        int zzn = zzfaVar.zzn();
        HashMap hashMap = new HashMap(zzn);
        for (int i4 = 0; i4 < zzn; i4++) {
            String zzi = zzi(zzfaVar);
            Object zzh = zzh(zzfaVar, zzfaVar.zzk());
            if (zzh != null) {
                hashMap.put(zzi, zzh);
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zza(zzfa zzfaVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    protected final boolean zzb(zzfa zzfaVar, long j4) {
        if (zzfaVar.zzk() != 2 || !"onMetaData".equals(zzi(zzfaVar)) || zzfaVar.zza() == 0 || zzfaVar.zzk() != 8) {
            return false;
        }
        HashMap zzj = zzj(zzfaVar);
        Object obj = zzj.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.zzb = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = zzj.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.zzc = new long[size];
                this.zzd = new long[size];
                for (int i4 = 0; i4 < size; i4++) {
                    Object obj5 = list.get(i4);
                    Object obj6 = list2.get(i4);
                    if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                        this.zzc[i4] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i4] = ((Double) obj5).longValue();
                    } else {
                        this.zzc = new long[0];
                        this.zzd = new long[0];
                        break;
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzd;
    }

    public final long[] zze() {
        return this.zzc;
    }
}
