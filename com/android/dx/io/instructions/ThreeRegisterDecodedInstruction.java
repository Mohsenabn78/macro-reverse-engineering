package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class ThreeRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1908a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1909b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1910c;

    public ThreeRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7, int i8, int i9) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1908a = i7;
        this.f1909b = i8;
        this.f1910c = i9;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1908a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getB() {
        return this.f1909b;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        return this.f1910c;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 3;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new ThreeRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1908a, this.f1909b, this.f1910c);
    }
}
