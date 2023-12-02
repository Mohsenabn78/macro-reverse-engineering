package com.google.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    private static final PostalAddress DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private int revision_;
    private String regionCode_ = "";
    private String languageCode_ = "";
    private String postalCode_ = "";
    private String sortingCode_ = "";
    private String administrativeArea_ = "";
    private String locality_ = "";
    private String sublocality_ = "";
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.y();
    private String organization_ = "";

    /* renamed from: com.google.type.PostalAddress$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33674a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f33674a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33674a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAddressLines(String str) {
            f();
            ((PostalAddress) this.f33398b).Q0(str);
            return this;
        }

        public Builder addAddressLinesBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).R0(byteString);
            return this;
        }

        public Builder addAllAddressLines(Iterable<String> iterable) {
            f();
            ((PostalAddress) this.f33398b).S0(iterable);
            return this;
        }

        public Builder addAllRecipients(Iterable<String> iterable) {
            f();
            ((PostalAddress) this.f33398b).T0(iterable);
            return this;
        }

        public Builder addRecipients(String str) {
            f();
            ((PostalAddress) this.f33398b).U0(str);
            return this;
        }

        public Builder addRecipientsBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).V0(byteString);
            return this;
        }

        public Builder clearAddressLines() {
            f();
            ((PostalAddress) this.f33398b).W0();
            return this;
        }

        public Builder clearAdministrativeArea() {
            f();
            ((PostalAddress) this.f33398b).X0();
            return this;
        }

        public Builder clearLanguageCode() {
            f();
            ((PostalAddress) this.f33398b).Y0();
            return this;
        }

        public Builder clearLocality() {
            f();
            ((PostalAddress) this.f33398b).Z0();
            return this;
        }

        public Builder clearOrganization() {
            f();
            ((PostalAddress) this.f33398b).a1();
            return this;
        }

        public Builder clearPostalCode() {
            f();
            ((PostalAddress) this.f33398b).b1();
            return this;
        }

        public Builder clearRecipients() {
            f();
            ((PostalAddress) this.f33398b).c1();
            return this;
        }

        public Builder clearRegionCode() {
            f();
            ((PostalAddress) this.f33398b).d1();
            return this;
        }

        public Builder clearRevision() {
            f();
            ((PostalAddress) this.f33398b).e1();
            return this;
        }

        public Builder clearSortingCode() {
            f();
            ((PostalAddress) this.f33398b).f1();
            return this;
        }

        public Builder clearSublocality() {
            f();
            ((PostalAddress) this.f33398b).g1();
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAddressLines(int i4) {
            return ((PostalAddress) this.f33398b).getAddressLines(i4);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAddressLinesBytes(int i4) {
            return ((PostalAddress) this.f33398b).getAddressLinesBytes(i4);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getAddressLinesCount() {
            return ((PostalAddress) this.f33398b).getAddressLinesCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.f33398b).getAddressLinesList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAdministrativeArea() {
            return ((PostalAddress) this.f33398b).getAdministrativeArea();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.f33398b).getAdministrativeAreaBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLanguageCode() {
            return ((PostalAddress) this.f33398b).getLanguageCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.f33398b).getLanguageCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLocality() {
            return ((PostalAddress) this.f33398b).getLocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLocalityBytes() {
            return ((PostalAddress) this.f33398b).getLocalityBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getOrganization() {
            return ((PostalAddress) this.f33398b).getOrganization();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getOrganizationBytes() {
            return ((PostalAddress) this.f33398b).getOrganizationBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getPostalCode() {
            return ((PostalAddress) this.f33398b).getPostalCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.f33398b).getPostalCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRecipients(int i4) {
            return ((PostalAddress) this.f33398b).getRecipients(i4);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRecipientsBytes(int i4) {
            return ((PostalAddress) this.f33398b).getRecipientsBytes(i4);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRecipientsCount() {
            return ((PostalAddress) this.f33398b).getRecipientsCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.f33398b).getRecipientsList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRegionCode() {
            return ((PostalAddress) this.f33398b).getRegionCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.f33398b).getRegionCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRevision() {
            return ((PostalAddress) this.f33398b).getRevision();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSortingCode() {
            return ((PostalAddress) this.f33398b).getSortingCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.f33398b).getSortingCodeBytes();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSublocality() {
            return ((PostalAddress) this.f33398b).getSublocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSublocalityBytes() {
            return ((PostalAddress) this.f33398b).getSublocalityBytes();
        }

        public Builder setAddressLines(int i4, String str) {
            f();
            ((PostalAddress) this.f33398b).j1(i4, str);
            return this;
        }

        public Builder setAdministrativeArea(String str) {
            f();
            ((PostalAddress) this.f33398b).k1(str);
            return this;
        }

        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).l1(byteString);
            return this;
        }

        public Builder setLanguageCode(String str) {
            f();
            ((PostalAddress) this.f33398b).m1(str);
            return this;
        }

        public Builder setLanguageCodeBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).n1(byteString);
            return this;
        }

        public Builder setLocality(String str) {
            f();
            ((PostalAddress) this.f33398b).o1(str);
            return this;
        }

        public Builder setLocalityBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).p1(byteString);
            return this;
        }

        public Builder setOrganization(String str) {
            f();
            ((PostalAddress) this.f33398b).q1(str);
            return this;
        }

        public Builder setOrganizationBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).r1(byteString);
            return this;
        }

        public Builder setPostalCode(String str) {
            f();
            ((PostalAddress) this.f33398b).s1(str);
            return this;
        }

        public Builder setPostalCodeBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).t1(byteString);
            return this;
        }

        public Builder setRecipients(int i4, String str) {
            f();
            ((PostalAddress) this.f33398b).u1(i4, str);
            return this;
        }

        public Builder setRegionCode(String str) {
            f();
            ((PostalAddress) this.f33398b).v1(str);
            return this;
        }

        public Builder setRegionCodeBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).w1(byteString);
            return this;
        }

        public Builder setRevision(int i4) {
            f();
            ((PostalAddress) this.f33398b).x1(i4);
            return this;
        }

        public Builder setSortingCode(String str) {
            f();
            ((PostalAddress) this.f33398b).y1(str);
            return this;
        }

        public Builder setSortingCodeBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).z1(byteString);
            return this;
        }

        public Builder setSublocality(String str) {
            f();
            ((PostalAddress) this.f33398b).A1(str);
            return this;
        }

        public Builder setSublocalityBytes(ByteString byteString) {
            f();
            ((PostalAddress) this.f33398b).B1(byteString);
            return this;
        }

        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }
    }

    static {
        PostalAddress postalAddress = new PostalAddress();
        DEFAULT_INSTANCE = postalAddress;
        GeneratedMessageLite.d0(PostalAddress.class, postalAddress);
    }

    private PostalAddress() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(String str) {
        str.getClass();
        this.sublocality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.sublocality_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(String str) {
        str.getClass();
        h1();
        this.addressLines_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        h1();
        this.addressLines_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(Iterable<String> iterable) {
        h1();
        AbstractMessageLite.a(iterable, this.addressLines_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Iterable<String> iterable) {
        i1();
        AbstractMessageLite.a(iterable, this.recipients_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(String str) {
        str.getClass();
        i1();
        this.recipients_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        i1();
        this.recipients_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.addressLines_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        this.recipients_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        this.revision_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void h1() {
        Internal.ProtobufList<String> protobufList = this.addressLines_;
        if (!protobufList.isModifiable()) {
            this.addressLines_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void i1() {
        Internal.ProtobufList<String> protobufList = this.recipients_;
        if (!protobufList.isModifiable()) {
            this.recipients_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(int i4, String str) {
        str.getClass();
        h1();
        this.addressLines_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(String str) {
        str.getClass();
        this.administrativeArea_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.administrativeArea_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(String str) {
        str.getClass();
        this.languageCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.languageCode_ = byteString.toStringUtf8();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(String str) {
        str.getClass();
        this.locality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.locality_ = byteString.toStringUtf8();
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(String str) {
        str.getClass();
        this.organization_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.organization_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.postalCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int i4, String str) {
        str.getClass();
        i1();
        this.recipients_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(String str) {
        str.getClass();
        this.regionCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.regionCode_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(int i4) {
        this.revision_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(String str) {
        str.getClass();
        this.sortingCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.sortingCode_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAddressLines(int i4) {
        return this.addressLines_.get(i4);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAddressLinesBytes(int i4) {
        return ByteString.copyFromUtf8(this.addressLines_.get(i4));
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLanguageCode() {
        return this.languageCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLocality() {
        return this.locality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getOrganization() {
        return this.organization_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getPostalCode() {
        return this.postalCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRecipients(int i4) {
        return this.recipients_.get(i4);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRecipientsBytes(int i4) {
        return ByteString.copyFromUtf8(this.recipients_.get(i4));
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public List<String> getRecipientsList() {
        return this.recipients_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRegionCode() {
        return this.regionCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRevision() {
        return this.revision_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSortingCode() {
        return this.sortingCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSublocality() {
        return this.sublocality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f33674a[methodToInvoke.ordinal()]) {
            case 1:
                return new PostalAddress();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȚ\nȚ\u000bȈ", new Object[]{"revision_", "regionCode_", "languageCode_", "postalCode_", "sortingCode_", "administrativeArea_", "locality_", "sublocality_", "addressLines_", "recipients_", "organization_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PostalAddress> parser = PARSER;
                if (parser == null) {
                    synchronized (PostalAddress.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.r(postalAddress);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
