package com.android.dx.io.instructions;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class AddressMap {
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public int get(int i4) {
        Integer num = this.map.get(Integer.valueOf(i4));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void put(int i4, int i5) {
        this.map.put(Integer.valueOf(i4), Integer.valueOf(i5));
    }
}
