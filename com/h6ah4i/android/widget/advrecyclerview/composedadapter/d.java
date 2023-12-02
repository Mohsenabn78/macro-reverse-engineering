package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import android.util.SparseIntArray;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import javax.mail.UIDFolder;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: SegmentedViewTypeTranslator.java */
/* loaded from: classes6.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private SparseIntArray f33717a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private SparseIntArray f33718b = new SparseIntArray();

    public static int a(long j4) {
        return ItemViewTypeComposer.composeSegment(65535 & ((int) (j4 >>> 32)), (int) (j4 & UIDFolder.MAXUID));
    }

    public static int b(long j4) {
        return (int) ((j4 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public long c(int i4) {
        int indexOfKey = this.f33718b.indexOfKey(ItemViewTypeComposer.extractSegmentPart(i4));
        if (indexOfKey >= 0) {
            return (this.f33718b.valueAt(indexOfKey) << 32) | (i4 & UIDFolder.MAXUID);
        }
        throw new IllegalStateException("Corresponding wrapped view type is not found!");
    }

    public int d(int i4, int i5) {
        int i6;
        int extractSegmentPart = (i4 << 16) | ItemViewTypeComposer.extractSegmentPart(i5);
        int indexOfKey = this.f33717a.indexOfKey(extractSegmentPart);
        if (indexOfKey >= 0) {
            i6 = this.f33717a.valueAt(indexOfKey);
        } else {
            int size = this.f33717a.size() + 1;
            if (size <= 127) {
                this.f33717a.put(extractSegmentPart, size);
                this.f33718b.put(size, extractSegmentPart);
                i6 = size;
            } else {
                throw new IllegalStateException("Failed to allocate a new wrapped view type.");
            }
        }
        return ItemViewTypeComposer.composeSegment(i6, i5);
    }
}
