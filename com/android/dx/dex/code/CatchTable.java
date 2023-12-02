package com.android.dx.dex.code;

import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class CatchTable extends FixedSizeList implements Comparable<CatchTable> {
    public static final CatchTable EMPTY = new CatchTable(0);

    /* loaded from: classes2.dex */
    public static class Entry implements Comparable<Entry> {
        private final int end;
        private final CatchHandlerList handlers;
        private final int start;

        public Entry(int i4, int i5, CatchHandlerList catchHandlerList) {
            if (i4 >= 0) {
                if (i5 > i4) {
                    if (!catchHandlerList.isMutable()) {
                        this.start = i4;
                        this.end = i5;
                        this.handlers = catchHandlerList;
                        return;
                    }
                    throw new IllegalArgumentException("handlers.isMutable()");
                }
                throw new IllegalArgumentException("end <= start");
            }
            throw new IllegalArgumentException("start < 0");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry) || compareTo((Entry) obj) != 0) {
                return false;
            }
            return true;
        }

        public int getEnd() {
            return this.end;
        }

        public CatchHandlerList getHandlers() {
            return this.handlers;
        }

        public int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (((this.start * 31) + this.end) * 31) + this.handlers.hashCode();
        }

        @Override // java.lang.Comparable
        public int compareTo(Entry entry) {
            int i4 = this.start;
            int i5 = entry.start;
            if (i4 < i5) {
                return -1;
            }
            if (i4 > i5) {
                return 1;
            }
            int i6 = this.end;
            int i7 = entry.end;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            return this.handlers.compareTo(entry.handlers);
        }
    }

    public CatchTable(int i4) {
        super(i4);
    }

    public Entry get(int i4) {
        return (Entry) get0(i4);
    }

    public void set(int i4, Entry entry) {
        set0(i4, entry);
    }

    @Override // java.lang.Comparable
    public int compareTo(CatchTable catchTable) {
        if (this == catchTable) {
            return 0;
        }
        int size = size();
        int size2 = catchTable.size();
        int min = Math.min(size, size2);
        for (int i4 = 0; i4 < min; i4++) {
            int compareTo = get(i4).compareTo(catchTable.get(i4));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (size < size2) {
            return -1;
        }
        return size > size2 ? 1 : 0;
    }
}
