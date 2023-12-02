package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzagt implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzagp
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzagt(0, null)};
        }
    };
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzam zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zzaaz zzD;
    private zzabz[] zzE;
    private zzabz[] zzF;
    private boolean zzG;
    private final List zzd;
    private final SparseArray zze;
    private final zzfa zzf;
    private final zzfa zzg;
    private final zzfa zzh;
    private final byte[] zzi;
    private final zzfa zzj;
    private final zzadq zzk;
    private final zzfa zzl;
    private final ArrayDeque zzm;
    private final ArrayDeque zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    @Nullable
    private zzfa zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    @Nullable
    private zzags zzy;
    private int zzz;

    static {
        zzak zzakVar = new zzak();
        zzakVar.zzS("application/x-emsg");
        zzc = zzakVar.zzY();
    }

    public zzagt() {
        this(0, null);
    }

    private static int zze(int i4) throws zzcd {
        if (i4 >= 0) {
            return i4;
        }
        throw zzcd.zza("Unexpected negative value: " + i4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzad zzf(java.util.List r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L8:
            if (r3 >= r0) goto Lb9
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzagd r5 = (com.google.android.gms.internal.ads.zzagd) r5
            int r6 = r5.zzd
            r7 = 1886614376(0x70737368, float:3.013775E29)
            if (r6 != r7) goto Lb5
            if (r4 != 0) goto L1e
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L1e:
            com.google.android.gms.internal.ads.zzfa r5 = r5.zza
            byte[] r5 = r5.zzH()
            com.google.android.gms.internal.ads.zzfa r6 = new com.google.android.gms.internal.ads.zzfa
            r6.<init>(r5)
            int r8 = r6.zzd()
            r9 = 32
            if (r8 >= r9) goto L33
        L31:
            r6 = r2
            goto L99
        L33:
            r6.zzF(r1)
            int r8 = r6.zze()
            int r9 = r6.zza()
            int r9 = r9 + 4
            if (r8 == r9) goto L43
            goto L31
        L43:
            int r8 = r6.zze()
            if (r8 == r7) goto L4a
            goto L31
        L4a:
            int r7 = r6.zze()
            int r7 = com.google.android.gms.internal.ads.zzage.zze(r7)
            r8 = 1
            if (r7 <= r8) goto L6c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Unsupported pssh version: "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "PsshAtomUtil"
            com.google.android.gms.internal.ads.zzer.zzf(r7, r6)
            goto L31
        L6c:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzr()
            long r12 = r6.zzr()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L84
            int r8 = r6.zzn()
            int r8 = r8 * 16
            r6.zzG(r8)
        L84:
            int r8 = r6.zzn()
            int r10 = r6.zza()
            if (r8 == r10) goto L8f
            goto L31
        L8f:
            byte[] r10 = new byte[r8]
            r6.zzB(r10, r1, r8)
            com.google.android.gms.internal.ads.zzagz r6 = new com.google.android.gms.internal.ads.zzagz
            r6.<init>(r9, r7, r10)
        L99:
            if (r6 != 0) goto L9d
            r6 = r2
            goto La1
        L9d:
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzagz.zza(r6)
        La1:
            if (r6 != 0) goto Lab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            com.google.android.gms.internal.ads.zzer.zzf(r5, r6)
            goto Lb5
        Lab:
            com.google.android.gms.internal.ads.zzac r7 = new com.google.android.gms.internal.ads.zzac
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r2, r8, r5)
            r4.add(r7)
        Lb5:
            int r3 = r3 + 1
            goto L8
        Lb9:
            if (r4 != 0) goto Lbc
            return r2
        Lbc:
            com.google.android.gms.internal.ads.zzad r14 = new com.google.android.gms.internal.ads.zzad
            r14.<init>(r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagt.zzf(java.util.List):com.google.android.gms.internal.ads.zzad");
    }

    private final void zzg() {
        this.zzo = 0;
        this.zzr = 0;
    }

    private static void zzh(zzfa zzfaVar, int i4, zzahe zzaheVar) throws zzcd {
        boolean z3;
        zzfaVar.zzF(i4 + 8);
        int zze = zzfaVar.zze() & 16777215;
        if ((zze & 1) == 0) {
            if ((zze & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int zzn = zzfaVar.zzn();
            if (zzn == 0) {
                Arrays.fill(zzaheVar.zzl, 0, zzaheVar.zze, false);
                return;
            }
            int i5 = zzaheVar.zze;
            if (zzn == i5) {
                Arrays.fill(zzaheVar.zzl, 0, zzn, z3);
                zzaheVar.zza(zzfaVar.zza());
                zzfa zzfaVar2 = zzaheVar.zzn;
                zzfaVar.zzB(zzfaVar2.zzH(), 0, zzfaVar2.zzd());
                zzaheVar.zzn.zzF(0);
                zzaheVar.zzo = false;
                return;
            }
            throw zzcd.zza("Senc sample count " + zzn + " is different from fragment sample count" + i5, null);
        }
        throw zzcd.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0315, code lost:
        if (com.google.android.gms.internal.ads.zzfj.zzp(r31 + r8[0], androidx.compose.animation.core.AnimationKt.MillisToNanos, r5.zzd) < r5.zze) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzi(long r46) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 1800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagt.zzi(long):void");
    }

    private static final zzago zzj(SparseArray sparseArray, int i4) {
        if (sparseArray.size() == 1) {
            return (zzago) sparseArray.valueAt(0);
        }
        zzago zzagoVar = (zzago) sparseArray.get(i4);
        zzagoVar.getClass();
        return zzagoVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0246, code lost:
        r23 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0248, code lost:
        r5.zzs(r10, r20, r33.zzz, 0, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x025b, code lost:
        if (r33.zzn.isEmpty() != false) goto L354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x025d, code lost:
        r1 = (com.google.android.gms.internal.ads.zzagr) r33.zzn.removeFirst();
        r33.zzu -= r1.zzc;
        r3 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0270, code lost:
        if (r1.zzb == false) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0272, code lost:
        r3 = r3 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0273, code lost:
        r5 = r33.zzE;
        r6 = r5.length;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0277, code lost:
        if (r8 >= r6) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0279, code lost:
        r5[r8].zzs(r3, 1, r1.zzc, r33.zzu, null);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0291, code lost:
        if (r2.zzk() != false) goto L358;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0293, code lost:
        r33.zzy = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0295, code lost:
        r33.zzo = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0099, code lost:
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
        if (r33.zzo != 3) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
        r3 = r2.zzb();
        r33.zzz = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
        if (r2.zzf >= r2.zzi) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
        ((com.google.android.gms.internal.ads.zzaam) r1).zzo(r3, false);
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
        if (r1 != null) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b6, code lost:
        r3 = r2.zzb.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
        if (r1 == 0) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:
        r3.zzG(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
        if (r2.zzb.zzb(r2.zzf) == false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cb, code lost:
        r3.zzG(r3.zzo() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
        if (r2.zzk() != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00da, code lost:
        r33.zzy = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:
        r33.zzo = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00de, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e7, code lost:
        if (r2.zzd.zza.zzg != 1) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e9, code lost:
        r33.zzz = r3 - 8;
        ((com.google.android.gms.internal.ads.zzaam) r1).zzo(8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0103, code lost:
        if ("audio/ac4".equals(r2.zzd.zza.zzf.zzm) == false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0105, code lost:
        r33.zzA = r2.zzc(r33.zzz, 7);
        com.google.android.gms.internal.ads.zzaaa.zzb(r33.zzz, r33.zzj);
        r2.zza.zzq(r33.zzj, 7);
        r3 = r33.zzA + 7;
        r33.zzA = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
        r3 = r2.zzc(r33.zzz, 0);
        r33.zzA = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012a, code lost:
        r33.zzz += r3;
        r33.zzo = 4;
        r33.zzB = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0134, code lost:
        r3 = r2.zzd.zza;
        r5 = r2.zza;
        r10 = r2.zze();
        r6 = r3.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0140, code lost:
        if (r6 != 0) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0142, code lost:
        r3 = r33.zzA;
        r4 = r33.zzz;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
        if (r3 >= r4) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0148, code lost:
        r33.zzA += r5.zze(r1, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0153, code lost:
        r13 = r33.zzg.zzH();
        r13[0] = 0;
        r13[1] = 0;
        r13[2] = 0;
        r14 = r6 + 1;
        r6 = 4 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (r33.zzA >= r33.zzz) goto L392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016b, code lost:
        r12 = r33.zzB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016f, code lost:
        if (r12 != 0) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0171, code lost:
        ((com.google.android.gms.internal.ads.zzaam) r1).zzn(r13, r6, r14, r9);
        r33.zzg.zzF(r9);
        r12 = r33.zzg.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0182, code lost:
        if (r12 <= 0) goto L383;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0184, code lost:
        r33.zzB = r12 - 1;
        r33.zzf.zzF(r9);
        r5.zzq(r33.zzf, 4);
        r5.zzq(r33.zzg, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019b, code lost:
        if (r33.zzF.length <= 0) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019d, code lost:
        r12 = r3.zzf.zzm;
        r17 = r13[4];
        r9 = com.google.android.gms.internal.ads.zzfu.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ab, code lost:
        if ("video/avc".equals(r12) == false) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01af, code lost:
        if ((r17 & 31) == r4) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b2, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
        if ("video/hevc".equals(r12) == false) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bf, code lost:
        if (((r17 & 126) >> r8) != 39) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c2, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c3, code lost:
        r33.zzC = r9;
        r33.zzA += 5;
        r33.zzz += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d7, code lost:
        throw com.google.android.gms.internal.ads.zzcd.zza("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01da, code lost:
        if (r33.zzC == false) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dc, code lost:
        r33.zzh.zzC(r12);
        ((com.google.android.gms.internal.ads.zzaam) r1).zzn(r33.zzh.zzH(), 0, r33.zzB, false);
        r5.zzq(r33.zzh, r33.zzB);
        r4 = r33.zzB;
        r8 = r33.zzh;
        r8 = com.google.android.gms.internal.ads.zzfu.zzb(r8.zzH(), r8.zzd());
        r33.zzh.zzF("video/hevc".equals(r3.zzf.zzm) ? 1 : 0);
        r33.zzh.zzE(r8);
        com.google.android.gms.internal.ads.zzaaj.zza(r10, r33.zzh, r33.zzF);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0221, code lost:
        r4 = r5.zze(r1, r12, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0227, code lost:
        r33.zzA += r4;
        r33.zzB -= r4;
        r4 = 6;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0233, code lost:
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0237, code lost:
        r20 = r2.zza();
        r1 = r2.zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023f, code lost:
        if (r1 == null) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0241, code lost:
        r23 = r1.zzc;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v10 */
    @Override // com.google.android.gms.internal.ads.zzaaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzaax r34, com.google.android.gms.internal.ads.zzabs r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagt.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzD = zzaazVar;
        zzg();
        zzabz[] zzabzVarArr = new zzabz[2];
        this.zzE = zzabzVarArr;
        int i4 = 0;
        zzabz[] zzabzVarArr2 = (zzabz[]) zzfj.zzG(zzabzVarArr, 0);
        this.zzE = zzabzVarArr2;
        for (zzabz zzabzVar : zzabzVarArr2) {
            zzabzVar.zzk(zzc);
        }
        this.zzF = new zzabz[this.zzd.size()];
        int i5 = 100;
        while (i4 < this.zzF.length) {
            int i6 = i5 + 1;
            zzabz zzv = this.zzD.zzv(i5, 3);
            zzv.zzk((zzam) this.zzd.get(i4));
            this.zzF[i4] = zzv;
            i4++;
            i5 = i6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        int size = this.zze.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((zzags) this.zze.valueAt(i4)).zzi();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j5;
        this.zzm.clear();
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        return zzahb.zza(zzaaxVar);
    }

    public zzagt(int i4, @Nullable zzfh zzfhVar) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzadq();
        this.zzl = new zzfa(16);
        this.zzf = new zzfa(zzfu.zza);
        this.zzg = new zzfa(5);
        this.zzh = new zzfa();
        byte[] bArr = new byte[16];
        this.zzi = bArr;
        this.zzj = new zzfa(bArr);
        this.zzm = new ArrayDeque();
        this.zzn = new ArrayDeque();
        this.zze = new SparseArray();
        this.zzw = -9223372036854775807L;
        this.zzv = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzD = zzaaz.zza;
        this.zzE = new zzabz[0];
        this.zzF = new zzabz[0];
    }
}
