package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class ZeroRegisterDecodedInstruction extends DecodedInstruction {
    public ZeroRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 0;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new ZeroRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral());
    }
}
