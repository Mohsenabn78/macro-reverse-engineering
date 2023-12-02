package com.arlosoft.macrodroid.troubleshooting.problem;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProblemListFragment_MembersInjector implements MembersInjector<ProblemListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ProblemViewModel> f15838a;

    public ProblemListFragment_MembersInjector(Provider<ProblemViewModel> provider) {
        this.f15838a = provider;
    }

    public static MembersInjector<ProblemListFragment> create(Provider<ProblemViewModel> provider) {
        return new ProblemListFragment_MembersInjector(provider);
    }

    public static void injectViewModel(ProblemListFragment problemListFragment, ProblemViewModel problemViewModel) {
        problemListFragment.viewModel = problemViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ProblemListFragment problemListFragment) {
        injectViewModel(problemListFragment, this.f15838a.get());
    }
}
