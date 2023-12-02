package com.google.android.gms.internal.mlkit_translate;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzdv implements Closeable, Flushable {
    private static final Pattern zza = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] zzb = new String[128];
    private static final String[] zzc;
    private final Writer zzd;
    private int[] zze = new int[32];
    private int zzf = 0;
    private final String zzg;
    private boolean zzh;
    private String zzi;

    static {
        for (int i4 = 0; i4 <= 31; i4++) {
            zzb[i4] = String.format("\\u%04x", Integer.valueOf(i4));
        }
        String[] strArr = zzb;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzc = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public zzdv(Writer writer) {
        zzo(6);
        this.zzg = ":";
        this.zzd = writer;
    }

    private final int zzk() {
        int i4 = this.zzf;
        if (i4 != 0) {
            return this.zze[i4 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final zzdv zzl(int i4, int i5, char c4) throws IOException {
        int zzk = zzk();
        if (zzk != i5 && zzk != i4) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.zzi;
        if (str == null) {
            this.zzf--;
            this.zzd.write(c4);
            return this;
        }
        throw new IllegalStateException("Dangling name: ".concat(str));
    }

    private final zzdv zzm(int i4, char c4) throws IOException {
        zzn();
        zzo(i4);
        this.zzd.write(c4);
        return this;
    }

    private final void zzn() throws IOException {
        int zzk = zzk();
        if (zzk != 1) {
            if (zzk != 2) {
                if (zzk != 4) {
                    if (zzk != 6) {
                        if (zzk == 7) {
                            if (!this.zzh) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    zzp(7);
                    return;
                }
                this.zzd.append((CharSequence) this.zzg);
                zzp(5);
                return;
            }
            this.zzd.append(',');
            return;
        }
        zzp(2);
    }

    private final void zzo(int i4) {
        int i5 = this.zzf;
        int[] iArr = this.zze;
        if (i5 == iArr.length) {
            this.zze = Arrays.copyOf(iArr, i5 + i5);
        }
        int[] iArr2 = this.zze;
        int i6 = this.zzf;
        this.zzf = i6 + 1;
        iArr2[i6] = i4;
    }

    private final void zzp(int i4) {
        this.zze[this.zzf - 1] = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzq(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String[] r0 = com.google.android.gms.internal.mlkit_translate.zzdv.zzb
            java.io.Writer r1 = r8.zzd
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        Lf:
            if (r3 >= r1) goto L3e
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1e
            r5 = r0[r5]
            if (r5 != 0) goto L2b
            goto L3b
        L1e:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L25
            java.lang.String r5 = "\\u2028"
            goto L2b
        L25:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L3b
            java.lang.String r5 = "\\u2029"
        L2b:
            if (r4 >= r3) goto L34
            java.io.Writer r6 = r8.zzd
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L34:
            java.io.Writer r4 = r8.zzd
            r4.write(r5)
            int r4 = r3 + 1
        L3b:
            int r3 = r3 + 1
            goto Lf
        L3e:
            if (r4 >= r1) goto L46
            java.io.Writer r0 = r8.zzd
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L46:
            java.io.Writer r9 = r8.zzd
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzdv.zzq(java.lang.String):void");
    }

    private final void zzr() throws IOException {
        if (this.zzi != null) {
            int zzk = zzk();
            if (zzk == 5) {
                this.zzd.write(44);
            } else if (zzk != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzp(4);
            zzq(this.zzi);
            this.zzi = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzd.close();
        int i4 = this.zzf;
        if (i4 <= 1 && (i4 != 1 || this.zze[0] == 7)) {
            this.zzf = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzf != 0) {
            this.zzd.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final zzdv zza() throws IOException {
        zzr();
        zzm(1, TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        return this;
    }

    public final zzdv zzb() throws IOException {
        zzr();
        zzm(3, '{');
        return this;
    }

    public final zzdv zzc() throws IOException {
        zzl(1, 2, ']');
        return this;
    }

    public final zzdv zzd() throws IOException {
        zzl(3, 5, '}');
        return this;
    }

    public final zzdv zze(String str) throws IOException {
        if (str != null) {
            if (this.zzi == null) {
                if (this.zzf != 0) {
                    this.zzi = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public final zzdv zzf() throws IOException {
        if (this.zzi != null) {
            zzr();
        }
        zzn();
        this.zzd.write("null");
        return this;
    }

    public final zzdv zzg(Number number) throws IOException {
        zzr();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !zza.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.zzh) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
        }
        zzn();
        this.zzd.append((CharSequence) obj);
        return this;
    }

    public final zzdv zzh(String str) throws IOException {
        if (str == null) {
            zzf();
            return this;
        }
        zzr();
        zzn();
        zzq(str);
        return this;
    }

    public final zzdv zzi(boolean z3) throws IOException {
        String str;
        zzr();
        zzn();
        Writer writer = this.zzd;
        if (true != z3) {
            str = "false";
        } else {
            str = "true";
        }
        writer.write(str);
        return this;
    }

    public final void zzj(boolean z3) {
        this.zzh = true;
    }
}
