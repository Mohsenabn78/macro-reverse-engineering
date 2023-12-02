package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzbi extends OutputStream {
    private long zza = 0;

    @Override // java.io.OutputStream
    public final void write(int i4) {
        this.zza++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza() {
        return this.zza;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i4, int i5) {
        int length;
        int i6;
        if (i4 >= 0 && i4 <= (length = bArr.length) && i5 >= 0 && (i6 = i4 + i5) <= length && i6 >= 0) {
            this.zza += i5;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
