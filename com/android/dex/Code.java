package com.android.dex;

/* loaded from: classes2.dex */
public final class Code {
    private final CatchHandler[] catchHandlers;
    private final int debugInfoOffset;
    private final int insSize;
    private final short[] instructions;
    private final int outsSize;
    private final int registersSize;
    private final Try[] tries;

    /* loaded from: classes2.dex */
    public static class CatchHandler {
        final int[] addresses;
        final int catchAllAddress;
        final int offset;
        final int[] typeIndexes;

        public CatchHandler(int[] iArr, int[] iArr2, int i4, int i5) {
            this.typeIndexes = iArr;
            this.addresses = iArr2;
            this.catchAllAddress = i4;
            this.offset = i5;
        }

        public int[] getAddresses() {
            return this.addresses;
        }

        public int getCatchAllAddress() {
            return this.catchAllAddress;
        }

        public int getOffset() {
            return this.offset;
        }

        public int[] getTypeIndexes() {
            return this.typeIndexes;
        }
    }

    /* loaded from: classes2.dex */
    public static class Try {
        final int catchHandlerIndex;
        final int instructionCount;
        final int startAddress;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Try(int i4, int i5, int i6) {
            this.startAddress = i4;
            this.instructionCount = i5;
            this.catchHandlerIndex = i6;
        }

        public int getCatchHandlerIndex() {
            return this.catchHandlerIndex;
        }

        public int getInstructionCount() {
            return this.instructionCount;
        }

        public int getStartAddress() {
            return this.startAddress;
        }
    }

    public Code(int i4, int i5, int i6, int i7, short[] sArr, Try[] tryArr, CatchHandler[] catchHandlerArr) {
        this.registersSize = i4;
        this.insSize = i5;
        this.outsSize = i6;
        this.debugInfoOffset = i7;
        this.instructions = sArr;
        this.tries = tryArr;
        this.catchHandlers = catchHandlerArr;
    }

    public CatchHandler[] getCatchHandlers() {
        return this.catchHandlers;
    }

    public int getDebugInfoOffset() {
        return this.debugInfoOffset;
    }

    public int getInsSize() {
        return this.insSize;
    }

    public short[] getInstructions() {
        return this.instructions;
    }

    public int getOutsSize() {
        return this.outsSize;
    }

    public int getRegistersSize() {
        return this.registersSize;
    }

    public Try[] getTries() {
        return this.tries;
    }
}
