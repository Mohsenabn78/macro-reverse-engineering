package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;

    /* renamed from: d  reason: collision with root package name */
    a f16689d;

    /* renamed from: f  reason: collision with root package name */
    int f16691f;

    /* renamed from: g  reason: collision with root package name */
    int f16692g;

    /* renamed from: h  reason: collision with root package name */
    boolean f16693h;

    /* renamed from: i  reason: collision with root package name */
    int f16694i;

    /* renamed from: j  reason: collision with root package name */
    int f16695j;

    /* renamed from: k  reason: collision with root package name */
    int f16696k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    int f16697l;
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    int[] f16686a = null;

    /* renamed from: b  reason: collision with root package name */
    int f16687b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f16688c = 0;

    /* renamed from: e  reason: collision with root package name */
    final List<a> f16690e = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    int f16698m = -1;

    public int getHeight() {
        return this.f16692g;
    }

    public int getNumFrames() {
        return this.f16688c;
    }

    public int getStatus() {
        return this.f16687b;
    }

    public int getWidth() {
        return this.f16691f;
    }
}
