package com.android.dx.io.instructions;

/* loaded from: classes2.dex */
public abstract class BaseCodeCursor implements CodeCursor {
    private final AddressMap baseAddressMap = new AddressMap();
    private int cursor = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void advance(int i4) {
        this.cursor += i4;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final int baseAddressForCursor() {
        int i4 = this.baseAddressMap.get(this.cursor);
        if (i4 < 0) {
            return this.cursor;
        }
        return i4;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final int cursor() {
        return this.cursor;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final void setBaseAddress(int i4, int i5) {
        this.baseAddressMap.put(i4, i5);
    }
}
