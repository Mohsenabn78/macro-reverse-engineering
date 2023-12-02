package com.android.dx.command.dump;

import com.android.dx.cf.code.ConcreteMethod;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.android.dx.util.IndentingWriter;
import com.android.dx.util.TwoColumnOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public abstract class BaseDumper implements ParseObserver {
    protected Args args;
    private int at;
    private final byte[] bytes;
    private final String filePath;
    private final int hexCols;
    private int indent;
    private final PrintStream out;
    private final boolean rawBytes;
    private String separator;
    private final boolean strictParse;
    private final int width;

    public BaseDumper(byte[] bArr, PrintStream printStream, String str, Args args) {
        String str2;
        this.bytes = bArr;
        boolean z3 = args.rawBytes;
        this.rawBytes = z3;
        this.out = printStream;
        int i4 = args.width;
        i4 = i4 <= 0 ? 79 : i4;
        this.width = i4;
        this.filePath = str;
        this.strictParse = args.strictParse;
        this.indent = 0;
        if (z3) {
            str2 = "|";
        } else {
            str2 = "";
        }
        this.separator = str2;
        this.at = 0;
        this.args = args;
        int i5 = (((i4 - 5) / 15) + 1) & (-2);
        if (i5 < 6) {
            i5 = 6;
        } else if (i5 > 10) {
            i5 = 10;
        }
        this.hexCols = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeParamWidth(ConcreteMethod concreteMethod, boolean z3) {
        return concreteMethod.getEffectiveDescriptor().getParameterTypes().getWordCount();
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void changeIndent(int i4) {
        String str;
        this.indent += i4;
        if (this.rawBytes) {
            str = "|";
        } else {
            str = "";
        }
        this.separator = str;
        for (int i5 = 0; i5 < this.indent; i5++) {
            this.separator += "  ";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getAt() {
        return this.at;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] getBytes() {
        return this.bytes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getFilePath() {
        return this.filePath;
    }

    protected final boolean getRawBytes() {
        return this.rawBytes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getStrictParse() {
        return this.strictParse;
    }

    protected final int getWidth1() {
        if (this.rawBytes) {
            int i4 = this.hexCols;
            return (i4 * 2) + 5 + (i4 / 2);
        }
        return 0;
    }

    protected final int getWidth2() {
        int i4;
        if (this.rawBytes) {
            i4 = getWidth1() + 1;
        } else {
            i4 = 0;
        }
        return (this.width - i4) - (this.indent * 2);
    }

    protected final String hexDump(int i4, int i5) {
        return Hex.dump(this.bytes, i4, i5, i4, this.hexCols, 4);
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void parsed(ByteArray byteArray, int i4, int i5, String str) {
        String str2;
        int underlyingOffset = byteArray.underlyingOffset(i4, getBytes());
        boolean rawBytes = getRawBytes();
        int i6 = this.at;
        String str3 = "";
        if (underlyingOffset < i6) {
            println("<dump skipped backwards to " + Hex.u4(underlyingOffset) + ">");
            this.at = underlyingOffset;
        } else if (underlyingOffset > i6) {
            if (!rawBytes) {
                str2 = "";
            } else {
                str2 = hexDump(i6, underlyingOffset - i6);
            }
            print(twoColumns(str2, "<skipped to " + Hex.u4(underlyingOffset) + ">"));
            this.at = underlyingOffset;
        }
        if (rawBytes) {
            str3 = hexDump(underlyingOffset, i5);
        }
        print(twoColumns(str3, str));
        this.at += i5;
    }

    protected final void print(String str) {
        this.out.print(str);
    }

    protected final void println(String str) {
        this.out.println(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setAt(ByteArray byteArray, int i4) {
        this.at = byteArray.underlyingOffset(i4, this.bytes);
    }

    protected final String twoColumns(String str, String str2) {
        int width1 = getWidth1();
        int width2 = getWidth2();
        try {
            if (width1 == 0) {
                int length = str2.length();
                StringWriter stringWriter = new StringWriter(length * 2);
                IndentingWriter indentingWriter = new IndentingWriter(stringWriter, width2, this.separator);
                indentingWriter.write(str2);
                if (length == 0 || str2.charAt(length - 1) != '\n') {
                    indentingWriter.write(10);
                }
                indentingWriter.flush();
                return stringWriter.toString();
            }
            return TwoColumnOutput.toString(str, width1, this.separator, str2, width2);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void startParsingMember(ByteArray byteArray, int i4, String str, String str2) {
    }

    @Override // com.android.dx.cf.iface.ParseObserver
    public void endParsingMember(ByteArray byteArray, int i4, String str, String str2, Member member) {
    }
}
