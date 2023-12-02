package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzmh;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzlj extends zzku {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlj(zzlh zzlhVar) {
        super(zzlhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List A(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i4 = 0; i4 < length; i4++) {
            long j4 = 0;
            for (int i5 = 0; i5 < 64; i5++) {
                int i6 = (i4 * 64) + i5;
                if (i6 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i6)) {
                    j4 |= 1 << i5;
                }
            }
            arrayList.add(Long.valueOf(j4));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean E(List list, int i4) {
        if (i4 < list.size() * 64) {
            if (((1 << (i4 % 64)) & ((Long) list.get(i4 / 64)).longValue()) != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean G(String str) {
        if (str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void d(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str, Object obj) {
        List zzp = zzfsVar.zzp();
        int i4 = 0;
        while (true) {
            if (i4 < zzp.size()) {
                if (str.equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(i4)).zzg())) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zze = com.google.android.gms.internal.measurement.zzfx.zze();
        zze.zzj(str);
        if (obj instanceof Long) {
            zze.zzi(((Long) obj).longValue());
        }
        if (i4 >= 0) {
            zzfsVar.zzj(i4, zze);
        } else {
            zzfsVar.zze(zze);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public static final boolean e(zzau zzauVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzauVar);
        Preconditions.checkNotNull(zzqVar);
        if (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final com.google.android.gms.internal.measurement.zzfx f(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfx zzfxVar : zzftVar.zzi()) {
            if (zzfxVar.zzg().equals(str)) {
                return zzfxVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object g(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        com.google.android.gms.internal.measurement.zzfx f4 = f(zzftVar, str);
        if (f4 != null) {
            if (f4.zzy()) {
                return f4.zzh();
            }
            if (f4.zzw()) {
                return Long.valueOf(f4.zzd());
            }
            if (f4.zzu()) {
                return Double.valueOf(f4.zza());
            }
            if (f4.zzc() > 0) {
                List<com.google.android.gms.internal.measurement.zzfx> zzi = f4.zzi();
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzfx zzfxVar : zzi) {
                    if (zzfxVar != null) {
                        Bundle bundle = new Bundle();
                        for (com.google.android.gms.internal.measurement.zzfx zzfxVar2 : zzfxVar.zzi()) {
                            if (zzfxVar2.zzy()) {
                                bundle.putString(zzfxVar2.zzg(), zzfxVar2.zzh());
                            } else if (zzfxVar2.zzw()) {
                                bundle.putLong(zzfxVar2.zzg(), zzfxVar2.zzd());
                            } else if (zzfxVar2.zzu()) {
                                bundle.putDouble(zzfxVar2.zzg(), zzfxVar2.zza());
                            }
                        }
                        if (!bundle.isEmpty()) {
                            arrayList.add(bundle);
                        }
                    }
                }
                return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    private final void h(StringBuilder sb, int i4, List list) {
        String str;
        String str2;
        Long l4;
        if (list == null) {
            return;
        }
        int i5 = i4 + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it.next();
            if (zzfxVar != null) {
                j(sb, i5);
                sb.append("param {\n");
                Double d4 = null;
                if (zzfxVar.zzx()) {
                    str = this.f21734a.zzj().e(zzfxVar.zzg());
                } else {
                    str = null;
                }
                m(sb, i5, "name", str);
                if (zzfxVar.zzy()) {
                    str2 = zzfxVar.zzh();
                } else {
                    str2 = null;
                }
                m(sb, i5, "string_value", str2);
                if (zzfxVar.zzw()) {
                    l4 = Long.valueOf(zzfxVar.zzd());
                } else {
                    l4 = null;
                }
                m(sb, i5, "int_value", l4);
                if (zzfxVar.zzu()) {
                    d4 = Double.valueOf(zzfxVar.zza());
                }
                m(sb, i5, "double_value", d4);
                if (zzfxVar.zzc() > 0) {
                    h(sb, i5, zzfxVar.zzi());
                }
                j(sb, i5);
                sb.append("}\n");
            }
        }
    }

    private final void i(StringBuilder sb, int i4, com.google.android.gms.internal.measurement.zzem zzemVar) {
        String str;
        if (zzemVar == null) {
            return;
        }
        j(sb, i4);
        sb.append("filter {\n");
        if (zzemVar.zzh()) {
            m(sb, i4, "complement", Boolean.valueOf(zzemVar.zzg()));
        }
        if (zzemVar.zzj()) {
            m(sb, i4, "param_name", this.f21734a.zzj().e(zzemVar.zze()));
        }
        if (zzemVar.zzk()) {
            int i5 = i4 + 1;
            com.google.android.gms.internal.measurement.zzey zzd = zzemVar.zzd();
            if (zzd != null) {
                j(sb, i5);
                sb.append("string_filter {\n");
                if (zzd.zzi()) {
                    switch (zzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    m(sb, i5, "match_type", str);
                }
                if (zzd.zzh()) {
                    m(sb, i5, "expression", zzd.zzd());
                }
                if (zzd.zzg()) {
                    m(sb, i5, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                }
                if (zzd.zza() > 0) {
                    j(sb, i5 + 1);
                    sb.append("expression_list {\n");
                    for (String str2 : zzd.zze()) {
                        j(sb, i5 + 2);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                j(sb, i5);
                sb.append("}\n");
            }
        }
        if (zzemVar.zzi()) {
            n(sb, i4 + 1, "number_filter", zzemVar.zzc());
        }
        j(sb, i4);
        sb.append("}\n");
    }

    private static final void j(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("  ");
        }
    }

    private static final String k(boolean z3, boolean z4, boolean z5) {
        StringBuilder sb = new StringBuilder();
        if (z3) {
            sb.append("Dynamic ");
        }
        if (z4) {
            sb.append("Sequence ");
        }
        if (z5) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void l(StringBuilder sb, int i4, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar) {
        Integer num;
        Integer num2;
        Long l4;
        if (zzgiVar == null) {
            return;
        }
        j(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzgiVar.zzb() != 0) {
            j(sb, 4);
            sb.append("results: ");
            int i5 = 0;
            for (Long l5 : zzgiVar.zzi()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(l5);
                i5 = i6;
            }
            sb.append('\n');
        }
        if (zzgiVar.zzd() != 0) {
            j(sb, 4);
            sb.append("status: ");
            int i7 = 0;
            for (Long l6 : zzgiVar.zzk()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(l6);
                i7 = i8;
            }
            sb.append('\n');
        }
        if (zzgiVar.zza() != 0) {
            j(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i9 = 0;
            for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzh()) {
                int i10 = i9 + 1;
                if (i9 != 0) {
                    sb.append(", ");
                }
                if (zzfrVar.zzh()) {
                    num2 = Integer.valueOf(zzfrVar.zza());
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(":");
                if (zzfrVar.zzg()) {
                    l4 = Long.valueOf(zzfrVar.zzb());
                } else {
                    l4 = null;
                }
                sb.append(l4);
                i9 = i10;
            }
            sb.append("}\n");
        }
        if (zzgiVar.zzc() != 0) {
            j(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i11 = 0;
            for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzj()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                if (zzgkVar.zzi()) {
                    num = Integer.valueOf(zzgkVar.zzb());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(": [");
                int i13 = 0;
                for (Long l7 : zzgkVar.zzf()) {
                    long longValue = l7.longValue();
                    int i14 = i13 + 1;
                    if (i13 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i13 = i14;
                }
                sb.append("]");
                i11 = i12;
            }
            sb.append("}\n");
        }
        j(sb, 3);
        sb.append("}\n");
    }

    private static final void m(StringBuilder sb, int i4, String str, Object obj) {
        if (obj == null) {
            return;
        }
        j(sb, i4 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void n(StringBuilder sb, int i4, String str, com.google.android.gms.internal.measurement.zzer zzerVar) {
        String str2;
        if (zzerVar == null) {
            return;
        }
        j(sb, i4);
        sb.append(str);
        sb.append(" {\n");
        if (zzerVar.zzg()) {
            int zzm = zzerVar.zzm();
            if (zzm != 1) {
                if (zzm != 2) {
                    if (zzm != 3) {
                        if (zzm != 4) {
                            str2 = "BETWEEN";
                        } else {
                            str2 = "EQUAL";
                        }
                    } else {
                        str2 = "GREATER_THAN";
                    }
                } else {
                    str2 = "LESS_THAN";
                }
            } else {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            }
            m(sb, i4, "comparison_type", str2);
        }
        if (zzerVar.zzi()) {
            m(sb, i4, "match_as_float", Boolean.valueOf(zzerVar.zzf()));
        }
        if (zzerVar.zzh()) {
            m(sb, i4, "comparison_value", zzerVar.zzc());
        }
        if (zzerVar.zzk()) {
            m(sb, i4, "min_comparison_value", zzerVar.zze());
        }
        if (zzerVar.zzj()) {
            m(sb, i4, "max_comparison_value", zzerVar.zzd());
        }
        j(sb, i4);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(com.google.android.gms.internal.measurement.zzgc zzgcVar, String str) {
        for (int i4 = 0; i4 < zzgcVar.zzb(); i4++) {
            if (str.equals(zzgcVar.zzap(i4).zzf())) {
                return i4;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmh v(zzmh zzmhVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzll {
        com.google.android.gms.internal.measurement.zzkn zza = com.google.android.gms.internal.measurement.zzkn.zza();
        if (zza != null) {
            return zzmhVar.zzaz(bArr, zza);
        }
        return zzmhVar.zzay(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r4 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r7 >= r4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        r5.add(B((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if ((r3 instanceof java.util.ArrayList) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r7 >= r4) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        r5.add(B((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        if ((r3 instanceof android.os.Bundle) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        r5.add(B((android.os.Bundle) r3, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        r0.put(r2, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map B(android.os.Bundle r11, boolean r12) {
        /*
            r10 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r11.get(r2)
            boolean r4 = r3 instanceof android.os.Parcelable[]
            if (r4 != 0) goto L30
            boolean r5 = r3 instanceof java.util.ArrayList
            if (r5 != 0) goto L30
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto L2a
            goto L30
        L2a:
            if (r3 == 0) goto Ld
            r0.put(r2, r3)
            goto Ld
        L30:
            if (r12 == 0) goto Ld
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            if (r4 == 0) goto L52
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            int r4 = r3.length
            r7 = 0
        L3e:
            if (r7 >= r4) goto L80
            r8 = r3[r7]
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L4f
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.Map r8 = r10.B(r8, r6)
            r5.add(r8)
        L4f:
            int r7 = r7 + 1
            goto L3e
        L52:
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 == 0) goto L73
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r4 = r3.size()
            r7 = 0
        L5d:
            if (r7 >= r4) goto L80
            java.lang.Object r8 = r3.get(r7)
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L70
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.Map r8 = r10.B(r8, r6)
            r5.add(r8)
        L70:
            int r7 = r7 + 1
            goto L5d
        L73:
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L80
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.util.Map r3 = r10.B(r3, r6)
            r5.add(r3)
        L80:
            r0.put(r2, r5)
            goto Ld
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.B(android.os.Bundle, boolean):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(com.google.android.gms.internal.measurement.zzfw zzfwVar, Object obj) {
        Bundle[] bundleArr;
        Preconditions.checkNotNull(obj);
        zzfwVar.zzg();
        zzfwVar.zze();
        zzfwVar.zzd();
        zzfwVar.zzf();
        if (obj instanceof String) {
            zzfwVar.zzk((String) obj);
        } else if (obj instanceof Long) {
            zzfwVar.zzi(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfwVar.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.zzfw zze = com.google.android.gms.internal.measurement.zzfx.zze();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
                        zze2.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.zzfx) zze.zzaD());
                    }
                }
            }
            zzfwVar.zzb(arrayList);
        } else {
            this.f21734a.zzaA().zzd().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(com.google.android.gms.internal.measurement.zzgl zzglVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzglVar.zzc();
        zzglVar.zzb();
        zzglVar.zza();
        if (obj instanceof String) {
            zzglVar.zzh((String) obj);
        } else if (obj instanceof Long) {
            zzglVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzglVar.zzd(((Double) obj).doubleValue());
        } else {
            this.f21734a.zzaA().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(long j4, long j5) {
        if (j4 != 0 && j5 > 0 && Math.abs(this.f21734a.zzax().currentTimeMillis() - j4) <= j5) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] H(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e4) {
            this.f21734a.zzaA().zzd().zzb("Failed to gzip content", e4);
            throw e4;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long p(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return q(str.getBytes(Charset.forName("UTF-8")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long q(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.f21734a.zzv().zzg();
        MessageDigest g4 = zzlp.g();
        if (g4 == null) {
            this.f21734a.zzaA().zzd().zza("Failed to get MD5");
            return 0L;
        }
        return zzlp.R(g4.digest(bArr));
    }

    final Bundle r(Map map, boolean z3) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof ArrayList) {
                if (z3) {
                    ArrayList arrayList = (ArrayList) obj;
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        arrayList2.add(r((Map) arrayList.get(i4), false));
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Parcelable s(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.f21734a.zzaA().zzd().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzau t(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle r4 = r(zzaaVar.zze(), true);
        if (r4.containsKey("_o") && (obj = r4.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzhc.zzb(zzaaVar.zzd());
        if (zzb == null) {
            zzb = zzaaVar.zzd();
        }
        return new zzau(zzb, new zzas(r4), str2, zzaaVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzft u(zzap zzapVar) {
        com.google.android.gms.internal.measurement.zzfs zze = com.google.android.gms.internal.measurement.zzft.zze();
        zze.zzl(zzapVar.f21469e);
        zzar zzarVar = new zzar(zzapVar.f21470f);
        while (zzarVar.hasNext()) {
            String next = zzarVar.next();
            com.google.android.gms.internal.measurement.zzfw zze2 = com.google.android.gms.internal.measurement.zzfx.zze();
            zze2.zzj(next);
            Object e4 = zzapVar.f21470f.e(next);
            Preconditions.checkNotNull(e4);
            C(zze2, e4);
            zze.zze(zze2);
        }
        return (com.google.android.gms.internal.measurement.zzft) zze.zzaD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String w(com.google.android.gms.internal.measurement.zzgb zzgbVar) {
        Long l4;
        Long l5;
        Double d4;
        if (zzgbVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.zzgd zzgdVar : zzgbVar.zzd()) {
            if (zzgdVar != null) {
                j(sb, 1);
                sb.append("bundle {\n");
                if (zzgdVar.zzbl()) {
                    m(sb, 1, "protocol_version", Integer.valueOf(zzgdVar.zzd()));
                }
                zzqu.zzc();
                if (this.f21734a.zzf().zzs(zzgdVar.zzy(), zzeg.zzao) && zzgdVar.zzbo()) {
                    m(sb, 1, "session_stitching_token", zzgdVar.zzL());
                }
                m(sb, 1, "platform", zzgdVar.zzJ());
                if (zzgdVar.zzbh()) {
                    m(sb, 1, "gmp_version", Long.valueOf(zzgdVar.zzm()));
                }
                if (zzgdVar.zzbt()) {
                    m(sb, 1, "uploading_gmp_version", Long.valueOf(zzgdVar.zzs()));
                }
                if (zzgdVar.zzbf()) {
                    m(sb, 1, "dynamite_version", Long.valueOf(zzgdVar.zzj()));
                }
                if (zzgdVar.zzbc()) {
                    m(sb, 1, "config_version", Long.valueOf(zzgdVar.zzh()));
                }
                m(sb, 1, "gmp_app_id", zzgdVar.zzG());
                m(sb, 1, "admob_app_id", zzgdVar.zzx());
                m(sb, 1, "app_id", zzgdVar.zzy());
                m(sb, 1, "app_version", zzgdVar.zzB());
                if (zzgdVar.zzba()) {
                    m(sb, 1, "app_version_major", Integer.valueOf(zzgdVar.zza()));
                }
                m(sb, 1, "firebase_instance_id", zzgdVar.zzF());
                if (zzgdVar.zzbe()) {
                    m(sb, 1, "dev_cert_hash", Long.valueOf(zzgdVar.zzi()));
                }
                m(sb, 1, "app_store", zzgdVar.zzA());
                if (zzgdVar.zzbs()) {
                    m(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgdVar.zzr()));
                }
                if (zzgdVar.zzbp()) {
                    m(sb, 1, "start_timestamp_millis", Long.valueOf(zzgdVar.zzp()));
                }
                if (zzgdVar.zzbg()) {
                    m(sb, 1, "end_timestamp_millis", Long.valueOf(zzgdVar.zzk()));
                }
                if (zzgdVar.zzbk()) {
                    m(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgdVar.zzo()));
                }
                if (zzgdVar.zzbj()) {
                    m(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgdVar.zzn()));
                }
                m(sb, 1, "app_instance_id", zzgdVar.zzz());
                m(sb, 1, "resettable_device_id", zzgdVar.zzK());
                m(sb, 1, "ds_id", zzgdVar.zzE());
                if (zzgdVar.zzbi()) {
                    m(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgdVar.zzaY()));
                }
                m(sb, 1, "os_version", zzgdVar.zzI());
                m(sb, 1, "device_model", zzgdVar.zzD());
                m(sb, 1, "user_default_language", zzgdVar.zzM());
                if (zzgdVar.zzbr()) {
                    m(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgdVar.zzf()));
                }
                if (zzgdVar.zzbb()) {
                    m(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgdVar.zzb()));
                }
                if (zzgdVar.zzbn()) {
                    m(sb, 1, "service_upload", Boolean.valueOf(zzgdVar.zzaZ()));
                }
                m(sb, 1, "health_monitor", zzgdVar.zzH());
                if (zzgdVar.zzbm()) {
                    m(sb, 1, "retry_counter", Integer.valueOf(zzgdVar.zze()));
                }
                if (zzgdVar.zzbd()) {
                    m(sb, 1, "consent_signals", zzgdVar.zzC());
                }
                zzpz.zzc();
                if (this.f21734a.zzf().zzs(null, zzeg.zzaE) && zzgdVar.zzbq()) {
                    m(sb, 1, "target_os_version", Long.valueOf(zzgdVar.zzq()));
                }
                List<com.google.android.gms.internal.measurement.zzgm> zzP = zzgdVar.zzP();
                if (zzP != null) {
                    for (com.google.android.gms.internal.measurement.zzgm zzgmVar : zzP) {
                        if (zzgmVar != null) {
                            j(sb, 2);
                            sb.append("user_property {\n");
                            if (zzgmVar.zzs()) {
                                l4 = Long.valueOf(zzgmVar.zzc());
                            } else {
                                l4 = null;
                            }
                            m(sb, 2, "set_timestamp_millis", l4);
                            m(sb, 2, "name", this.f21734a.zzj().f(zzgmVar.zzf()));
                            m(sb, 2, "string_value", zzgmVar.zzg());
                            if (zzgmVar.zzr()) {
                                l5 = Long.valueOf(zzgmVar.zzb());
                            } else {
                                l5 = null;
                            }
                            m(sb, 2, "int_value", l5);
                            if (zzgmVar.zzq()) {
                                d4 = Double.valueOf(zzgmVar.zza());
                            } else {
                                d4 = null;
                            }
                            m(sb, 2, "double_value", d4);
                            j(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzfp> zzN = zzgdVar.zzN();
                if (zzN != null) {
                    for (com.google.android.gms.internal.measurement.zzfp zzfpVar : zzN) {
                        if (zzfpVar != null) {
                            j(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzfpVar.zzk()) {
                                m(sb, 2, "audience_id", Integer.valueOf(zzfpVar.zza()));
                            }
                            if (zzfpVar.zzm()) {
                                m(sb, 2, "new_audience", Boolean.valueOf(zzfpVar.zzj()));
                            }
                            l(sb, 2, "current_data", zzfpVar.zzd());
                            if (zzfpVar.zzn()) {
                                l(sb, 2, "previous_data", zzfpVar.zze());
                            }
                            j(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzft> zzO = zzgdVar.zzO();
                if (zzO != null) {
                    for (com.google.android.gms.internal.measurement.zzft zzftVar : zzO) {
                        if (zzftVar != null) {
                            j(sb, 2);
                            sb.append("event {\n");
                            m(sb, 2, "name", this.f21734a.zzj().d(zzftVar.zzh()));
                            if (zzftVar.zzu()) {
                                m(sb, 2, "timestamp_millis", Long.valueOf(zzftVar.zzd()));
                            }
                            if (zzftVar.zzt()) {
                                m(sb, 2, "previous_timestamp_millis", Long.valueOf(zzftVar.zzc()));
                            }
                            if (zzftVar.zzs()) {
                                m(sb, 2, "count", Integer.valueOf(zzftVar.zza()));
                            }
                            if (zzftVar.zzb() != 0) {
                                h(sb, 2, zzftVar.zzi());
                            }
                            j(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                j(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String x(com.google.android.gms.internal.measurement.zzek zzekVar) {
        if (zzekVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzekVar.zzp()) {
            m(sb, 0, "filter_id", Integer.valueOf(zzekVar.zzb()));
        }
        m(sb, 0, "event_name", this.f21734a.zzj().d(zzekVar.zzg()));
        String k4 = k(zzekVar.zzk(), zzekVar.zzm(), zzekVar.zzn());
        if (!k4.isEmpty()) {
            m(sb, 0, "filter_type", k4);
        }
        if (zzekVar.zzo()) {
            n(sb, 1, "event_count_filter", zzekVar.zzf());
        }
        if (zzekVar.zza() > 0) {
            sb.append("  filters {\n");
            for (com.google.android.gms.internal.measurement.zzem zzemVar : zzekVar.zzh()) {
                i(sb, 2, zzemVar);
            }
        }
        j(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String y(com.google.android.gms.internal.measurement.zzet zzetVar) {
        if (zzetVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzetVar.zzj()) {
            m(sb, 0, "filter_id", Integer.valueOf(zzetVar.zza()));
        }
        m(sb, 0, "property_name", this.f21734a.zzj().f(zzetVar.zze()));
        String k4 = k(zzetVar.zzg(), zzetVar.zzh(), zzetVar.zzi());
        if (!k4.isEmpty()) {
            m(sb, 0, "filter_type", k4);
        }
        i(sb, 1, zzetVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List z(List list, List list2) {
        int i4;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f21734a.zzaA().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.f21734a.zzaA().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i5 = size2;
            i4 = size;
            size = i5;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i4);
    }
}
