package com.arlosoft.macrodroid.stopwatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.StopWatchAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.constraint.StopWatchConstraint;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.stopwatch.StopwatchesAdapter;
import com.arlosoft.macrodroid.triggers.StopwatchTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public class StopwatchesAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, List<Macro>> f13603a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f13604b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f13605c;

    /* renamed from: d  reason: collision with root package name */
    private final ClickHandler f13606d;

    /* renamed from: e  reason: collision with root package name */
    private Timer f13607e = new Timer();

    /* renamed from: f  reason: collision with root package name */
    private final int f13608f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13609g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13610h;

    /* renamed from: i  reason: collision with root package name */
    private final int f13611i;

    /* loaded from: classes3.dex */
    public interface ClickHandler {
        void onStopWatchClicked(String str);
    }

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.clear_button)
        ImageView clearButton;
        @BindView(R.id.stopwatch_macro_list)
        FlowLayout macroList;
        @BindView(R.id.play_pause_button)
        ImageView playPauseButton;
        @BindView(R.id.stopwatch_container)
        ViewGroup stopwatchContainer;
        @BindView(R.id.stopwatch_icon)
        ImageView stopwatchIcon;
        @BindView(R.id.stopwatch_name)
        TextView stopwatchNameText;
        @BindView(R.id.stopwatch_time)
        TextView stopwatchTime;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f13612a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f13612a = viewHolder;
            viewHolder.stopwatchContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.stopwatch_container, "field 'stopwatchContainer'", ViewGroup.class);
            viewHolder.stopwatchNameText = (TextView) Utils.findRequiredViewAsType(view, R.id.stopwatch_name, "field 'stopwatchNameText'", TextView.class);
            viewHolder.playPauseButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.play_pause_button, "field 'playPauseButton'", ImageView.class);
            viewHolder.stopwatchTime = (TextView) Utils.findRequiredViewAsType(view, R.id.stopwatch_time, "field 'stopwatchTime'", TextView.class);
            viewHolder.clearButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.clear_button, "field 'clearButton'", ImageView.class);
            viewHolder.stopwatchIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.stopwatch_icon, "field 'stopwatchIcon'", ImageView.class);
            viewHolder.macroList = (FlowLayout) Utils.findRequiredViewAsType(view, R.id.stopwatch_macro_list, "field 'macroList'", FlowLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f13612a;
            if (viewHolder != null) {
                this.f13612a = null;
                viewHolder.stopwatchContainer = null;
                viewHolder.stopwatchNameText = null;
                viewHolder.playPauseButton = null;
                viewHolder.stopwatchTime = null;
                viewHolder.clearButton = null;
                viewHolder.stopwatchIcon = null;
                viewHolder.macroList = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Handler f13613a;

        a(Handler handler) {
            this.f13613a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            StopwatchesAdapter.this.notifyDataSetChanged();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f13613a.post(new Runnable() { // from class: com.arlosoft.macrodroid.stopwatch.a
                @Override // java.lang.Runnable
                public final void run() {
                    StopwatchesAdapter.a.this.b();
                }
            });
        }
    }

    public StopwatchesAdapter(@NonNull List<String> list, @NonNull Context context, @NonNull ClickHandler clickHandler) {
        this.f13605c = list;
        this.f13604b = context;
        this.f13606d = clickHandler;
        this.f13607e.scheduleAtFixedRate(new a(new Handler()), 0L, 1000L);
        this.f13608f = context.getResources().getColor(R.color.white);
        this.f13609g = context.getResources().getColor(R.color.action_block_link);
        this.f13610h = context.getResources().getDimensionPixelSize(R.dimen.margin_small);
        this.f13611i = context.getResources().getDimensionPixelSize(R.dimen.margin_micro);
        refreshMacroMap();
    }

    private void f(String str, Macro macro) {
        if (str != null && macro != null) {
            List<Macro> list = this.f13603a.get(str);
            boolean z3 = true;
            if (list == null) {
                list = new ArrayList<>();
            } else {
                Iterator<Macro> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().equals(macro)) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3) {
                list.add(macro);
                this.f13603a.put(str, list);
            }
        }
    }

    private void g(Constraint constraint, Macro macro) {
        String[] possibleMagicText;
        if (constraint instanceof StopWatchConstraint) {
            f(((StopWatchConstraint) constraint).getStopwatchName(), macro);
        }
        if (constraint instanceof SupportsMagicText) {
            for (String str : ((SupportsMagicText) constraint).getPossibleMagicText()) {
                for (String str2 : this.f13605c) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!str.contains("[stopwatch=" + str2 + "]")) {
                            if (str.contains("[stopwatchtime=" + str2 + "]")) {
                            }
                        }
                        f(str2, macro);
                    }
                }
            }
        }
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                g(constraint2, macro);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(boolean z3, String str, View view) {
        if (z3) {
            StopWatch.pauseStopWatch(this.f13604b, str);
        } else {
            StopWatch.startStopWatch(this.f13604b, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str, View view) {
        StopWatch.resetStopWatch(this.f13604b, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str, View view) {
        this.f13606d.onStopWatchClicked(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean k(String str, View view) {
        this.f13606d.onStopWatchClicked(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Macro macro, View view) {
        if (macro.isActionBlock) {
            Context context = this.f13604b;
            context.startActivity(ActionBlockEditActivity.getIntent((Activity) context, true, (ActionBlock) macro, false));
            return;
        }
        Intent intent = new Intent(this.f13604b, EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        this.f13604b.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13605c.size();
    }

    public void onClose() {
        this.f13607e.cancel();
        this.f13607e = null;
    }

    public void refreshMacroMap() {
        String[] possibleMagicText;
        String[] possibleMagicText2;
        this.f13603a = new HashMap<>();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosWithActionBlocksSortedMacrosFirst()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Trigger next = it.next();
                if (next instanceof StopwatchTrigger) {
                    f(((StopwatchTrigger) next).getStopwatchName(), macro);
                }
                if (next instanceof SupportsMagicText) {
                    for (String str : ((SupportsMagicText) next).getPossibleMagicText()) {
                        for (String str2 : this.f13605c) {
                            if (!TextUtils.isEmpty(str)) {
                                if (!str.contains("[stopwatch=" + str2 + "]")) {
                                    if (str.contains("[stopwatchtime=" + str2 + "]")) {
                                    }
                                }
                                f(str2, macro);
                            }
                        }
                    }
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                if (next2 instanceof StopWatchAction) {
                    f(((StopWatchAction) next2).getStopwatchName(), macro);
                }
                if (next2 instanceof SupportsMagicText) {
                    for (String str3 : ((SupportsMagicText) next2).getPossibleMagicText()) {
                        for (String str4 : this.f13605c) {
                            if (!TextUtils.isEmpty(str3)) {
                                if (!str3.contains("[stopwatch=" + str4 + "]")) {
                                    if (str3.contains("[stopwatchtime=" + str4 + "]")) {
                                    }
                                }
                                f(str4, macro);
                            }
                        }
                    }
                }
                for (Constraint constraint : next2.getConstraints()) {
                    g(constraint, macro);
                }
            }
            for (Constraint constraint2 : macro.getConstraints()) {
                g(constraint2, macro);
            }
        }
    }

    public void setStopwatchNames(List<String> list) {
        this.f13605c = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i4) {
        final String str = this.f13605c.get(i4);
        viewHolder.stopwatchNameText.setText(str);
        viewHolder.stopwatchTime.setText(StopWatch.formatStopwatchTime(StopWatch.getStopWatchDuration(this.f13604b, str)));
        final boolean isActive = StopWatch.isActive(this.f13604b, str);
        viewHolder.stopwatchIcon.setAlpha(isActive ? 1.0f : 0.5f);
        if (isActive) {
            viewHolder.playPauseButton.setImageResource(R.drawable.ic_pause_white_24dp);
            viewHolder.playPauseButton.setContentDescription(this.f13604b.getString(R.string.action_control_media_pause));
        } else {
            viewHolder.playPauseButton.setImageResource(R.drawable.ic_play_white_24dp);
            viewHolder.playPauseButton.setContentDescription(this.f13604b.getString(R.string.start));
        }
        viewHolder.playPauseButton.setOnClickListener(new View.OnClickListener() { // from class: m0.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchesAdapter.this.h(isActive, str, view);
            }
        });
        viewHolder.clearButton.setOnClickListener(new View.OnClickListener() { // from class: m0.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchesAdapter.this.i(str, view);
            }
        });
        viewHolder.stopwatchContainer.setOnClickListener(new View.OnClickListener() { // from class: m0.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchesAdapter.this.j(str, view);
            }
        });
        viewHolder.stopwatchContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: m0.l
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean k4;
                k4 = StopwatchesAdapter.this.k(str, view);
                return k4;
            }
        });
        viewHolder.macroList.removeAllViews();
        List<Macro> list = this.f13603a.get(str);
        if (list != null) {
            for (final Macro macro : list) {
                TextView textView = new TextView(this.f13604b);
                textView.setText(macro.getName());
                textView.setTextColor(macro.isActionBlock ? this.f13609g : this.f13608f);
                textView.setTextSize(12.0f);
                textView.setPaintFlags(textView.getPaintFlags() | 8);
                int i5 = this.f13610h;
                int i6 = this.f13611i;
                textView.setPadding(i5, i6, i5, i6);
                viewHolder.macroList.addView(textView, -2, -2);
                textView.setOnClickListener(new View.OnClickListener() { // from class: m0.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StopwatchesAdapter.this.l(macro, view);
                    }
                });
            }
            return;
        }
        TextView textView2 = new TextView(this.f13604b);
        textView2.setText("(" + this.f13604b.getString(R.string.not_used) + ")");
        textView2.setTextSize(12.0f);
        textView2.setTextColor(this.f13608f);
        int i7 = this.f13610h;
        int i8 = this.f13611i;
        textView2.setPadding(i7, i8, i7, i8);
        viewHolder.macroList.addView(textView2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_stopwatch, viewGroup, false));
    }
}
