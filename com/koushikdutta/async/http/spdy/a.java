package com.koushikdutta.async.http.spdy;

import com.google.common.base.Ascii;
import com.koushikdutta.async.util.Charsets;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import net.bytebuddy.asm.Advice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByteString.java */
/* loaded from: classes6.dex */
public final class a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f35512c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* renamed from: d  reason: collision with root package name */
    public static final a f35513d = e(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private transient int f35514a;

    /* renamed from: b  reason: collision with root package name */
    private transient String f35515b;
    final byte[] data;

    a(byte[] bArr) {
        this.data = bArr;
    }

    public static a a(String str) {
        if (str != null) {
            a aVar = new a(str.getBytes(Charsets.UTF_8));
            aVar.f35515b = str;
            return aVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static a e(byte... bArr) {
        if (bArr != null) {
            return new a((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static a f(InputStream inputStream, int i4) throws IOException {
        if (inputStream != null) {
            if (i4 >= 0) {
                byte[] bArr = new byte[i4];
                int i5 = 0;
                while (i5 < i4) {
                    int read = inputStream.read(bArr, i5, i4 - i5);
                    if (read != -1) {
                        i5 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new a(bArr);
            }
            throw new IllegalArgumentException("byteCount < 0: " + i4);
        }
        throw new IllegalArgumentException("in == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        a f4 = f(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = a.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, f4.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public byte b(int i4) {
        return this.data[i4];
    }

    public String c() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f35512c;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & Ascii.SI];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof a) || !Arrays.equals(((a) obj).data, this.data))) {
            return false;
        }
        return true;
    }

    public int g() {
        return this.data.length;
    }

    public a h() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i4 < bArr.length) {
                byte b4 = bArr[i4];
                if (b4 >= 65 && b4 <= 90) {
                    byte[] bArr2 = (byte[]) bArr.clone();
                    bArr2[i4] = (byte) (b4 + 32);
                    for (int i5 = i4 + 1; i5 < bArr2.length; i5++) {
                        byte b5 = bArr2[i5];
                        if (b5 >= 65 && b5 <= 90) {
                            bArr2[i5] = (byte) (b5 + 32);
                        }
                    }
                    return new a(bArr2);
                }
                i4++;
            } else {
                return this;
            }
        }
    }

    public int hashCode() {
        int i4 = this.f35514a;
        if (i4 == 0) {
            int hashCode = Arrays.hashCode(this.data);
            this.f35514a = hashCode;
            return hashCode;
        }
        return i4;
    }

    public byte[] i() {
        return (byte[]) this.data.clone();
    }

    public String j() {
        String str = this.f35515b;
        if (str == null) {
            String str2 = new String(this.data, Charsets.UTF_8);
            this.f35515b = str2;
            return str2;
        }
        return str;
    }

    public String toString() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format(Locale.ENGLISH, "ByteString[size=%s data=%s]", Integer.valueOf(bArr.length), c());
        }
        try {
            return String.format(Locale.ENGLISH, "ByteString[size=%s md5=%s]", Integer.valueOf(bArr.length), e(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(this.data)).c());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }
}
