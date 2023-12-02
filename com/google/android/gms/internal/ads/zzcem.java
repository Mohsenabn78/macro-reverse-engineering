package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcem extends zzcbr implements zzhg, zzlv {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdx zzc;
    private final zzwy zzd;
    private final zzcbz zze;
    private final WeakReference zzf;
    private final zzuu zzg;
    @Nullable
    private zzis zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcbq zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    @Nullable
    private Integer zzr;
    private final ArrayList zzs;
    @Nullable
    private volatile zzcdz zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e3, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzbJ)).booleanValue() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e7, code lost:
        if (r5.zzj == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e9, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ec, code lost:
        if (r5.zzm == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ee, code lost:
        r6 = new com.google.android.gms.internal.ads.zzced(r3, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f6, code lost:
        if (r5.zzi <= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f8, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcee(r3, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fe, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcef(r3, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0105, code lost:
        if (r5.zzj == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0107, code lost:
        r5 = new com.google.android.gms.internal.ads.zzceg(r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010e, code lost:
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010f, code lost:
        r4 = r3.zzi;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0111, code lost:
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0117, code lost:
        if (r4.limit() <= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0119, code lost:
        r4 = new byte[r3.zzi.limit()];
        r3.zzi.get(r4);
        r5 = new com.google.android.gms.internal.ads.zzceh(r5, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcem(android.content.Context r4, com.google.android.gms.internal.ads.zzcbz r5, com.google.android.gms.internal.ads.zzcca r6, @androidx.annotation.Nullable java.lang.Integer r7) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcem.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcbz, com.google.android.gms.internal.ads.zzcca, java.lang.Integer):void");
    }

    private final boolean zzad() {
        if (this.zzt != null && this.zzt.zzq()) {
            return true;
        }
        return false;
    }

    public final void finalize() {
        zzcbr.zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzA() {
        if (!zzad()) {
            return this.zzl;
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzB() {
        if (!zzad()) {
            synchronized (this.zzq) {
                while (!this.zzs.isEmpty()) {
                    long j4 = this.zzn;
                    Map zze = ((zzhb) this.zzs.remove(0)).zze();
                    long j5 = 0;
                    if (zze != null) {
                        Iterator it = zze.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzfon.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j5 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j4 + j5;
                }
            }
            return this.zzn;
        }
        return this.zzt.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    @Nullable
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z3) {
        zztq zzugVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z3;
            int length = uriArr.length;
            if (length == 1) {
                zzugVar = zzaa(uriArr[0]);
            } else {
                zztq[] zztqVarArr = new zztq[length];
                for (int i4 = 0; i4 < uriArr.length; i4++) {
                    zztqVarArr[i4] = zzaa(uriArr[i4]);
                }
                zzugVar = new zzug(false, false, zztqVarArr);
            }
            this.zzh.zzB(zzugVar);
            this.zzh.zzp();
            zzcbr.zzE().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzH() {
        zzis zzisVar = this.zzh;
        if (zzisVar != null) {
            zzisVar.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzcbr.zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzI(long j4) {
        zzm zzmVar = (zzm) this.zzh;
        zzmVar.zza(zzmVar.zzd(), j4, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzJ(int i4) {
        this.zzc.zzk(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzK(int i4) {
        this.zzc.zzl(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzL(zzcbq zzcbqVar) {
        this.zzk = zzcbqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzM(int i4) {
        this.zzc.zzm(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzN(int i4) {
        this.zzc.zzn(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzO(boolean z3) {
        this.zzh.zzr(z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzP(@Nullable Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzQ(boolean z3) {
        if (this.zzh != null) {
            int i4 = 0;
            while (true) {
                this.zzh.zzy();
                if (i4 < 2) {
                    zzwy zzwyVar = this.zzd;
                    zzwk zzc = zzwyVar.zzd().zzc();
                    zzc.zzo(i4, !z3);
                    zzwyVar.zzk(zzc);
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzR(int i4) {
        for (WeakReference weakReference : this.zzu) {
            zzcdw zzcdwVar = (zzcdw) weakReference.get();
            if (zzcdwVar != null) {
                zzcdwVar.zzm(i4);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzS(Surface surface, boolean z3) {
        zzis zzisVar = this.zzh;
        if (zzisVar != null) {
            zzisVar.zzs(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzT(float f4, boolean z3) {
        zzis zzisVar = this.zzh;
        if (zzisVar != null) {
            zzisVar.zzt(f4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzU() {
        this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final boolean zzV() {
        if (this.zzh != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzW(String str, boolean z3) {
        zzcem zzcemVar;
        zzcbz zzcbzVar = this.zze;
        int i4 = zzcbzVar.zzd;
        int i5 = zzcbzVar.zzf;
        long j4 = zzcbzVar.zzn;
        long j5 = zzcbzVar.zzo;
        if (true != z3) {
            zzcemVar = null;
        } else {
            zzcemVar = this;
        }
        return new zzcep(str, zzcemVar, i4, i5, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzX(String str, boolean z3) {
        zzcem zzcemVar;
        zzcbz zzcbzVar = this.zze;
        int i4 = zzcbzVar.zzd;
        int i5 = zzcbzVar.zzf;
        int i6 = zzcbzVar.zzi;
        if (true != z3) {
            zzcemVar = null;
        } else {
            zzcemVar = this;
        }
        zzcdw zzcdwVar = new zzcdw(str, zzcemVar, i4, i5, i6);
        this.zzu.add(new WeakReference(zzcdwVar));
        return zzcdwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzY(String str, boolean z3) {
        zzcem zzcemVar;
        zzgm zzgmVar = new zzgm();
        zzgmVar.zzf(str);
        if (true != z3) {
            zzcemVar = null;
        } else {
            zzcemVar = this;
        }
        zzgmVar.zze(zzcemVar);
        zzgmVar.zzc(this.zze.zzd);
        zzgmVar.zzd(this.zze.zzf);
        zzgmVar.zzb(true);
        return zzgmVar.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzge zzZ(zzgd zzgdVar) {
        return new zzcdz(this.zzb, zzgdVar.zza(), this.zzo, this.zzp, this, new zzcec(this));
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzge zzgeVar, zzgj zzgjVar, boolean z3, int i4) {
        this.zzl += i4;
    }

    @VisibleForTesting
    final zztq zzaa(Uri uri) {
        zzar zzarVar = new zzar();
        zzarVar.zzb(uri);
        zzbp zzc = zzarVar.zzc();
        zzuu zzuuVar = this.zzg;
        zzuuVar.zza(this.zze.zzg);
        return zzuuVar.zzb(zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(boolean z3, long j4) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            zzcbqVar.zzi(z3, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzli[] zzac(Handler handler, zzzr zzzrVar, zzot zzotVar, zzvq zzvqVar, zzso zzsoVar) {
        Context context = this.zzb;
        zzry zzryVar = zzry.zzb;
        zzoe zzoeVar = zzoe.zza;
        zzdr[] zzdrVarArr = new zzdr[0];
        zzpn zzpnVar = new zzpn();
        if (zzoeVar != null || zzoeVar != null) {
            zzpnVar.zzc(zzoeVar);
            zzpnVar.zzd(zzdrVarArr);
            zzpz zze = zzpnVar.zze();
            zzro zzroVar = zzro.zza;
            return new zzli[]{new zzqf(context, zzroVar, zzryVar, false, handler, zzotVar, zze), new zzyu(this.zzb, zzroVar, zzryVar, 0L, false, handler, zzzrVar, -1, 30.0f)};
        }
        throw new NullPointerException("Both parameters are null");
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzd(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
        if (zzgeVar instanceof zzhb) {
            synchronized (this.zzq) {
                this.zzs.add((zzhb) zzgeVar);
            }
        } else if (zzgeVar instanceof zzcdz) {
            this.zzt = (zzcdz) zzgeVar;
            final zzcca zzccaVar = (zzcca) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzccaVar != null && this.zzt.zzn()) {
                final HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcej
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcca zzccaVar2 = zzcca.this;
                        Map map = hashMap;
                        int i4 = zzcem.zza;
                        zzccaVar2.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zze(zzlt zzltVar, zzam zzamVar, @Nullable zzia zziaVar) {
        zzcca zzccaVar = (zzcca) this.zzf.get();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzccaVar != null && zzamVar != null) {
            HashMap hashMap = new HashMap();
            String str = zzamVar.zzl;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzamVar.zzm;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzamVar.zzj;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzccaVar.zzd("onMetadataEvent", hashMap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzh(zzlt zzltVar, int i4, long j4) {
        this.zzm += i4;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzj(zzlt zzltVar, zztf zztfVar, zztk zztkVar, IOException iOException, boolean z3) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            if (this.zze.zzk) {
                zzcbqVar.zzl("onLoadException", iOException);
            } else {
                zzcbqVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzk(zzlt zzltVar, int i4) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            zzcbqVar.zzm(i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzl(zzlt zzltVar, zzcf zzcfVar) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            zzcbqVar.zzk("onPlayerError", zzcfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzn(zzlt zzltVar, Object obj, long j4) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            zzcbqVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzp(zzlt zzltVar, zzam zzamVar, @Nullable zzia zziaVar) {
        zzcca zzccaVar = (zzcca) this.zzf.get();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbJ)).booleanValue() && zzccaVar != null && zzamVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzamVar.zzt));
            hashMap.put("bitRate", String.valueOf(zzamVar.zzi));
            int i4 = zzamVar.zzr;
            int i5 = zzamVar.zzs;
            hashMap.put("resolution", i4 + "x" + i5);
            String str = zzamVar.zzl;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzamVar.zzm;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzamVar.zzj;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzccaVar.zzd("onMetadataEvent", hashMap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzq(zzlt zzltVar, zzdn zzdnVar) {
        zzcbq zzcbqVar = this.zzk;
        if (zzcbqVar != null) {
            zzcbqVar.zzD(zzdnVar.zzc, zzdnVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final int zzt() {
        return this.zzh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzv() {
        return this.zzh.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzx() {
        if (!zzad() || !this.zzt.zzp()) {
            return 0L;
        }
        return Math.min(this.zzl, this.zzt.zzk());
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzy() {
        return this.zzh.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final long zzz() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzg(zzlt zzltVar, zztk zztkVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzi(zzcp zzcpVar, zzlu zzluVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzo(zzlt zzltVar, zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzb(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzc(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzf(zzlt zzltVar, int i4, long j4, long j5) {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final /* synthetic */ void zzm(zzlt zzltVar, zzco zzcoVar, zzco zzcoVar2, int i4) {
    }
}
