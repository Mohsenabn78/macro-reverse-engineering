package com.android.dx.dex.file;

import com.android.dex.Leb128;
import com.android.dex.util.ByteArrayByteInput;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DebugInfoDecoder {
    private final int codesize;
    private final Prototype desc;
    private final byte[] encoded;
    private final DexFile file;
    private final boolean isStatic;
    private final LocalEntry[] lastEntryForReg;
    private final ArrayList<LocalEntry> locals;
    private final ArrayList<PositionEntry> positions;
    private final int regSize;
    private final int thisStringIdx;
    private int line = 1;
    private int address = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LocalEntry {
        public int address;
        public boolean isStart;
        public int nameIndex;
        public int reg;
        public int signatureIndex;
        public int typeIndex;

        public LocalEntry(int i4, boolean z3, int i5, int i6, int i7, int i8) {
            this.address = i4;
            this.isStart = z3;
            this.reg = i5;
            this.nameIndex = i6;
            this.typeIndex = i7;
            this.signatureIndex = i8;
        }

        public String toString() {
            String str;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(this.address);
            if (this.isStart) {
                str = "start";
            } else {
                str = "end";
            }
            objArr[1] = str;
            objArr[2] = Integer.valueOf(this.reg);
            objArr[3] = Integer.valueOf(this.nameIndex);
            objArr[4] = Integer.valueOf(this.typeIndex);
            objArr[5] = Integer.valueOf(this.signatureIndex);
            return String.format("[%x %s v%d %04x %04x %04x]", objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PositionEntry {
        public int address;
        public int line;

        public PositionEntry(int i4, int i5) {
            this.address = i4;
            this.line = i5;
        }
    }

    DebugInfoDecoder(byte[] bArr, int i4, int i5, boolean z3, CstMethodRef cstMethodRef, DexFile dexFile) {
        int i6;
        if (bArr != null) {
            this.encoded = bArr;
            this.isStatic = z3;
            this.desc = cstMethodRef.getPrototype();
            this.file = dexFile;
            this.regSize = i5;
            this.positions = new ArrayList<>();
            this.locals = new ArrayList<>();
            this.codesize = i4;
            this.lastEntryForReg = new LocalEntry[i5];
            try {
                i6 = dexFile.getStringIds().indexOf(new CstString("this"));
            } catch (IllegalArgumentException unused) {
                i6 = -1;
            }
            this.thisStringIdx = i6;
            return;
        }
        throw new NullPointerException("encoded == null");
    }

    private void decode0() throws IOException {
        int i4;
        LocalEntry localEntry;
        ByteArrayByteInput byteArrayByteInput = new ByteArrayByteInput(this.encoded);
        this.line = Leb128.readUnsignedLeb128(byteArrayByteInput);
        int readUnsignedLeb128 = Leb128.readUnsignedLeb128(byteArrayByteInput);
        StdTypeList parameterTypes = this.desc.getParameterTypes();
        int paramBase = getParamBase();
        if (readUnsignedLeb128 == parameterTypes.size()) {
            if (!this.isStatic) {
                LocalEntry localEntry2 = new LocalEntry(0, true, paramBase, this.thisStringIdx, 0, 0);
                this.locals.add(localEntry2);
                this.lastEntryForReg[paramBase] = localEntry2;
                paramBase++;
            }
            int i5 = paramBase;
            for (int i6 = 0; i6 < readUnsignedLeb128; i6++) {
                Type type = parameterTypes.getType(i6);
                int readStringIndex = readStringIndex(byteArrayByteInput);
                if (readStringIndex == -1) {
                    localEntry = new LocalEntry(0, true, i5, -1, 0, 0);
                } else {
                    localEntry = new LocalEntry(0, true, i5, readStringIndex, 0, 0);
                }
                this.locals.add(localEntry);
                this.lastEntryForReg[i5] = localEntry;
                i5 += type.getCategory();
            }
            while (true) {
                int readByte = byteArrayByteInput.readByte() & 255;
                switch (readByte) {
                    case 0:
                        return;
                    case 1:
                        this.address += Leb128.readUnsignedLeb128(byteArrayByteInput);
                        break;
                    case 2:
                        this.line += Leb128.readSignedLeb128(byteArrayByteInput);
                        break;
                    case 3:
                        int readUnsignedLeb1282 = Leb128.readUnsignedLeb128(byteArrayByteInput);
                        LocalEntry localEntry3 = new LocalEntry(this.address, true, readUnsignedLeb1282, readStringIndex(byteArrayByteInput), readStringIndex(byteArrayByteInput), 0);
                        this.locals.add(localEntry3);
                        this.lastEntryForReg[readUnsignedLeb1282] = localEntry3;
                        break;
                    case 4:
                        int readUnsignedLeb1283 = Leb128.readUnsignedLeb128(byteArrayByteInput);
                        LocalEntry localEntry4 = new LocalEntry(this.address, true, readUnsignedLeb1283, readStringIndex(byteArrayByteInput), readStringIndex(byteArrayByteInput), readStringIndex(byteArrayByteInput));
                        this.locals.add(localEntry4);
                        this.lastEntryForReg[readUnsignedLeb1283] = localEntry4;
                        break;
                    case 5:
                        int readUnsignedLeb1284 = Leb128.readUnsignedLeb128(byteArrayByteInput);
                        try {
                            LocalEntry localEntry5 = this.lastEntryForReg[readUnsignedLeb1284];
                            if (localEntry5.isStart) {
                                LocalEntry localEntry6 = new LocalEntry(this.address, false, readUnsignedLeb1284, localEntry5.nameIndex, localEntry5.typeIndex, localEntry5.signatureIndex);
                                this.locals.add(localEntry6);
                                this.lastEntryForReg[readUnsignedLeb1284] = localEntry6;
                                break;
                            } else {
                                throw new RuntimeException("nonsensical END_LOCAL on dead register v" + readUnsignedLeb1284);
                            }
                        } catch (NullPointerException unused) {
                            throw new RuntimeException("Encountered END_LOCAL on new v" + readUnsignedLeb1284);
                        }
                    case 6:
                        int readUnsignedLeb1285 = Leb128.readUnsignedLeb128(byteArrayByteInput);
                        try {
                            LocalEntry localEntry7 = this.lastEntryForReg[readUnsignedLeb1285];
                            if (!localEntry7.isStart) {
                                LocalEntry localEntry8 = new LocalEntry(this.address, true, readUnsignedLeb1285, localEntry7.nameIndex, localEntry7.typeIndex, 0);
                                this.locals.add(localEntry8);
                                this.lastEntryForReg[readUnsignedLeb1285] = localEntry8;
                                break;
                            } else {
                                throw new RuntimeException("nonsensical RESTART_LOCAL on live register v" + readUnsignedLeb1285);
                            }
                        } catch (NullPointerException unused2) {
                            throw new RuntimeException("Encountered RESTART_LOCAL on new v" + readUnsignedLeb1285);
                        }
                    case 7:
                    case 8:
                    case 9:
                        break;
                    default:
                        if (readByte >= 10) {
                            int i7 = this.address + ((readByte - 10) / 15);
                            this.address = i7;
                            int i8 = this.line + ((i4 % 15) - 4);
                            this.line = i8;
                            this.positions.add(new PositionEntry(i7, i8));
                            break;
                        } else {
                            throw new RuntimeException("Invalid extended opcode encountered " + readByte);
                        }
                }
            }
        } else {
            throw new RuntimeException("Mismatch between parameters_size and prototype");
        }
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (!this.isStatic ? 1 : 0);
    }

    private int readStringIndex(ByteInput byteInput) throws IOException {
        return Leb128.readUnsignedLeb128(byteInput) - 1;
    }

    public static void validateEncode(byte[] bArr, DexFile dexFile, CstMethodRef cstMethodRef, DalvCode dalvCode, boolean z3) {
        PositionList positions = dalvCode.getPositions();
        LocalList locals = dalvCode.getLocals();
        DalvInsnList insns = dalvCode.getInsns();
        try {
            validateEncode0(bArr, insns.codeSize(), insns.getRegistersSize(), z3, cstMethodRef, dexFile, positions, locals);
        } catch (RuntimeException e4) {
            System.err.println("instructions:");
            insns.debugPrint((OutputStream) System.err, "  ", true);
            System.err.println("local list:");
            locals.debugPrint(System.err, "  ");
            throw ExceptionWithContext.withContext(e4, "while processing " + cstMethodRef.toHuman());
        }
    }

    private static void validateEncode0(byte[] bArr, int i4, int i5, boolean z3, CstMethodRef cstMethodRef, DexFile dexFile, PositionList positionList, LocalList localList) {
        boolean z4;
        LocalEntry localEntry;
        PositionEntry next;
        DebugInfoDecoder debugInfoDecoder = new DebugInfoDecoder(bArr, i4, i5, z3, cstMethodRef, dexFile);
        debugInfoDecoder.decode();
        List<PositionEntry> positionList2 = debugInfoDecoder.getPositionList();
        if (positionList2.size() == positionList.size()) {
            Iterator<PositionEntry> it = positionList2.iterator();
            do {
                z4 = false;
                if (it.hasNext()) {
                    next = it.next();
                    int size = positionList.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            PositionList.Entry entry = positionList.get(size);
                            if (next.line == entry.getPosition().getLine() && next.address == entry.getAddress()) {
                                z4 = true;
                                continue;
                                break;
                            }
                            size--;
                        }
                    }
                } else {
                    List<LocalEntry> locals = debugInfoDecoder.getLocals();
                    int i6 = debugInfoDecoder.thisStringIdx;
                    int size2 = locals.size();
                    int paramBase = debugInfoDecoder.getParamBase();
                    for (int i7 = 0; i7 < size2; i7++) {
                        LocalEntry localEntry2 = locals.get(i7);
                        int i8 = localEntry2.nameIndex;
                        if (i8 < 0 || i8 == i6) {
                            int i9 = i7 + 1;
                            while (true) {
                                if (i9 < size2) {
                                    LocalEntry localEntry3 = locals.get(i9);
                                    if (localEntry3.address == 0) {
                                        if (localEntry2.reg == localEntry3.reg && localEntry3.isStart) {
                                            locals.set(i7, localEntry3);
                                            locals.remove(i9);
                                            size2--;
                                            break;
                                        }
                                        i9++;
                                    }
                                }
                            }
                        }
                    }
                    int size3 = localList.size();
                    int i10 = 0;
                    for (int i11 = 0; i11 < size3; i11++) {
                        LocalList.Entry entry2 = localList.get(i11);
                        if (entry2.getDisposition() != LocalList.Disposition.END_REPLACED) {
                            do {
                                localEntry = locals.get(i10);
                                if (localEntry.nameIndex >= 0) {
                                    break;
                                }
                                i10++;
                            } while (i10 < size2);
                            int i12 = localEntry.address;
                            if (localEntry.reg != entry2.getRegister()) {
                                System.err.println("local register mismatch at orig " + i11 + " / decoded " + i10);
                            } else if (localEntry.isStart != entry2.isStart()) {
                                System.err.println("local start/end mismatch at orig " + i11 + " / decoded " + i10);
                            } else if (i12 != entry2.getAddress() && (i12 != 0 || localEntry.reg < paramBase)) {
                                System.err.println("local address mismatch at orig " + i11 + " / decoded " + i10);
                            } else {
                                i10++;
                            }
                            z4 = true;
                            break;
                        }
                    }
                    if (z4) {
                        System.err.println("decoded locals:");
                        Iterator<LocalEntry> it2 = locals.iterator();
                        while (it2.hasNext()) {
                            System.err.println("  " + it2.next());
                        }
                        throw new RuntimeException("local table problem");
                    }
                    return;
                }
            } while (z4);
            throw new RuntimeException("Could not match position entry: " + next.address + ", " + next.line);
        }
        throw new RuntimeException("Decoded positions table not same size was " + positionList2.size() + " expected " + positionList.size());
    }

    public void decode() {
        try {
            decode0();
        } catch (Exception e4) {
            throw ExceptionWithContext.withContext(e4, "...while decoding debug info");
        }
    }

    public List<LocalEntry> getLocals() {
        return this.locals;
    }

    public List<PositionEntry> getPositionList() {
        return this.positions;
    }
}
