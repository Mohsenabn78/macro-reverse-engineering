package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityCellTowerGroupBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10935a;
    @NonNull
    public final TextView cellTowerCountText;
    @NonNull
    public final FloatingActionButton cellTowerDoneButton;
    @NonNull
    public final ListView cellTowerList;
    @NonNull
    public final Button cellTowerScanBgButton;
    @NonNull
    public final RelativeLayout cellTowerScanningLayout;
    @NonNull
    public final Button cellTowerStopScanningButton;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ProgressBar progressSpinner;
    @NonNull
    public final TextView scanningText;
    @NonNull
    public final LinearLayout scanningTopBar;

    private ActivityCellTowerGroupBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull FloatingActionButton floatingActionButton, @NonNull ListView listView, @NonNull Button button, @NonNull RelativeLayout relativeLayout, @NonNull Button button2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull LinearLayout linearLayout) {
        this.f10935a = coordinatorLayout;
        this.cellTowerCountText = textView;
        this.cellTowerDoneButton = floatingActionButton;
        this.cellTowerList = listView;
        this.cellTowerScanBgButton = button;
        this.cellTowerScanningLayout = relativeLayout;
        this.cellTowerStopScanningButton = button2;
        this.coordinatorLayout = coordinatorLayout2;
        this.progressSpinner = progressBar;
        this.scanningText = textView2;
        this.scanningTopBar = linearLayout;
    }

    @NonNull
    public static ActivityCellTowerGroupBinding bind(@NonNull View view) {
        int i4 = R.id.cell_tower_count_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cell_tower_count_text);
        if (textView != null) {
            i4 = R.id.cell_tower_done_button;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.cell_tower_done_button);
            if (floatingActionButton != null) {
                i4 = R.id.cell_tower_list;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.cell_tower_list);
                if (listView != null) {
                    i4 = R.id.cell_tower_scan_bg_button;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.cell_tower_scan_bg_button);
                    if (button != null) {
                        i4 = R.id.cell_tower_scanning_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.cell_tower_scanning_layout);
                        if (relativeLayout != null) {
                            i4 = R.id.cell_tower_stop_scanning_button;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cell_tower_stop_scanning_button);
                            if (button2 != null) {
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                i4 = R.id.progress_spinner;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_spinner);
                                if (progressBar != null) {
                                    i4 = R.id.scanning_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.scanning_text);
                                    if (textView2 != null) {
                                        i4 = R.id.scanning_top_bar;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.scanning_top_bar);
                                        if (linearLayout != null) {
                                            return new ActivityCellTowerGroupBinding(coordinatorLayout, textView, floatingActionButton, listView, button, relativeLayout, button2, coordinatorLayout, progressBar, textView2, linearLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityCellTowerGroupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityCellTowerGroupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_cell_tower_group, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10935a;
    }
}
