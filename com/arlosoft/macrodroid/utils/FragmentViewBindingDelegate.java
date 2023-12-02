package com.arlosoft.macrodroid.utils;

import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FragmentViewBindingDelegate.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFragmentViewBindingDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FragmentViewBindingDelegate.kt\ncom/arlosoft/macrodroid/utils/FragmentViewBindingDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
/* loaded from: classes3.dex */
public final class FragmentViewBindingDelegate<T extends ViewBinding> implements ReadOnlyProperty<Fragment, T> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f16027a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<View, T> f16028b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private T f16029c;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(@NotNull Fragment fragment, @NotNull Function1<? super View, ? extends T> viewBindingFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewBindingFactory, "viewBindingFactory");
        this.f16027a = fragment;
        this.f16028b = viewBindingFactory;
        fragment.getLifecycle().addObserver(new DefaultLifecycleObserver(this) { // from class: com.arlosoft.macrodroid.utils.FragmentViewBindingDelegate.1
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final Observer<LifecycleOwner> f16030a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentViewBindingDelegate<T> f16031b;

            {
                this.f16031b = this;
                this.f16030a = new Observer<LifecycleOwner>() { // from class: com.arlosoft.macrodroid.utils.FragmentViewBindingDelegate$1$viewLifecycleOwnerLiveDataObserver$1
                    @Override // androidx.lifecycle.Observer
                    /* renamed from: a */
                    public final void onChanged(@Nullable LifecycleOwner lifecycleOwner) {
                        if (lifecycleOwner == null) {
                            return;
                        }
                        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
                        final FragmentViewBindingDelegate<T> fragmentViewBindingDelegate = this;
                        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: com.arlosoft.macrodroid.utils.FragmentViewBindingDelegate$1$viewLifecycleOwnerLiveDataObserver$1$onChanged$1
                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                                androidx.lifecycle.d.a(this, lifecycleOwner2);
                            }

                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public void onDestroy(@NotNull LifecycleOwner owner) {
                                Intrinsics.checkNotNullParameter(owner, "owner");
                                ((FragmentViewBindingDelegate) fragmentViewBindingDelegate).f16029c = null;
                            }

                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                                androidx.lifecycle.d.c(this, lifecycleOwner2);
                            }

                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                                androidx.lifecycle.d.d(this, lifecycleOwner2);
                            }

                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                                androidx.lifecycle.d.e(this, lifecycleOwner2);
                            }

                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                                androidx.lifecycle.d.f(this, lifecycleOwner2);
                            }
                        });
                    }
                };
            }

            @NotNull
            public final Observer<LifecycleOwner> getViewLifecycleOwnerLiveDataObserver() {
                return this.f16030a;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onCreate(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.f16031b.getFragment().getViewLifecycleOwnerLiveData().observeForever(this.f16030a);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.f16031b.getFragment().getViewLifecycleOwnerLiveData().removeObserver(this.f16030a);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.d.c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.d.d(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.d.e(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.d.f(this, lifecycleOwner);
            }
        });
    }

    @NotNull
    public final Fragment getFragment() {
        return this.f16027a;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Fragment fragment, KProperty kProperty) {
        return getValue2(fragment, (KProperty<?>) kProperty);
    }

    @NotNull
    public final Function1<View, T> getViewBindingFactory() {
        return this.f16028b;
    }

    @NotNull
    /* renamed from: getValue  reason: avoid collision after fix types in other method */
    public T getValue2(@NotNull Fragment thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        T t3 = this.f16029c;
        if (t3 != null) {
            return t3;
        }
        if (this.f16027a.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            Function1<View, T> function1 = this.f16028b;
            View requireView = thisRef.requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "thisRef.requireView()");
            T invoke = function1.invoke(requireView);
            this.f16029c = invoke;
            return invoke;
        }
        throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
    }
}
