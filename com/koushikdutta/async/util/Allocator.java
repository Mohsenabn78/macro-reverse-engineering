package com.koushikdutta.async.util;

import com.koushikdutta.async.ByteBufferList;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class Allocator {

    /* renamed from: a  reason: collision with root package name */
    final int f35666a;

    /* renamed from: b  reason: collision with root package name */
    int f35667b;

    /* renamed from: c  reason: collision with root package name */
    int f35668c;

    public Allocator(int i4) {
        this.f35667b = 0;
        this.f35668c = 4096;
        this.f35666a = i4;
    }

    public ByteBuffer allocate() {
        return allocate(this.f35667b);
    }

    public int getMaxAlloc() {
        return this.f35666a;
    }

    public int getMinAlloc() {
        return this.f35668c;
    }

    public void setCurrentAlloc(int i4) {
        this.f35667b = i4;
    }

    public Allocator setMinAlloc(int i4) {
        this.f35668c = i4;
        return this;
    }

    public void track(long j4) {
        this.f35667b = ((int) j4) * 2;
    }

    public ByteBuffer allocate(int i4) {
        return ByteBufferList.obtain(Math.min(Math.max(i4, this.f35668c), this.f35666a));
    }

    public Allocator() {
        this.f35667b = 0;
        this.f35668c = 4096;
        this.f35666a = ByteBufferList.MAX_ITEM_SIZE;
    }
}
