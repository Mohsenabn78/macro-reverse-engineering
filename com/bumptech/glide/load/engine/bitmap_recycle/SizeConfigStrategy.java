package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import net.bytebuddy.pool.TypePool;

@RequiresApi(19)
/* loaded from: classes3.dex */
public class SizeConfigStrategy implements d {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f16856d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f16857e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f16858f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f16859g;

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f16860h;

    /* renamed from: a  reason: collision with root package name */
    private final c f16861a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c<b, Bitmap> f16862b = new com.bumptech.glide.load.engine.bitmap_recycle.c<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f16863c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16864a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f16864a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16864a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16864a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16864a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        private final c f16865a;

        /* renamed from: b  reason: collision with root package name */
        int f16866b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f16867c;

        public b(c cVar) {
            this.f16865a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
        public void a() {
            this.f16865a.c(this);
        }

        public void b(int i4, Bitmap.Config config) {
            this.f16866b = i4;
            this.f16867c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f16866b != bVar.f16866b || !Util.bothNullOrEqual(this.f16867c, bVar.f16867c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i4;
            int i5 = this.f16866b * 31;
            Bitmap.Config config = this.f16867c;
            if (config != null) {
                i4 = config.hashCode();
            } else {
                i4 = 0;
            }
            return i5 + i4;
        }

        public String toString() {
            return SizeConfigStrategy.c(this.f16866b, this.f16867c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class c extends com.bumptech.glide.load.engine.bitmap_recycle.b<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i4, Bitmap.Config config) {
            b b4 = b();
            b4.b(i4, config);
            return b4;
        }
    }

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            config = Bitmap.Config.RGBA_F16;
            configArr[configArr.length - 1] = config;
        }
        f16856d = configArr;
        f16857e = configArr;
        f16858f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f16859g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f16860h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> e4 = e(bitmap.getConfig());
        Integer num2 = e4.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                e4.remove(num);
                return;
            } else {
                e4.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
    }

    private b b(int i4, Bitmap.Config config) {
        Bitmap.Config[] d4;
        b e4 = this.f16861a.e(i4, config);
        for (Bitmap.Config config2 : d(config)) {
            Integer ceilingKey = e(config2).ceilingKey(Integer.valueOf(i4));
            if (ceilingKey != null && ceilingKey.intValue() <= i4 * 8) {
                if (ceilingKey.intValue() == i4) {
                    if (config2 == null) {
                        if (config == null) {
                            return e4;
                        }
                    } else if (config2.equals(config)) {
                        return e4;
                    }
                }
                this.f16861a.c(e4);
                return this.f16861a.e(ceilingKey.intValue(), config2);
            }
        }
        return e4;
    }

    static String c(int i4, Bitmap.Config config) {
        return "[" + i4 + "](" + config + ")";
    }

    private static Bitmap.Config[] d(Bitmap.Config config) {
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                return f16857e;
            }
        }
        int i4 = a.f16864a[config.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return i4 != 4 ? new Bitmap.Config[]{config} : f16860h;
                }
                return f16859g;
            }
            return f16858f;
        }
        return f16856d;
    }

    private NavigableMap<Integer, Integer> e(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f16863c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f16863c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    @Nullable
    public Bitmap get(int i4, int i5, Bitmap.Config config) {
        b b4 = b(Util.getBitmapByteSize(i4, i5, config), config);
        Bitmap a4 = this.f16862b.a(b4);
        if (a4 != null) {
            a(Integer.valueOf(b4.f16866b), a4);
            a4.reconfigure(i4, i5, config);
        }
        return a4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    public String logBitmap(Bitmap bitmap) {
        return c(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    public void put(Bitmap bitmap) {
        b e4 = this.f16861a.e(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.f16862b.d(e4, bitmap);
        NavigableMap<Integer, Integer> e5 = e(bitmap.getConfig());
        Integer num = e5.get(Integer.valueOf(e4.f16866b));
        Integer valueOf = Integer.valueOf(e4.f16866b);
        int i4 = 1;
        if (num != null) {
            i4 = 1 + num.intValue();
        }
        e5.put(valueOf, Integer.valueOf(i4));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    @Nullable
    public Bitmap removeLast() {
        Bitmap f4 = this.f16862b.f();
        if (f4 != null) {
            a(Integer.valueOf(Util.getBitmapByteSize(f4)), f4);
        }
        return f4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f16862b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f16863c.entrySet()) {
            sb.append(entry.getKey());
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f16863c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
    public String logBitmap(int i4, int i5, Bitmap.Config config) {
        return c(Util.getBitmapByteSize(i4, i5, config), config);
    }
}
