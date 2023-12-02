package com.android.dx.dex.file;

import androidx.core.view.InputDeviceCompat;
import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class DebugInfoEncoder {
    private static final boolean DEBUG = false;
    private AnnotatedOutput annotateTo;
    private final int codeSize;
    private PrintWriter debugPrint;
    private final Prototype desc;
    private final DexFile file;
    private final boolean isStatic;
    private final LocalList.Entry[] lastEntryForReg;
    private final LocalList locals;
    private final PositionList positions;
    private String prefix;
    private final int regSize;
    private boolean shouldConsume;
    private int address = 0;
    private int line = 1;
    private final ByteArrayAnnotatedOutput output = new ByteArrayAnnotatedOutput();

    public DebugInfoEncoder(PositionList positionList, LocalList localList, DexFile dexFile, int i4, int i5, boolean z3, CstMethodRef cstMethodRef) {
        this.positions = positionList;
        this.locals = localList;
        this.file = dexFile;
        this.desc = cstMethodRef.getPrototype();
        this.isStatic = z3;
        this.codeSize = i4;
        this.regSize = i5;
        this.lastEntryForReg = new LocalList.Entry[i5];
    }

    private void annotate(int i4, String str) {
        if (this.prefix != null) {
            str = this.prefix + str;
        }
        AnnotatedOutput annotatedOutput = this.annotateTo;
        if (annotatedOutput != null) {
            if (!this.shouldConsume) {
                i4 = 0;
            }
            annotatedOutput.annotate(i4, str);
        }
        PrintWriter printWriter = this.debugPrint;
        if (printWriter != null) {
            printWriter.println(str);
        }
    }

    private ArrayList<PositionList.Entry> buildSortedPositions() {
        int size;
        PositionList positionList = this.positions;
        if (positionList == null) {
            size = 0;
        } else {
            size = positionList.size();
        }
        ArrayList<PositionList.Entry> arrayList = new ArrayList<>(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(this.positions.get(i4));
        }
        Collections.sort(arrayList, new Comparator<PositionList.Entry>() { // from class: com.android.dx.dex.file.DebugInfoEncoder.1
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Comparator
            public int compare(PositionList.Entry entry, PositionList.Entry entry2) {
                return entry.getAddress() - entry2.getAddress();
            }
        });
        return arrayList;
    }

    private static int computeOpcode(int i4, int i5) {
        if (i4 >= -4 && i4 <= 10) {
            return (i4 - (-4)) + (i5 * 15) + 10;
        }
        throw new RuntimeException("Parameter out of range");
    }

    private byte[] convert0() throws IOException {
        int i4;
        int i5;
        ArrayList<PositionList.Entry> buildSortedPositions = buildSortedPositions();
        emitHeader(buildSortedPositions, extractMethodArguments());
        this.output.writeByte(7);
        int i6 = 0;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(1, String.format("%04x: prologue end", Integer.valueOf(this.address)));
        }
        int size = buildSortedPositions.size();
        int size2 = this.locals.size();
        int i7 = 0;
        while (true) {
            i6 = emitLocalsAtAddress(i6);
            i7 = emitPositionsAtAddress(i7, buildSortedPositions);
            if (i6 < size2) {
                i4 = this.locals.get(i6).getAddress();
            } else {
                i4 = Integer.MAX_VALUE;
            }
            if (i7 < size) {
                i5 = buildSortedPositions.get(i7).getAddress();
            } else {
                i5 = Integer.MAX_VALUE;
            }
            int min = Math.min(i5, i4);
            if (min != Integer.MAX_VALUE && (min != this.codeSize || i4 != Integer.MAX_VALUE || i5 != Integer.MAX_VALUE)) {
                if (min == i5) {
                    emitPosition(buildSortedPositions.get(i7));
                    i7++;
                } else {
                    emitAdvancePc(min - this.address);
                }
            }
        }
        emitEndSequence();
        return this.output.toByteArray();
    }

    private void emitAdvanceLine(int i4) throws IOException {
        int cursor = this.output.getCursor();
        this.output.writeByte(2);
        this.output.writeSleb128(i4);
        this.line += i4;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("line = %d", Integer.valueOf(this.line)));
        }
    }

    private void emitAdvancePc(int i4) throws IOException {
        int cursor = this.output.getCursor();
        this.output.writeByte(1);
        this.output.writeUleb128(i4);
        this.address += i4;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: advance pc", Integer.valueOf(this.address)));
        }
    }

    private void emitEndSequence() {
        this.output.writeByte(0);
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(1, "end sequence");
        }
    }

    private void emitHeader(ArrayList<PositionList.Entry> arrayList, ArrayList<LocalList.Entry> arrayList2) throws IOException {
        boolean z3;
        LocalList.Entry[] entryArr;
        LocalList.Entry entry;
        String str;
        if (this.annotateTo == null && this.debugPrint == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        int cursor = this.output.getCursor();
        if (arrayList.size() > 0) {
            this.line = arrayList.get(0).getPosition().getLine();
        }
        this.output.writeUleb128(this.line);
        if (z3) {
            annotate(this.output.getCursor() - cursor, "line_start: " + this.line);
        }
        int paramBase = getParamBase();
        StdTypeList parameterTypes = this.desc.getParameterTypes();
        int size = parameterTypes.size();
        if (!this.isStatic) {
            Iterator<LocalList.Entry> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LocalList.Entry next = it.next();
                if (paramBase == next.getRegister()) {
                    this.lastEntryForReg[paramBase] = next;
                    break;
                }
            }
            paramBase++;
        }
        int cursor2 = this.output.getCursor();
        this.output.writeUleb128(size);
        if (z3) {
            annotate(this.output.getCursor() - cursor2, String.format("parameters_size: %04x", Integer.valueOf(size)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            Type type = parameterTypes.get(i4);
            int cursor3 = this.output.getCursor();
            Iterator<LocalList.Entry> it2 = arrayList2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    entry = it2.next();
                    if (paramBase == entry.getRegister()) {
                        if (entry.getSignature() != null) {
                            emitStringIndex(null);
                        } else {
                            emitStringIndex(entry.getName());
                        }
                        this.lastEntryForReg[paramBase] = entry;
                    }
                } else {
                    entry = null;
                    break;
                }
            }
            if (entry == null) {
                emitStringIndex(null);
            }
            if (z3) {
                if (entry != null && entry.getSignature() == null) {
                    str = entry.getName().toHuman();
                } else {
                    str = "<unnamed>";
                }
                annotate(this.output.getCursor() - cursor3, "parameter " + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + RegisterSpec.PREFIX + paramBase);
            }
            paramBase += type.getCategory();
        }
        for (LocalList.Entry entry2 : this.lastEntryForReg) {
            if (entry2 != null && entry2.getSignature() != null) {
                emitLocalStartExtended(entry2);
            }
        }
    }

    private void emitLocalEnd(LocalList.Entry entry) throws IOException {
        int cursor = this.output.getCursor();
        this.output.writeByte(5);
        this.output.writeUleb128(entry.getRegister());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: -local %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
        }
    }

    private void emitLocalRestart(LocalList.Entry entry) throws IOException {
        int cursor = this.output.getCursor();
        this.output.writeByte(6);
        emitUnsignedLeb128(entry.getRegister());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +local restart %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
        }
    }

    private void emitLocalStart(LocalList.Entry entry) throws IOException {
        if (entry.getSignature() != null) {
            emitLocalStartExtended(entry);
            return;
        }
        int cursor = this.output.getCursor();
        this.output.writeByte(3);
        emitUnsignedLeb128(entry.getRegister());
        emitStringIndex(entry.getName());
        emitTypeIndex(entry.getType());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +local %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
        }
    }

    private void emitLocalStartExtended(LocalList.Entry entry) throws IOException {
        int cursor = this.output.getCursor();
        this.output.writeByte(4);
        emitUnsignedLeb128(entry.getRegister());
        emitStringIndex(entry.getName());
        emitTypeIndex(entry.getType());
        emitStringIndex(entry.getSignature());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +localx %s", Integer.valueOf(this.address), entryAnnotationString(entry)));
        }
    }

    private int emitLocalsAtAddress(int i4) throws IOException {
        int size = this.locals.size();
        while (i4 < size && this.locals.get(i4).getAddress() == this.address) {
            int i5 = i4 + 1;
            LocalList.Entry entry = this.locals.get(i4);
            int register = entry.getRegister();
            LocalList.Entry[] entryArr = this.lastEntryForReg;
            LocalList.Entry entry2 = entryArr[register];
            if (entry != entry2) {
                entryArr[register] = entry;
                if (entry.isStart()) {
                    if (entry2 != null && entry.matches(entry2)) {
                        if (!entry2.isStart()) {
                            emitLocalRestart(entry);
                        } else {
                            throw new RuntimeException("shouldn't happen");
                        }
                    } else {
                        emitLocalStart(entry);
                    }
                } else if (entry.getDisposition() != LocalList.Disposition.END_REPLACED) {
                    emitLocalEnd(entry);
                }
            }
            i4 = i5;
        }
        return i4;
    }

    private void emitPosition(PositionList.Entry entry) throws IOException {
        int line = entry.getPosition().getLine();
        int address = entry.getAddress();
        int i4 = line - this.line;
        int i5 = address - this.address;
        if (i5 >= 0) {
            if (i4 < -4 || i4 > 10) {
                emitAdvanceLine(i4);
                i4 = 0;
            }
            int computeOpcode = computeOpcode(i4, i5);
            if ((computeOpcode & InputDeviceCompat.SOURCE_ANY) > 0) {
                emitAdvancePc(i5);
                computeOpcode = computeOpcode(i4, 0);
                if ((computeOpcode & InputDeviceCompat.SOURCE_ANY) > 0) {
                    emitAdvanceLine(i4);
                    computeOpcode = computeOpcode(0, 0);
                    i5 = 0;
                    i4 = 0;
                } else {
                    i5 = 0;
                }
            }
            this.output.writeByte(computeOpcode);
            this.line += i4;
            int i6 = this.address + i5;
            this.address = i6;
            if (this.annotateTo != null || this.debugPrint != null) {
                annotate(1, String.format("%04x: line %d", Integer.valueOf(i6), Integer.valueOf(this.line)));
                return;
            }
            return;
        }
        throw new RuntimeException("Position entries must be in ascending address order");
    }

    private int emitPositionsAtAddress(int i4, ArrayList<PositionList.Entry> arrayList) throws IOException {
        int size = arrayList.size();
        while (i4 < size && arrayList.get(i4).getAddress() == this.address) {
            emitPosition(arrayList.get(i4));
            i4++;
        }
        return i4;
    }

    private void emitStringIndex(CstString cstString) throws IOException {
        DexFile dexFile;
        if (cstString != null && (dexFile = this.file) != null) {
            this.output.writeUleb128(dexFile.getStringIds().indexOf(cstString) + 1);
        } else {
            this.output.writeUleb128(0);
        }
    }

    private void emitTypeIndex(CstType cstType) throws IOException {
        DexFile dexFile;
        if (cstType != null && (dexFile = this.file) != null) {
            this.output.writeUleb128(dexFile.getTypeIds().indexOf(cstType) + 1);
        } else {
            this.output.writeUleb128(0);
        }
    }

    private void emitUnsignedLeb128(int i4) throws IOException {
        if (i4 >= 0) {
            this.output.writeUleb128(i4);
            return;
        }
        throw new RuntimeException("Signed value where unsigned required: " + i4);
    }

    private String entryAnnotationString(LocalList.Entry entry) {
        StringBuilder sb = new StringBuilder();
        sb.append(RegisterSpec.PREFIX);
        sb.append(entry.getRegister());
        sb.append(' ');
        CstString name = entry.getName();
        if (name == null) {
            sb.append("null");
        } else {
            sb.append(name.toHuman());
        }
        sb.append(' ');
        CstType type = entry.getType();
        if (type == null) {
            sb.append("null");
        } else {
            sb.append(type.toHuman());
        }
        CstString signature = entry.getSignature();
        if (signature != null) {
            sb.append(' ');
            sb.append(signature.toHuman());
        }
        return sb.toString();
    }

    private ArrayList<LocalList.Entry> extractMethodArguments() {
        ArrayList<LocalList.Entry> arrayList = new ArrayList<>(this.desc.getParameterTypes().size());
        int paramBase = getParamBase();
        BitSet bitSet = new BitSet(this.regSize - paramBase);
        int size = this.locals.size();
        for (int i4 = 0; i4 < size; i4++) {
            LocalList.Entry entry = this.locals.get(i4);
            int register = entry.getRegister();
            if (register >= paramBase) {
                int i5 = register - paramBase;
                if (!bitSet.get(i5)) {
                    bitSet.set(i5);
                    arrayList.add(entry);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<LocalList.Entry>() { // from class: com.android.dx.dex.file.DebugInfoEncoder.2
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Comparator
            public int compare(LocalList.Entry entry2, LocalList.Entry entry3) {
                return entry2.getRegister() - entry3.getRegister();
            }
        });
        return arrayList;
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (!this.isStatic ? 1 : 0);
    }

    public byte[] convert() {
        try {
            return convert0();
        } catch (IOException e4) {
            throw ExceptionWithContext.withContext(e4, "...while encoding debug info");
        }
    }

    public byte[] convertAndAnnotate(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z3) {
        this.prefix = str;
        this.debugPrint = printWriter;
        this.annotateTo = annotatedOutput;
        this.shouldConsume = z3;
        return convert();
    }
}
