package com.sun.mail.util;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public class LineOutputStream extends FilterOutputStream {
    private static byte[] newline;
    private boolean allowutf8;

    static {
        newline = r0;
        byte[] bArr = {Ascii.CR, 10};
    }

    public LineOutputStream(OutputStream outputStream) {
        this(outputStream, false);
    }

    public void writeln(String str) throws IOException {
        byte[] bytes;
        if (this.allowutf8) {
            bytes = str.getBytes(StandardCharsets.UTF_8);
        } else {
            bytes = ASCIIUtility.getBytes(str);
        }
        ((FilterOutputStream) this).out.write(bytes);
        ((FilterOutputStream) this).out.write(newline);
    }

    public LineOutputStream(OutputStream outputStream, boolean z3) {
        super(outputStream);
        this.allowutf8 = z3;
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
    }
}
