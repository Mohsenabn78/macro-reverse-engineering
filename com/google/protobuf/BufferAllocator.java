package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes6.dex */
abstract class BufferAllocator {

    /* renamed from: a  reason: collision with root package name */
    private static final BufferAllocator f33197a = new BufferAllocator() { // from class: com.google.protobuf.BufferAllocator.1
        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer a(int i4) {
            return AllocatedBuffer.i(ByteBuffer.allocateDirect(i4));
        }

        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer b(int i4) {
            return AllocatedBuffer.j(new byte[i4]);
        }
    };

    BufferAllocator() {
    }

    public abstract AllocatedBuffer a(int i4);

    public abstract AllocatedBuffer b(int i4);
}
