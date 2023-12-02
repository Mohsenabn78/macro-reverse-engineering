package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzwy extends zzxd implements zzlj {
    public static final /* synthetic */ int zzb = 0;
    private static final zzftl zzc = zzftl.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzwe
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i4 = zzwy.zzb;
            if (num.intValue() == -1) {
                if (num2.intValue() != -1) {
                    return -1;
                }
                return 0;
            } else if (num2.intValue() == -1) {
                return 1;
            } else {
                return num.intValue() - num2.intValue();
            }
        }
    });
    private static final zzftl zzd = zzftl.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzwf
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i4 = zzwy.zzb;
            return 0;
        }
    });
    @Nullable
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    @GuardedBy("lock")
    private zzwm zzg;
    @Nullable
    @GuardedBy("lock")
    private zzwr zzh;
    @GuardedBy("lock")
    private zzk zzi;
    private final zzvt zzj;

    public zzwy(Context context) {
        Context context2;
        zzvt zzvtVar = new zzvt();
        zzwm zzd2 = zzwm.zzd(context);
        this.zze = new Object();
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.zza = context2;
        this.zzj = zzvtVar;
        this.zzg = zzd2;
        this.zzi = zzk.zza;
        boolean z3 = false;
        if (context != null && zzfj.zzE(context)) {
            z3 = true;
        }
        this.zzf = z3;
        if (!z3 && context != null && zzfj.zza >= 32) {
            this.zzh = zzwr.zza(context);
        }
        if (this.zzg.zzQ && context == null) {
            zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static int zza(zzam zzamVar, @Nullable String str, boolean z3) {
        if (!TextUtils.isEmpty(str) && str.equals(zzamVar.zzd)) {
            return 4;
        }
        String zzg = zzg(str);
        String zzg2 = zzg(zzamVar.zzd);
        if (zzg2 != null && zzg != null) {
            if (!zzg2.startsWith(zzg) && !zzg.startsWith(zzg2)) {
                int i4 = zzfj.zza;
                if (!zzg2.split("-", 2)[0].equals(zzg.split("-", 2)[0])) {
                    return 0;
                }
                return 2;
            }
            return 3;
        } else if (!z3 || zzg2 != null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Nullable
    public static String zzg(@Nullable String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "und")) {
            return str;
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ void zzh(zzwy zzwyVar) {
        zzwyVar.zzu();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0053, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ boolean zzl(com.google.android.gms.internal.ads.zzwy r8, com.google.android.gms.internal.ads.zzam r9) {
        /*
            java.lang.Object r0 = r8.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzwm r1 = r8.zzg     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzQ     // Catch: java.lang.Throwable -> L8f
            r2 = 1
            if (r1 == 0) goto L8d
            boolean r1 = r8.zzf     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L8d
            int r1 = r9.zzz     // Catch: java.lang.Throwable -> L8f
            r3 = 2
            if (r1 <= r3) goto L8d
            java.lang.String r1 = r9.zzm     // Catch: java.lang.Throwable -> L8f
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L1b
            goto L65
        L1b:
            int r6 = r1.hashCode()     // Catch: java.lang.Throwable -> L8f
            r7 = 3
            switch(r6) {
                case -2123537834: goto L42;
                case 187078296: goto L38;
                case 187078297: goto L2e;
                case 1504578661: goto L24;
                default: goto L23;
            }
        L23:
            goto L4c
        L24:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 1
            goto L4d
        L2e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 3
            goto L4d
        L38:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 0
            goto L4d
        L42:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L4c
            r1 = 2
            goto L4d
        L4c:
            r1 = -1
        L4d:
            if (r1 == 0) goto L56
            if (r1 == r2) goto L56
            if (r1 == r3) goto L56
            if (r1 == r7) goto L56
            goto L65
        L56:
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8d
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8d
            boolean r1 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L65
            goto L8d
        L65:
            int r1 = com.google.android.gms.internal.ads.zzfj.zza     // Catch: java.lang.Throwable -> L8f
            if (r1 < r4) goto L8c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            boolean r3 = r1.zzg()     // Catch: java.lang.Throwable -> L8f
            if (r3 == 0) goto L8c
            boolean r1 = r1.zze()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.zzf()     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8c
            com.google.android.gms.internal.ads.zzwr r1 = r8.zzh     // Catch: java.lang.Throwable -> L8f
            com.google.android.gms.internal.ads.zzk r8 = r8.zzi     // Catch: java.lang.Throwable -> L8f
            boolean r8 = r1.zzd(r8, r9)     // Catch: java.lang.Throwable -> L8f
            if (r8 == 0) goto L8c
            goto L8d
        L8c:
            r2 = 0
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            return r2
        L8f:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwy.zzl(com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzam):boolean");
    }

    public static boolean zzn(int i4, boolean z3) {
        int i5 = i4 & 7;
        if (i5 == 4) {
            return true;
        }
        if (z3 && i5 == 3) {
            return true;
        }
        return false;
    }

    private static void zzt(zzvn zzvnVar, zzdd zzddVar, Map map) {
        for (int i4 = 0; i4 < zzvnVar.zzc; i4++) {
            if (((zzda) zzddVar.zzC.get(zzvnVar.zzb(i4))) != null) {
                throw null;
            }
        }
    }

    public final void zzu() {
        boolean z3;
        zzwr zzwrVar;
        synchronized (this.zze) {
            z3 = false;
            if (this.zzg.zzQ && !this.zzf && zzfj.zza >= 32 && (zzwrVar = this.zzh) != null && zzwrVar.zzg()) {
                z3 = true;
            }
        }
        if (z3) {
            zzs();
        }
    }

    @Nullable
    private static final Pair zzv(int i4, zzxc zzxcVar, int[][][] iArr, zzwt zzwtVar, Comparator comparator) {
        RandomAccess randomAccess;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 2; i5++) {
            if (i4 == zzxcVar.zzc(i5)) {
                zzvn zzd2 = zzxcVar.zzd(i5);
                for (int i6 = 0; i6 < zzd2.zzc; i6++) {
                    zzcy zzb2 = zzd2.zzb(i6);
                    List zza = zzwtVar.zza(i5, zzb2, iArr[i5][i6]);
                    int i7 = zzb2.zzb;
                    int i8 = 1;
                    boolean[] zArr = new boolean[1];
                    int i9 = 0;
                    while (i9 <= 0) {
                        zzwu zzwuVar = (zzwu) zza.get(i9);
                        int zzb3 = zzwuVar.zzb();
                        if (!zArr[i9] && zzb3 != 0) {
                            if (zzb3 == i8) {
                                randomAccess = zzfsc.zzm(zzwuVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzwuVar);
                                for (int i10 = i9 + 1; i10 <= 0; i10++) {
                                    zzwu zzwuVar2 = (zzwu) zza.get(i10);
                                    if (zzwuVar2.zzb() == 2 && zzwuVar.zzc(zzwuVar2)) {
                                        arrayList2.add(zzwuVar2);
                                        zArr[i10] = true;
                                    }
                                }
                                randomAccess = arrayList2;
                            }
                            arrayList.add(randomAccess);
                        }
                        i9++;
                        i8 = 1;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            iArr2[i11] = ((zzwu) list.get(i11)).zzc;
        }
        zzwu zzwuVar3 = (zzwu) list.get(0);
        return Pair.create(new zzwz(zzwuVar3.zzb, iArr2, 0), Integer.valueOf(zzwuVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    protected final Pair zzb(zzxc zzxcVar, int[][][] iArr, final int[] iArr2, zzto zztoVar, zzcw zzcwVar) throws zzih {
        final zzwm zzwmVar;
        int i4;
        final boolean z3;
        final String str;
        int[] iArr3;
        int length;
        zzxa zza;
        zzwr zzwrVar;
        int[][][] iArr4 = iArr;
        synchronized (this.zze) {
            zzwmVar = this.zzg;
            if (zzwmVar.zzQ && zzfj.zza >= 32 && (zzwrVar = this.zzh) != null) {
                Looper myLooper = Looper.myLooper();
                zzdy.zzb(myLooper);
                zzwrVar.zzb(this, myLooper);
            }
        }
        int i5 = 2;
        zzwz[] zzwzVarArr = new zzwz[2];
        Pair zzv = zzv(2, zzxcVar, iArr4, new zzwt() { // from class: com.google.android.gms.internal.ads.zzwa
            /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
            @Override // com.google.android.gms.internal.ads.zzwt
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.util.List zza(int r20, com.google.android.gms.internal.ads.zzcy r21, int[] r22) {
                /*
                    Method dump skipped, instructions count: 205
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwa.zza(int, com.google.android.gms.internal.ads.zzcy, int[]):java.util.List");
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                zzfrr zzj = zzfrr.zzj();
                zzwv zzwvVar = new Comparator() { // from class: com.google.android.gms.internal.ads.zzwv
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzwx.zzd((zzwx) obj3, (zzwx) obj4);
                    }
                };
                zzfrr zzb2 = zzj.zzc((zzwx) Collections.max(list, zzwvVar), (zzwx) Collections.max(list2, zzwvVar), zzwvVar).zzb(list.size(), list2.size());
                zzww zzwwVar = new Comparator() { // from class: com.google.android.gms.internal.ads.zzww
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzwx.zza((zzwx) obj3, (zzwx) obj4);
                    }
                };
                return zzb2.zzc((zzwx) Collections.max(list, zzwwVar), (zzwx) Collections.max(list2, zzwwVar), zzwwVar).zza();
            }
        });
        if (zzv != null) {
            zzwzVarArr[((Integer) zzv.second).intValue()] = (zzwz) zzv.first;
        }
        int i6 = 0;
        while (true) {
            i4 = 1;
            if (i6 >= 2) {
                z3 = false;
                break;
            } else if (zzxcVar.zzc(i6) == 2 && zzxcVar.zzd(i6).zzc > 0) {
                z3 = true;
                break;
            } else {
                i6++;
            }
        }
        Pair zzv2 = zzv(1, zzxcVar, iArr4, new zzwt() { // from class: com.google.android.gms.internal.ads.zzvy
            @Override // com.google.android.gms.internal.ads.zzwt
            public final List zza(int i7, zzcy zzcyVar, int[] iArr5) {
                final zzwy zzwyVar = zzwy.this;
                zzwm zzwmVar2 = zzwmVar;
                boolean z4 = z3;
                zzfpi zzfpiVar = new zzfpi() { // from class: com.google.android.gms.internal.ads.zzvx
                    @Override // com.google.android.gms.internal.ads.zzfpi
                    public final boolean zza(Object obj) {
                        return zzwy.zzl(zzwy.this, (zzam) obj);
                    }
                };
                zzfrz zzfrzVar = new zzfrz();
                int i8 = 0;
                while (true) {
                    int i9 = zzcyVar.zzb;
                    if (i8 <= 0) {
                        zzfrzVar.zzf(new zzwg(i7, zzcyVar, i8, zzwmVar2, iArr5[i8], z4, zzfpiVar));
                        i8++;
                    } else {
                        return zzfrzVar.zzi();
                    }
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzvz
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzwg) Collections.max((List) obj)).zza((zzwg) Collections.max((List) obj2));
            }
        });
        if (zzv2 != null) {
            zzwzVarArr[((Integer) zzv2.second).intValue()] = (zzwz) zzv2.first;
        }
        if (zzv2 == null) {
            str = null;
        } else {
            Object obj = zzv2.first;
            str = ((zzwz) obj).zza.zzb(((zzwz) obj).zzb[0]).zzd;
        }
        int i7 = 3;
        Pair zzv3 = zzv(3, zzxcVar, iArr4, new zzwt() { // from class: com.google.android.gms.internal.ads.zzwc
            @Override // com.google.android.gms.internal.ads.zzwt
            public final List zza(int i8, zzcy zzcyVar, int[] iArr5) {
                zzwm zzwmVar2 = zzwm.this;
                String str2 = str;
                int i9 = zzwy.zzb;
                zzfrz zzfrzVar = new zzfrz();
                int i10 = 0;
                while (true) {
                    int i11 = zzcyVar.zzb;
                    if (i10 <= 0) {
                        zzfrzVar.zzf(new zzws(i8, zzcyVar, i10, zzwmVar2, iArr5[i10], str2));
                        i10++;
                    } else {
                        return zzfrzVar.zzi();
                    }
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwd
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((zzws) ((List) obj2).get(0)).zza((zzws) ((List) obj3).get(0));
            }
        });
        if (zzv3 != null) {
            zzwzVarArr[((Integer) zzv3.second).intValue()] = (zzwz) zzv3.first;
        }
        int i8 = 0;
        while (i8 < i5) {
            int zzc2 = zzxcVar.zzc(i8);
            if (zzc2 != i5 && zzc2 != i4 && zzc2 != i7) {
                zzvn zzd2 = zzxcVar.zzd(i8);
                int[][] iArr5 = iArr4[i8];
                int i9 = 0;
                zzcy zzcyVar = null;
                int i10 = 0;
                zzwh zzwhVar = null;
                while (i9 < zzd2.zzc) {
                    zzcy zzb2 = zzd2.zzb(i9);
                    int[] iArr6 = iArr5[i9];
                    zzwh zzwhVar2 = zzwhVar;
                    int i11 = 0;
                    while (true) {
                        int i12 = zzb2.zzb;
                        if (i11 <= 0) {
                            if (zzn(iArr6[i11], zzwmVar.zzR)) {
                                zzwh zzwhVar3 = new zzwh(zzb2.zzb(i11), iArr6[i11]);
                                if (zzwhVar2 == null || zzwhVar3.compareTo(zzwhVar2) > 0) {
                                    i10 = i11;
                                    zzwhVar2 = zzwhVar3;
                                    zzcyVar = zzb2;
                                }
                            }
                            i11++;
                        }
                    }
                    i9++;
                    zzwhVar = zzwhVar2;
                }
                zzwzVarArr[i8] = zzcyVar == null ? null : new zzwz(zzcyVar, new int[]{i10}, 0);
            }
            i8++;
            iArr4 = iArr;
            i5 = 2;
            i4 = 1;
            i7 = 3;
        }
        HashMap hashMap = new HashMap();
        for (int i13 = 0; i13 < 2; i13++) {
            zzt(zzxcVar.zzd(i13), zzwmVar, hashMap);
        }
        zzt(zzxcVar.zze(), zzwmVar, hashMap);
        for (int i14 = 0; i14 < 2; i14++) {
            if (((zzda) hashMap.get(Integer.valueOf(zzxcVar.zzc(i14)))) != null) {
                throw null;
            }
        }
        int i15 = 0;
        for (int i16 = 2; i15 < i16; i16 = 2) {
            zzvn zzd3 = zzxcVar.zzd(i15);
            if (zzwmVar.zzg(i15, zzd3)) {
                if (zzwmVar.zze(i15, zzd3) == null) {
                    zzwzVarArr[i15] = null;
                } else {
                    throw null;
                }
            }
            i15++;
        }
        int i17 = 0;
        for (int i18 = 2; i17 < i18; i18 = 2) {
            int zzc3 = zzxcVar.zzc(i17);
            if (zzwmVar.zzf(i17) || zzwmVar.zzD.contains(Integer.valueOf(zzc3))) {
                zzwzVarArr[i17] = null;
            }
            i17++;
        }
        zzvt zzvtVar = this.zzj;
        zzxo zzq = zzq();
        zzfsc zzf = zzvu.zzf(zzwzVarArr);
        int i19 = 2;
        zzxa[] zzxaVarArr = new zzxa[2];
        int i20 = 0;
        while (i20 < i19) {
            zzwz zzwzVar = zzwzVarArr[i20];
            if (zzwzVar != null && (length = (iArr3 = zzwzVar.zzb).length) != 0) {
                if (length == 1) {
                    zza = new zzxb(zzwzVar.zza, iArr3[0], 0, 0, null);
                } else {
                    zza = zzvtVar.zza(zzwzVar.zza, iArr3, 0, zzq, (zzfsc) zzf.get(i20));
                }
                zzxaVarArr[i20] = zza;
            }
            i20++;
            i19 = 2;
        }
        zzll[] zzllVarArr = new zzll[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            zzllVarArr[i21] = (zzwmVar.zzf(i21) || zzwmVar.zzD.contains(Integer.valueOf(zzxcVar.zzc(i21))) || (zzxcVar.zzc(i21) != -2 && zzxaVarArr[i21] == null)) ? null : zzll.zza;
        }
        return Pair.create(zzllVarArr, zzxaVarArr);
    }

    public final zzwm zzd() {
        zzwm zzwmVar;
        synchronized (this.zze) {
            zzwmVar = this.zzg;
        }
        return zzwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzi() {
        zzwr zzwrVar;
        synchronized (this.zze) {
            if (zzfj.zza >= 32 && (zzwrVar = this.zzh) != null) {
                zzwrVar.zzc();
            }
        }
        super.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzj(zzk zzkVar) {
        boolean z3;
        synchronized (this.zze) {
            z3 = !this.zzi.equals(zzkVar);
            this.zzi = zzkVar;
        }
        if (z3) {
            zzu();
        }
    }

    public final void zzk(zzwk zzwkVar) {
        boolean z3;
        zzwm zzwmVar = new zzwm(zzwkVar);
        synchronized (this.zze) {
            z3 = !this.zzg.equals(zzwmVar);
            this.zzg = zzwmVar;
        }
        if (z3) {
            if (zzwmVar.zzQ && this.zza == null) {
                zzer.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean zzm() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    @Nullable
    public final zzlj zzc() {
        return this;
    }
}
