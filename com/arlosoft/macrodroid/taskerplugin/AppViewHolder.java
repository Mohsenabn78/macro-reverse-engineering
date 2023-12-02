package com.arlosoft.macrodroid.taskerplugin;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.databinding.ListItemPluginAppBinding;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerPluginHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AppViewHolder extends GroupViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ListItemPluginAppBinding f13619b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewHolder(@NotNull ListItemPluginAppBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f13619b = binding;
    }

    public final void onBind(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PackageManager packageManager = this.itemView.getContext().getPackageManager();
        String obj = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128)).toString();
        Drawable applicationIcon = packageManager.getApplicationIcon(packageName);
        Intrinsics.checkNotNullExpressionValue(applicationIcon, "packageManager.getApplicationIcon(packageName)");
        this.f13619b.appIcon.setImageDrawable(applicationIcon);
        this.f13619b.appName.setText(obj);
    }
}
