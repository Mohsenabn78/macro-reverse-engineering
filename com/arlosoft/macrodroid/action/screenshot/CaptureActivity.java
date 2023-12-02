package com.arlosoft.macrodroid.action.screenshot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CaptureActivity.kt */
@StabilityInferred(parameters = 0)
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class CaptureActivity extends Activity {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static MediaProjection f4857b;

    /* renamed from: a  reason: collision with root package name */
    private MediaProjectionManager f4858a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CaptureActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MediaProjection getProjection() {
            return CaptureActivity.f4857b;
        }

        public final void setProjection(@Nullable MediaProjection mediaProjection) {
            CaptureActivity.f4857b = mediaProjection;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        if (i4 == 1) {
            MediaProjectionManager mediaProjectionManager = null;
            if (i5 == -1) {
                MediaProjectionManager mediaProjectionManager2 = this.f4858a;
                if (mediaProjectionManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaProjectionManager");
                } else {
                    mediaProjectionManager = mediaProjectionManager2;
                }
                Intrinsics.checkNotNull(intent);
                f4857b = mediaProjectionManager.getMediaProjection(i5, intent);
                Intent action = new Intent(this, CaptureService.class).setAction(CaptureService.ACTION_ENABLE_CAPTURE);
                Intrinsics.checkNotNullExpressionValue(action, "Intent(this, CaptureServ…ce.ACTION_ENABLE_CAPTURE)");
                startService(action);
            } else {
                f4857b = null;
                ToastCompat.makeText(getApplicationContext(), (int) R.string.error, 0).show();
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Object systemService = getSystemService("media_projection");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) systemService;
        this.f4858a = mediaProjectionManager;
        if (mediaProjectionManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaProjectionManager");
            mediaProjectionManager = null;
        }
        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 1);
    }
}
