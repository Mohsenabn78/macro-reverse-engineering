package com.android.dx.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class TwoColumnOutput {
    private final StringBuffer leftBuf;
    private final IndentingWriter leftColumn;
    private final int leftWidth;
    private final Writer out;
    private final StringBuffer rightBuf;
    private final IndentingWriter rightColumn;

    public TwoColumnOutput(Writer writer, int i4, int i5, String str) {
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i4 < 1) {
            throw new IllegalArgumentException("leftWidth < 1");
        }
        if (i5 < 1) {
            throw new IllegalArgumentException("rightWidth < 1");
        }
        if (str != null) {
            StringWriter stringWriter = new StringWriter(1000);
            StringWriter stringWriter2 = new StringWriter(1000);
            this.out = writer;
            this.leftWidth = i4;
            this.leftBuf = stringWriter.getBuffer();
            this.rightBuf = stringWriter2.getBuffer();
            this.leftColumn = new IndentingWriter(stringWriter, i4);
            this.rightColumn = new IndentingWriter(stringWriter2, i5, str);
            return;
        }
        throw new NullPointerException("spacer == null");
    }

    private static void appendNewlineIfNecessary(StringBuffer stringBuffer, Writer writer) throws IOException {
        int length = stringBuffer.length();
        if (length != 0 && stringBuffer.charAt(length - 1) != '\n') {
            writer.write(10);
        }
    }

    private void flushLeft() throws IOException {
        appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
        while (this.leftBuf.length() != 0) {
            this.rightColumn.write(10);
            outputFullLines();
        }
    }

    private void flushRight() throws IOException {
        appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
        while (this.rightBuf.length() != 0) {
            this.leftColumn.write(10);
            outputFullLines();
        }
    }

    private void outputFullLines() throws IOException {
        int indexOf;
        while (true) {
            int indexOf2 = this.leftBuf.indexOf("\n");
            if (indexOf2 < 0 || (indexOf = this.rightBuf.indexOf("\n")) < 0) {
                return;
            }
            if (indexOf2 != 0) {
                this.out.write(this.leftBuf.substring(0, indexOf2));
            }
            if (indexOf != 0) {
                writeSpaces(this.out, this.leftWidth - indexOf2);
                this.out.write(this.rightBuf.substring(0, indexOf));
            }
            this.out.write(10);
            this.leftBuf.delete(0, indexOf2 + 1);
            this.rightBuf.delete(0, indexOf + 1);
        }
    }

    public static String toString(String str, int i4, String str2, String str3, int i5) {
        StringWriter stringWriter = new StringWriter((str.length() + str3.length()) * 3);
        TwoColumnOutput twoColumnOutput = new TwoColumnOutput(stringWriter, i4, i5, str2);
        try {
            twoColumnOutput.getLeft().write(str);
            twoColumnOutput.getRight().write(str3);
            twoColumnOutput.flush();
            return stringWriter.toString();
        } catch (IOException e4) {
            throw new RuntimeException("shouldn't happen", e4);
        }
    }

    private static void writeSpaces(Writer writer, int i4) throws IOException {
        while (i4 > 0) {
            writer.write(32);
            i4--;
        }
    }

    public void flush() {
        try {
            appendNewlineIfNecessary(this.leftBuf, this.leftColumn);
            appendNewlineIfNecessary(this.rightBuf, this.rightColumn);
            outputFullLines();
            flushLeft();
            flushRight();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public Writer getLeft() {
        return this.leftColumn;
    }

    public Writer getRight() {
        return this.rightColumn;
    }

    public TwoColumnOutput(OutputStream outputStream, int i4, int i5, String str) {
        this(new OutputStreamWriter(outputStream), i4, i5, str);
    }
}
