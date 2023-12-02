package com.google.android.gms.internal.mlkit_translate;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzdt implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private boolean zzc = false;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzbz.zza = new zzds();
    }

    public zzdt(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        this.zzb = reader;
    }

    private final int zzo(boolean z3) throws IOException {
        char[] cArr = this.zzd;
        int i4 = this.zze;
        int i5 = this.zzf;
        while (true) {
            if (i4 == i5) {
                this.zze = i4;
                if (!zzv(1)) {
                    if (!z3) {
                        return -1;
                    }
                    throw new EOFException("End of input".concat(zzb()));
                }
                i4 = this.zze;
                i5 = this.zzf;
            }
            int i6 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 == '\n') {
                this.zzg++;
                this.zzh = i6;
            } else if (c4 != ' ' && c4 != '\r' && c4 != '\t') {
                if (c4 == '/') {
                    this.zze = i6;
                    if (i6 == i5) {
                        this.zze = i6 - 1;
                        boolean zzv = zzv(2);
                        this.zze++;
                        if (!zzv) {
                            return 47;
                        }
                    }
                    zzs();
                    int i7 = this.zze;
                    char c5 = cArr[i7];
                    if (c5 != '*') {
                        if (c5 != '/') {
                            return 47;
                        }
                        this.zze = i7 + 1;
                        zzu();
                        i4 = this.zze;
                        i5 = this.zzf;
                    } else {
                        this.zze = i7 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzv(2)) {
                                throw zzp("Unterminated comment");
                            }
                            char[] cArr2 = this.zzd;
                            int i8 = this.zze;
                            if (cArr2[i8] == '\n') {
                                this.zzg++;
                                this.zzh = i8 + 1;
                            } else {
                                for (int i9 = 0; i9 < 2; i9++) {
                                    if (this.zzd[this.zze + i9] == "*/".charAt(i9)) {
                                    }
                                }
                                i4 = 2 + this.zze;
                                i5 = this.zzf;
                                break;
                            }
                            this.zze++;
                        }
                    }
                } else if (c4 == '#') {
                    this.zze = i6;
                    zzs();
                    zzu();
                    i4 = this.zze;
                    i5 = this.zzf;
                } else {
                    this.zze = i6;
                    return c4;
                }
            }
            i4 = i6;
        }
    }

    private final IOException zzp(String str) throws IOException {
        throw new zzdw(str.concat(zzb()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e5, code lost:
        throw new java.lang.NumberFormatException("\\u".concat(new java.lang.String(r5, r10.zze, 4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011c, code lost:
        if (r1 != null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x011e, code lost:
        r1 = r2 - r3;
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r1 + r1, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x012b, code lost:
        r1.append(r0, r3, r2 - r3);
        r10.zze = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzq(char r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzdt.zzq(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
        zzs();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzr() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.zze
            int r3 = r3 + r2
            int r4 = r5.zzf
            if (r3 >= r4) goto L4c
            char[] r4 = r5.zzd
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L58
            r4 = 10
            if (r3 == r4) goto L58
            r4 = 12
            if (r3 == r4) goto L58
            r4 = 13
            if (r3 == r4) goto L58
            r4 = 32
            if (r3 == r4) goto L58
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L58
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L58
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L58
            r4 = 58
            if (r3 == r4) goto L58
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L58;
                case 92: goto L48;
                case 93: goto L58;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.zzs()
            goto L58
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5a
            int r3 = r2 + 1
            boolean r3 = r5.zzv(r3)
            if (r3 != 0) goto L3
        L58:
            r1 = r2
            goto L7a
        L5a:
            if (r0 != 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L67:
            char[] r3 = r5.zzd
            int r4 = r5.zze
            r0.append(r3, r4, r2)
            int r3 = r5.zze
            int r3 = r3 + r2
            r5.zze = r3
            r2 = 1
            boolean r2 = r5.zzv(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L86
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r0.<init>(r2, r3, r1)
            goto L91
        L86:
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L91:
            int r2 = r5.zze
            int r2 = r2 + r1
            r5.zze = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzdt.zzr():java.lang.String");
    }

    private final void zzs() throws IOException {
        if (this.zzc) {
            return;
        }
        throw zzp("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private final void zzt(int i4) {
        int i5 = this.zzl;
        int[] iArr = this.zzk;
        if (i5 == iArr.length) {
            int i6 = i5 + i5;
            this.zzk = Arrays.copyOf(iArr, i6);
            this.zzn = Arrays.copyOf(this.zzn, i6);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i6);
        }
        int[] iArr2 = this.zzk;
        int i7 = this.zzl;
        this.zzl = i7 + 1;
        iArr2[i7] = i4;
    }

    private final void zzu() throws IOException {
        char c4;
        do {
            if (this.zze < this.zzf || zzv(1)) {
                char[] cArr = this.zzd;
                int i4 = this.zze;
                int i5 = i4 + 1;
                this.zze = i5;
                c4 = cArr[i4];
                if (c4 == '\n') {
                    this.zzg++;
                    this.zzh = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c4 != '\r');
    }

    private final boolean zzv(int i4) throws IOException {
        int i5;
        char[] cArr = this.zzd;
        int i6 = this.zzh;
        int i7 = this.zze;
        this.zzh = i6 - i7;
        int i8 = this.zzf;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.zzf = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i10 = this.zzf;
            int read = reader.read(cArr, i10, 1024 - i10);
            if (read == -1) {
                return false;
            }
            i5 = this.zzf + read;
            this.zzf = i5;
            if (this.zzg == 0 && this.zzh == 0 && i5 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i4++;
                continue;
            }
        } while (i5 < i4);
        return true;
    }

    private final boolean zzw(char c4) throws IOException {
        if (c4 != '\t' && c4 != '\n' && c4 != '\f' && c4 != '\r' && c4 != ' ') {
            if (c4 != '#') {
                if (c4 != ',') {
                    if (c4 != '/' && c4 != '=') {
                        if (c4 != '{' && c4 != '}' && c4 != ':') {
                            if (c4 != ';') {
                                switch (c4) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            zzs();
            return false;
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        return zzdt.class.getSimpleName().concat(zzb());
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x019f, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0219, code lost:
        if (zzw(r1) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x021d, code lost:
        if (r9 != 2) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x021f, code lost:
        if (r15 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0225, code lost:
        if (r11 != Long.MIN_VALUE) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0227, code lost:
        if (r16 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x022a, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0230, code lost:
        if (r11 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0232, code lost:
        if (r14 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0235, code lost:
        if (r14 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0238, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0239, code lost:
        r19.zzi = r11;
        r19.zze += r10;
        r19.zza = 15;
        r14 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0247, code lost:
        r1 = 2;
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0249, code lost:
        if (r9 == r1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x024c, code lost:
        if (r9 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x024f, code lost:
        if (r9 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0251, code lost:
        r19.zzj = r10;
        r19.zza = 16;
        r14 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0280 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x029c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzdt.zza():int");
    }

    final String zzb() {
        int i4 = this.zzg;
        int i5 = this.zze;
        int i6 = this.zzh;
        StringBuilder sb = new StringBuilder();
        sb.append(" at line ");
        sb.append(i4 + 1);
        sb.append(" column ");
        sb.append((i5 - i6) + 1);
        sb.append(" path ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Typography.dollar);
        for (int i7 = 0; i7 < this.zzl; i7++) {
            int i8 = this.zzk[i7];
            if (i8 != 1 && i8 != 2) {
                if (i8 == 3 || i8 == 4 || i8 == 5) {
                    sb2.append('.');
                    String str = this.zzm[i7];
                    if (str != null) {
                        sb2.append(str);
                    }
                }
            } else {
                int i9 = this.zzn[i7];
                sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                sb2.append(i9);
                sb2.append(']');
            }
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    public final String zzc() throws IOException {
        String zzq;
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 14) {
            zzq = zzr();
        } else if (i4 == 12) {
            zzq = zzq('\'');
        } else if (i4 == 13) {
            zzq = zzq(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + ((Object) zzdu.zza(zzn())) + zzb());
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = zzq;
        return zzq;
    }

    public final String zzd() throws IOException {
        String str;
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 10) {
            str = zzr();
        } else if (i4 == 8) {
            str = zzq('\'');
        } else if (i4 == 9) {
            str = zzq(Typography.quote);
        } else if (i4 == 11) {
            str = null;
        } else if (i4 == 15) {
            str = Long.toString(this.zzi);
        } else if (i4 == 16) {
            str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
        } else {
            throw new IllegalStateException("Expected a string but was " + ((Object) zzdu.zza(zzn())) + zzb());
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i5 = this.zzl - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public final void zze() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 3) {
            zzt(1);
            this.zzn[this.zzl - 1] = 0;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + ((Object) zzdu.zza(zzn())) + zzb());
    }

    public final void zzf() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 1) {
            zzt(3);
            this.zza = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + ((Object) zzdu.zza(zzn())) + zzb());
    }

    public final void zzg() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 4) {
            int i5 = this.zzl - 1;
            this.zzl = i5;
            int[] iArr = this.zzn;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + ((Object) zzdu.zza(zzn())) + zzb());
    }

    public final void zzh() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 2) {
            int i5 = this.zzl - 1;
            this.zzl = i5;
            this.zzm[i5] = null;
            int[] iArr = this.zzn;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.zza = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + ((Object) zzdu.zza(zzn())) + zzb());
    }

    public final void zzi() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 7) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i5 = this.zzl - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + ((Object) zzdu.zza(zzn())) + zzb());
    }

    public final void zzj(boolean z3) {
        this.zzc = z3;
    }

    public final boolean zzk() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 != 2 && i4 != 4 && i4 != 17) {
            return true;
        }
        return false;
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final boolean zzm() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        if (i4 == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i5 = this.zzl - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i4 == 6) {
            this.zza = 0;
            int[] iArr2 = this.zzn;
            int i6 = this.zzl - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + ((Object) zzdu.zza(zzn())) + zzb());
        }
    }

    public final int zzn() throws IOException {
        int i4 = this.zza;
        if (i4 == 0) {
            i4 = zza();
        }
        switch (i4) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
