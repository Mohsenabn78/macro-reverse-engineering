package com.android.dx.dex.code;

import com.android.dex.DexException;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMemberRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.ssa.BasicRegisterMapper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class OutputFinisher {
    private final DexOptions dexOptions;
    private ArrayList<DalvInsn> insns;
    private final int paramSize;
    private int reservedParameterCount;
    private final int unreservedRegCount;
    private int reservedCount = -1;
    private boolean hasAnyPositionInfo = false;
    private boolean hasAnyLocalInfo = false;

    public OutputFinisher(DexOptions dexOptions, int i4, int i5, int i6) {
        this.dexOptions = dexOptions;
        this.unreservedRegCount = i5;
        this.insns = new ArrayList<>(i4);
        this.paramSize = i6;
    }

    private static void addConstants(HashSet<Constant> hashSet, DalvInsn dalvInsn) {
        if (dalvInsn instanceof CstInsn) {
            hashSet.add(((CstInsn) dalvInsn).getConstant());
        } else if (dalvInsn instanceof LocalSnapshot) {
            RegisterSpecSet locals = ((LocalSnapshot) dalvInsn).getLocals();
            int size = locals.size();
            for (int i4 = 0; i4 < size; i4++) {
                addConstants(hashSet, locals.get(i4));
            }
        } else if (dalvInsn instanceof LocalStart) {
            addConstants(hashSet, ((LocalStart) dalvInsn).getLocal());
        }
    }

    private void addReservedParameters(int i4) {
        shiftParameters(i4);
        this.reservedParameterCount += i4;
    }

    private void addReservedRegisters(int i4) {
        shiftAllRegisters(i4);
        this.reservedCount += i4;
    }

    private void align64bits(Dop[] dopArr) {
        boolean z3;
        do {
            int i4 = ((this.unreservedRegCount + this.reservedCount) + this.reservedParameterCount) - this.paramSize;
            Iterator<DalvInsn> it = this.insns.iterator();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (it.hasNext()) {
                RegisterSpecList registers = it.next().getRegisters();
                for (int i9 = 0; i9 < registers.size(); i9++) {
                    RegisterSpec registerSpec = registers.get(i9);
                    if (registerSpec.isCategory2()) {
                        if (registerSpec.getReg() >= i4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (registerSpec.isEvenRegister()) {
                            if (z3) {
                                i6++;
                            } else {
                                i8++;
                            }
                        } else if (z3) {
                            i5++;
                        } else {
                            i7++;
                        }
                    }
                }
            }
            if (i5 > i6 && i7 > i8) {
                addReservedRegisters(1);
            } else if (i5 > i6) {
                addReservedParameters(1);
            } else if (i7 > i8) {
                addReservedRegisters(1);
                if (this.paramSize != 0 && i6 > i5) {
                    addReservedParameters(1);
                }
            } else {
                return;
            }
        } while (reserveRegisters(dopArr));
    }

    private void assignAddresses() {
        int size = this.insns.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            DalvInsn dalvInsn = this.insns.get(i5);
            dalvInsn.setAddress(i4);
            i4 += dalvInsn.codeSize();
        }
    }

    private void assignAddressesAndFixBranches() {
        do {
            assignAddresses();
        } while (fixBranches());
    }

    private int calculateReservedCount(Dop[] dopArr) {
        int size = this.insns.size();
        int i4 = this.reservedCount;
        for (int i5 = 0; i5 < size; i5++) {
            DalvInsn dalvInsn = this.insns.get(i5);
            Dop dop = dopArr[i5];
            Dop findOpcodeForInsn = findOpcodeForInsn(dalvInsn, dop);
            if (findOpcodeForInsn == null) {
                int minimumRegisterRequirement = dalvInsn.getMinimumRegisterRequirement(findExpandedOpcodeForInsn(dalvInsn).getFormat().compatibleRegs(dalvInsn));
                if (minimumRegisterRequirement > i4) {
                    i4 = minimumRegisterRequirement;
                }
            } else if (dop == findOpcodeForInsn) {
            }
            dopArr[i5] = findOpcodeForInsn;
        }
        return i4;
    }

    private Dop findExpandedOpcodeForInsn(DalvInsn dalvInsn) {
        Dop findOpcodeForInsn = findOpcodeForInsn(dalvInsn.getLowRegVersion(), dalvInsn.getOpcode());
        if (findOpcodeForInsn != null) {
            return findOpcodeForInsn;
        }
        throw new DexException("No expanded opcode for " + dalvInsn);
    }

    private Dop findOpcodeForInsn(DalvInsn dalvInsn, Dop dop) {
        while (dop != null && (!dop.getFormat().isCompatible(dalvInsn) || (this.dexOptions.forceJumbo && dop.getOpcode() == 26))) {
            dop = Dops.getNextOrNull(dop, this.dexOptions);
        }
        return dop;
    }

    private boolean fixBranches() {
        int size = this.insns.size();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < size) {
            DalvInsn dalvInsn = this.insns.get(i4);
            if (dalvInsn instanceof TargetInsn) {
                Dop opcode = dalvInsn.getOpcode();
                TargetInsn targetInsn = (TargetInsn) dalvInsn;
                if (opcode.getFormat().branchFits(targetInsn)) {
                    continue;
                } else {
                    if (opcode.getFamily() == 40) {
                        Dop findOpcodeForInsn = findOpcodeForInsn(dalvInsn, opcode);
                        if (findOpcodeForInsn != null) {
                            this.insns.set(i4, dalvInsn.withOpcode(findOpcodeForInsn));
                        } else {
                            throw new UnsupportedOperationException("method too long");
                        }
                    } else {
                        try {
                            int i5 = i4 + 1;
                            CodeAddress codeAddress = (CodeAddress) this.insns.get(i5);
                            this.insns.set(i4, new TargetInsn(Dops.GOTO, targetInsn.getPosition(), RegisterSpecList.EMPTY, targetInsn.getTarget()));
                            this.insns.add(i4, targetInsn.withNewTargetAndReversed(codeAddress));
                            size++;
                            i4 = i5;
                        } catch (ClassCastException unused) {
                            throw new IllegalStateException("unpaired TargetInsn");
                        } catch (IndexOutOfBoundsException unused2) {
                            throw new IllegalStateException("unpaired TargetInsn (dangling)");
                        }
                    }
                    z3 = true;
                }
            }
            i4++;
        }
        return z3;
    }

    private static boolean hasLocalInfo(DalvInsn dalvInsn) {
        if (dalvInsn instanceof LocalSnapshot) {
            RegisterSpecSet locals = ((LocalSnapshot) dalvInsn).getLocals();
            int size = locals.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (hasLocalInfo(locals.get(i4))) {
                    return true;
                }
            }
        } else if ((dalvInsn instanceof LocalStart) && hasLocalInfo(((LocalStart) dalvInsn).getLocal())) {
            return true;
        }
        return false;
    }

    private Dop[] makeOpcodesArray() {
        int size = this.insns.size();
        Dop[] dopArr = new Dop[size];
        for (int i4 = 0; i4 < size; i4++) {
            dopArr[i4] = this.insns.get(i4).getOpcode();
        }
        return dopArr;
    }

    private void massageInstructions(Dop[] dopArr) {
        if (this.reservedCount == 0) {
            int size = this.insns.size();
            for (int i4 = 0; i4 < size; i4++) {
                DalvInsn dalvInsn = this.insns.get(i4);
                Dop opcode = dalvInsn.getOpcode();
                Dop dop = dopArr[i4];
                if (opcode != dop) {
                    this.insns.set(i4, dalvInsn.withOpcode(dop));
                }
            }
            return;
        }
        this.insns = performExpansion(dopArr);
    }

    private ArrayList<DalvInsn> performExpansion(Dop[] dopArr) {
        DalvInsn expandedSuffix;
        DalvInsn dalvInsn;
        int size = this.insns.size();
        ArrayList<DalvInsn> arrayList = new ArrayList<>(size * 2);
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < size; i4++) {
            DalvInsn dalvInsn2 = this.insns.get(i4);
            Dop opcode = dalvInsn2.getOpcode();
            Dop dop = dopArr[i4];
            if (dop != null) {
                dalvInsn = null;
                expandedSuffix = null;
            } else {
                dop = findExpandedOpcodeForInsn(dalvInsn2);
                BitSet compatibleRegs = dop.getFormat().compatibleRegs(dalvInsn2);
                DalvInsn expandedPrefix = dalvInsn2.expandedPrefix(compatibleRegs);
                expandedSuffix = dalvInsn2.expandedSuffix(compatibleRegs);
                dalvInsn2 = dalvInsn2.expandedVersion(compatibleRegs);
                dalvInsn = expandedPrefix;
            }
            if (dalvInsn2 instanceof CodeAddress) {
                CodeAddress codeAddress = (CodeAddress) dalvInsn2;
                if (codeAddress.getBindsClosely()) {
                    arrayList2.add(codeAddress);
                }
            }
            if (dalvInsn != null) {
                arrayList.add(dalvInsn);
            }
            if (!(dalvInsn2 instanceof ZeroSizeInsn) && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add((CodeAddress) it.next());
                }
                arrayList2.clear();
            }
            if (dop != opcode) {
                dalvInsn2 = dalvInsn2.withOpcode(dop);
            }
            arrayList.add(dalvInsn2);
            if (expandedSuffix != null) {
                arrayList.add(expandedSuffix);
            }
        }
        return arrayList;
    }

    private boolean reserveRegisters(Dop[] dopArr) {
        int i4 = this.reservedCount;
        if (i4 < 0) {
            i4 = 0;
        }
        boolean z3 = false;
        while (true) {
            int calculateReservedCount = calculateReservedCount(dopArr);
            if (i4 >= calculateReservedCount) {
                this.reservedCount = i4;
                return z3;
            }
            int i5 = calculateReservedCount - i4;
            int size = this.insns.size();
            for (int i6 = 0; i6 < size; i6++) {
                DalvInsn dalvInsn = this.insns.get(i6);
                if (!(dalvInsn instanceof CodeAddress)) {
                    this.insns.set(i6, dalvInsn.withRegisterOffset(i5));
                }
            }
            z3 = true;
            i4 = calculateReservedCount;
        }
    }

    private void shiftAllRegisters(int i4) {
        int size = this.insns.size();
        for (int i5 = 0; i5 < size; i5++) {
            DalvInsn dalvInsn = this.insns.get(i5);
            if (!(dalvInsn instanceof CodeAddress)) {
                this.insns.set(i5, dalvInsn.withRegisterOffset(i4));
            }
        }
    }

    private void shiftParameters(int i4) {
        int size = this.insns.size();
        int i5 = this.unreservedRegCount + this.reservedCount + this.reservedParameterCount;
        int i6 = i5 - this.paramSize;
        BasicRegisterMapper basicRegisterMapper = new BasicRegisterMapper(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 >= i6) {
                basicRegisterMapper.addMapping(i7, i7 + i4, 1);
            } else {
                basicRegisterMapper.addMapping(i7, i7, 1);
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            DalvInsn dalvInsn = this.insns.get(i8);
            if (!(dalvInsn instanceof CodeAddress)) {
                this.insns.set(i8, dalvInsn.withMapper(basicRegisterMapper));
            }
        }
    }

    private void updateInfo(DalvInsn dalvInsn) {
        if (!this.hasAnyPositionInfo && dalvInsn.getPosition().getLine() >= 0) {
            this.hasAnyPositionInfo = true;
        }
        if (!this.hasAnyLocalInfo && hasLocalInfo(dalvInsn)) {
            this.hasAnyLocalInfo = true;
        }
    }

    public void add(DalvInsn dalvInsn) {
        this.insns.add(dalvInsn);
        updateInfo(dalvInsn);
    }

    public void assignIndices(DalvCode.AssignIndicesCallback assignIndicesCallback) {
        Iterator<DalvInsn> it = this.insns.iterator();
        while (it.hasNext()) {
            DalvInsn next = it.next();
            if (next instanceof CstInsn) {
                assignIndices((CstInsn) next, assignIndicesCallback);
            }
        }
    }

    public DalvInsnList finishProcessingAndGetList() {
        if (this.reservedCount < 0) {
            Dop[] makeOpcodesArray = makeOpcodesArray();
            reserveRegisters(makeOpcodesArray);
            if (this.dexOptions.ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER) {
                align64bits(makeOpcodesArray);
            }
            massageInstructions(makeOpcodesArray);
            assignAddressesAndFixBranches();
            return DalvInsnList.makeImmutable(this.insns, this.reservedCount + this.unreservedRegCount + this.reservedParameterCount);
        }
        throw new UnsupportedOperationException("already processed");
    }

    public HashSet<Constant> getAllConstants() {
        HashSet<Constant> hashSet = new HashSet<>(20);
        Iterator<DalvInsn> it = this.insns.iterator();
        while (it.hasNext()) {
            addConstants(hashSet, it.next());
        }
        return hashSet;
    }

    public boolean hasAnyLocalInfo() {
        return this.hasAnyLocalInfo;
    }

    public boolean hasAnyPositionInfo() {
        return this.hasAnyPositionInfo;
    }

    public void insert(int i4, DalvInsn dalvInsn) {
        this.insns.add(i4, dalvInsn);
        updateInfo(dalvInsn);
    }

    public void reverseBranch(int i4, CodeAddress codeAddress) {
        int size = (this.insns.size() - i4) - 1;
        try {
            this.insns.set(size, ((TargetInsn) this.insns.get(size)).withNewTargetAndReversed(codeAddress));
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("non-reversible instruction");
        } catch (IndexOutOfBoundsException unused2) {
            throw new IllegalArgumentException("too few instructions");
        }
    }

    private static void assignIndices(CstInsn cstInsn, DalvCode.AssignIndicesCallback assignIndicesCallback) {
        int index;
        Constant constant = cstInsn.getConstant();
        int index2 = assignIndicesCallback.getIndex(constant);
        if (index2 >= 0) {
            cstInsn.setIndex(index2);
        }
        if (!(constant instanceof CstMemberRef) || (index = assignIndicesCallback.getIndex(((CstMemberRef) constant).getDefiningClass())) < 0) {
            return;
        }
        cstInsn.setClassIndex(index);
    }

    private static boolean hasLocalInfo(RegisterSpec registerSpec) {
        return (registerSpec == null || registerSpec.getLocalItem().getName() == null) ? false : true;
    }

    private static void addConstants(HashSet<Constant> hashSet, RegisterSpec registerSpec) {
        if (registerSpec == null) {
            return;
        }
        LocalItem localItem = registerSpec.getLocalItem();
        CstString name = localItem.getName();
        CstString signature = localItem.getSignature();
        Type type = registerSpec.getType();
        if (type != Type.KNOWN_NULL) {
            hashSet.add(CstType.intern(type));
        }
        if (name != null) {
            hashSet.add(name);
        }
        if (signature != null) {
            hashSet.add(signature);
        }
    }
}
