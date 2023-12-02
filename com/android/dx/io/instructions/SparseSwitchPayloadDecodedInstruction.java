package com.android.dx.io.instructions;

/* loaded from: classes2.dex */
public final class SparseSwitchPayloadDecodedInstruction extends DecodedInstruction {
    private final int[] keys;
    private final int[] targets;

    public SparseSwitchPayloadDecodedInstruction(InstructionCodec instructionCodec, int i4, int[] iArr, int[] iArr2) {
        super(instructionCodec, i4, 0, null, 0, 0L);
        if (iArr.length == iArr2.length) {
            this.keys = iArr;
            this.targets = iArr2;
            return;
        }
        throw new IllegalArgumentException("keys/targets length mismatch");
    }

    public int[] getKeys() {
        return this.keys;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public int getRegisterCount() {
        return 0;
    }

    public int[] getTargets() {
        return this.targets;
    }

    @Override // com.android.dx.io.instructions.DecodedInstruction
    public DecodedInstruction withIndex(int i4) {
        throw new UnsupportedOperationException("no index in instruction");
    }
}
