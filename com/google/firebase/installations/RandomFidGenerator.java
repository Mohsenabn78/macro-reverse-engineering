package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes5.dex */
public class RandomFidGenerator {

    /* renamed from: a  reason: collision with root package name */
    private static final byte f31538a = Byte.parseByte("01110000", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final byte f31539b = Byte.parseByte("00001111", 2);

    private static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    private static byte[] b(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    @NonNull
    public String createRandomFid() {
        byte[] b4 = b(UUID.randomUUID(), new byte[17]);
        byte b5 = b4[0];
        b4[16] = b5;
        b4[0] = (byte) ((b5 & f31539b) | f31538a);
        return a(b4);
    }
}
