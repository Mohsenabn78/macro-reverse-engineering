package com.arlosoft.macrodroid.videos.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.videos.data.VideoInfo;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: VideoHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VideoHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f16439a;

    @Inject
    public VideoHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f16439a = context;
    }

    @NotNull
    public final Context getContext() {
        return this.f16439a;
    }

    public final void openVideo(@NotNull VideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(videoInfo.getUrl()));
            intent.setFlags(intent.getFlags() + 268435456);
            this.f16439a.startActivity(intent);
        } catch (Exception unused) {
            Context context = this.f16439a;
            String string = context.getString(R.string.no_app_available);
            String url = videoInfo.getUrl();
            ToastCompat.makeText(context, (CharSequence) (string + ":" + url), 1).show();
        }
    }
}
