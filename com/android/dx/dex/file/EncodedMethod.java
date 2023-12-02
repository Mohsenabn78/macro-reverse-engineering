package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import org.joni.constants.internal.StackType;

/* loaded from: classes2.dex */
public final class EncodedMethod extends EncodedMember implements Comparable<EncodedMethod> {
    private final CodeItem code;
    private final CstMethodRef method;

    public EncodedMethod(CstMethodRef cstMethodRef, int i4, DalvCode dalvCode, TypeList typeList) {
        super(i4);
        boolean z3;
        if (cstMethodRef != null) {
            this.method = cstMethodRef;
            if (dalvCode == null) {
                this.code = null;
                return;
            }
            if ((i4 & 8) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.code = new CodeItem(cstMethodRef, dalvCode, z3, typeList);
            return;
        }
        throw new NullPointerException("method == null");
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void addContents(DexFile dexFile) {
        MethodIdsSection methodIds = dexFile.getMethodIds();
        MixedItemSection wordData = dexFile.getWordData();
        methodIds.intern(this.method);
        CodeItem codeItem = this.code;
        if (codeItem != null) {
            wordData.add(codeItem);
        }
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void debugPrint(PrintWriter printWriter, boolean z3) {
        CodeItem codeItem = this.code;
        if (codeItem == null) {
            printWriter.println(getRef().toHuman() + ": abstract or native");
            return;
        }
        codeItem.debugPrint(printWriter, "  ", z3);
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i4, int i5) {
        boolean z3;
        boolean z4;
        int indexOf = dexFile.getMethodIds().indexOf(this.method);
        int i6 = indexOf - i4;
        int accessFlags = getAccessFlags();
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.code);
        if (absoluteOffsetOr0 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((accessFlags & StackType.POS) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 == z4) {
            if (annotatedOutput.annotates()) {
                annotatedOutput.annotate(0, String.format("  [%x] %s", Integer.valueOf(i5), this.method.toHuman()));
                int unsignedLeb128Size = Leb128.unsignedLeb128Size(i6);
                annotatedOutput.annotate(unsignedLeb128Size, "    method_idx:   " + Hex.u4(indexOf));
                int unsignedLeb128Size2 = Leb128.unsignedLeb128Size(accessFlags);
                annotatedOutput.annotate(unsignedLeb128Size2, "    access_flags: " + AccessFlags.methodString(accessFlags));
                int unsignedLeb128Size3 = Leb128.unsignedLeb128Size(absoluteOffsetOr0);
                annotatedOutput.annotate(unsignedLeb128Size3, "    code_off:     " + Hex.u4(absoluteOffsetOr0));
            }
            annotatedOutput.writeUleb128(i6);
            annotatedOutput.writeUleb128(accessFlags);
            annotatedOutput.writeUleb128(absoluteOffsetOr0);
            return indexOf;
        }
        throw new UnsupportedOperationException("code vs. access_flags mismatch");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EncodedMethod) || compareTo((EncodedMethod) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public final CstString getName() {
        return this.method.getNat().getName();
    }

    public final CstMethodRef getRef() {
        return this.method;
    }

    @Override // com.android.dx.util.ToHuman
    public final String toHuman() {
        return this.method.toHuman();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(EncodedMethod.class.getName());
        stringBuffer.append('{');
        stringBuffer.append(Hex.u2(getAccessFlags()));
        stringBuffer.append(' ');
        stringBuffer.append(this.method);
        if (this.code != null) {
            stringBuffer.append(' ');
            stringBuffer.append(this.code);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(EncodedMethod encodedMethod) {
        return this.method.compareTo((Constant) encodedMethod.method);
    }
}
