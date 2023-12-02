package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class LocalsArraySet extends LocalsArray {
    private final OneLocalsArray primary;
    private final ArrayList<LocalsArray> secondaries;

    public LocalsArraySet(int i4) {
        super(i4 != 0);
        this.primary = new OneLocalsArray(i4);
        this.secondaries = new ArrayList<>();
    }

    private LocalsArray getSecondaryForLabel(int i4) {
        if (i4 >= this.secondaries.size()) {
            return null;
        }
        return this.secondaries.get(i4);
    }

    private LocalsArraySet mergeWithOne(OneLocalsArray oneLocalsArray) {
        LocalsArray merge;
        OneLocalsArray merge2 = this.primary.merge(oneLocalsArray.getPrimary());
        ArrayList arrayList = new ArrayList(this.secondaries.size());
        int size = this.secondaries.size();
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            LocalsArray localsArray = this.secondaries.get(i4);
            if (localsArray != null) {
                try {
                    merge = localsArray.merge(oneLocalsArray);
                } catch (SimException e4) {
                    e4.addContext("Merging one locals against caller block " + Hex.u2(i4));
                }
                if (z3 && localsArray == merge) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                arrayList.add(merge);
            }
            merge = null;
            if (z3) {
            }
            z3 = true;
            arrayList.add(merge);
        }
        if (this.primary == merge2 && !z3) {
            return this;
        }
        return new LocalsArraySet(merge2, arrayList);
    }

    private LocalsArraySet mergeWithSet(LocalsArraySet localsArraySet) {
        LocalsArray localsArray;
        LocalsArray localsArray2;
        OneLocalsArray merge = this.primary.merge(localsArraySet.getPrimary());
        int size = this.secondaries.size();
        int size2 = localsArraySet.secondaries.size();
        int max = Math.max(size, size2);
        ArrayList arrayList = new ArrayList(max);
        boolean z3 = false;
        for (int i4 = 0; i4 < max; i4++) {
            LocalsArray localsArray3 = null;
            if (i4 < size) {
                localsArray = this.secondaries.get(i4);
            } else {
                localsArray = null;
            }
            if (i4 < size2) {
                localsArray2 = localsArraySet.secondaries.get(i4);
            } else {
                localsArray2 = null;
            }
            if (localsArray != localsArray2) {
                if (localsArray == null) {
                    localsArray3 = localsArray2;
                } else if (localsArray2 != null) {
                    try {
                        localsArray3 = localsArray.merge(localsArray2);
                    } catch (SimException e4) {
                        e4.addContext("Merging locals set for caller block " + Hex.u2(i4));
                    }
                }
                if (z3 && localsArray == localsArray3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                arrayList.add(localsArray3);
            }
            localsArray3 = localsArray;
            if (z3) {
            }
            z3 = true;
            arrayList.add(localsArray3);
        }
        if (this.primary == merge && !z3) {
            return this;
        }
        return new LocalsArraySet(merge, arrayList);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void annotate(ExceptionWithContext exceptionWithContext) {
        exceptionWithContext.addContext("(locals array set; primary)");
        this.primary.annotate(exceptionWithContext);
        int size = this.secondaries.size();
        for (int i4 = 0; i4 < size; i4++) {
            LocalsArray localsArray = this.secondaries.get(i4);
            if (localsArray != null) {
                exceptionWithContext.addContext("(locals array set: primary for caller " + Hex.u2(i4) + ')');
                localsArray.getPrimary().annotate(exceptionWithContext);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArray copy() {
        return new LocalsArraySet(this);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer get(int i4) {
        return this.primary.get(i4);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory1(int i4) {
        return this.primary.getCategory1(i4);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory2(int i4) {
        return this.primary.getCategory2(i4);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public int getMaxLocals() {
        return this.primary.getMaxLocals();
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getOrNull(int i4) {
        return this.primary.getOrNull(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.dx.cf.code.LocalsArray
    public OneLocalsArray getPrimary() {
        return this.primary;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void invalidate(int i4) {
        throwIfImmutable();
        this.primary.invalidate(i4);
        Iterator<LocalsArray> it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray next = it.next();
            if (next != null) {
                next.invalidate(i4);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void makeInitialized(Type type) {
        if (this.primary.getMaxLocals() == 0) {
            return;
        }
        throwIfImmutable();
        this.primary.makeInitialized(type);
        Iterator<LocalsArray> it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray next = it.next();
            if (next != null) {
                next.makeInitialized(type);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i4) {
        LocalsArray localsArray2;
        LocalsArray secondaryForLabel = getSecondaryForLabel(i4);
        OneLocalsArray merge = this.primary.merge(localsArray.getPrimary());
        if (secondaryForLabel == localsArray) {
            localsArray = secondaryForLabel;
        } else if (secondaryForLabel != null) {
            localsArray = secondaryForLabel.merge(localsArray);
        }
        if (localsArray == secondaryForLabel && merge == this.primary) {
            return this;
        }
        int size = this.secondaries.size();
        int max = Math.max(i4 + 1, size);
        ArrayList arrayList = new ArrayList(max);
        OneLocalsArray oneLocalsArray = null;
        for (int i5 = 0; i5 < max; i5++) {
            if (i5 == i4) {
                localsArray2 = localsArray;
            } else if (i5 < size) {
                localsArray2 = this.secondaries.get(i5);
            } else {
                localsArray2 = null;
            }
            if (localsArray2 != null) {
                if (oneLocalsArray == null) {
                    oneLocalsArray = localsArray2.getPrimary();
                } else {
                    oneLocalsArray = oneLocalsArray.merge(localsArray2.getPrimary());
                }
            }
            arrayList.add(localsArray2);
        }
        LocalsArraySet localsArraySet = new LocalsArraySet(oneLocalsArray, arrayList);
        localsArraySet.setImmutable();
        return localsArraySet;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(int i4, TypeBearer typeBearer) {
        throwIfImmutable();
        this.primary.set(i4, typeBearer);
        Iterator<LocalsArray> it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray next = it.next();
            if (next != null) {
                next.set(i4, typeBearer);
            }
        }
    }

    @Override // com.android.dx.util.MutabilityControl
    public void setImmutable() {
        this.primary.setImmutable();
        Iterator<LocalsArray> it = this.secondaries.iterator();
        while (it.hasNext()) {
            LocalsArray next = it.next();
            if (next != null) {
                next.setImmutable();
            }
        }
        super.setImmutable();
    }

    public LocalsArray subArrayForLabel(int i4) {
        return getSecondaryForLabel(i4);
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append("(locals array set; primary)\n");
        sb.append(getPrimary().toHuman());
        sb.append('\n');
        int size = this.secondaries.size();
        for (int i4 = 0; i4 < size; i4++) {
            LocalsArray localsArray = this.secondaries.get(i4);
            if (localsArray != null) {
                sb.append("(locals array set: primary for caller " + Hex.u2(i4) + ")\n");
                sb.append(localsArray.getPrimary().toHuman());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArraySet merge(LocalsArray localsArray) {
        LocalsArraySet mergeWithOne;
        try {
            if (localsArray instanceof LocalsArraySet) {
                mergeWithOne = mergeWithSet((LocalsArraySet) localsArray);
            } else {
                mergeWithOne = mergeWithOne((OneLocalsArray) localsArray);
            }
            mergeWithOne.setImmutable();
            return mergeWithOne;
        } catch (SimException e4) {
            e4.addContext("underlay locals:");
            annotate(e4);
            e4.addContext("overlay locals:");
            localsArray.annotate(e4);
            throw e4;
        }
    }

    public LocalsArraySet(OneLocalsArray oneLocalsArray, ArrayList<LocalsArray> arrayList) {
        super(oneLocalsArray.getMaxLocals() > 0);
        this.primary = oneLocalsArray;
        this.secondaries = arrayList;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(RegisterSpec registerSpec) {
        set(registerSpec.getReg(), registerSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private LocalsArraySet(LocalsArraySet localsArraySet) {
        super(localsArraySet.getMaxLocals() > 0);
        this.primary = localsArraySet.primary.copy();
        this.secondaries = new ArrayList<>(localsArraySet.secondaries.size());
        int size = localsArraySet.secondaries.size();
        for (int i4 = 0; i4 < size; i4++) {
            LocalsArray localsArray = localsArraySet.secondaries.get(i4);
            if (localsArray == null) {
                this.secondaries.add(null);
            } else {
                this.secondaries.add(localsArray.copy());
            }
        }
    }
}
