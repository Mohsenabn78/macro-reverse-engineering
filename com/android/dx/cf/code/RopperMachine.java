package com.android.dx.cf.code;

import com.android.dx.cf.iface.Method;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import java.util.ArrayList;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RopperMachine extends ValueAwareMachine {
    private static final CstType ARRAY_REFLECT_TYPE;
    private static final CstMethodRef MULTIANEWARRAY_METHOD;
    private final TranslationAdvice advice;
    private boolean blockCanThrow;
    private TypeList catches;
    private boolean catchesUsed;
    private int extraBlockCount;
    private boolean hasJsr;
    private final ArrayList<Insn> insns;
    private final int maxLocals;
    private final ConcreteMethod method;
    private final MethodList methods;
    private int primarySuccessorIndex;
    private ReturnAddress returnAddress;
    private Rop returnOp;
    private SourcePosition returnPosition;
    private boolean returns;
    private final Ropper ropper;

    static {
        CstType cstType = new CstType(Type.internClassName("java/lang/reflect/Array"));
        ARRAY_REFLECT_TYPE = cstType;
        MULTIANEWARRAY_METHOD = new CstMethodRef(cstType, new CstNat(new CstString(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME), new CstString("(Ljava/lang/Class;[I)Ljava/lang/Object;")));
    }

    public RopperMachine(Ropper ropper, ConcreteMethod concreteMethod, TranslationAdvice translationAdvice, MethodList methodList) {
        super(concreteMethod.getEffectiveDescriptor());
        if (methodList != null) {
            if (ropper != null) {
                if (translationAdvice != null) {
                    this.ropper = ropper;
                    this.method = concreteMethod;
                    this.methods = methodList;
                    this.advice = translationAdvice;
                    this.maxLocals = concreteMethod.getMaxLocals();
                    this.insns = new ArrayList<>(25);
                    this.catches = null;
                    this.catchesUsed = false;
                    this.returns = false;
                    this.primarySuccessorIndex = -1;
                    this.extraBlockCount = 0;
                    this.blockCanThrow = false;
                    this.returnOp = null;
                    this.returnPosition = null;
                    return;
                }
                throw new NullPointerException("advice == null");
            }
            throw new NullPointerException("ropper == null");
        }
        throw new NullPointerException("methods == null");
    }

    private RegisterSpecList getSources(int i4, int i5) {
        RegisterSpecList registerSpecList;
        int argCount = argCount();
        if (argCount == 0) {
            return RegisterSpecList.EMPTY;
        }
        int localIndex = getLocalIndex();
        if (localIndex >= 0) {
            registerSpecList = new RegisterSpecList(1);
            registerSpecList.set(0, RegisterSpec.make(localIndex, arg(0)));
        } else {
            RegisterSpecList registerSpecList2 = new RegisterSpecList(argCount);
            for (int i6 = 0; i6 < argCount; i6++) {
                RegisterSpec make = RegisterSpec.make(i5, arg(i6));
                registerSpecList2.set(i6, make);
                i5 += make.getCategory();
            }
            if (i4 != 79) {
                if (i4 == 181) {
                    if (argCount == 2) {
                        RegisterSpec registerSpec = registerSpecList2.get(0);
                        registerSpecList2.set(0, registerSpecList2.get(1));
                        registerSpecList2.set(1, registerSpec);
                    } else {
                        throw new RuntimeException("shouldn't happen");
                    }
                }
            } else if (argCount == 3) {
                RegisterSpec registerSpec2 = registerSpecList2.get(0);
                RegisterSpec registerSpec3 = registerSpecList2.get(1);
                registerSpecList2.set(0, registerSpecList2.get(2));
                registerSpecList2.set(1, registerSpec2);
                registerSpecList2.set(2, registerSpec3);
            } else {
                throw new RuntimeException("shouldn't happen");
            }
            registerSpecList = registerSpecList2;
        }
        registerSpecList.setImmutable();
        return registerSpecList;
    }

    private int jopToRopOpcode(int i4, Constant constant) {
        if (i4 != 0) {
            if (i4 != 20) {
                if (i4 != 21) {
                    if (i4 != 171) {
                        if (i4 != 172) {
                            if (i4 != 198) {
                                if (i4 == 199) {
                                    return 8;
                                }
                                switch (i4) {
                                    case 0:
                                        return 1;
                                    case 18:
                                        return 5;
                                    case 46:
                                        return 38;
                                    case 54:
                                        return 2;
                                    case 79:
                                        return 39;
                                    case 96:
                                        return 14;
                                    case 100:
                                        return 15;
                                    case 104:
                                        return 16;
                                    case 108:
                                        return 17;
                                    case 112:
                                        return 18;
                                    case 116:
                                        return 19;
                                    case 120:
                                        return 23;
                                    case 122:
                                        return 24;
                                    case 124:
                                        return 25;
                                    case 126:
                                        return 20;
                                    case 128:
                                        return 21;
                                    case 130:
                                        return 22;
                                    default:
                                        switch (i4) {
                                            case 132:
                                                return 14;
                                            case 133:
                                            case 134:
                                            case 135:
                                            case 136:
                                            case 137:
                                            case 138:
                                            case 139:
                                            case 140:
                                            case 141:
                                            case 142:
                                            case 143:
                                            case 144:
                                                return 29;
                                            case 145:
                                                return 30;
                                            case 146:
                                                return 31;
                                            case 147:
                                                return 32;
                                            case 148:
                                            case 149:
                                            case 151:
                                                return 27;
                                            case 150:
                                            case 152:
                                                return 28;
                                            case 153:
                                            case 159:
                                            case 165:
                                                return 7;
                                            case 154:
                                            case 160:
                                            case 166:
                                                return 8;
                                            case 155:
                                            case 161:
                                                return 9;
                                            case 156:
                                            case 162:
                                                return 10;
                                            case 157:
                                            case 163:
                                                return 12;
                                            case 158:
                                            case 164:
                                                return 11;
                                            case 167:
                                                return 6;
                                            default:
                                                switch (i4) {
                                                    case 177:
                                                        return 33;
                                                    case 178:
                                                        return 46;
                                                    case 179:
                                                        return 48;
                                                    case 180:
                                                        return 45;
                                                    case 181:
                                                        return 47;
                                                    case 182:
                                                        CstMethodRef cstMethodRef = (CstMethodRef) constant;
                                                        if (cstMethodRef.getDefiningClass().equals(this.method.getDefiningClass())) {
                                                            for (int i5 = 0; i5 < this.methods.size(); i5++) {
                                                                Method method = this.methods.get(i5);
                                                                if (AccessFlags.isPrivate(method.getAccessFlags()) && cstMethodRef.getNat().equals(method.getNat())) {
                                                                    return 52;
                                                                }
                                                            }
                                                            return 50;
                                                        }
                                                        return 50;
                                                    case 183:
                                                        CstMethodRef cstMethodRef2 = (CstMethodRef) constant;
                                                        if (cstMethodRef2.isInstanceInit() || cstMethodRef2.getDefiningClass().equals(this.method.getDefiningClass()) || !this.method.getAccSuper()) {
                                                            return 52;
                                                        }
                                                        return 51;
                                                    case 184:
                                                        return 49;
                                                    case 185:
                                                        return 53;
                                                    default:
                                                        switch (i4) {
                                                            case 187:
                                                                return 40;
                                                            case 188:
                                                            case 189:
                                                                return 41;
                                                            case 190:
                                                                return 34;
                                                            case 191:
                                                                return 35;
                                                            case 192:
                                                                return 43;
                                                            case 193:
                                                                return 44;
                                                            case 194:
                                                                return 36;
                                                            case 195:
                                                                return 37;
                                                            default:
                                                                throw new RuntimeException("shouldn't happen");
                                                        }
                                                }
                                        }
                                }
                            }
                            return 7;
                        }
                        return 33;
                    }
                    return 13;
                }
                return 2;
            }
            return 5;
        }
        return 1;
    }

    private void updateReturnOp(Rop rop, SourcePosition sourcePosition) {
        if (rop != null) {
            if (sourcePosition != null) {
                Rop rop2 = this.returnOp;
                if (rop2 == null) {
                    this.returnOp = rop;
                    this.returnPosition = sourcePosition;
                    return;
                } else if (rop2 == rop) {
                    if (sourcePosition.getLine() > this.returnPosition.getLine()) {
                        this.returnPosition = sourcePosition;
                        return;
                    }
                    return;
                } else {
                    throw new SimException("return op mismatch: " + rop + ", " + this.returnOp);
                }
            }
            throw new NullPointerException("pos == null");
        }
        throw new NullPointerException("op == null");
    }

    public boolean canThrow() {
        return this.blockCanThrow;
    }

    public int getExtraBlockCount() {
        return this.extraBlockCount;
    }

    public ArrayList<Insn> getInsns() {
        return this.insns;
    }

    public int getPrimarySuccessorIndex() {
        return this.primarySuccessorIndex;
    }

    public ReturnAddress getReturnAddress() {
        return this.returnAddress;
    }

    public Rop getReturnOp() {
        return this.returnOp;
    }

    public SourcePosition getReturnPosition() {
        return this.returnPosition;
    }

    public boolean hasJsr() {
        return this.hasJsr;
    }

    public boolean hasRet() {
        if (this.returnAddress != null) {
            return true;
        }
        return false;
    }

    public boolean returns() {
        return this.returns;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0285  */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.android.dx.rop.code.Insn, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // com.android.dx.cf.code.ValueAwareMachine, com.android.dx.cf.code.Machine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run(com.android.dx.cf.code.Frame r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.cf.code.RopperMachine.run(com.android.dx.cf.code.Frame, int, int):void");
    }

    public void startBlock(TypeList typeList) {
        this.catches = typeList;
        this.insns.clear();
        this.catchesUsed = false;
        this.returns = false;
        this.primarySuccessorIndex = 0;
        this.extraBlockCount = 0;
        this.blockCanThrow = false;
        this.hasJsr = false;
        this.returnAddress = null;
    }

    public boolean wereCatchesUsed() {
        return this.catchesUsed;
    }
}
