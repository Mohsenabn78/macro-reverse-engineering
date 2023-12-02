package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dx.io.Opcodes;
import java.io.UTFDataFormatException;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public final class Mutf8 {
    private Mutf8() {
    }

    private static long countBytes(String str, boolean z3) throws UTFDataFormatException {
        long j4;
        int length = str.length();
        long j5 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt != 0 && charAt <= 127) {
                j4 = 1;
            } else if (charAt <= 2047) {
                j4 = 2;
            } else {
                j4 = 3;
            }
            j5 += j4;
            if (z3 && j5 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return j5;
    }

    public static String decode(ByteInput byteInput, char[] cArr) throws UTFDataFormatException {
        int i4;
        int i5 = 0;
        while (true) {
            char readByte = (char) (byteInput.readByte() & 255);
            if (readByte == 0) {
                return new String(cArr, 0, i5);
            }
            cArr[i5] = readByte;
            if (readByte < 128) {
                i5++;
            } else {
                if ((readByte & 224) == 192) {
                    int readByte2 = byteInput.readByte() & 255;
                    if ((readByte2 & 192) == 128) {
                        i4 = i5 + 1;
                        cArr[i5] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                    } else {
                        throw new UTFDataFormatException("bad second byte");
                    }
                } else if ((readByte & 240) == 224) {
                    int readByte3 = byteInput.readByte() & 255;
                    int readByte4 = byteInput.readByte() & 255;
                    if ((readByte3 & 192) != 128 || (readByte4 & 192) != 128) {
                        break;
                    }
                    i4 = i5 + 1;
                    cArr[i5] = (char) (((readByte & 15) << 12) | ((readByte3 & 63) << 6) | (readByte4 & 63));
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
                i5 = i4;
            }
        }
        throw new UTFDataFormatException("bad second or third byte");
    }

    public static void encode(byte[] bArr, int i4, String str) {
        int i5;
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt != 0 && charAt <= 127) {
                i5 = i4 + 1;
                bArr[i4] = (byte) charAt;
            } else if (charAt <= 2047) {
                int i7 = i4 + 1;
                bArr[i4] = (byte) (((charAt >> 6) & 31) | 192);
                i4 = i7 + 1;
                bArr[i7] = (byte) ((charAt & '?') | 128);
            } else {
                int i8 = i4 + 1;
                bArr[i4] = (byte) (((charAt >> '\f') & 15) | Opcodes.SHL_INT_LIT8);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt >> 6) & 63) | 128);
                i5 = i9 + 1;
                bArr[i9] = (byte) ((charAt & '?') | 128);
            }
            i4 = i5;
        }
    }

    public static byte[] encode(String str) throws UTFDataFormatException {
        byte[] bArr = new byte[(int) countBytes(str, true)];
        encode(bArr, 0, str);
        return bArr;
    }
}
