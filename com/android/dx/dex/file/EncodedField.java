package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class EncodedField extends EncodedMember implements Comparable<EncodedField> {
    private final CstFieldRef field;

    public EncodedField(CstFieldRef cstFieldRef, int i4) {
        super(i4);
        if (cstFieldRef != null) {
            this.field = cstFieldRef;
            return;
        }
        throw new NullPointerException("field == null");
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void addContents(DexFile dexFile) {
        dexFile.getFieldIds().intern(this.field);
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void debugPrint(PrintWriter printWriter, boolean z3) {
        printWriter.println(toString());
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i4, int i5) {
        int indexOf = dexFile.getFieldIds().indexOf(this.field);
        int i6 = indexOf - i4;
        int accessFlags = getAccessFlags();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, String.format("  [%x] %s", Integer.valueOf(i5), this.field.toHuman()));
            int unsignedLeb128Size = Leb128.unsignedLeb128Size(i6);
            annotatedOutput.annotate(unsignedLeb128Size, "    field_idx:    " + Hex.u4(indexOf));
            int unsignedLeb128Size2 = Leb128.unsignedLeb128Size(accessFlags);
            annotatedOutput.annotate(unsignedLeb128Size2, "    access_flags: " + AccessFlags.fieldString(accessFlags));
        }
        annotatedOutput.writeUleb128(i6);
        annotatedOutput.writeUleb128(accessFlags);
        return indexOf;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EncodedField) || compareTo((EncodedField) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public CstString getName() {
        return this.field.getNat().getName();
    }

    public CstFieldRef getRef() {
        return this.field;
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.field.toHuman();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(EncodedField.class.getName());
        stringBuffer.append('{');
        stringBuffer.append(Hex.u2(getAccessFlags()));
        stringBuffer.append(' ');
        stringBuffer.append(this.field);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(EncodedField encodedField) {
        return this.field.compareTo((Constant) encodedField.field);
    }
}
