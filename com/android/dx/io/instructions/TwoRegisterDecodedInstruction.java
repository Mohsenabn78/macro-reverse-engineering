package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class TwoRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1911a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1912b;

    public TwoRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7, int i8) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1911a = i7;
        this.f1912b = i8;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1911a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getB() {
        return this.f1912b;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 2;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new TwoRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1911a, this.f1912b);
    }
}
