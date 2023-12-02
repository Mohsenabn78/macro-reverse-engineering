package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecSet;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.FixedSizeList;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class LocalList extends FixedSizeList {
    private static final boolean DEBUG = false;
    public static final LocalList EMPTY = new LocalList(0);

    /* loaded from: classes2.dex */
    public enum Disposition {
        START,
        END_SIMPLY,
        END_REPLACED,
        END_MOVED,
        END_CLOBBERED_BY_PREV,
        END_CLOBBERED_BY_NEXT
    }

    /* loaded from: classes2.dex */
    public static class Entry implements Comparable<Entry> {
        private final int address;
        private final Disposition disposition;
        private final RegisterSpec spec;
        private final CstType type;

        public Entry(int i4, Disposition disposition, RegisterSpec registerSpec) {
            if (i4 >= 0) {
                if (disposition != null) {
                    try {
                        if (registerSpec.getLocalItem() != null) {
                            this.address = i4;
                            this.disposition = disposition;
                            this.spec = registerSpec;
                            this.type = CstType.intern(registerSpec.getType());
                            return;
                        }
                        throw new NullPointerException("spec.getLocalItem() == null");
                    } catch (NullPointerException unused) {
                        throw new NullPointerException("spec == null");
                    }
                }
                throw new NullPointerException("disposition == null");
            }
            throw new IllegalArgumentException("address < 0");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry) || compareTo((Entry) obj) != 0) {
                return false;
            }
            return true;
        }

        public int getAddress() {
            return this.address;
        }

        public Disposition getDisposition() {
            return this.disposition;
        }

        public CstString getName() {
            return this.spec.getLocalItem().getName();
        }

        public int getRegister() {
            return this.spec.getReg();
        }

        public RegisterSpec getRegisterSpec() {
            return this.spec;
        }

        public CstString getSignature() {
            return this.spec.getLocalItem().getSignature();
        }

        public CstType getType() {
            return this.type;
        }

        public boolean isStart() {
            if (this.disposition == Disposition.START) {
                return true;
            }
            return false;
        }

        public boolean matches(RegisterSpec registerSpec) {
            return this.spec.equalsUsingSimpleType(registerSpec);
        }

        public String toString() {
            return Integer.toHexString(this.address) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.disposition + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.spec;
        }

        public Entry withDisposition(Disposition disposition) {
            if (disposition == this.disposition) {
                return this;
            }
            return new Entry(this.address, disposition, this.spec);
        }

        @Override // java.lang.Comparable
        public int compareTo(Entry entry) {
            int i4 = this.address;
            int i5 = entry.address;
            if (i4 < i5) {
                return -1;
            }
            if (i4 > i5) {
                return 1;
            }
            boolean isStart = isStart();
            if (isStart != entry.isStart()) {
                return isStart ? 1 : -1;
            }
            return this.spec.compareTo(entry.spec);
        }

        public boolean matches(Entry entry) {
            return matches(entry.spec);
        }
    }

    /* loaded from: classes2.dex */
    public static class MakeState {
        private final ArrayList<Entry> result;
        private int nullResultCount = 0;
        private RegisterSpecSet regs = null;
        private int[] endIndices = null;
        private int lastAddress = 0;

        public MakeState(int i4) {
            this.result = new ArrayList<>(i4);
        }

        private void aboutToProcess(int i4, int i5) {
            boolean z3;
            int[] iArr = this.endIndices;
            if (iArr == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i6 = this.lastAddress;
            if (i4 == i6 && !z3) {
                return;
            }
            if (i4 >= i6) {
                if (z3 || i5 >= iArr.length) {
                    int i7 = i5 + 1;
                    RegisterSpecSet registerSpecSet = new RegisterSpecSet(i7);
                    int[] iArr2 = new int[i7];
                    Arrays.fill(iArr2, -1);
                    if (!z3) {
                        registerSpecSet.putAll(this.regs);
                        int[] iArr3 = this.endIndices;
                        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
                    }
                    this.regs = registerSpecSet;
                    this.endIndices = iArr2;
                    return;
                }
                return;
            }
            throw new RuntimeException("shouldn't happen");
        }

        private void add(int i4, Disposition disposition, RegisterSpec registerSpec) {
            int reg = registerSpec.getReg();
            this.result.add(new Entry(i4, disposition, registerSpec));
            if (disposition == Disposition.START) {
                this.regs.put(registerSpec);
                this.endIndices[reg] = -1;
                return;
            }
            this.regs.remove(registerSpec);
            this.endIndices[reg] = this.result.size() - 1;
        }

        private void addOrUpdateEnd(int i4, Disposition disposition, RegisterSpec registerSpec) {
            if (disposition != Disposition.START) {
                int i5 = this.endIndices[registerSpec.getReg()];
                if (i5 >= 0) {
                    Entry entry = this.result.get(i5);
                    if (entry.getAddress() == i4 && entry.getRegisterSpec().equals(registerSpec)) {
                        this.result.set(i5, entry.withDisposition(disposition));
                        this.regs.remove(registerSpec);
                        return;
                    }
                }
                endLocal(i4, registerSpec, disposition);
                return;
            }
            throw new RuntimeException("shouldn't happen");
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            r5.regs.remove(r7);
            r4 = null;
            r5.result.set(r0, null);
            r5.nullResultCount++;
            r7 = r7.getReg();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
            r0 = r0 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
            if (r0 < 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
            r4 = r5.result.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
            if (r4 != null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
            if (r4.getRegisterSpec().getReg() != r7) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
            if (r2 == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
            r5.endIndices[r7] = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
            if (r4.getAddress() != r6) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
            r5.result.set(r0, r4.withDisposition(com.android.dx.dex.code.LocalList.Disposition.END_SIMPLY));
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean checkForEmptyRange(int r6, com.android.dx.rop.code.RegisterSpec r7) {
            /*
                r5 = this;
                java.util.ArrayList<com.android.dx.dex.code.LocalList$Entry> r0 = r5.result
                int r0 = r0.size()
                r1 = 1
                int r0 = r0 - r1
            L8:
                r2 = 0
                if (r0 < 0) goto L27
                java.util.ArrayList<com.android.dx.dex.code.LocalList$Entry> r3 = r5.result
                java.lang.Object r3 = r3.get(r0)
                com.android.dx.dex.code.LocalList$Entry r3 = (com.android.dx.dex.code.LocalList.Entry) r3
                if (r3 != 0) goto L16
                goto L24
            L16:
                int r4 = r3.getAddress()
                if (r4 == r6) goto L1d
                return r2
            L1d:
                boolean r3 = r3.matches(r7)
                if (r3 == 0) goto L24
                goto L27
            L24:
                int r0 = r0 + (-1)
                goto L8
            L27:
                com.android.dx.rop.code.RegisterSpecSet r3 = r5.regs
                r3.remove(r7)
                java.util.ArrayList<com.android.dx.dex.code.LocalList$Entry> r3 = r5.result
                r4 = 0
                r3.set(r0, r4)
                int r3 = r5.nullResultCount
                int r3 = r3 + r1
                r5.nullResultCount = r3
                int r7 = r7.getReg()
            L3b:
                int r0 = r0 + (-1)
                if (r0 < 0) goto L56
                java.util.ArrayList<com.android.dx.dex.code.LocalList$Entry> r3 = r5.result
                java.lang.Object r3 = r3.get(r0)
                r4 = r3
                com.android.dx.dex.code.LocalList$Entry r4 = (com.android.dx.dex.code.LocalList.Entry) r4
                if (r4 != 0) goto L4b
                goto L3b
            L4b:
                com.android.dx.rop.code.RegisterSpec r3 = r4.getRegisterSpec()
                int r3 = r3.getReg()
                if (r3 != r7) goto L3b
                r2 = 1
            L56:
                if (r2 == 0) goto L6d
                int[] r2 = r5.endIndices
                r2[r7] = r0
                int r7 = r4.getAddress()
                if (r7 != r6) goto L6d
                java.util.ArrayList<com.android.dx.dex.code.LocalList$Entry> r6 = r5.result
                com.android.dx.dex.code.LocalList$Disposition r7 = com.android.dx.dex.code.LocalList.Disposition.END_SIMPLY
                com.android.dx.dex.code.LocalList$Entry r7 = r4.withDisposition(r7)
                r6.set(r0, r7)
            L6d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.dx.dex.code.LocalList.MakeState.checkForEmptyRange(int, com.android.dx.rop.code.RegisterSpec):boolean");
        }

        private static RegisterSpec filterSpec(RegisterSpec registerSpec) {
            if (registerSpec != null && registerSpec.getType() == Type.KNOWN_NULL) {
                return registerSpec.withType(Type.OBJECT);
            }
            return registerSpec;
        }

        public void endLocal(int i4, RegisterSpec registerSpec) {
            endLocal(i4, registerSpec, Disposition.END_SIMPLY);
        }

        public LocalList finish() {
            aboutToProcess(Integer.MAX_VALUE, 0);
            int size = this.result.size();
            int i4 = size - this.nullResultCount;
            if (i4 == 0) {
                return LocalList.EMPTY;
            }
            Entry[] entryArr = new Entry[i4];
            if (size == i4) {
                this.result.toArray(entryArr);
            } else {
                Iterator<Entry> it = this.result.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    Entry next = it.next();
                    if (next != null) {
                        entryArr[i5] = next;
                        i5++;
                    }
                }
            }
            Arrays.sort(entryArr);
            LocalList localList = new LocalList(i4);
            for (int i6 = 0; i6 < i4; i6++) {
                localList.set(i6, entryArr[i6]);
            }
            localList.setImmutable();
            return localList;
        }

        public void snapshot(int i4, RegisterSpecSet registerSpecSet) {
            int maxSize = registerSpecSet.getMaxSize();
            aboutToProcess(i4, maxSize - 1);
            for (int i5 = 0; i5 < maxSize; i5++) {
                RegisterSpec registerSpec = this.regs.get(i5);
                RegisterSpec filterSpec = filterSpec(registerSpecSet.get(i5));
                if (registerSpec == null) {
                    if (filterSpec != null) {
                        startLocal(i4, filterSpec);
                    }
                } else if (filterSpec == null) {
                    endLocal(i4, registerSpec);
                } else if (!filterSpec.equalsUsingSimpleType(registerSpec)) {
                    endLocal(i4, registerSpec);
                    startLocal(i4, filterSpec);
                }
            }
        }

        public void startLocal(int i4, RegisterSpec registerSpec) {
            RegisterSpec registerSpec2;
            RegisterSpec registerSpec3;
            int reg = registerSpec.getReg();
            RegisterSpec filterSpec = filterSpec(registerSpec);
            aboutToProcess(i4, reg);
            RegisterSpec registerSpec4 = this.regs.get(reg);
            if (filterSpec.equalsUsingSimpleType(registerSpec4)) {
                return;
            }
            RegisterSpec findMatchingLocal = this.regs.findMatchingLocal(filterSpec);
            if (findMatchingLocal != null) {
                addOrUpdateEnd(i4, Disposition.END_MOVED, findMatchingLocal);
            }
            int i5 = this.endIndices[reg];
            if (registerSpec4 != null) {
                add(i4, Disposition.END_REPLACED, registerSpec4);
            } else if (i5 >= 0) {
                Entry entry = this.result.get(i5);
                if (entry.getAddress() == i4) {
                    if (entry.matches(filterSpec)) {
                        this.result.set(i5, null);
                        this.nullResultCount++;
                        this.regs.put(filterSpec);
                        this.endIndices[reg] = -1;
                        return;
                    }
                    this.result.set(i5, entry.withDisposition(Disposition.END_REPLACED));
                }
            }
            if (reg > 0 && (registerSpec3 = this.regs.get(reg - 1)) != null && registerSpec3.isCategory2()) {
                addOrUpdateEnd(i4, Disposition.END_CLOBBERED_BY_NEXT, registerSpec3);
            }
            if (filterSpec.isCategory2() && (registerSpec2 = this.regs.get(reg + 1)) != null) {
                addOrUpdateEnd(i4, Disposition.END_CLOBBERED_BY_PREV, registerSpec2);
            }
            add(i4, Disposition.START, filterSpec);
        }

        public void endLocal(int i4, RegisterSpec registerSpec, Disposition disposition) {
            int reg = registerSpec.getReg();
            RegisterSpec filterSpec = filterSpec(registerSpec);
            aboutToProcess(i4, reg);
            if (this.endIndices[reg] < 0 && !checkForEmptyRange(i4, filterSpec)) {
                add(i4, disposition, filterSpec);
            }
        }
    }

    public LocalList(int i4) {
        super(i4);
    }

    private static void debugVerify(LocalList localList) {
        try {
            debugVerify0(localList);
        } catch (RuntimeException e4) {
            int size = localList.size();
            for (int i4 = 0; i4 < size; i4++) {
                System.err.println(localList.get(i4));
            }
            throw e4;
        }
    }

    private static void debugVerify0(LocalList localList) {
        int size = localList.size();
        Entry[] entryArr = new Entry[65536];
        for (int i4 = 0; i4 < size; i4++) {
            Entry entry = localList.get(i4);
            int register = entry.getRegister();
            if (entry.isStart()) {
                Entry entry2 = entryArr[register];
                if (entry2 != null && entry.matches(entry2)) {
                    throw new RuntimeException("redundant start at " + Integer.toHexString(entry.getAddress()) + ": got " + entry + "; had " + entry2);
                }
                entryArr[register] = entry;
            } else if (entryArr[register] != null) {
                int address = entry.getAddress();
                boolean z3 = false;
                for (int i5 = i4 + 1; i5 < size; i5++) {
                    Entry entry3 = localList.get(i5);
                    if (entry3.getAddress() != address) {
                        break;
                    }
                    if (entry3.getRegisterSpec().getReg() == register) {
                        if (entry3.isStart()) {
                            if (entry.getDisposition() == Disposition.END_REPLACED) {
                                z3 = true;
                            } else {
                                throw new RuntimeException("improperly marked end at " + Integer.toHexString(address));
                            }
                        } else {
                            throw new RuntimeException("redundant end at " + Integer.toHexString(address));
                        }
                    }
                }
                if (!z3 && entry.getDisposition() == Disposition.END_REPLACED) {
                    throw new RuntimeException("improper end replacement claim at " + Integer.toHexString(address));
                }
                entryArr[register] = null;
            } else {
                throw new RuntimeException("redundant end at " + Integer.toHexString(entry.getAddress()));
            }
        }
    }

    public static LocalList make(DalvInsnList dalvInsnList) {
        int size = dalvInsnList.size();
        MakeState makeState = new MakeState(size);
        for (int i4 = 0; i4 < size; i4++) {
            DalvInsn dalvInsn = dalvInsnList.get(i4);
            if (dalvInsn instanceof LocalSnapshot) {
                makeState.snapshot(dalvInsn.getAddress(), ((LocalSnapshot) dalvInsn).getLocals());
            } else if (dalvInsn instanceof LocalStart) {
                makeState.startLocal(dalvInsn.getAddress(), ((LocalStart) dalvInsn).getLocal());
            }
        }
        return makeState.finish();
    }

    public void debugPrint(PrintStream printStream, String str) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            printStream.print(str);
            printStream.println(get(i4));
        }
    }

    public Entry get(int i4) {
        return (Entry) get0(i4);
    }

    public void set(int i4, Entry entry) {
        set0(i4, entry);
    }
}
