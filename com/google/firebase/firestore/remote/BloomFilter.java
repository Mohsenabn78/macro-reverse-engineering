package com.google.firebase.firestore.remote;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.protobuf.ByteString;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes5.dex */
public final class BloomFilter {

    /* renamed from: a  reason: collision with root package name */
    private final int f31066a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteString f31067b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31068c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageDigest f31069d;

    /* loaded from: classes5.dex */
    public static final class BloomFilterCreateException extends Exception {
        public BloomFilterCreateException(String str) {
            super(str);
        }
    }

    public BloomFilter(@NonNull ByteString byteString, int i4, int i5) {
        if (i4 >= 0 && i4 < 8) {
            if (i5 >= 0) {
                if (byteString.size() > 0 && i5 == 0) {
                    throw new IllegalArgumentException("Invalid hash count: " + i5);
                } else if (byteString.size() == 0 && i4 != 0) {
                    throw new IllegalArgumentException("Expected padding of 0 when bitmap length is 0, but got " + i4);
                } else {
                    this.f31067b = byteString;
                    this.f31068c = i5;
                    this.f31066a = (byteString.size() * 8) - i4;
                    this.f31069d = a();
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid hash count: " + i5);
        }
        throw new IllegalArgumentException("Invalid padding: " + i4);
    }

    @NonNull
    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException("Missing MD5 MessageDigest provider: ", e4);
        }
    }

    private int c(long j4, long j5, int i4) {
        return (int) g(j4 + (j5 * i4), this.f31066a);
    }

    public static BloomFilter create(@NonNull ByteString byteString, int i4, int i5) throws BloomFilterCreateException {
        if (i4 >= 0 && i4 < 8) {
            if (i5 >= 0) {
                if (byteString.size() > 0 && i5 == 0) {
                    throw new BloomFilterCreateException("Invalid hash count: " + i5);
                } else if (byteString.size() == 0 && i4 != 0) {
                    throw new BloomFilterCreateException("Expected padding of 0 when bitmap length is 0, but got " + i4);
                } else {
                    return new BloomFilter(byteString, i4, i5);
                }
            }
            throw new BloomFilterCreateException("Invalid hash count: " + i5);
        }
        throw new BloomFilterCreateException("Invalid padding: " + i4);
    }

    private static long d(@NonNull byte[] bArr, int i4) {
        long j4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            j4 |= (bArr[i4 + i5] & 255) << (i5 * 8);
        }
        return j4;
    }

    private boolean e(int i4) {
        if (((1 << (i4 % 8)) & this.f31067b.byteAt(i4 / 8)) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    private byte[] f(@NonNull String str) {
        return this.f31069d.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    private static long g(long j4, long j5) {
        long j6 = j4 - ((((j4 >>> 1) / j5) << 1) * j5);
        if (j6 < j5) {
            j5 = 0;
        }
        return j6 - j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f31066a;
    }

    public boolean mightContain(@NonNull String str) {
        if (this.f31066a == 0) {
            return false;
        }
        byte[] f4 = f(str);
        if (f4.length == 16) {
            long d4 = d(f4, 0);
            long d5 = d(f4, 8);
            for (int i4 = 0; i4 < this.f31068c; i4++) {
                if (!e(c(d4, d5, i4))) {
                    return false;
                }
            }
            return true;
        }
        throw new RuntimeException("Invalid md5 hash array length: " + f4.length + " (expected 16)");
    }

    public String toString() {
        return "BloomFilter{hashCount=" + this.f31068c + ", size=" + this.f31066a + ", bitmap=\"" + Base64.encodeToString(this.f31067b.toByteArray(), 2) + "\"}";
    }
}
