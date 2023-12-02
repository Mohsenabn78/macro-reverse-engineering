package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class Section {
    private final int alignment;
    private final DexFile file;
    private int fileOffset;
    private final String name;
    private boolean prepared;

    public Section(String str, DexFile dexFile, int i4) {
        if (dexFile != null) {
            validateAlignment(i4);
            this.name = str;
            this.file = dexFile;
            this.alignment = i4;
            this.fileOffset = -1;
            this.prepared = false;
            return;
        }
        throw new NullPointerException("file == null");
    }

    public static void validateAlignment(int i4) {
        if (i4 > 0 && (i4 & (i4 - 1)) == 0) {
            return;
        }
        throw new IllegalArgumentException("invalid alignment");
    }

    protected final void align(AnnotatedOutput annotatedOutput) {
        annotatedOutput.alignTo(this.alignment);
    }

    public abstract int getAbsoluteItemOffset(Item item);

    public final int getAbsoluteOffset(int i4) {
        if (i4 >= 0) {
            int i5 = this.fileOffset;
            if (i5 >= 0) {
                return i5 + i4;
            }
            throw new RuntimeException("fileOffset not yet set");
        }
        throw new IllegalArgumentException("relative < 0");
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final DexFile getFile() {
        return this.file;
    }

    public final int getFileOffset() {
        int i4 = this.fileOffset;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("fileOffset not set");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getName() {
        return this.name;
    }

    public abstract Collection<? extends Item> items();

    public final void prepare() {
        throwIfPrepared();
        prepare0();
        this.prepared = true;
    }

    protected abstract void prepare0();

    public final int setFileOffset(int i4) {
        if (i4 >= 0) {
            if (this.fileOffset < 0) {
                int i5 = this.alignment - 1;
                int i6 = (i4 + i5) & (~i5);
                this.fileOffset = i6;
                return i6;
            }
            throw new RuntimeException("fileOffset already set");
        }
        throw new IllegalArgumentException("fileOffset < 0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void throwIfNotPrepared() {
        if (this.prepared) {
            return;
        }
        throw new RuntimeException("not prepared");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void throwIfPrepared() {
        if (!this.prepared) {
            return;
        }
        throw new RuntimeException("already prepared");
    }

    public abstract int writeSize();

    public final void writeTo(AnnotatedOutput annotatedOutput) {
        throwIfNotPrepared();
        align(annotatedOutput);
        int cursor = annotatedOutput.getCursor();
        int i4 = this.fileOffset;
        if (i4 < 0) {
            this.fileOffset = cursor;
        } else if (i4 != cursor) {
            throw new RuntimeException("alignment mismatch: for " + this + ", at " + cursor + ", but expected " + this.fileOffset);
        }
        if (annotatedOutput.annotates()) {
            if (this.name != null) {
                annotatedOutput.annotate(0, "\n" + this.name + ":");
            } else if (cursor != 0) {
                annotatedOutput.annotate(0, "\n");
            }
        }
        writeTo0(annotatedOutput);
    }

    protected abstract void writeTo0(AnnotatedOutput annotatedOutput);
}
