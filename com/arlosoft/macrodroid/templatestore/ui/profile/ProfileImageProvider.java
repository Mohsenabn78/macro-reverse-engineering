package com.arlosoft.macrodroid.templatestore.ui.profile;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.avatar.glide.GlideLoader;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileImageProvider.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class ProfileImageProvider {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final GlideLoader f13815a = new GlideLoader();

    public final void loadImageFromBitmap(@NotNull AvatarView avatarView, @NotNull Bitmap bitmap, @NotNull String imageUsername) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(imageUsername, "imageUsername");
        this.f13815a.loadImage(avatarView, bitmap, imageUsername);
    }

    public final void loadImageFromUrl(@NotNull AvatarView avatarView, @NotNull String imageName, @NotNull String imageUsername) {
        boolean z3;
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(imageName, "imageName");
        Intrinsics.checkNotNullParameter(imageUsername, "imageUsername");
        if (imageName.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3 && !Intrinsics.areEqual(imageName, "null")) {
            this.f13815a.loadImage(avatarView, "https://backend.macrodroid.com/profilepics/" + imageName, imageUsername);
            return;
        }
        this.f13815a.loadImage(avatarView, (String) null, imageUsername);
    }
}
