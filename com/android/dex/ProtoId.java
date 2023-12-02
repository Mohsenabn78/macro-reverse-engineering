package com.android.dex;

import com.android.dex.Dex;
import com.android.dex.util.Unsigned;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public final class ProtoId implements Comparable<ProtoId> {
    private final Dex dex;
    private final int parametersOffset;
    private final int returnTypeIndex;
    private final int shortyIndex;

    public ProtoId(Dex dex, int i4, int i5, int i6) {
        this.dex = dex;
        this.shortyIndex = i4;
        this.returnTypeIndex = i5;
        this.parametersOffset = i6;
    }

    public int getParametersOffset() {
        return this.parametersOffset;
    }

    public int getReturnTypeIndex() {
        return this.returnTypeIndex;
    }

    public int getShortyIndex() {
        return this.shortyIndex;
    }

    public String toString() {
        if (this.dex == null) {
            return this.shortyIndex + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.returnTypeIndex + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.parametersOffset;
        }
        return this.dex.strings().get(this.shortyIndex) + ": " + this.dex.typeNames().get(this.returnTypeIndex) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.dex.readTypeList(this.parametersOffset);
    }

    public void writeTo(Dex.Section section) {
        section.writeInt(this.shortyIndex);
        section.writeInt(this.returnTypeIndex);
        section.writeInt(this.parametersOffset);
    }

    @Override // java.lang.Comparable
    public int compareTo(ProtoId protoId) {
        int i4 = this.returnTypeIndex;
        int i5 = protoId.returnTypeIndex;
        if (i4 != i5) {
            return Unsigned.compare(i4, i5);
        }
        return Unsigned.compare(this.parametersOffset, protoId.parametersOffset);
    }
}
