package com.android.dx.cf.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class BaseMachine implements Machine {
    private int argCount;
    private TypeBearer[] args;
    private SwitchList auxCases;
    private Constant auxCst;
    private ArrayList<Constant> auxInitValues;
    private int auxInt;
    private int auxTarget;
    private Type auxType;
    private int localIndex;
    private boolean localInfo;
    private RegisterSpec localTarget;
    private final Prototype prototype;
    private int resultCount;
    private TypeBearer[] results;

    public BaseMachine(Prototype prototype) {
        if (prototype != null) {
            this.prototype = prototype;
            this.args = new TypeBearer[10];
            this.results = new TypeBearer[6];
            clearArgs();
            return;
        }
        throw new NullPointerException("prototype == null");
    }

    public static void throwLocalMismatch(TypeBearer typeBearer, TypeBearer typeBearer2) {
        throw new SimException("local variable type mismatch: attempt to set or access a value of type " + typeBearer.toHuman() + " using a local variable of type " + typeBearer2.toHuman() + ". This is symptomatic of .class transformation tools that ignore local variable information.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addResult(TypeBearer typeBearer) {
        if (typeBearer != null) {
            TypeBearer[] typeBearerArr = this.results;
            int i4 = this.resultCount;
            typeBearerArr[i4] = typeBearer;
            this.resultCount = i4 + 1;
            return;
        }
        throw new NullPointerException("result == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TypeBearer arg(int i4) {
        if (i4 < this.argCount) {
            try {
                return this.args[i4];
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("n < 0");
            }
        }
        throw new IllegalArgumentException("n >= argCount");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int argCount() {
        return this.argCount;
    }

    protected final int argWidth() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.argCount; i5++) {
            i4 += this.args[i5].getType().getCategory();
        }
        return i4;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxCstArg(Constant constant) {
        if (constant != null) {
            this.auxCst = constant;
            return;
        }
        throw new NullPointerException("cst == null");
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxInitValues(ArrayList<Constant> arrayList) {
        this.auxInitValues = arrayList;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxIntArg(int i4) {
        this.auxInt = i4;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxSwitchArg(SwitchList switchList) {
        if (switchList != null) {
            this.auxCases = switchList;
            return;
        }
        throw new NullPointerException("cases == null");
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxTargetArg(int i4) {
        this.auxTarget = i4;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void auxType(Type type) {
        this.auxType = type;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void clearArgs() {
        this.argCount = 0;
        this.auxType = null;
        this.auxInt = 0;
        this.auxCst = null;
        this.auxTarget = 0;
        this.auxCases = null;
        this.auxInitValues = null;
        this.localIndex = -1;
        this.localInfo = false;
        this.localTarget = null;
        this.resultCount = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clearResult() {
        this.resultCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SwitchList getAuxCases() {
        return this.auxCases;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Constant getAuxCst() {
        return this.auxCst;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getAuxInt() {
        return this.auxInt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getAuxTarget() {
        return this.auxTarget;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Type getAuxType() {
        return this.auxType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<Constant> getInitValues() {
        return this.auxInitValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLocalIndex() {
        return this.localIndex;
    }

    protected final boolean getLocalInfo() {
        return this.localInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RegisterSpec getLocalTarget(boolean z3) {
        String str;
        if (this.localTarget == null) {
            return null;
        }
        if (this.resultCount != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("local target with ");
            if (this.resultCount == 0) {
                str = TranslateLanguage.NORWEGIAN;
            } else {
                str = "multiple";
            }
            sb.append(str);
            sb.append(" results");
            throw new SimException(sb.toString());
        }
        TypeBearer typeBearer = this.results[0];
        Type type = typeBearer.getType();
        Type type2 = this.localTarget.getType();
        if (type == type2) {
            if (z3) {
                return this.localTarget.withType(typeBearer);
            }
            return this.localTarget;
        } else if (!Merger.isPossiblyAssignableFrom(type2, type)) {
            throwLocalMismatch(type, type2);
            return null;
        } else {
            if (type2 == Type.OBJECT) {
                this.localTarget = this.localTarget.withType(typeBearer);
            }
            return this.localTarget;
        }
    }

    @Override // com.android.dx.cf.code.Machine
    public Prototype getPrototype() {
        return this.prototype;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void localArg(Frame frame, int i4) {
        clearArgs();
        this.args[0] = frame.getLocals().get(i4);
        this.argCount = 1;
        this.localIndex = i4;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void localInfo(boolean z3) {
        this.localInfo = z3;
    }

    @Override // com.android.dx.cf.code.Machine
    public final void localTarget(int i4, Type type, LocalItem localItem) {
        this.localTarget = RegisterSpec.makeLocalOptional(i4, type, localItem);
    }

    @Override // com.android.dx.cf.code.Machine
    public final void popArgs(Frame frame, int i4) {
        ExecutionStack stack = frame.getStack();
        clearArgs();
        if (i4 > this.args.length) {
            this.args = new TypeBearer[i4 + 10];
        }
        for (int i5 = i4 - 1; i5 >= 0; i5--) {
            this.args[i5] = stack.pop();
        }
        this.argCount = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TypeBearer result(int i4) {
        if (i4 < this.resultCount) {
            try {
                return this.results[i4];
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("n < 0");
            }
        }
        throw new IllegalArgumentException("n >= resultCount");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int resultCount() {
        int i4 = this.resultCount;
        if (i4 >= 0) {
            return i4;
        }
        throw new SimException("results never set");
    }

    protected final int resultWidth() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.resultCount; i5++) {
            i4 += this.results[i5].getType().getCategory();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setResult(TypeBearer typeBearer) {
        if (typeBearer != null) {
            this.results[0] = typeBearer;
            this.resultCount = 1;
            return;
        }
        throw new NullPointerException("result == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void storeResults(Frame frame) {
        int i4 = this.resultCount;
        if (i4 >= 0) {
            if (i4 == 0) {
                return;
            }
            if (this.localTarget != null) {
                frame.getLocals().set(getLocalTarget(false));
                return;
            }
            ExecutionStack stack = frame.getStack();
            for (int i5 = 0; i5 < this.resultCount; i5++) {
                if (this.localInfo) {
                    stack.setLocal();
                }
                stack.push(this.results[i5]);
            }
            return;
        }
        throw new SimException("results never set");
    }

    @Override // com.android.dx.cf.code.Machine
    public void popArgs(Frame frame, Prototype prototype) {
        StdTypeList parameterTypes = prototype.getParameterTypes();
        int size = parameterTypes.size();
        popArgs(frame, size);
        for (int i4 = 0; i4 < size; i4++) {
            if (!Merger.isPossiblyAssignableFrom(parameterTypes.getType(i4), this.args[i4])) {
                throw new SimException("at stack depth " + ((size - 1) - i4) + ", expected type " + parameterTypes.getType(i4).toHuman() + " but found " + this.args[i4].getType().toHuman());
            }
        }
    }

    @Override // com.android.dx.cf.code.Machine
    public final void popArgs(Frame frame, Type type) {
        popArgs(frame, 1);
        if (Merger.isPossiblyAssignableFrom(type, this.args[0])) {
            return;
        }
        throw new SimException("expected type " + type.toHuman() + " but found " + this.args[0].getType().toHuman());
    }

    @Override // com.android.dx.cf.code.Machine
    public final void popArgs(Frame frame, Type type, Type type2) {
        popArgs(frame, 2);
        if (Merger.isPossiblyAssignableFrom(type, this.args[0])) {
            if (Merger.isPossiblyAssignableFrom(type2, this.args[1])) {
                return;
            }
            throw new SimException("expected type " + type2.toHuman() + " but found " + this.args[1].getType().toHuman());
        }
        throw new SimException("expected type " + type.toHuman() + " but found " + this.args[0].getType().toHuman());
    }

    @Override // com.android.dx.cf.code.Machine
    public final void popArgs(Frame frame, Type type, Type type2, Type type3) {
        popArgs(frame, 3);
        if (Merger.isPossiblyAssignableFrom(type, this.args[0])) {
            if (Merger.isPossiblyAssignableFrom(type2, this.args[1])) {
                if (Merger.isPossiblyAssignableFrom(type3, this.args[2])) {
                    return;
                }
                throw new SimException("expected type " + type3.toHuman() + " but found " + this.args[2].getType().toHuman());
            }
            throw new SimException("expected type " + type2.toHuman() + " but found " + this.args[1].getType().toHuman());
        }
        throw new SimException("expected type " + type.toHuman() + " but found " + this.args[0].getType().toHuman());
    }
}
