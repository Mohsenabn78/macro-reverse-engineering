package com.android.dx.rop.code;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.Hex;

/* loaded from: classes2.dex */
public final class SourcePosition {
    public static final SourcePosition NO_INFO = new SourcePosition(null, -1, -1);
    private final int address;
    private final int line;
    private final CstString sourceFile;

    public SourcePosition(CstString cstString, int i4, int i5) {
        if (i4 >= -1) {
            if (i5 >= -1) {
                this.sourceFile = cstString;
                this.address = i4;
                this.line = i5;
                return;
            }
            throw new IllegalArgumentException("line < -1");
        }
        throw new IllegalArgumentException("address < -1");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SourcePosition)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        SourcePosition sourcePosition = (SourcePosition) obj;
        if (this.address != sourcePosition.address || !sameLineAndFile(sourcePosition)) {
            return false;
        }
        return true;
    }

    public int getAddress() {
        return this.address;
    }

    public int getLine() {
        return this.line;
    }

    public CstString getSourceFile() {
        return this.sourceFile;
    }

    public int hashCode() {
        return this.sourceFile.hashCode() + this.address + this.line;
    }

    public boolean sameLine(SourcePosition sourcePosition) {
        if (this.line == sourcePosition.line) {
            return true;
        }
        return false;
    }

    public boolean sameLineAndFile(SourcePosition sourcePosition) {
        CstString cstString;
        CstString cstString2;
        if (this.line == sourcePosition.line && ((cstString = this.sourceFile) == (cstString2 = sourcePosition.sourceFile) || (cstString != null && cstString.equals(cstString2)))) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        CstString cstString = this.sourceFile;
        if (cstString != null) {
            stringBuffer.append(cstString.toHuman());
            stringBuffer.append(":");
        }
        int i4 = this.line;
        if (i4 >= 0) {
            stringBuffer.append(i4);
        }
        stringBuffer.append('@');
        int i5 = this.address;
        if (i5 < 0) {
            stringBuffer.append("????");
        } else {
            stringBuffer.append(Hex.u2(i5));
        }
        return stringBuffer.toString();
    }
}
