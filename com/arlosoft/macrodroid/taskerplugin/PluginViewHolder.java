package com.arlosoft.macrodroid.taskerplugin;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ListItemPluginBinding;
import com.arlosoft.macrodroid.taskerplugin.PluginSelectedListener;
import com.arlosoft.macrodroid.taskerplugin.PluginViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerPluginHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginViewHolder extends ChildViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ListItemPluginBinding f13622a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginViewHolder(@NotNull ListItemPluginBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f13622a = binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PluginSelectedListener pluginSelectedListener, Plugin plugin, View view) {
        Intrinsics.checkNotNullParameter(pluginSelectedListener, "$pluginSelectedListener");
        Intrinsics.checkNotNullParameter(plugin, "$plugin");
        pluginSelectedListener.pluginSelected(plugin);
    }

    public final void onBind(@NotNull final Plugin plugin, @NotNull final PluginSelectedListener pluginSelectedListener) {
        int i4;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(pluginSelectedListener, "pluginSelectedListener");
        this.f13622a.pluginName.setText(plugin.getActivityLabel(this.itemView.getContext()));
        this.f13622a.pluginIcon.setImageDrawable(plugin.getActivityIcon(this.itemView.getContext()));
        TextView textView = this.f13622a.conditionEventLabel;
        Context context = this.itemView.getContext();
        if (plugin.getType() == PluginType.CONDITION) {
            i4 = R.string.tasker_plugin_type_condition;
        } else {
            i4 = R.string.tasker_plugin_type_event;
        }
        textView.setText(context.getString(i4));
        this.f13622a.pluginContainer.setOnClickListener(new View.OnClickListener() { // from class: n0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginViewHolder.b(PluginSelectedListener.this, plugin, view);
            }
        });
    }
}
