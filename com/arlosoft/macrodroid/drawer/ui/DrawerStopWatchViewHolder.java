package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemStopwatch;
import com.arlosoft.macrodroid.stopwatch.StopWatch;

/* loaded from: classes3.dex */
public class DrawerStopWatchViewHolder extends DrawerItemViewHolder {
    @BindView(R.id.clear_button)
    ImageView clearButton;
    @BindView(R.id.drag_handle)
    ImageView dragHandle;

    /* renamed from: e  reason: collision with root package name */
    private DrawerItemStopwatch f11531e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11532f;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.play_pause_button)
    ImageView playPauseButton;
    @BindView(R.id.stopwatch_name)
    TextView stopWatchName;
    @BindView(R.id.stopwatch_time)
    TextView stopWatchTime;

    public DrawerStopWatchViewHolder(@NonNull View view, DrawItemListener drawItemListener, int i4) {
        super(view, drawItemListener);
        ButterKnife.bind(this, view);
        float f4 = i4;
        this.stopWatchName.setTextSize(2, f4);
        this.stopWatchTime.setTextSize(2, f4);
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected ImageView[] e() {
        return new ImageView[]{this.icon, this.playPauseButton, this.clearButton};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    protected TextView[] f() {
        return new TextView[]{this.stopWatchName, this.stopWatchTime};
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        super.onBind(drawerItem, z3);
        if (drawerItem instanceof DrawerItemStopwatch) {
            ImageView imageView = this.icon;
            int i8 = 8;
            if (drawerItem.hideIcon()) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageView.setVisibility(i4);
            this.f11531e = (DrawerItemStopwatch) drawerItem;
            setIcon(this.icon, drawerItem, R.drawable.ic_timer_white_24dp);
            setColor(this.f11531e.getColor());
            this.stopWatchName.setText(this.f11531e.getName());
            TextView textView = this.stopWatchName;
            if (this.f11531e.getHideName()) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            textView.setVisibility(i5);
            refresh();
            i(this.dragHandle);
            if (z3) {
                this.dragHandle.setVisibility(0);
                i(this.dragHandle);
            } else {
                this.dragHandle.setVisibility(8);
            }
            boolean isValid = this.f11531e.isValid();
            ImageView imageView2 = this.playPauseButton;
            if (isValid) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView2.setVisibility(i6);
            ImageView imageView3 = this.clearButton;
            if (isValid) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            imageView3.setVisibility(i7);
            TextView textView2 = this.stopWatchTime;
            if (isValid) {
                i8 = 0;
            }
            textView2.setVisibility(i8);
            return;
        }
        throw new IllegalArgumentException("DrawerItemStopwatch required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.clear_button})
    public void onClearButton() {
        StopWatch.resetStopWatch(this.itemView.getContext(), this.f11531e.getStopwatchName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.play_pause_button})
    public void onPlayPauseClicked() {
        if (this.f11532f) {
            StopWatch.pauseStopWatch(this.itemView.getContext(), this.f11531e.getStopwatchName());
        } else {
            StopWatch.startStopWatch(this.itemView.getContext(), this.f11531e.getStopwatchName());
        }
    }

    @Override // com.arlosoft.macrodroid.drawer.ui.DrawerItemViewHolder
    public void refresh() {
        float f4;
        int i4;
        boolean isActive = StopWatch.isActive(this.itemView.getContext(), this.f11531e.getStopwatchName());
        this.f11532f = isActive;
        ImageView imageView = this.icon;
        if (isActive) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        imageView.setAlpha(f4);
        ImageView imageView2 = this.playPauseButton;
        if (this.f11532f) {
            i4 = R.drawable.ic_pause_white_24dp;
        } else {
            i4 = R.drawable.ic_play_white_24dp;
        }
        imageView2.setImageResource(i4);
        j(this.playPauseButton);
        this.stopWatchTime.setText(StopWatch.formatStopwatchTime(StopWatch.getStopWatchDuration(this.itemView.getContext(), this.f11531e.getStopwatchName())));
    }
}
