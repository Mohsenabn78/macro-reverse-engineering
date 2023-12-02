package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class ResponseInputStream {

    /* renamed from: a  reason: collision with root package name */
    private BufferedInputStream f37627a;

    public ResponseInputStream(InputStream inputStream) {
        this.f37627a = new BufferedInputStream(inputStream, 2048);
    }

    public int available() throws IOException {
        return this.f37627a.available();
    }

    public ByteArray readResponse() throws IOException {
        return readResponse(null);
    }

    public ByteArray readResponse(ByteArray byteArray) throws IOException {
        if (byteArray == null) {
            byteArray = new ByteArray(new byte[128], 0, 128);
        }
        byte[] bytes = byteArray.getBytes();
        int i4 = 0;
        while (true) {
            boolean z3 = false;
            int i5 = 0;
            while (!z3 && (i5 = this.f37627a.read()) != -1) {
                if (i5 == 10 && i4 > 0 && bytes[i4 - 1] == 13) {
                    z3 = true;
                }
                if (i4 >= bytes.length) {
                    int length = bytes.length;
                    if (length > 262144) {
                        length = 262144;
                    }
                    byteArray.grow(length);
                    bytes = byteArray.getBytes();
                }
                bytes[i4] = (byte) i5;
                i4++;
            }
            if (i5 == -1) {
                throw new IOException("Connection dropped by server?");
            }
            if (i4 < 5) {
                break;
            }
            int i6 = i4 - 3;
            if (bytes[i6] != 125) {
                break;
            }
            int i7 = i4 - 4;
            while (i7 >= 0 && bytes[i7] != 123) {
                i7--;
            }
            if (i7 < 0) {
                break;
            }
            try {
                int parseInt = ASCIIUtility.parseInt(bytes, i7 + 1, i6);
                if (parseInt > 0) {
                    int length2 = bytes.length - i4;
                    int i8 = parseInt + 16;
                    if (i8 > length2) {
                        int i9 = i8 - length2;
                        if (256 > i9) {
                            i9 = 256;
                        }
                        byteArray.grow(i9);
                        bytes = byteArray.getBytes();
                    }
                    while (parseInt > 0) {
                        int read = this.f37627a.read(bytes, i4, parseInt);
                        if (read == -1) {
                            throw new IOException("Connection dropped by server?");
                        }
                        parseInt -= read;
                        i4 += read;
                    }
                    continue;
                }
            } catch (NumberFormatException unused) {
            }
        }
        byteArray.setCount(i4);
        return byteArray;
    }
}
