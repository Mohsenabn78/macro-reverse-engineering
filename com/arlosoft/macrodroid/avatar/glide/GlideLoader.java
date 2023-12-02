package com.arlosoft.macrodroid.avatar.glide;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.avatar.AvatarPlaceholder;
import com.arlosoft.macrodroid.avatar.ImageLoaderBase;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: classes3.dex */
public class GlideLoader extends ImageLoaderBase {
    public GlideLoader() {
    }

    @Override // com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, @NonNull String str) {
        Glide.with(avatarView.getContext()).m4161load(str).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(avatarPlaceholder).fitCenter()).into(avatarView);
    }

    public GlideLoader(String str) {
        super(str);
    }

    @Override // com.arlosoft.macrodroid.avatar.ImageLoaderBase, com.arlosoft.macrodroid.avatar.IImageLoader
    public void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, Bitmap bitmap) {
        Glide.with(avatarView.getContext()).m4155load(bitmap).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(avatarPlaceholder).fitCenter()).into(avatarView);
    }

    @Override // com.arlosoft.macrodroid.avatar.ImageLoaderBase
    public void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, Uri uri) {
        Glide.with(avatarView.getContext()).m4157load(uri).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(avatarPlaceholder).fitCenter()).into(avatarView);
    }

    @Override // com.arlosoft.macrodroid.avatar.ImageLoaderBase
    public void loadImage(@NonNull AvatarView avatarView, @NonNull AvatarPlaceholder avatarPlaceholder, @DrawableRes Integer num) {
        Glide.with(avatarView.getContext()).m4159load(num).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(avatarPlaceholder).fitCenter()).into(avatarView);
    }
}
