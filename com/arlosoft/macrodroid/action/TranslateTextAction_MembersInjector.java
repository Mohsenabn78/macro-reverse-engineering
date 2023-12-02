package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.templatestore.translation.TranslationActionHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TranslateTextAction_MembersInjector implements MembersInjector<TranslateTextAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationActionHelper> f2707a;

    public TranslateTextAction_MembersInjector(Provider<TranslationActionHelper> provider) {
        this.f2707a = provider;
    }

    public static MembersInjector<TranslateTextAction> create(Provider<TranslationActionHelper> provider) {
        return new TranslateTextAction_MembersInjector(provider);
    }

    public static void injectTranslationHelper(TranslateTextAction translateTextAction, TranslationActionHelper translationActionHelper) {
        translateTextAction.translationHelper = translationActionHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TranslateTextAction translateTextAction) {
        injectTranslationHelper(translateTextAction, this.f2707a.get());
    }
}
