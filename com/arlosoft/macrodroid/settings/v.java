package com.arlosoft.macrodroid.settings;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ListItemNotificationChannelBinding;
import com.arlosoft.macrodroid.notification.NotificationChannelList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: EditNotificationChannelsActivity.kt */
/* loaded from: classes3.dex */
final class v extends RecyclerView.Adapter<u> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final NotificationChannelList f13576a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final a f13577b;

    public v(@NotNull NotificationChannelList notificationChannelList, @NotNull a channelSelectedCallback) {
        Intrinsics.checkNotNullParameter(notificationChannelList, "notificationChannelList");
        Intrinsics.checkNotNullParameter(channelSelectedCallback, "channelSelectedCallback");
        this.f13576a = notificationChannelList;
        this.f13577b = channelSelectedCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NotNull u holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(this.f13576a.getNotificationChannels().get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: b */
    public u onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemNotificationChannelBinding inflate = ListItemNotificationChannelBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new u(inflate, this.f13577b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13576a.getNotificationChannels().size();
    }
}
