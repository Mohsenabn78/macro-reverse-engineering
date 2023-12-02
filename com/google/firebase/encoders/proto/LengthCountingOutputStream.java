package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* loaded from: classes5.dex */
final class LengthCountingOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f30098a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        return this.f30098a;
    }

    @Override // java.io.OutputStream
    public void write(int i4) {
        this.f30098a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f30098a += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i4, int i5) {
        int i6;
        if (i4 >= 0 && i4 <= bArr.length && i5 >= 0 && (i6 = i4 + i5) <= bArr.length && i6 >= 0) {
            this.f30098a += i5;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
