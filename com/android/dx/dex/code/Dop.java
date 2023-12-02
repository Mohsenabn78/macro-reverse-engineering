package com.android.dx.dex.code;

import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.Opcodes;

/* loaded from: classes2.dex */
public final class Dop {
    private final int family;
    private final InsnFormat format;
    private final boolean hasResult;
    private final int nextOpcode;
    private final int opcode;

    public Dop(int i4, int i5, int i6, InsnFormat insnFormat, boolean z3) {
        if (Opcodes.isValidShape(i4)) {
            if (Opcodes.isValidShape(i5)) {
                if (Opcodes.isValidShape(i6)) {
                    if (insnFormat != null) {
                        this.opcode = i4;
                        this.family = i5;
                        this.nextOpcode = i6;
                        this.format = insnFormat;
                        this.hasResult = z3;
                        return;
                    }
                    throw new NullPointerException("format == null");
                }
                throw new IllegalArgumentException("bogus nextOpcode");
            }
            throw new IllegalArgumentException("bogus family");
        }
        throw new IllegalArgumentException("bogus opcode");
    }

    public int getFamily() {
        return this.family;
    }

    public InsnFormat getFormat() {
        return this.format;
    }

    public String getName() {
        return OpcodeInfo.getName(this.opcode);
    }

    public int getNextOpcode() {
        return this.nextOpcode;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Dop getOppositeTest() {
        switch (this.opcode) {
            case 50:
                return Dops.IF_NE;
            case 51:
                return Dops.IF_EQ;
            case 52:
                return Dops.IF_GE;
            case 53:
                return Dops.IF_LT;
            case 54:
                return Dops.IF_LE;
            case 55:
                return Dops.IF_GT;
            case 56:
                return Dops.IF_NEZ;
            case 57:
                return Dops.IF_EQZ;
            case 58:
                return Dops.IF_GEZ;
            case 59:
                return Dops.IF_LTZ;
            case 60:
                return Dops.IF_LEZ;
            case 61:
                return Dops.IF_GTZ;
            default:
                throw new IllegalArgumentException("bogus opcode: " + this);
        }
    }

    public boolean hasResult() {
        return this.hasResult;
    }

    public String toString() {
        return getName();
    }
}
