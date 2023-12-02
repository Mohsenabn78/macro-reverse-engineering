package com.android.dx;

import com.android.dx.DexMaker;
import com.android.dx.rop.code.BasicBlockList;
import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.PlainCstInsn;
import com.android.dx.rop.code.PlainInsn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.code.ThrowingInsn;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Code {
    private final List<Label> catchLabels;
    private final List<TypeId<?>> catchTypes;
    private StdTypeList catches;
    private Label currentLabel;
    private final List<Label> labels = new ArrayList();
    private final List<Local<?>> locals;
    private boolean localsInitialized;
    private final MethodId<?, ?> method;
    private final List<Local<?>> parameters;
    private SourcePosition sourcePosition;
    private final Local<?> thisLocal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Code(DexMaker.MethodDeclaration methodDeclaration) {
        ArrayList arrayList = new ArrayList();
        this.parameters = arrayList;
        this.locals = new ArrayList();
        this.sourcePosition = SourcePosition.NO_INFO;
        this.catchTypes = new ArrayList();
        this.catchLabels = new ArrayList();
        this.catches = StdTypeList.EMPTY;
        MethodId<?, ?> methodId = methodDeclaration.method;
        this.method = methodId;
        if (methodDeclaration.isStatic()) {
            this.thisLocal = null;
        } else {
            Local<?> local = Local.get(this, methodId.declaringType);
            this.thisLocal = local;
            arrayList.add(local);
        }
        TypeId<?>[] typeIdArr = methodId.parameters.types;
        for (TypeId<?> typeId : typeIdArr) {
            this.parameters.add(Local.get(this, typeId));
        }
        Label label = new Label();
        this.currentLabel = label;
        adopt(label);
        this.currentLabel.marked = true;
    }

    private void addInstruction(Insn insn) {
        addInstruction(insn, null);
    }

    private void adopt(Label label) {
        Code code = label.code;
        if (code == this) {
            return;
        }
        if (code == null) {
            label.code = this;
            this.labels.add(label);
            return;
        }
        throw new IllegalArgumentException("Cannot adopt label; it belongs to another Code");
    }

    private void cleanUpLabels() {
        Iterator<Label> it = this.labels.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Label next = it.next();
            if (next.isEmpty()) {
                it.remove();
            } else {
                next.compact();
                next.id = i4;
                i4++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> Local<T> coerce(Local<?> local, TypeId<T> typeId) {
        if (local.type.equals(typeId)) {
            return local;
        }
        throw new IllegalArgumentException("requested " + typeId + " but was " + local.type);
    }

    private static RegisterSpecList concatenate(Local<?> local, Local<?>[] localArr) {
        int i4;
        if (local != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        RegisterSpecList registerSpecList = new RegisterSpecList(localArr.length + i4);
        if (local != null) {
            registerSpecList.set(0, local.spec());
        }
        for (int i5 = 0; i5 < localArr.length; i5++) {
            registerSpecList.set(i5 + i4, localArr[i5].spec());
        }
        return registerSpecList;
    }

    private Rop getCastRop(Type type, Type type2) {
        if (type.getBasicType() == 6) {
            int basicType = type2.getBasicType();
            if (basicType != 2) {
                if (basicType != 3) {
                    if (basicType == 8) {
                        return Rops.TO_SHORT;
                    }
                } else {
                    return Rops.TO_CHAR;
                }
            } else {
                return Rops.TO_BYTE;
            }
        }
        return Rops.opConv(type2, type);
    }

    private <D, R> void invoke(Rop rop, MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        addInstruction(new ThrowingCstInsn(rop, this.sourcePosition, concatenate(local2, localArr), this.catches, methodId.constant));
        if (local != null) {
            moveResult(local, false);
        }
    }

    private void moveResult(Local<?> local, boolean z3) {
        Rop opMoveResult;
        if (z3) {
            opMoveResult = Rops.opMoveResultPseudo(local.type.ropType);
        } else {
            opMoveResult = Rops.opMoveResult(local.type.ropType);
        }
        addInstruction(new PlainInsn(opMoveResult, this.sourcePosition, local.spec(), RegisterSpecList.EMPTY));
    }

    private void splitCurrentLabel(Label label, List<Label> list) {
        Label label2 = new Label();
        adopt(label2);
        Label label3 = this.currentLabel;
        label3.primarySuccessor = label2;
        label3.alternateSuccessor = label;
        label3.catchLabels = list;
        this.currentLabel = label2;
        label2.marked = true;
    }

    private StdTypeList toTypeList(List<TypeId<?>> list) {
        StdTypeList stdTypeList = new StdTypeList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            stdTypeList.set(i4, list.get(i4).ropType);
        }
        return stdTypeList;
    }

    public void addCatchClause(TypeId<? extends Throwable> typeId, Label label) {
        if (!this.catchTypes.contains(typeId)) {
            adopt(label);
            this.catchTypes.add(typeId);
            this.catches = toTypeList(this.catchTypes);
            this.catchLabels.add(label);
            return;
        }
        throw new IllegalArgumentException("Already caught: " + typeId);
    }

    public void aget(Local<?> local, Local<?> local2, Local<Integer> local3) {
        addInstruction(new ThrowingInsn(Rops.opAget(local.type.ropType), this.sourcePosition, RegisterSpecList.make(local2.spec(), local3.spec()), this.catches));
        moveResult(local, true);
    }

    public void aput(Local<?> local, Local<Integer> local2, Local<?> local3) {
        addInstruction(new ThrowingInsn(Rops.opAput(local3.type.ropType), this.sourcePosition, RegisterSpecList.make(local3.spec(), local.spec(), local2.spec()), this.catches));
    }

    public <T> void arrayLength(Local<Integer> local, Local<T> local2) {
        addInstruction(new ThrowingInsn(Rops.ARRAY_LENGTH, this.sourcePosition, RegisterSpecList.make(local2.spec()), this.catches));
        moveResult(local, true);
    }

    public void cast(Local<?> local, Local<?> local2) {
        if (local2.getType().ropType.isReference()) {
            addInstruction(new ThrowingCstInsn(Rops.CHECK_CAST, this.sourcePosition, RegisterSpecList.make(local2.spec()), this.catches, local.type.constant));
            moveResult(local, true);
            return;
        }
        addInstruction(new PlainInsn(getCastRop(local2.type.ropType, local.type.ropType), this.sourcePosition, local.spec(), local2.spec()));
    }

    public <T> void compare(Comparison comparison, Label label, Local<T> local, Local<T> local2) {
        adopt(label);
        addInstruction(new PlainInsn(comparison.rop(StdTypeList.make(local.type.ropType, local2.type.ropType)), this.sourcePosition, (RegisterSpec) null, RegisterSpecList.make(local.spec(), local2.spec())), label);
    }

    public <T extends Number> void compareFloatingPoint(Local<Integer> local, Local<T> local2, Local<T> local3, int i4) {
        Rop opCmpl;
        if (i4 == 1) {
            opCmpl = Rops.opCmpg(local2.type.ropType);
        } else if (i4 == -1) {
            opCmpl = Rops.opCmpl(local2.type.ropType);
        } else {
            throw new IllegalArgumentException("expected 1 or -1 but was " + i4);
        }
        addInstruction(new PlainInsn(opCmpl, this.sourcePosition, local.spec(), RegisterSpecList.make(local2.spec(), local3.spec())));
    }

    public void compareLongs(Local<Integer> local, Local<Long> local2, Local<Long> local3) {
        addInstruction(new PlainInsn(Rops.CMPL_LONG, this.sourcePosition, local.spec(), RegisterSpecList.make(local2.spec(), local3.spec())));
    }

    public <T> void compareZ(Comparison comparison, Label label, Local<?> local) {
        adopt(label);
        addInstruction(new PlainInsn(comparison.rop(StdTypeList.make(local.type.ropType)), this.sourcePosition, (RegisterSpec) null, RegisterSpecList.make(local.spec())), label);
    }

    public <T> Local<T> getParameter(int i4, TypeId<T> typeId) {
        if (this.thisLocal != null) {
            i4++;
        }
        return coerce(this.parameters.get(i4), typeId);
    }

    public <T> Local<T> getThis(TypeId<T> typeId) {
        Local<?> local = this.thisLocal;
        if (local != null) {
            return coerce(local, typeId);
        }
        throw new IllegalStateException("static methods cannot access 'this'");
    }

    public <D, V> void iget(FieldId<D, ? extends V> fieldId, Local<V> local, Local<D> local2) {
        addInstruction(new ThrowingCstInsn(Rops.opGetField(local.type.ropType), this.sourcePosition, RegisterSpecList.make(local2.spec()), this.catches, fieldId.constant));
        moveResult(local, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initializeLocals() {
        if (!this.localsInitialized) {
            this.localsInitialized = true;
            int i4 = 0;
            for (Local<?> local : this.locals) {
                i4 += local.initialize(i4);
            }
            ArrayList arrayList = new ArrayList();
            int i5 = i4;
            for (Local<?> local2 : this.parameters) {
                CstInteger make = CstInteger.make(i5 - i4);
                i5 += local2.initialize(i5);
                arrayList.add(new PlainCstInsn(Rops.opMoveParam(local2.type.ropType), this.sourcePosition, local2.spec(), RegisterSpecList.EMPTY, make));
            }
            this.labels.get(0).instructions.addAll(0, arrayList);
            return;
        }
        throw new AssertionError();
    }

    public void instanceOfType(Local<?> local, Local<?> local2, TypeId<?> typeId) {
        addInstruction(new ThrowingCstInsn(Rops.INSTANCE_OF, this.sourcePosition, RegisterSpecList.make(local2.spec()), this.catches, typeId.constant));
        moveResult(local, true);
    }

    public <D, R> void invokeDirect(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        invoke(Rops.opInvokeDirect(methodId.prototype(true)), methodId, local, local2, localArr);
    }

    public <D, R> void invokeInterface(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        invoke(Rops.opInvokeInterface(methodId.prototype(true)), methodId, local, local2, localArr);
    }

    public <R> void invokeStatic(MethodId<?, R> methodId, Local<? super R> local, Local<?>... localArr) {
        invoke(Rops.opInvokeStatic(methodId.prototype(true)), methodId, local, null, localArr);
    }

    public <D, R> void invokeSuper(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        invoke(Rops.opInvokeSuper(methodId.prototype(true)), methodId, local, local2, localArr);
    }

    public <D, R> void invokeVirtual(MethodId<D, R> methodId, Local<? super R> local, Local<? extends D> local2, Local<?>... localArr) {
        invoke(Rops.opInvokeVirtual(methodId.prototype(true)), methodId, local, local2, localArr);
    }

    public <D, V> void iput(FieldId<D, V> fieldId, Local<? extends D> local, Local<? extends V> local2) {
        addInstruction(new ThrowingCstInsn(Rops.opPutField(local2.type.ropType), this.sourcePosition, RegisterSpecList.make(local2.spec(), local.spec()), this.catches, fieldId.constant));
    }

    public void jump(Label label) {
        adopt(label);
        addInstruction(new PlainInsn(Rops.GOTO, this.sourcePosition, (RegisterSpec) null, RegisterSpecList.EMPTY), label);
    }

    public <T> void loadConstant(Local<T> local, T t3) {
        Rop opConst;
        if (t3 == null) {
            opConst = Rops.CONST_OBJECT_NOTHROW;
        } else {
            opConst = Rops.opConst(local.type.ropType);
        }
        Rop rop = opConst;
        if (rop.getBranchingness() == 1) {
            addInstruction(new PlainCstInsn(rop, this.sourcePosition, local.spec(), RegisterSpecList.EMPTY, Constants.getConstant(t3)));
            return;
        }
        addInstruction(new ThrowingCstInsn(rop, this.sourcePosition, RegisterSpecList.EMPTY, this.catches, Constants.getConstant(t3)));
        moveResult(local, true);
    }

    public void mark(Label label) {
        adopt(label);
        if (!label.marked) {
            label.marked = true;
            if (this.currentLabel != null) {
                jump(label);
            }
            this.currentLabel = label;
            return;
        }
        throw new IllegalStateException("already marked");
    }

    public void monitorEnter(Local<?> local) {
        addInstruction(new ThrowingInsn(Rops.MONITOR_ENTER, this.sourcePosition, RegisterSpecList.make(local.spec()), this.catches));
    }

    public void monitorExit(Local<?> local) {
        addInstruction(new ThrowingInsn(Rops.MONITOR_EXIT, this.sourcePosition, RegisterSpecList.make(local.spec()), this.catches));
    }

    public <T> void move(Local<T> local, Local<T> local2) {
        addInstruction(new PlainInsn(Rops.opMove(local2.type.ropType), this.sourcePosition, local.spec(), local2.spec()));
    }

    public <T> void newArray(Local<T> local, Local<Integer> local2) {
        addInstruction(new ThrowingCstInsn(Rops.opNewArray(local.type.ropType), this.sourcePosition, RegisterSpecList.make(local2.spec()), this.catches, local.type.constant));
        moveResult(local, true);
    }

    public <T> void newInstance(Local<T> local, MethodId<T, Void> methodId, Local<?>... localArr) {
        if (local != null) {
            addInstruction(new ThrowingCstInsn(Rops.NEW_INSTANCE, this.sourcePosition, RegisterSpecList.EMPTY, this.catches, methodId.declaringType.constant));
            moveResult(local, true);
            invokeDirect(methodId, null, local, localArr);
            return;
        }
        throw new IllegalArgumentException();
    }

    public <T> Local<T> newLocal(TypeId<T> typeId) {
        if (!this.localsInitialized) {
            Local<T> local = Local.get(this, typeId);
            this.locals.add(local);
            return local;
        }
        throw new IllegalStateException("Cannot allocate locals after adding instructions");
    }

    public <T> void op(UnaryOp unaryOp, Local<T> local, Local<T> local2) {
        addInstruction(new PlainInsn(unaryOp.rop(local2.type), this.sourcePosition, local.spec(), local2.spec()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int paramSize() {
        int i4 = 0;
        for (Local<?> local : this.parameters) {
            i4 += local.size();
        }
        return i4;
    }

    public Label removeCatchClause(TypeId<? extends Throwable> typeId) {
        int indexOf = this.catchTypes.indexOf(typeId);
        if (indexOf != -1) {
            this.catchTypes.remove(indexOf);
            this.catches = toTypeList(this.catchTypes);
            return this.catchLabels.remove(indexOf);
        }
        throw new IllegalArgumentException("No catch clause: " + typeId);
    }

    public void returnValue(Local<?> local) {
        if (local.type.equals(this.method.returnType)) {
            addInstruction(new PlainInsn(Rops.opReturn(local.type.ropType), this.sourcePosition, (RegisterSpec) null, RegisterSpecList.make(local.spec())));
            return;
        }
        throw new IllegalArgumentException("declared " + this.method.returnType + " but returned " + local.type);
    }

    public void returnVoid() {
        if (this.method.returnType.equals(TypeId.VOID)) {
            addInstruction(new PlainInsn(Rops.RETURN_VOID, this.sourcePosition, (RegisterSpec) null, RegisterSpecList.EMPTY));
            return;
        }
        throw new IllegalArgumentException("declared " + this.method.returnType + " but returned void");
    }

    public <V> void sget(FieldId<?, ? extends V> fieldId, Local<V> local) {
        addInstruction(new ThrowingCstInsn(Rops.opGetStatic(local.type.ropType), this.sourcePosition, RegisterSpecList.EMPTY, this.catches, fieldId.constant));
        moveResult(local, true);
    }

    public <V> void sput(FieldId<?, V> fieldId, Local<? extends V> local) {
        addInstruction(new ThrowingCstInsn(Rops.opPutStatic(local.type.ropType), this.sourcePosition, RegisterSpecList.make(local.spec()), this.catches, fieldId.constant));
    }

    public void throwValue(Local<? extends Throwable> local) {
        addInstruction(new ThrowingInsn(Rops.THROW, this.sourcePosition, RegisterSpecList.make(local.spec()), this.catches));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicBlockList toBasicBlocks() {
        if (!this.localsInitialized) {
            initializeLocals();
        }
        cleanUpLabels();
        BasicBlockList basicBlockList = new BasicBlockList(this.labels.size());
        for (int i4 = 0; i4 < this.labels.size(); i4++) {
            basicBlockList.set(i4, this.labels.get(i4).toBasicBlock());
        }
        return basicBlockList;
    }

    private void addInstruction(Insn insn, Label label) {
        Label label2 = this.currentLabel;
        if (label2 != null && label2.marked) {
            label2.instructions.add(insn);
            int branchingness = insn.getOpcode().getBranchingness();
            if (branchingness == 1) {
                if (label == null) {
                    return;
                }
                throw new IllegalArgumentException("unexpected branch: " + label);
            } else if (branchingness == 2) {
                if (label == null) {
                    this.currentLabel = null;
                    return;
                }
                throw new IllegalArgumentException("unexpected branch: " + label);
            } else if (branchingness == 3) {
                if (label != null) {
                    this.currentLabel.primarySuccessor = label;
                    this.currentLabel = null;
                    return;
                }
                throw new IllegalArgumentException("branch == null");
            } else if (branchingness == 4) {
                if (label != null) {
                    splitCurrentLabel(label, Collections.emptyList());
                    return;
                }
                throw new IllegalArgumentException("branch == null");
            } else if (branchingness != 6) {
                throw new IllegalArgumentException();
            } else {
                if (label == null) {
                    splitCurrentLabel(null, new ArrayList(this.catchLabels));
                    return;
                }
                throw new IllegalArgumentException("unexpected branch: " + label);
            }
        }
        throw new IllegalStateException("no current label");
    }

    public <T1, T2> void op(BinaryOp binaryOp, Local<T1> local, Local<T1> local2, Local<T2> local3) {
        Rop rop = binaryOp.rop(StdTypeList.make(local2.type.ropType, local3.type.ropType));
        RegisterSpecList make = RegisterSpecList.make(local2.spec(), local3.spec());
        if (rop.getBranchingness() == 1) {
            addInstruction(new PlainInsn(rop, this.sourcePosition, local.spec(), make));
            return;
        }
        addInstruction(new ThrowingInsn(rop, this.sourcePosition, make, this.catches));
        moveResult(local, true);
    }
}
