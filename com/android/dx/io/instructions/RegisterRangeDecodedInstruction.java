package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class RegisterRangeDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1907a;
    private final int registerCount;

    public RegisterRangeDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7, int i8) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1907a = i7;
        this.registerCount = i8;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1907a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new RegisterRangeDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1907a, this.registerCount);
    }
}
