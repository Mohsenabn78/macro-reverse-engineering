package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

/* loaded from: classes2.dex */
public final class EncodedValueCodec {
    private EncodedValueCodec() {
    }

    public static int readSignedInt(ByteInput byteInput, int i4) {
        int i5 = 0;
        for (int i6 = i4; i6 >= 0; i6--) {
            i5 = (i5 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i5 >> ((3 - i4) * 8);
    }

    public static long readSignedLong(ByteInput byteInput, int i4) {
        long j4 = 0;
        for (int i5 = i4; i5 >= 0; i5--) {
            j4 = (j4 >>> 8) | ((byteInput.readByte() & 255) << 56);
        }
        return j4 >> ((7 - i4) * 8);
    }

    public static int readUnsignedInt(ByteInput byteInput, int i4, boolean z3) {
        int i5 = 0;
        if (!z3) {
            for (int i6 = i4; i6 >= 0; i6--) {
                i5 = (i5 >>> 8) | ((byteInput.readByte() & 255) << 24);
            }
            return i5 >>> ((3 - i4) * 8);
        }
        while (i4 >= 0) {
            i5 = ((byteInput.readByte() & 255) << 24) | (i5 >>> 8);
            i4--;
        }
        return i5;
    }

    public static long readUnsignedLong(ByteInput byteInput, int i4, boolean z3) {
        long j4 = 0;
        if (!z3) {
            for (int i5 = i4; i5 >= 0; i5--) {
                j4 = (j4 >>> 8) | ((byteInput.readByte() & 255) << 56);
            }
            return j4 >>> ((7 - i4) * 8);
        }
        while (i4 >= 0) {
            j4 = (j4 >>> 8) | ((byteInput.readByte() & 255) << 56);
            i4--;
        }
        return j4;
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i4, long j4) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j4);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        int i5 = (numberOfTrailingZeros + 7) >> 3;
        long j5 = j4 >> (64 - (i5 * 8));
        byteOutput.writeByte(i4 | ((i5 - 1) << 5));
        while (i5 > 0) {
            byteOutput.writeByte((byte) j5);
            j5 >>= 8;
            i5--;
        }
    }

    public static void writeSignedIntegralValue(ByteOutput byteOutput, int i4, long j4) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j4 >> 63) ^ j4)) + 7) >> 3;
        byteOutput.writeByte(i4 | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            byteOutput.writeByte((byte) j4);
            j4 >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void writeUnsignedIntegralValue(ByteOutput byteOutput, int i4, long j4) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j4);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        int i5 = (numberOfLeadingZeros + 7) >> 3;
        byteOutput.writeByte(i4 | ((i5 - 1) << 5));
        while (i5 > 0) {
            byteOutput.writeByte((byte) j4);
            j4 >>= 8;
            i5--;
        }
    }
}
