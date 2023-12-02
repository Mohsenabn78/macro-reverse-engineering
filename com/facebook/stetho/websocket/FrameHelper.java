package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

/* loaded from: classes3.dex */
class FrameHelper {
    FrameHelper() {
    }

    public static Frame createBinaryFrame(byte[] bArr) {
        return createSimpleFrame((byte) 2, bArr);
    }

    public static Frame createCloseFrame(int i4, String str) {
        byte[] bArr;
        int i5;
        if (str != null) {
            bArr = Utf8Charset.encodeUTF8(str);
            i5 = bArr.length + 2;
        } else {
            bArr = null;
            i5 = 2;
        }
        byte[] bArr2 = new byte[i5];
        bArr2[0] = (byte) ((i4 >> 8) & 255);
        bArr2[1] = (byte) (i4 & 255);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        }
        return createSimpleFrame((byte) 8, bArr2);
    }

    public static Frame createPingFrame(byte[] bArr, int i4) {
        return createSimpleFrame((byte) 9, bArr, i4);
    }

    public static Frame createPongFrame(byte[] bArr, int i4) {
        return createSimpleFrame((byte) 10, bArr, i4);
    }

    private static Frame createSimpleFrame(byte b4, byte[] bArr) {
        return createSimpleFrame(b4, bArr, bArr.length);
    }

    public static Frame createTextFrame(String str) {
        return createSimpleFrame((byte) 1, Utf8Charset.encodeUTF8(str));
    }

    private static Frame createSimpleFrame(byte b4, byte[] bArr, int i4) {
        Frame frame = new Frame();
        frame.fin = true;
        frame.hasMask = false;
        frame.opcode = b4;
        frame.payloadLen = i4;
        frame.payloadData = bArr;
        return frame;
    }
}
