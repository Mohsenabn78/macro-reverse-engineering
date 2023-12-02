package com.arlosoft.macrodroid.action.screenshot;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import android.os.IBinder;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CaptureService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class CaptureService extends Service {
    @NotNull
    public static final String ACTION_ENABLE_CAPTURE = "enable_capture";

    /* renamed from: a  reason: collision with root package name */
    private final int f4860a = new Random().nextInt();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Capture f4861b = new Capture(this);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static final String f4859c = Reflection.getOrCreateKotlinClass(CaptureService.class).getQualifiedName();

    /* compiled from: CaptureService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CaptureService.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Bitmap, Unit> {
        a() {
            super(1);
        }

        public final void a(@NotNull Bitmap it) {
            Intrinsics.checkNotNullParameter(it, "it");
            CaptureService.this.f4861b.stop();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            a(bitmap);
            return Unit.INSTANCE;
        }
    }

    private final void a() {
        this.f4861b.stop();
        CaptureActivity.Companion.setProjection(null);
    }

    private final void b() {
        MediaProjection projection = CaptureActivity.Companion.getProjection();
        if (projection != null) {
            this.f4861b.run(projection, new a());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        String action;
        if (intent != null && (action = intent.getAction()) != null && action.hashCode() == -1104912246 && action.equals(ACTION_ENABLE_CAPTURE)) {
            b();
            return 3;
        }
        return 3;
    }
}
