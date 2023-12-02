package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
final class SingleFileMetadataSourceImpl implements MetadataSource {

    /* renamed from: a  reason: collision with root package name */
    private final String f32898a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataLoader f32899b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<MetadataManager.SingleFileMetadataMaps> f32900c;

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata a(String str) {
        return MetadataManager.f(this.f32900c, this.f32898a, this.f32899b).b(str);
    }

    @Override // com.google.i18n.phonenumbers.MetadataSource
    public Phonemetadata.PhoneMetadata b(int i4) {
        return MetadataManager.f(this.f32900c, this.f32898a, this.f32899b).a(i4);
    }
}
