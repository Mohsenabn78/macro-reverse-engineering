package com.arlosoft.macrodroid.avatar;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public abstract class ImageLoaderBase implements IImageLoader {

    /* renamed from: a  reason: collision with root package name */
    private String f9439a;

    public ImageLoaderBase() {
        this.f9439a = "-";
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public abstract void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, Bitmap bitmap);

    public abstract void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, Uri uri);

    public abstract void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, @DrawableRes Integer num);

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, String str, String str2) {
        loadImage(avatarView, new AvatarPlaceholder(str2, this.f9439a), str);
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, String str, String str2, int i4) {
        loadImage(avatarView, new AvatarPlaceholder(str2, i4, this.f9439a), str);
    }

    public ImageLoaderBase(String str) {
        this.f9439a = str;
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, Bitmap bitmap, String str) {
        loadImage(avatarView, new AvatarPlaceholder(str, this.f9439a), bitmap);
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, Uri uri, String str) {
        loadImage(avatarView, new AvatarPlaceholder(str, this.f9439a), uri);
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, @DrawableRes Integer num, String str) {
        loadImage(avatarView, new AvatarPlaceholder(str, this.f9439a), num);
    }
}
