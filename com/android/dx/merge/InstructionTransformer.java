package com.android.dx.merge;

import com.android.dex.DexException;
import com.android.dex.DexIndexOverflowException;
import com.android.dx.io.CodeReader;
import com.android.dx.io.instructions.DecodedInstruction;
import com.android.dx.io.instructions.ShortArrayCodeOutput;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class InstructionTransformer {
    private IndexMap indexMap;
    private int mappedAt;
    private DecodedInstruction[] mappedInstructions;
    private final CodeReader reader;

    /* loaded from: classes2.dex */
    private class FieldVisitor implements CodeReader.Visitor {
        private FieldVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            boolean z3;
            int adjustField = InstructionTransformer.this.indexMap.adjustField(decodedInstruction.getIndex());
            if (decodedInstruction.getOpcode() == 27) {
                z3 = true;
            } else {
                z3 = false;
            }
            InstructionTransformer.jumboCheck(z3, adjustField);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$608(InstructionTransformer.this)] = decodedInstruction.withIndex(adjustField);
        }
    }

    /* loaded from: classes2.dex */
    private class GenericVisitor implements CodeReader.Visitor {
        private GenericVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$608(InstructionTransformer.this)] = decodedInstruction;
        }
    }

    /* loaded from: classes2.dex */
    private class MethodVisitor implements CodeReader.Visitor {
        private MethodVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            boolean z3;
            int adjustMethod = InstructionTransformer.this.indexMap.adjustMethod(decodedInstruction.getIndex());
            if (decodedInstruction.getOpcode() == 27) {
                z3 = true;
            } else {
                z3 = false;
            }
            InstructionTransformer.jumboCheck(z3, adjustMethod);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$608(InstructionTransformer.this)] = decodedInstruction.withIndex(adjustMethod);
        }
    }

    /* loaded from: classes2.dex */
    private class StringVisitor implements CodeReader.Visitor {
        private StringVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            boolean z3;
            int adjustString = InstructionTransformer.this.indexMap.adjustString(decodedInstruction.getIndex());
            if (decodedInstruction.getOpcode() == 27) {
                z3 = true;
            } else {
                z3 = false;
            }
            InstructionTransformer.jumboCheck(z3, adjustString);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$608(InstructionTransformer.this)] = decodedInstruction.withIndex(adjustString);
        }
    }

    /* loaded from: classes2.dex */
    private class TypeVisitor implements CodeReader.Visitor {
        private TypeVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            boolean z3;
            int adjustType = InstructionTransformer.this.indexMap.adjustType(decodedInstruction.getIndex());
            if (decodedInstruction.getOpcode() == 27) {
                z3 = true;
            } else {
                z3 = false;
            }
            InstructionTransformer.jumboCheck(z3, adjustType);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$608(InstructionTransformer.this)] = decodedInstruction.withIndex(adjustType);
        }
    }

    public InstructionTransformer() {
        CodeReader codeReader = new CodeReader();
        this.reader = codeReader;
        codeReader.setAllVisitors(new GenericVisitor());
        codeReader.setStringVisitor(new StringVisitor());
        codeReader.setTypeVisitor(new TypeVisitor());
        codeReader.setFieldVisitor(new FieldVisitor());
        codeReader.setMethodVisitor(new MethodVisitor());
    }

    static /* synthetic */ int access$608(InstructionTransformer instructionTransformer) {
        int i4 = instructionTransformer.mappedAt;
        instructionTransformer.mappedAt = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jumboCheck(boolean z3, int i4) {
        if (!z3 && i4 > 65535) {
            throw new DexIndexOverflowException("Cannot merge new index " + i4 + " into a non-jumbo instruction!");
        }
    }

    public short[] transform(IndexMap indexMap, short[] sArr) throws DexException {
        DecodedInstruction[] decodedInstructionArr;
        DecodedInstruction[] decodeAll = DecodedInstruction.decodeAll(sArr);
        int length = decodeAll.length;
        this.indexMap = indexMap;
        this.mappedInstructions = new DecodedInstruction[length];
        this.mappedAt = 0;
        this.reader.visitAll(decodeAll);
        ShortArrayCodeOutput shortArrayCodeOutput = new ShortArrayCodeOutput(length);
        for (DecodedInstruction decodedInstruction : this.mappedInstructions) {
            if (decodedInstruction != null) {
                decodedInstruction.encode(shortArrayCodeOutput);
            }
        }
        this.indexMap = null;
        return shortArrayCodeOutput.getArray();
    }
}
