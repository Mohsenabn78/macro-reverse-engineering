package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class FourRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1902a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1903b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1904c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1905d;

    public FourRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7, int i8, int i9, int i10) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1902a = i7;
        this.f1903b = i8;
        this.f1904c = i9;
        this.f1905d = i10;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1902a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getB() {
        return this.f1903b;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        return this.f1904c;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getD() {
        return this.f1905d;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 4;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new FourRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1902a, this.f1903b, this.f1904c, this.f1905d);
    }
}
