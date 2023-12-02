package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.helper.HelperResultHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ShellScriptAction_MembersInjector implements MembersInjector<ShellScriptAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HelperResultHandler> f2604a;

    public ShellScriptAction_MembersInjector(Provider<HelperResultHandler> provider) {
        this.f2604a = provider;
    }

    public static MembersInjector<ShellScriptAction> create(Provider<HelperResultHandler> provider) {
        return new ShellScriptAction_MembersInjector(provider);
    }

    public static void injectHelperResultHandler(ShellScriptAction shellScriptAction, HelperResultHandler helperResultHandler) {
        shellScriptAction.helperResultHandler = helperResultHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ShellScriptAction shellScriptAction) {
        injectHelperResultHandler(shellScriptAction, this.f2604a.get());
    }
}
