package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class OneRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1906a;

    public OneRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1906a = i7;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1906a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 1;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new OneRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1906a);
    }
}
