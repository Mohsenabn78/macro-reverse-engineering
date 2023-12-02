package com.facebook.stetho.websocket;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Frame {
    public static final byte OPCODE_BINARY_FRAME = 2;
    public static final byte OPCODE_CONNECTION_CLOSE = 8;
    public static final byte OPCODE_CONNECTION_PING = 9;
    public static final byte OPCODE_CONNECTION_PONG = 10;
    public static final byte OPCODE_TEXT_FRAME = 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    private void decodeFirstByte(byte b4) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = true;
        if ((b4 & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.fin = z3;
        if ((b4 & SignedBytes.MAX_POWER_OF_TWO) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.rsv1 = z4;
        if ((b4 & 32) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.rsv2 = z5;
        if ((b4 & Ascii.DLE) == 0) {
            z6 = false;
        }
        this.rsv3 = z6;
        this.opcode = (byte) (b4 & Ascii.SI);
    }

    private long decodeLength(byte b4, InputStream inputStream) throws IOException {
        if (b4 <= 125) {
            return b4;
        }
        if (b4 == 126) {
            return ((readByteOrThrow(inputStream) & 255) << 8) | (readByteOrThrow(inputStream) & 255);
        }
        if (b4 == Byte.MAX_VALUE) {
            long j4 = 0;
            for (int i4 = 0; i4 < 8; i4++) {
                j4 = (j4 << 8) | (readByteOrThrow(inputStream) & 255);
            }
            return j4;
        }
        throw new IOException("Unexpected length byte: " + ((int) b4));
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, 4);
        return bArr;
    }

    private byte encodeFirstByte() {
        byte b4;
        if (this.fin) {
            b4 = (byte) 128;
        } else {
            b4 = 0;
        }
        if (this.rsv1) {
            b4 = (byte) (b4 | SignedBytes.MAX_POWER_OF_TWO);
        }
        if (this.rsv2) {
            b4 = (byte) (b4 | 32);
        }
        if (this.rsv3) {
            b4 = (byte) (b4 | Ascii.DLE);
        }
        return (byte) (b4 | (this.opcode & Ascii.SI));
    }

    private static byte[] encodeLength(long j4) {
        return j4 <= 125 ? new byte[]{(byte) j4} : j4 <= WebSocketProtocol.PAYLOAD_SHORT_MAX ? new byte[]{126, (byte) ((j4 >> 8) & 255), (byte) (j4 & 255)} : new byte[]{Byte.MAX_VALUE, (byte) ((j4 >> 56) & 255), (byte) ((j4 >> 48) & 255), (byte) ((j4 >> 40) & 255), (byte) ((j4 >> 32) & 255), (byte) ((j4 >> 24) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 8) & 255), (byte) (j4 & 255)};
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new EOFException();
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
        while (i5 > 0) {
            int read = inputStream.read(bArr, i4, i5);
            if (read != -1) {
                i5 -= read;
                i4 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z3;
        byte[] bArr;
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte readByteOrThrow = readByteOrThrow(bufferedInputStream);
        if ((readByteOrThrow & 128) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.hasMask = z3;
        this.payloadLen = decodeLength((byte) (readByteOrThrow & (-129)), bufferedInputStream);
        if (this.hasMask) {
            bArr = decodeMaskingKey(bufferedInputStream);
        } else {
            bArr = null;
        }
        this.maskingKey = bArr;
        long j4 = this.payloadLen;
        byte[] bArr2 = new byte[(int) j4];
        this.payloadData = bArr2;
        readBytesOrThrow(bufferedInputStream, bArr2, 0, (int) j4);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] encodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            encodeLength[0] = (byte) (encodeLength[0] | 128);
        }
        bufferedOutputStream.write(encodeLength, 0, encodeLength.length);
        if (!this.hasMask) {
            bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
            return;
        }
        throw new UnsupportedOperationException("Writing masked data not implemented");
    }
}
