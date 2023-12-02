package com.sun.mail.util;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class QEncoderStream extends QPEncoderStream {
    private static String TEXT_SPECIALS = "=_?";
    private static String WORD_SPECIALS = "=_?\"#$%&'(),.:;<>@[\\]^`{|}~";
    private String specials;

    public QEncoderStream(OutputStream outputStream, boolean z3) {
        super(outputStream, Integer.MAX_VALUE);
        String str;
        if (z3) {
            str = WORD_SPECIALS;
        } else {
            str = TEXT_SPECIALS;
        }
        this.specials = str;
    }

    public static int encodedLength(byte[] bArr, boolean z3) {
        String str;
        if (z3) {
            str = WORD_SPECIALS;
        } else {
            str = TEXT_SPECIALS;
        }
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = b4 & 255;
            if (i5 >= 32 && i5 < 127 && str.indexOf(i5) < 0) {
                i4++;
            } else {
                i4 += 3;
            }
        }
        return i4;
    }

    @Override // com.sun.mail.util.QPEncoderStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i4) throws IOException {
        int i5 = i4 & 255;
        if (i5 == 32) {
            output(95, false);
        } else if (i5 >= 32 && i5 < 127 && this.specials.indexOf(i5) < 0) {
            output(i5, false);
        } else {
            output(i5, true);
        }
    }
}
