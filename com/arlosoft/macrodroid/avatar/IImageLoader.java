package com.arlosoft.macrodroid.avatar;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public interface IImageLoader {
    void loadImage(@NonNull AvatarView avatarView, Bitmap bitmap, String str);

    void loadImage(@NonNull AvatarView avatarView, Uri uri, String str);

    void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, Bitmap bitmap);

    void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, String str);

    void loadImage(@NonNull AvatarView avatarView, @DrawableRes Integer num, String str);

    void loadImage(@NonNull AvatarView avatarView, String str, String str2);

    void loadImage(@NonNull AvatarView avatarView, String str, String str2, int i4);
}
