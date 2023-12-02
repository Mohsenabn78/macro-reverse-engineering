package com.android.dx.io.instructions;

import com.android.dx.io.IndexType;

/* loaded from: classes2.dex */
public final class FiveRegisterDecodedInstruction extends DecodedInstruction {

    /* renamed from: a  reason: collision with root package name */
    private final int f1897a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1898b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1899c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1900d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1901e;

    public FiveRegisterDecodedInstruction(InstructionCodec instructionCodec, int i4, int i5, IndexType indexType, int i6, long j4, int i7, int i8, int i9, int i10, int i11) {
        super(instructionCodec, i4, i5, indexType, i6, j4);
        this.f1897a = i7;
        this.f1898b = i8;
        this.f1899c = i9;
        this.f1900d = i10;
        this.f1901e = i11;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getA() {
        return this.f1897a;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getB() {
        return this.f1898b;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getC() {
        return this.f1899c;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getD() {
        return this.f1900d;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getE() {
        return this.f1901e;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 5;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        return new FiveRegisterDecodedInstruction(getFormat(), getOpcode(), i4, getIndexType(), getTarget(), getLiteral(), this.f1897a, this.f1898b, this.f1899c, this.f1900d, this.f1901e);
    }
}
