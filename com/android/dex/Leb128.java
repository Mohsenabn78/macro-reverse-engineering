package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;

/* loaded from: classes2.dex */
public final class Leb128 {
    private Leb128() {
    }

    public static int readSignedLeb128(ByteInput byteInput) {
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        do {
            int readByte = byteInput.readByte() & 255;
            i5 |= (readByte & 127) << (i6 * 7);
            i7 <<= 7;
            i6++;
            i4 = readByte & 128;
            if (i4 != 128) {
                break;
            }
        } while (i6 < 5);
        if (i4 != 128) {
            if (((i7 >> 1) & i5) != 0) {
                return i5 | i7;
            }
            return i5;
        }
        throw new DexException("invalid LEB128 sequence");
    }

    public static int readUnsignedLeb128(ByteInput byteInput) {
        int i4;
        int i5 = 0;
        int i6 = 0;
        do {
            int readByte = byteInput.readByte() & 255;
            i5 |= (readByte & 127) << (i6 * 7);
            i6++;
            i4 = readByte & 128;
            if (i4 != 128) {
                break;
            }
        } while (i6 < 5);
        if (i4 != 128) {
            return i5;
        }
        throw new DexException("invalid LEB128 sequence");
    }

    public static int signedLeb128Size(int i4) {
        int i5;
        int i6 = i4 >> 7;
        if ((Integer.MIN_VALUE & i4) == 0) {
            i5 = 0;
        } else {
            i5 = -1;
        }
        boolean z3 = true;
        int i7 = 0;
        while (true) {
            int i8 = i6;
            int i9 = i4;
            i4 = i8;
            if (z3) {
                if (i4 == i5 && (i4 & 1) == ((i9 >> 6) & 1)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                i6 = i4 >> 7;
                i7++;
            } else {
                return i7;
            }
        }
    }

    public static int unsignedLeb128Size(int i4) {
        int i5 = i4 >> 7;
        int i6 = 0;
        while (i5 != 0) {
            i5 >>= 7;
            i6++;
        }
        return i6 + 1;
    }

    public static void writeSignedLeb128(ByteOutput byteOutput, int i4) {
        int i5;
        int i6;
        int i7 = i4 >> 7;
        if ((Integer.MIN_VALUE & i4) == 0) {
            i5 = 0;
        } else {
            i5 = -1;
        }
        boolean z3 = true;
        while (true) {
            int i8 = i7;
            int i9 = i4;
            i4 = i8;
            if (z3) {
                if (i4 == i5 && (i4 & 1) == ((i9 >> 6) & 1)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                int i10 = i9 & 127;
                if (z3) {
                    i6 = 128;
                } else {
                    i6 = 0;
                }
                byteOutput.writeByte((byte) (i10 | i6));
                i7 = i4 >> 7;
            } else {
                return;
            }
        }
    }

    public static void writeUnsignedLeb128(ByteOutput byteOutput, int i4) {
        while (true) {
            int i5 = i4;
            i4 >>>= 7;
            if (i4 != 0) {
                byteOutput.writeByte((byte) ((i5 & 127) | 128));
            } else {
                byteOutput.writeByte((byte) (i5 & 127));
                return;
            }
        }
    }
}
