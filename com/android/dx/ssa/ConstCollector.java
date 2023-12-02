package com.android.dx.ssa;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.TypeBearer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConstCollector {
    private static boolean COLLECT_ONE_LOCAL = false;
    private static boolean COLLECT_STRINGS = false;
    private static final int MAX_COLLECTED_CONSTANTS = 5;
    private final SsaMethod ssaMeth;

    private ConstCollector(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
    }

    private void fixLocalAssignment(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        for (SsaInsn ssaInsn : this.ssaMeth.getUseListForRegister(registerSpec.getReg())) {
            RegisterSpec localAssignment = ssaInsn.getLocalAssignment();
            if (localAssignment != null && ssaInsn.getResult() != null) {
                LocalItem localItem = localAssignment.getLocalItem();
                ssaInsn.setResultLocal(null);
                registerSpec2 = registerSpec2.withLocalItem(localItem);
                SsaInsn makeFromRop = SsaInsn.makeFromRop(new PlainInsn(Rops.opMarkLocal(registerSpec2), SourcePosition.NO_INFO, (RegisterSpec) null, RegisterSpecList.make(registerSpec2)), ssaInsn.getBlock());
                ArrayList<SsaInsn> insns = ssaInsn.getBlock().getInsns();
                insns.add(insns.indexOf(ssaInsn) + 1, makeFromRop);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<TypedConstant> getConstsSortedByCountUse() {
        int regCount = this.ssaMeth.getRegCount();
        final HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < regCount; i4++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i4);
            if (definitionForRegister != null && definitionForRegister.getOpcode() != null) {
                RegisterSpec result = definitionForRegister.getResult();
                TypeBearer typeBearer = result.getTypeBearer();
                if (typeBearer.isConstant()) {
                    TypedConstant typedConstant = (TypedConstant) typeBearer;
                    if (definitionForRegister.getOpcode().getOpcode() == 56) {
                        ArrayList<SsaInsn> insns = this.ssaMeth.getBlocks().get(definitionForRegister.getBlock().getPredecessors().nextSetBit(0)).getInsns();
                        definitionForRegister = insns.get(insns.size() - 1);
                    }
                    if (!definitionForRegister.canThrow() || ((typedConstant instanceof CstString) && COLLECT_STRINGS && definitionForRegister.getBlock().getSuccessors().cardinality() <= 1)) {
                        if (this.ssaMeth.isRegALocal(result)) {
                            if (COLLECT_ONE_LOCAL && !hashSet.contains(typedConstant)) {
                                hashSet.add(typedConstant);
                            }
                        }
                        Integer num = (Integer) hashMap.get(typedConstant);
                        if (num == null) {
                            hashMap.put(typedConstant, 1);
                        } else {
                            hashMap.put(typedConstant, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            }
        }
        ArrayList<TypedConstant> arrayList = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > 1) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList, new Comparator<Constant>() { // from class: com.android.dx.ssa.ConstCollector.1
            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Comparator
            public int compare(Constant constant, Constant constant2) {
                int intValue = ((Integer) hashMap.get(constant2)).intValue() - ((Integer) hashMap.get(constant)).intValue();
                return intValue == 0 ? constant.compareTo(constant2) : intValue;
            }
        });
        return arrayList;
    }

    public static void process(SsaMethod ssaMethod) {
        new ConstCollector(ssaMethod).run();
    }

    private void run() {
        ArrayList<TypedConstant> arrayList;
        int i4;
        SsaBasicBlock ssaBasicBlock;
        int regCount = this.ssaMeth.getRegCount();
        ArrayList<TypedConstant> constsSortedByCountUse = getConstsSortedByCountUse();
        int min = Math.min(constsSortedByCountUse.size(), 5);
        SsaBasicBlock entryBlock = this.ssaMeth.getEntryBlock();
        HashMap<TypedConstant, RegisterSpec> hashMap = new HashMap<>(min);
        int i5 = 0;
        while (i5 < min) {
            TypedConstant typedConstant = constsSortedByCountUse.get(i5);
            RegisterSpec make = RegisterSpec.make(this.ssaMeth.makeNewSsaReg(), typedConstant);
            Rop opConst = Rops.opConst(typedConstant);
            if (opConst.getBranchingness() == 1) {
                entryBlock.addInsnToHead(new PlainCstInsn(Rops.opConst(typedConstant), SourcePosition.NO_INFO, make, RegisterSpecList.EMPTY, typedConstant));
                arrayList = constsSortedByCountUse;
                i4 = min;
                ssaBasicBlock = entryBlock;
            } else {
                SsaBasicBlock entryBlock2 = this.ssaMeth.getEntryBlock();
                SsaBasicBlock primarySuccessor = entryBlock2.getPrimarySuccessor();
                SsaBasicBlock insertNewSuccessor = entryBlock2.insertNewSuccessor(primarySuccessor);
                SourcePosition sourcePosition = SourcePosition.NO_INFO;
                RegisterSpecList registerSpecList = RegisterSpecList.EMPTY;
                arrayList = constsSortedByCountUse;
                i4 = min;
                ssaBasicBlock = entryBlock;
                insertNewSuccessor.replaceLastInsn(new ThrowingCstInsn(opConst, sourcePosition, registerSpecList, StdTypeList.EMPTY, typedConstant));
                insertNewSuccessor.insertNewSuccessor(primarySuccessor).addInsnToHead(new PlainInsn(Rops.opMoveResultPseudo(make.getTypeBearer()), sourcePosition, make, registerSpecList));
            }
            hashMap.put(typedConstant, make);
            i5++;
            entryBlock = ssaBasicBlock;
            constsSortedByCountUse = arrayList;
            min = i4;
        }
        updateConstUses(hashMap, regCount);
    }

    private void updateConstUses(HashMap<TypedConstant, RegisterSpec> hashMap, int i4) {
        TypedConstant typedConstant;
        final RegisterSpec registerSpec;
        HashSet hashSet = new HashSet();
        ArrayList<SsaInsn>[] useListCopy = this.ssaMeth.getUseListCopy();
        for (int i5 = 0; i5 < i4; i5++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i5);
            if (definitionForRegister != null) {
                final RegisterSpec result = definitionForRegister.getResult();
                TypeBearer typeBearer = definitionForRegister.getResult().getTypeBearer();
                if (typeBearer.isConstant() && (registerSpec = hashMap.get((typedConstant = (TypedConstant) typeBearer))) != null) {
                    if (this.ssaMeth.isRegALocal(result)) {
                        if (COLLECT_ONE_LOCAL && !hashSet.contains(typedConstant)) {
                            hashSet.add(typedConstant);
                            fixLocalAssignment(result, hashMap.get(typedConstant));
                        }
                    }
                    RegisterMapper registerMapper = new RegisterMapper() { // from class: com.android.dx.ssa.ConstCollector.2
                        @Override // com.android.dx.ssa.RegisterMapper
                        public int getNewRegisterCount() {
                            return ConstCollector.this.ssaMeth.getRegCount();
                        }

                        @Override // com.android.dx.ssa.RegisterMapper
                        public RegisterSpec map(RegisterSpec registerSpec2) {
                            if (registerSpec2.getReg() == result.getReg()) {
                                return registerSpec.withLocalItem(registerSpec2.getLocalItem());
                            }
                            return registerSpec2;
                        }
                    };
                    Iterator<SsaInsn> it = useListCopy[result.getReg()].iterator();
                    while (it.hasNext()) {
                        SsaInsn next = it.next();
                        if (!next.canThrow() || next.getBlock().getSuccessors().cardinality() <= 1) {
                            next.mapSourceRegisters(registerMapper);
                        }
                    }
                }
            }
        }
    }
}
