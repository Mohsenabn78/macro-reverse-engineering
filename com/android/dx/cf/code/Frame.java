package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.IntList;

/* loaded from: classes2.dex */
public final class Frame {
    private final LocalsArray locals;
    private final ExecutionStack stack;
    private final IntList subroutines;

    private Frame(LocalsArray localsArray, ExecutionStack executionStack) {
        this(localsArray, executionStack, IntList.EMPTY);
    }

    private static LocalsArray adjustLocalsForSubroutines(LocalsArray localsArray, IntList intList) {
        if (!(localsArray instanceof LocalsArraySet)) {
            return localsArray;
        }
        LocalsArraySet localsArraySet = (LocalsArraySet) localsArray;
        if (intList.size() == 0) {
            return localsArraySet.getPrimary();
        }
        return localsArraySet;
    }

    private IntList mergeSubroutineLists(IntList intList) {
        if (this.subroutines.equals(intList)) {
            return this.subroutines;
        }
        IntList intList2 = new IntList();
        int size = this.subroutines.size();
        int size2 = intList.size();
        for (int i4 = 0; i4 < size && i4 < size2 && this.subroutines.get(i4) == intList.get(i4); i4++) {
            intList2.add(i4);
        }
        intList2.setImmutable();
        return intList2;
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        this.locals.annotate(exceptionWithContext);
        this.stack.annotate(exceptionWithContext);
    }

    public Frame copy() {
        return new Frame(this.locals.copy(), this.stack.copy(), this.subroutines);
    }

    public LocalsArray getLocals() {
        return this.locals;
    }

    public ExecutionStack getStack() {
        return this.stack;
    }

    public IntList getSubroutines() {
        return this.subroutines;
    }

    public void initializeWithParameters(StdTypeList stdTypeList) {
        int size = stdTypeList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Type type = stdTypeList.get(i5);
            this.locals.set(i4, type);
            i4 += type.getCategory();
        }
    }

    public Frame makeExceptionHandlerStartFrame(CstType cstType) {
        ExecutionStack copy = getStack().copy();
        copy.clear();
        copy.push(cstType);
        return new Frame(getLocals(), copy, this.subroutines);
    }

    public void makeInitialized(Type type) {
        this.locals.makeInitialized(type);
        this.stack.makeInitialized(type);
    }

    public Frame makeNewSubroutineStartFrame(int i4, int i5) {
        this.subroutines.mutableCopy().add(i4);
        return new Frame(this.locals.getPrimary(), this.stack, IntList.makeImmutable(i4)).mergeWithSubroutineCaller(this, i4, i5);
    }

    public Frame mergeWith(Frame frame) {
        LocalsArray merge = getLocals().merge(frame.getLocals());
        ExecutionStack merge2 = getStack().merge(frame.getStack());
        IntList mergeSubroutineLists = mergeSubroutineLists(frame.subroutines);
        LocalsArray adjustLocalsForSubroutines = adjustLocalsForSubroutines(merge, mergeSubroutineLists);
        if (adjustLocalsForSubroutines == getLocals() && merge2 == getStack() && this.subroutines == mergeSubroutineLists) {
            return this;
        }
        return new Frame(adjustLocalsForSubroutines, merge2, mergeSubroutineLists);
    }

    public Frame mergeWithSubroutineCaller(Frame frame, int i4, int i5) {
        IntList intList;
        LocalsArraySet mergeWithSubroutineCaller = getLocals().mergeWithSubroutineCaller(frame.getLocals(), i5);
        ExecutionStack merge = getStack().merge(frame.getStack());
        IntList mutableCopy = frame.subroutines.mutableCopy();
        mutableCopy.add(i4);
        mutableCopy.setImmutable();
        if (mergeWithSubroutineCaller == getLocals() && merge == getStack() && this.subroutines.equals(mutableCopy)) {
            return this;
        }
        if (this.subroutines.equals(mutableCopy)) {
            mutableCopy = this.subroutines;
        } else {
            if (this.subroutines.size() > mutableCopy.size()) {
                intList = mutableCopy;
                mutableCopy = this.subroutines;
            } else {
                intList = this.subroutines;
            }
            int size = mutableCopy.size();
            int size2 = intList.size();
            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                if (intList.get(i6) != mutableCopy.get((size - size2) + i6)) {
                    throw new RuntimeException("Incompatible merged subroutines");
                }
            }
        }
        return new Frame(mergeWithSubroutineCaller, merge, mutableCopy);
    }

    public void setImmutable() {
        this.locals.setImmutable();
        this.stack.setImmutable();
    }

    public Frame subFrameForLabel(int i4, int i5) {
        LocalsArray localsArray;
        LocalsArray localsArray2 = this.locals;
        if (localsArray2 instanceof LocalsArraySet) {
            localsArray = ((LocalsArraySet) localsArray2).subArrayForLabel(i5);
        } else {
            localsArray = null;
        }
        try {
            IntList mutableCopy = this.subroutines.mutableCopy();
            if (mutableCopy.pop() == i4) {
                mutableCopy.setImmutable();
                if (localsArray == null) {
                    return null;
                }
                return new Frame(localsArray, this.stack, mutableCopy);
            }
            throw new RuntimeException("returning from invalid subroutine");
        } catch (IndexOutOfBoundsException unused) {
            throw new RuntimeException("returning from invalid subroutine");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("can't return from non-subroutine");
        }
    }

    private Frame(LocalsArray localsArray, ExecutionStack executionStack, IntList intList) {
        if (localsArray == null) {
            throw new NullPointerException("locals == null");
        }
        if (executionStack != null) {
            intList.throwIfMutable();
            this.locals = localsArray;
            this.stack = executionStack;
            this.subroutines = intList;
            return;
        }
        throw new NullPointerException("stack == null");
    }

    public Frame(int i4, int i5) {
        this(new OneLocalsArray(i4), new ExecutionStack(i5));
    }
}
