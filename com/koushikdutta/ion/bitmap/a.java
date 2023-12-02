package com.koushikdutta.ion.bitmap;

import com.koushikdutta.async.util.LruCache;

/* compiled from: LruBitmapCache.java */
/* loaded from: classes6.dex */
class a extends LruCache<String, BitmapInfo> {

    /* renamed from: i  reason: collision with root package name */
    private SoftReferenceHashtable<String, BitmapInfo> f35814i;

    public a(int i4) {
        super(i4);
        this.f35814i = new SoftReferenceHashtable<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.util.LruCache
    /* renamed from: f */
    public void b(boolean z3, String str, BitmapInfo bitmapInfo, BitmapInfo bitmapInfo2) {
        super.b(z3, str, bitmapInfo, bitmapInfo2);
        if (z3) {
            this.f35814i.put(str, bitmapInfo);
        }
    }

    public void g() {
        evictAll();
        this.f35814i.clear();
    }

    public BitmapInfo h(String str) {
        BitmapInfo bitmapInfo = get(str);
        if (bitmapInfo != null) {
            return bitmapInfo;
        }
        BitmapInfo remove = this.f35814i.remove(str);
        if (remove != null) {
            put(str, remove);
        }
        return remove;
    }

    public void i(String str, BitmapInfo bitmapInfo) {
        this.f35814i.put(str, bitmapInfo);
    }

    public BitmapInfo j(String str) {
        BitmapInfo remove = this.f35814i.remove(str);
        BitmapInfo remove2 = remove(str);
        if (remove2 != null) {
            return remove2;
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.util.LruCache
    /* renamed from: k */
    public long d(String str, BitmapInfo bitmapInfo) {
        return bitmapInfo.sizeOf();
    }
}
