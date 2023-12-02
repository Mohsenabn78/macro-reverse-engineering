package com.arlosoft.macrodroid.troubleshooting.problem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.databinding.FragmentProblemListBinding;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProblemListFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nProblemListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProblemListFragment.kt\ncom/arlosoft/macrodroid/troubleshooting/problem/ProblemListFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,50:1\n262#2,2:51\n262#2,2:53\n262#2,2:55\n262#2,2:57\n*S KotlinDebug\n*F\n+ 1 ProblemListFragment.kt\ncom/arlosoft/macrodroid/troubleshooting/problem/ProblemListFragment\n*L\n41#1:51,2\n42#1:53,2\n46#1:55,2\n47#1:57,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ProblemListFragment extends MacroDroidDaggerBaseFragment {
    public static final int $stable = 8;

    /* renamed from: b  reason: collision with root package name */
    private FragmentProblemListBinding f15836b;
    @Inject
    public ProblemViewModel viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProblemListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Observer<List<? extends Problem>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(List<? extends Problem> it) {
            ProblemListFragment problemListFragment = ProblemListFragment.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            problemListFragment.c(it);
        }
    }

    private final void b() {
        getViewModel().getProblemList().observe(getViewLifecycleOwner(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(List<? extends Problem> list) {
        FragmentProblemListBinding fragmentProblemListBinding = null;
        if (list.isEmpty()) {
            FragmentProblemListBinding fragmentProblemListBinding2 = this.f15836b;
            if (fragmentProblemListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentProblemListBinding2 = null;
            }
            LinearLayout linearLayout = fragmentProblemListBinding2.emptyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
            linearLayout.setVisibility(0);
            FragmentProblemListBinding fragmentProblemListBinding3 = this.f15836b;
            if (fragmentProblemListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentProblemListBinding = fragmentProblemListBinding3;
            }
            RecyclerView recyclerView = fragmentProblemListBinding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            recyclerView.setVisibility(8);
            return;
        }
        ProblemsListAdapter problemsListAdapter = new ProblemsListAdapter(list);
        FragmentProblemListBinding fragmentProblemListBinding4 = this.f15836b;
        if (fragmentProblemListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentProblemListBinding4 = null;
        }
        fragmentProblemListBinding4.recyclerView.setAdapter(problemsListAdapter);
        FragmentProblemListBinding fragmentProblemListBinding5 = this.f15836b;
        if (fragmentProblemListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentProblemListBinding5 = null;
        }
        RecyclerView recyclerView2 = fragmentProblemListBinding5.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setVisibility(0);
        FragmentProblemListBinding fragmentProblemListBinding6 = this.f15836b;
        if (fragmentProblemListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentProblemListBinding = fragmentProblemListBinding6;
        }
        LinearLayout linearLayout2 = fragmentProblemListBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.emptyView");
        linearLayout2.setVisibility(8);
    }

    @NotNull
    public final ProblemViewModel getViewModel() {
        ProblemViewModel problemViewModel = this.viewModel;
        if (problemViewModel != null) {
            return problemViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        getLifecycle().addObserver(getViewModel());
        b();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentProblemListBinding inflate = FragmentProblemListBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f15836b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setViewModel(@NotNull ProblemViewModel problemViewModel) {
        Intrinsics.checkNotNullParameter(problemViewModel, "<set-?>");
        this.viewModel = problemViewModel;
    }
}
