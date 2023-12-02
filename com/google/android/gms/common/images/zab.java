package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final zag f20410a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ImageManager f20411b;

    public zab(ImageManager imageManager, zag zagVar) {
        this.f20411b = imageManager;
        this.f20410a = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        zam zamVar;
        Map map2;
        Map map3;
        Object obj;
        HashSet hashSet;
        HashSet hashSet2;
        Map map4;
        Map map5;
        Map map6;
        zam zamVar2;
        Map map7;
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        map = this.f20411b.f20395e;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) map.get(this.f20410a);
        if (imageReceiver != null) {
            map7 = this.f20411b.f20395e;
            map7.remove(this.f20410a);
            imageReceiver.c(this.f20410a);
        }
        zag zagVar = this.f20410a;
        zad zadVar = zagVar.f20419a;
        Uri uri = zadVar.f20416a;
        if (uri != null) {
            map2 = this.f20411b.f20397g;
            Long l4 = (Long) map2.get(uri);
            if (l4 != null) {
                if (SystemClock.elapsedRealtime() - l4.longValue() >= 3600000) {
                    map6 = this.f20411b.f20397g;
                    map6.remove(zadVar.f20416a);
                } else {
                    zag zagVar2 = this.f20410a;
                    ImageManager imageManager = this.f20411b;
                    Context context = imageManager.f20391a;
                    zamVar2 = imageManager.f20394d;
                    zagVar2.b(context, zamVar2, true);
                    return;
                }
            }
            this.f20410a.a(null, false, true, false);
            map3 = this.f20411b.f20396f;
            ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) map3.get(zadVar.f20416a);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageManager.ImageReceiver(zadVar.f20416a);
                map5 = this.f20411b.f20396f;
                map5.put(zadVar.f20416a, imageReceiver2);
            }
            imageReceiver2.b(this.f20410a);
            zag zagVar3 = this.f20410a;
            if (!(zagVar3 instanceof zaf)) {
                map4 = this.f20411b.f20395e;
                map4.put(zagVar3, imageReceiver2);
            }
            obj = ImageManager.f20388h;
            synchronized (obj) {
                hashSet = ImageManager.f20389i;
                if (!hashSet.contains(zadVar.f20416a)) {
                    hashSet2 = ImageManager.f20389i;
                    hashSet2.add(zadVar.f20416a);
                    imageReceiver2.d();
                }
            }
            return;
        }
        ImageManager imageManager2 = this.f20411b;
        Context context2 = imageManager2.f20391a;
        zamVar = imageManager2.f20394d;
        zagVar.b(context2, zamVar, true);
    }
}
