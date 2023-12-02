package com.google.api.services.gmail;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.gmail.model.AutoForwarding;
import com.google.api.services.gmail.model.BatchDeleteMessagesRequest;
import com.google.api.services.gmail.model.BatchModifyMessagesRequest;
import com.google.api.services.gmail.model.Draft;
import com.google.api.services.gmail.model.Filter;
import com.google.api.services.gmail.model.ForwardingAddress;
import com.google.api.services.gmail.model.ImapSettings;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListDraftsResponse;
import com.google.api.services.gmail.model.ListFiltersResponse;
import com.google.api.services.gmail.model.ListForwardingAddressesResponse;
import com.google.api.services.gmail.model.ListHistoryResponse;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.ListSendAsResponse;
import com.google.api.services.gmail.model.ListSmimeInfoResponse;
import com.google.api.services.gmail.model.ListThreadsResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePartBody;
import com.google.api.services.gmail.model.ModifyMessageRequest;
import com.google.api.services.gmail.model.ModifyThreadRequest;
import com.google.api.services.gmail.model.PopSettings;
import com.google.api.services.gmail.model.Profile;
import com.google.api.services.gmail.model.Thread;
import com.google.api.services.gmail.model.VacationSettings;
import com.google.api.services.gmail.model.WatchRequest;
import com.google.api.services.gmail.model.WatchResponse;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public class Gmail extends AbstractGoogleJsonClient {
    public static final String DEFAULT_BASE_URL = "https://www.googleapis.com/gmail/v1/users/";
    public static final String DEFAULT_BATCH_PATH = "batch/gmail/v1";
    public static final String DEFAULT_ROOT_URL = "https://www.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "gmail/v1/users/";

    /* loaded from: classes5.dex */
    public static final class Builder extends AbstractGoogleJsonClient.Builder {
        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
            super(httpTransport, jsonFactory, Gmail.DEFAULT_ROOT_URL, Gmail.DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
            setBatchPath(Gmail.DEFAULT_BATCH_PATH);
        }

        public Builder setGmailRequestInitializer(GmailRequestInitializer gmailRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer((GoogleClientRequestInitializer) gmailRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setBatchPath(String str) {
            return (Builder) super.setBatchPath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Gmail build() {
            return new Gmail(this);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setApplicationName(String str) {
            return (Builder) super.setApplicationName(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setRootUrl(String str) {
            return (Builder) super.setRootUrl(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setServicePath(String str) {
            return (Builder) super.setServicePath(str);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressAllChecks(boolean z3) {
            return (Builder) super.setSuppressAllChecks(z3);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressPatternChecks(boolean z3) {
            return (Builder) super.setSuppressPatternChecks(z3);
        }

        @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder, com.google.api.client.googleapis.services.AbstractGoogleClient.Builder
        public Builder setSuppressRequiredParameterChecks(boolean z3) {
            return (Builder) super.setSuppressRequiredParameterChecks(z3);
        }
    }

    /* loaded from: classes5.dex */
    public class Users {

        /* loaded from: classes5.dex */
        public class GetProfile extends GmailRequest<Profile> {
            @Key
            private String userId;

            protected GetProfile(String str) {
                super(Gmail.this, "GET", "{userId}/profile", null, Profile.class);
                this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public String getUserId() {
                return this.userId;
            }

            public GetProfile setUserId(String str) {
                this.userId = str;
                return this;
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setAlt */
            public GmailRequest<Profile> setAlt2(String str) {
                return (GetProfile) super.setAlt(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setFields */
            public GmailRequest<Profile> setFields2(String str) {
                return (GetProfile) super.setFields(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setKey */
            public GmailRequest<Profile> setKey2(String str) {
                return (GetProfile) super.setKey(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setOauthToken */
            public GmailRequest<Profile> setOauthToken2(String str) {
                return (GetProfile) super.setOauthToken(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setPrettyPrint */
            public GmailRequest<Profile> setPrettyPrint2(Boolean bool) {
                return (GetProfile) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setQuotaUser */
            public GmailRequest<Profile> setQuotaUser2(String str) {
                return (GetProfile) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setUserIp */
            public GmailRequest<Profile> setUserIp2(String str) {
                return (GetProfile) super.setUserIp(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public GetProfile set(String str, Object obj) {
                return (GetProfile) super.set(str, obj);
            }
        }

        /* loaded from: classes5.dex */
        public class History {

            /* loaded from: classes5.dex */
            public class List extends GmailRequest<ListHistoryResponse> {
                @Key
                private java.util.List<String> historyTypes;
                @Key
                private String labelId;
                @Key
                private Long maxResults;
                @Key
                private String pageToken;
                @Key
                private BigInteger startHistoryId;
                @Key
                private String userId;

                protected List(String str) {
                    super(Gmail.this, "GET", "{userId}/history", null, ListHistoryResponse.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public java.util.List<String> getHistoryTypes() {
                    return this.historyTypes;
                }

                public String getLabelId() {
                    return this.labelId;
                }

                public Long getMaxResults() {
                    return this.maxResults;
                }

                public String getPageToken() {
                    return this.pageToken;
                }

                public BigInteger getStartHistoryId() {
                    return this.startHistoryId;
                }

                public String getUserId() {
                    return this.userId;
                }

                public List setHistoryTypes(java.util.List<String> list) {
                    this.historyTypes = list;
                    return this;
                }

                public List setLabelId(String str) {
                    this.labelId = str;
                    return this;
                }

                public List setMaxResults(Long l4) {
                    this.maxResults = l4;
                    return this;
                }

                public List setPageToken(String str) {
                    this.pageToken = str;
                    return this;
                }

                public List setStartHistoryId(BigInteger bigInteger) {
                    this.startHistoryId = bigInteger;
                    return this;
                }

                public List setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ListHistoryResponse> setAlt2(String str) {
                    return (List) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ListHistoryResponse> setFields2(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ListHistoryResponse> setKey2(String str) {
                    return (List) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ListHistoryResponse> setOauthToken2(String str) {
                    return (List) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ListHistoryResponse> setPrettyPrint2(Boolean bool) {
                    return (List) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ListHistoryResponse> setQuotaUser2(String str) {
                    return (List) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ListHistoryResponse> setUserIp2(String str) {
                    return (List) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            public History() {
            }

            public List list(String str) throws IOException {
                List list = new List(str);
                Gmail.this.a(list);
                return list;
            }
        }

        /* loaded from: classes5.dex */
        public class Labels {

            /* loaded from: classes5.dex */
            public class Create extends GmailRequest<Label> {
                @Key
                private String userId;

                protected Create(String str, Label label) {
                    super(Gmail.this, "POST", "{userId}/labels", label, Label.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getLabelListVisibility(), "Label.getLabelListVisibility()");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getMessageListVisibility(), "Label.getMessageListVisibility()");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getName(), "Label.getName()");
                }

                public String getUserId() {
                    return this.userId;
                }

                public Create setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Label> setAlt2(String str) {
                    return (Create) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Label> setFields2(String str) {
                    return (Create) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Label> setKey2(String str) {
                    return (Create) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Label> setOauthToken2(String str) {
                    return (Create) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Label> setPrettyPrint2(Boolean bool) {
                    return (Create) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Label> setQuotaUser2(String str) {
                    return (Create) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Label> setUserIp2(String str) {
                    return (Create) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Create set(String str, Object obj) {
                    return (Create) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Delete extends GmailRequest<Void> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Delete(String str, String str2) {
                    super(Gmail.this, "DELETE", "{userId}/labels/{id}", null, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Delete setId(String str) {
                    this.id = str;
                    return this;
                }

                public Delete setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (Delete) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (Delete) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (Delete) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (Delete) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (Delete) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (Delete) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Get extends GmailRequest<Label> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Get(String str, String str2) {
                    super(Gmail.this, "GET", "{userId}/labels/{id}", null, Label.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Get setId(String str) {
                    this.id = str;
                    return this;
                }

                public Get setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Label> setAlt2(String str) {
                    return (Get) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Label> setFields2(String str) {
                    return (Get) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Label> setKey2(String str) {
                    return (Get) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Label> setOauthToken2(String str) {
                    return (Get) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Label> setPrettyPrint2(Boolean bool) {
                    return (Get) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Label> setQuotaUser2(String str) {
                    return (Get) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Label> setUserIp2(String str) {
                    return (Get) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Get set(String str, Object obj) {
                    return (Get) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class List extends GmailRequest<ListLabelsResponse> {
                @Key
                private String userId;

                protected List(String str) {
                    super(Gmail.this, "GET", "{userId}/labels", null, ListLabelsResponse.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getUserId() {
                    return this.userId;
                }

                public List setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ListLabelsResponse> setAlt2(String str) {
                    return (List) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ListLabelsResponse> setFields2(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ListLabelsResponse> setKey2(String str) {
                    return (List) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ListLabelsResponse> setOauthToken2(String str) {
                    return (List) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ListLabelsResponse> setPrettyPrint2(Boolean bool) {
                    return (List) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ListLabelsResponse> setQuotaUser2(String str) {
                    return (List) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ListLabelsResponse> setUserIp2(String str) {
                    return (List) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Patch extends GmailRequest<Label> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Patch(String str, String str2, Label label) {
                    super(Gmail.this, HttpMethods.PATCH, "{userId}/labels/{id}", label, Label.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Patch setId(String str) {
                    this.id = str;
                    return this;
                }

                public Patch setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Label> setAlt2(String str) {
                    return (Patch) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Label> setFields2(String str) {
                    return (Patch) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Label> setKey2(String str) {
                    return (Patch) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Label> setOauthToken2(String str) {
                    return (Patch) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Label> setPrettyPrint2(Boolean bool) {
                    return (Patch) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Label> setQuotaUser2(String str) {
                    return (Patch) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Label> setUserIp2(String str) {
                    return (Patch) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Patch set(String str, Object obj) {
                    return (Patch) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Update extends GmailRequest<Label> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Update(String str, String str2, Label label) {
                    super(Gmail.this, "PUT", "{userId}/labels/{id}", label, Label.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getId(), "Label.getId()");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getLabelListVisibility(), "Label.getLabelListVisibility()");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getMessageListVisibility(), "Label.getMessageListVisibility()");
                    c(label, FirebaseAnalytics.Param.CONTENT);
                    c(label.getName(), "Label.getName()");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Update setId(String str) {
                    this.id = str;
                    return this;
                }

                public Update setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Label> setAlt2(String str) {
                    return (Update) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Label> setFields2(String str) {
                    return (Update) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Label> setKey2(String str) {
                    return (Update) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Label> setOauthToken2(String str) {
                    return (Update) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Label> setPrettyPrint2(Boolean bool) {
                    return (Update) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Label> setQuotaUser2(String str) {
                    return (Update) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Label> setUserIp2(String str) {
                    return (Update) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Update set(String str, Object obj) {
                    return (Update) super.set(str, obj);
                }
            }

            public Labels() {
            }

            public Create create(String str, Label label) throws IOException {
                Create create = new Create(str, label);
                Gmail.this.a(create);
                return create;
            }

            public Delete delete(String str, String str2) throws IOException {
                Delete delete = new Delete(str, str2);
                Gmail.this.a(delete);
                return delete;
            }

            public Get get(String str, String str2) throws IOException {
                Get get = new Get(str, str2);
                Gmail.this.a(get);
                return get;
            }

            public List list(String str) throws IOException {
                List list = new List(str);
                Gmail.this.a(list);
                return list;
            }

            public Patch patch(String str, String str2, Label label) throws IOException {
                Patch patch = new Patch(str, str2, label);
                Gmail.this.a(patch);
                return patch;
            }

            public Update update(String str, String str2, Label label) throws IOException {
                Update update = new Update(str, str2, label);
                Gmail.this.a(update);
                return update;
            }
        }

        /* loaded from: classes5.dex */
        public class Settings {

            /* loaded from: classes5.dex */
            public class Filters {

                /* loaded from: classes5.dex */
                public class Create extends GmailRequest<Filter> {
                    @Key
                    private String userId;

                    protected Create(String str, Filter filter) {
                        super(Gmail.this, "POST", "{userId}/settings/filters", filter, Filter.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Create setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Filter> setAlt2(String str) {
                        return (Create) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Filter> setFields2(String str) {
                        return (Create) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Filter> setKey2(String str) {
                        return (Create) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Filter> setOauthToken2(String str) {
                        return (Create) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Filter> setPrettyPrint2(Boolean bool) {
                        return (Create) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Filter> setQuotaUser2(String str) {
                        return (Create) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Filter> setUserIp2(String str) {
                        return (Create) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Create set(String str, Object obj) {
                        return (Create) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Delete extends GmailRequest<Void> {
                    @Key
                    private String id;
                    @Key
                    private String userId;

                    protected Delete(String str, String str2) {
                        super(Gmail.this, "DELETE", "{userId}/settings/filters/{id}", null, Void.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                    }

                    public String getId() {
                        return this.id;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Delete setId(String str) {
                        this.id = str;
                        return this;
                    }

                    public Delete setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Void> setAlt2(String str) {
                        return (Delete) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Void> setFields2(String str) {
                        return (Delete) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Void> setKey2(String str) {
                        return (Delete) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Void> setOauthToken2(String str) {
                        return (Delete) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                        return (Delete) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Void> setQuotaUser2(String str) {
                        return (Delete) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Void> setUserIp2(String str) {
                        return (Delete) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Delete set(String str, Object obj) {
                        return (Delete) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Get extends GmailRequest<Filter> {
                    @Key
                    private String id;
                    @Key
                    private String userId;

                    protected Get(String str, String str2) {
                        super(Gmail.this, "GET", "{userId}/settings/filters/{id}", null, Filter.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getId() {
                        return this.id;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Get setId(String str) {
                        this.id = str;
                        return this;
                    }

                    public Get setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Filter> setAlt2(String str) {
                        return (Get) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Filter> setFields2(String str) {
                        return (Get) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Filter> setKey2(String str) {
                        return (Get) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Filter> setOauthToken2(String str) {
                        return (Get) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Filter> setPrettyPrint2(Boolean bool) {
                        return (Get) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Filter> setQuotaUser2(String str) {
                        return (Get) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Filter> setUserIp2(String str) {
                        return (Get) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class List extends GmailRequest<ListFiltersResponse> {
                    @Key
                    private String userId;

                    protected List(String str) {
                        super(Gmail.this, "GET", "{userId}/settings/filters", null, ListFiltersResponse.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public List setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<ListFiltersResponse> setAlt2(String str) {
                        return (List) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<ListFiltersResponse> setFields2(String str) {
                        return (List) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<ListFiltersResponse> setKey2(String str) {
                        return (List) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<ListFiltersResponse> setOauthToken2(String str) {
                        return (List) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<ListFiltersResponse> setPrettyPrint2(Boolean bool) {
                        return (List) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<ListFiltersResponse> setQuotaUser2(String str) {
                        return (List) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<ListFiltersResponse> setUserIp2(String str) {
                        return (List) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public List set(String str, Object obj) {
                        return (List) super.set(str, obj);
                    }
                }

                public Filters() {
                }

                public Create create(String str, Filter filter) throws IOException {
                    Create create = new Create(str, filter);
                    Gmail.this.a(create);
                    return create;
                }

                public Delete delete(String str, String str2) throws IOException {
                    Delete delete = new Delete(str, str2);
                    Gmail.this.a(delete);
                    return delete;
                }

                public Get get(String str, String str2) throws IOException {
                    Get get = new Get(str, str2);
                    Gmail.this.a(get);
                    return get;
                }

                public List list(String str) throws IOException {
                    List list = new List(str);
                    Gmail.this.a(list);
                    return list;
                }
            }

            /* loaded from: classes5.dex */
            public class ForwardingAddresses {

                /* loaded from: classes5.dex */
                public class Create extends GmailRequest<ForwardingAddress> {
                    @Key
                    private String userId;

                    protected Create(String str, ForwardingAddress forwardingAddress) {
                        super(Gmail.this, "POST", "{userId}/settings/forwardingAddresses", forwardingAddress, ForwardingAddress.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Create setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<ForwardingAddress> setAlt2(String str) {
                        return (Create) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<ForwardingAddress> setFields2(String str) {
                        return (Create) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<ForwardingAddress> setKey2(String str) {
                        return (Create) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<ForwardingAddress> setOauthToken2(String str) {
                        return (Create) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<ForwardingAddress> setPrettyPrint2(Boolean bool) {
                        return (Create) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<ForwardingAddress> setQuotaUser2(String str) {
                        return (Create) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<ForwardingAddress> setUserIp2(String str) {
                        return (Create) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Create set(String str, Object obj) {
                        return (Create) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Delete extends GmailRequest<Void> {
                    @Key
                    private String forwardingEmail;
                    @Key
                    private String userId;

                    protected Delete(String str, String str2) {
                        super(Gmail.this, "DELETE", "{userId}/settings/forwardingAddresses/{forwardingEmail}", null, Void.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.forwardingEmail = (String) Preconditions.checkNotNull(str2, "Required parameter forwardingEmail must be specified.");
                    }

                    public String getForwardingEmail() {
                        return this.forwardingEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Delete setForwardingEmail(String str) {
                        this.forwardingEmail = str;
                        return this;
                    }

                    public Delete setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Void> setAlt2(String str) {
                        return (Delete) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Void> setFields2(String str) {
                        return (Delete) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Void> setKey2(String str) {
                        return (Delete) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Void> setOauthToken2(String str) {
                        return (Delete) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                        return (Delete) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Void> setQuotaUser2(String str) {
                        return (Delete) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Void> setUserIp2(String str) {
                        return (Delete) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Delete set(String str, Object obj) {
                        return (Delete) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Get extends GmailRequest<ForwardingAddress> {
                    @Key
                    private String forwardingEmail;
                    @Key
                    private String userId;

                    protected Get(String str, String str2) {
                        super(Gmail.this, "GET", "{userId}/settings/forwardingAddresses/{forwardingEmail}", null, ForwardingAddress.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.forwardingEmail = (String) Preconditions.checkNotNull(str2, "Required parameter forwardingEmail must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getForwardingEmail() {
                        return this.forwardingEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Get setForwardingEmail(String str) {
                        this.forwardingEmail = str;
                        return this;
                    }

                    public Get setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<ForwardingAddress> setAlt2(String str) {
                        return (Get) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<ForwardingAddress> setFields2(String str) {
                        return (Get) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<ForwardingAddress> setKey2(String str) {
                        return (Get) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<ForwardingAddress> setOauthToken2(String str) {
                        return (Get) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<ForwardingAddress> setPrettyPrint2(Boolean bool) {
                        return (Get) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<ForwardingAddress> setQuotaUser2(String str) {
                        return (Get) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<ForwardingAddress> setUserIp2(String str) {
                        return (Get) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class List extends GmailRequest<ListForwardingAddressesResponse> {
                    @Key
                    private String userId;

                    protected List(String str) {
                        super(Gmail.this, "GET", "{userId}/settings/forwardingAddresses", null, ListForwardingAddressesResponse.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public List setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<ListForwardingAddressesResponse> setAlt2(String str) {
                        return (List) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<ListForwardingAddressesResponse> setFields2(String str) {
                        return (List) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<ListForwardingAddressesResponse> setKey2(String str) {
                        return (List) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<ListForwardingAddressesResponse> setOauthToken2(String str) {
                        return (List) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<ListForwardingAddressesResponse> setPrettyPrint2(Boolean bool) {
                        return (List) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<ListForwardingAddressesResponse> setQuotaUser2(String str) {
                        return (List) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<ListForwardingAddressesResponse> setUserIp2(String str) {
                        return (List) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public List set(String str, Object obj) {
                        return (List) super.set(str, obj);
                    }
                }

                public ForwardingAddresses() {
                }

                public Create create(String str, ForwardingAddress forwardingAddress) throws IOException {
                    Create create = new Create(str, forwardingAddress);
                    Gmail.this.a(create);
                    return create;
                }

                public Delete delete(String str, String str2) throws IOException {
                    Delete delete = new Delete(str, str2);
                    Gmail.this.a(delete);
                    return delete;
                }

                public Get get(String str, String str2) throws IOException {
                    Get get = new Get(str, str2);
                    Gmail.this.a(get);
                    return get;
                }

                public List list(String str) throws IOException {
                    List list = new List(str);
                    Gmail.this.a(list);
                    return list;
                }
            }

            /* loaded from: classes5.dex */
            public class GetAutoForwarding extends GmailRequest<AutoForwarding> {
                @Key
                private String userId;

                protected GetAutoForwarding(String str) {
                    super(Gmail.this, "GET", "{userId}/settings/autoForwarding", null, AutoForwarding.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getUserId() {
                    return this.userId;
                }

                public GetAutoForwarding setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<AutoForwarding> setAlt2(String str) {
                    return (GetAutoForwarding) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<AutoForwarding> setFields2(String str) {
                    return (GetAutoForwarding) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<AutoForwarding> setKey2(String str) {
                    return (GetAutoForwarding) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<AutoForwarding> setOauthToken2(String str) {
                    return (GetAutoForwarding) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<AutoForwarding> setPrettyPrint2(Boolean bool) {
                    return (GetAutoForwarding) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<AutoForwarding> setQuotaUser2(String str) {
                    return (GetAutoForwarding) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<AutoForwarding> setUserIp2(String str) {
                    return (GetAutoForwarding) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public GetAutoForwarding set(String str, Object obj) {
                    return (GetAutoForwarding) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class GetImap extends GmailRequest<ImapSettings> {
                @Key
                private String userId;

                protected GetImap(String str) {
                    super(Gmail.this, "GET", "{userId}/settings/imap", null, ImapSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getUserId() {
                    return this.userId;
                }

                public GetImap setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ImapSettings> setAlt2(String str) {
                    return (GetImap) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ImapSettings> setFields2(String str) {
                    return (GetImap) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ImapSettings> setKey2(String str) {
                    return (GetImap) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ImapSettings> setOauthToken2(String str) {
                    return (GetImap) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ImapSettings> setPrettyPrint2(Boolean bool) {
                    return (GetImap) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ImapSettings> setQuotaUser2(String str) {
                    return (GetImap) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ImapSettings> setUserIp2(String str) {
                    return (GetImap) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public GetImap set(String str, Object obj) {
                    return (GetImap) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class GetPop extends GmailRequest<PopSettings> {
                @Key
                private String userId;

                protected GetPop(String str) {
                    super(Gmail.this, "GET", "{userId}/settings/pop", null, PopSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getUserId() {
                    return this.userId;
                }

                public GetPop setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<PopSettings> setAlt2(String str) {
                    return (GetPop) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<PopSettings> setFields2(String str) {
                    return (GetPop) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<PopSettings> setKey2(String str) {
                    return (GetPop) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<PopSettings> setOauthToken2(String str) {
                    return (GetPop) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<PopSettings> setPrettyPrint2(Boolean bool) {
                    return (GetPop) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<PopSettings> setQuotaUser2(String str) {
                    return (GetPop) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<PopSettings> setUserIp2(String str) {
                    return (GetPop) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public GetPop set(String str, Object obj) {
                    return (GetPop) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class GetVacation extends GmailRequest<VacationSettings> {
                @Key
                private String userId;

                protected GetVacation(String str) {
                    super(Gmail.this, "GET", "{userId}/settings/vacation", null, VacationSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getUserId() {
                    return this.userId;
                }

                public GetVacation setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<VacationSettings> setAlt2(String str) {
                    return (GetVacation) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<VacationSettings> setFields2(String str) {
                    return (GetVacation) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<VacationSettings> setKey2(String str) {
                    return (GetVacation) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<VacationSettings> setOauthToken2(String str) {
                    return (GetVacation) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<VacationSettings> setPrettyPrint2(Boolean bool) {
                    return (GetVacation) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<VacationSettings> setQuotaUser2(String str) {
                    return (GetVacation) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<VacationSettings> setUserIp2(String str) {
                    return (GetVacation) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public GetVacation set(String str, Object obj) {
                    return (GetVacation) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class SendAs {

                /* loaded from: classes5.dex */
                public class Create extends GmailRequest<com.google.api.services.gmail.model.SendAs> {
                    @Key
                    private String userId;

                    protected Create(String str, com.google.api.services.gmail.model.SendAs sendAs) {
                        super(Gmail.this, "POST", "{userId}/settings/sendAs", sendAs, com.google.api.services.gmail.model.SendAs.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Create setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setAlt2(String str) {
                        return (Create) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setFields2(String str) {
                        return (Create) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setKey2(String str) {
                        return (Create) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setOauthToken2(String str) {
                        return (Create) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setPrettyPrint2(Boolean bool) {
                        return (Create) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setQuotaUser2(String str) {
                        return (Create) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setUserIp2(String str) {
                        return (Create) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Create set(String str, Object obj) {
                        return (Create) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Delete extends GmailRequest<Void> {
                    @Key
                    private String sendAsEmail;
                    @Key
                    private String userId;

                    protected Delete(String str, String str2) {
                        super(Gmail.this, "DELETE", "{userId}/settings/sendAs/{sendAsEmail}", null, Void.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                    }

                    public String getSendAsEmail() {
                        return this.sendAsEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Delete setSendAsEmail(String str) {
                        this.sendAsEmail = str;
                        return this;
                    }

                    public Delete setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Void> setAlt2(String str) {
                        return (Delete) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Void> setFields2(String str) {
                        return (Delete) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Void> setKey2(String str) {
                        return (Delete) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Void> setOauthToken2(String str) {
                        return (Delete) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                        return (Delete) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Void> setQuotaUser2(String str) {
                        return (Delete) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Void> setUserIp2(String str) {
                        return (Delete) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Delete set(String str, Object obj) {
                        return (Delete) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Get extends GmailRequest<com.google.api.services.gmail.model.SendAs> {
                    @Key
                    private String sendAsEmail;
                    @Key
                    private String userId;

                    protected Get(String str, String str2) {
                        super(Gmail.this, "GET", "{userId}/settings/sendAs/{sendAsEmail}", null, com.google.api.services.gmail.model.SendAs.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getSendAsEmail() {
                        return this.sendAsEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Get setSendAsEmail(String str) {
                        this.sendAsEmail = str;
                        return this;
                    }

                    public Get setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setAlt2(String str) {
                        return (Get) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setFields2(String str) {
                        return (Get) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setKey2(String str) {
                        return (Get) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setOauthToken2(String str) {
                        return (Get) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setPrettyPrint2(Boolean bool) {
                        return (Get) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setQuotaUser2(String str) {
                        return (Get) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setUserIp2(String str) {
                        return (Get) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class List extends GmailRequest<ListSendAsResponse> {
                    @Key
                    private String userId;

                    protected List(String str) {
                        super(Gmail.this, "GET", "{userId}/settings/sendAs", null, ListSendAsResponse.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public List setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<ListSendAsResponse> setAlt2(String str) {
                        return (List) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<ListSendAsResponse> setFields2(String str) {
                        return (List) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<ListSendAsResponse> setKey2(String str) {
                        return (List) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<ListSendAsResponse> setOauthToken2(String str) {
                        return (List) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<ListSendAsResponse> setPrettyPrint2(Boolean bool) {
                        return (List) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<ListSendAsResponse> setQuotaUser2(String str) {
                        return (List) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<ListSendAsResponse> setUserIp2(String str) {
                        return (List) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public List set(String str, Object obj) {
                        return (List) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Patch extends GmailRequest<com.google.api.services.gmail.model.SendAs> {
                    @Key
                    private String sendAsEmail;
                    @Key
                    private String userId;

                    protected Patch(String str, String str2, com.google.api.services.gmail.model.SendAs sendAs) {
                        super(Gmail.this, HttpMethods.PATCH, "{userId}/settings/sendAs/{sendAsEmail}", sendAs, com.google.api.services.gmail.model.SendAs.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                    }

                    public String getSendAsEmail() {
                        return this.sendAsEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Patch setSendAsEmail(String str) {
                        this.sendAsEmail = str;
                        return this;
                    }

                    public Patch setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setAlt2(String str) {
                        return (Patch) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setFields2(String str) {
                        return (Patch) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setKey2(String str) {
                        return (Patch) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setOauthToken2(String str) {
                        return (Patch) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setPrettyPrint2(Boolean bool) {
                        return (Patch) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setQuotaUser2(String str) {
                        return (Patch) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setUserIp2(String str) {
                        return (Patch) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Patch set(String str, Object obj) {
                        return (Patch) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class SmimeInfo {

                    /* loaded from: classes5.dex */
                    public class Delete extends GmailRequest<Void> {
                        @Key
                        private String id;
                        @Key
                        private String sendAsEmail;
                        @Key
                        private String userId;

                        protected Delete(String str, String str2, String str3) {
                            super(Gmail.this, "DELETE", "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}", null, Void.class);
                            this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                            this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                            this.id = (String) Preconditions.checkNotNull(str3, "Required parameter id must be specified.");
                        }

                        public String getId() {
                            return this.id;
                        }

                        public String getSendAsEmail() {
                            return this.sendAsEmail;
                        }

                        public String getUserId() {
                            return this.userId;
                        }

                        public Delete setId(String str) {
                            this.id = str;
                            return this;
                        }

                        public Delete setSendAsEmail(String str) {
                            this.sendAsEmail = str;
                            return this;
                        }

                        public Delete setUserId(String str) {
                            this.userId = str;
                            return this;
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setAlt */
                        public GmailRequest<Void> setAlt2(String str) {
                            return (Delete) super.setAlt(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setFields */
                        public GmailRequest<Void> setFields2(String str) {
                            return (Delete) super.setFields(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setKey */
                        public GmailRequest<Void> setKey2(String str) {
                            return (Delete) super.setKey(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setOauthToken */
                        public GmailRequest<Void> setOauthToken2(String str) {
                            return (Delete) super.setOauthToken(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setPrettyPrint */
                        public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                            return (Delete) super.setPrettyPrint(bool);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setQuotaUser */
                        public GmailRequest<Void> setQuotaUser2(String str) {
                            return (Delete) super.setQuotaUser(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setUserIp */
                        public GmailRequest<Void> setUserIp2(String str) {
                            return (Delete) super.setUserIp(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                        public Delete set(String str, Object obj) {
                            return (Delete) super.set(str, obj);
                        }
                    }

                    /* loaded from: classes5.dex */
                    public class Get extends GmailRequest<com.google.api.services.gmail.model.SmimeInfo> {
                        @Key
                        private String id;
                        @Key
                        private String sendAsEmail;
                        @Key
                        private String userId;

                        protected Get(String str, String str2, String str3) {
                            super(Gmail.this, "GET", "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}", null, com.google.api.services.gmail.model.SmimeInfo.class);
                            this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                            this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                            this.id = (String) Preconditions.checkNotNull(str3, "Required parameter id must be specified.");
                        }

                        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                        public HttpRequest buildHttpRequestUsingHead() throws IOException {
                            return super.buildHttpRequestUsingHead();
                        }

                        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                        public HttpResponse executeUsingHead() throws IOException {
                            return super.executeUsingHead();
                        }

                        public String getId() {
                            return this.id;
                        }

                        public String getSendAsEmail() {
                            return this.sendAsEmail;
                        }

                        public String getUserId() {
                            return this.userId;
                        }

                        public Get setId(String str) {
                            this.id = str;
                            return this;
                        }

                        public Get setSendAsEmail(String str) {
                            this.sendAsEmail = str;
                            return this;
                        }

                        public Get setUserId(String str) {
                            this.userId = str;
                            return this;
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setAlt */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setAlt2(String str) {
                            return (Get) super.setAlt(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setFields */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setFields2(String str) {
                            return (Get) super.setFields(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setKey */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setKey2(String str) {
                            return (Get) super.setKey(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setOauthToken */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setOauthToken2(String str) {
                            return (Get) super.setOauthToken(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setPrettyPrint */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setPrettyPrint2(Boolean bool) {
                            return (Get) super.setPrettyPrint(bool);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setQuotaUser */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setQuotaUser2(String str) {
                            return (Get) super.setQuotaUser(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setUserIp */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setUserIp2(String str) {
                            return (Get) super.setUserIp(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                        public Get set(String str, Object obj) {
                            return (Get) super.set(str, obj);
                        }
                    }

                    /* loaded from: classes5.dex */
                    public class Insert extends GmailRequest<com.google.api.services.gmail.model.SmimeInfo> {
                        @Key
                        private String sendAsEmail;
                        @Key
                        private String userId;

                        protected Insert(String str, String str2, com.google.api.services.gmail.model.SmimeInfo smimeInfo) {
                            super(Gmail.this, "POST", "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo", smimeInfo, com.google.api.services.gmail.model.SmimeInfo.class);
                            this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                            this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                        }

                        public String getSendAsEmail() {
                            return this.sendAsEmail;
                        }

                        public String getUserId() {
                            return this.userId;
                        }

                        public Insert setSendAsEmail(String str) {
                            this.sendAsEmail = str;
                            return this;
                        }

                        public Insert setUserId(String str) {
                            this.userId = str;
                            return this;
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setAlt */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setAlt2(String str) {
                            return (Insert) super.setAlt(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setFields */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setFields2(String str) {
                            return (Insert) super.setFields(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setKey */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setKey2(String str) {
                            return (Insert) super.setKey(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setOauthToken */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setOauthToken2(String str) {
                            return (Insert) super.setOauthToken(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setPrettyPrint */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setPrettyPrint2(Boolean bool) {
                            return (Insert) super.setPrettyPrint(bool);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setQuotaUser */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setQuotaUser2(String str) {
                            return (Insert) super.setQuotaUser(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setUserIp */
                        public GmailRequest<com.google.api.services.gmail.model.SmimeInfo> setUserIp2(String str) {
                            return (Insert) super.setUserIp(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                        public Insert set(String str, Object obj) {
                            return (Insert) super.set(str, obj);
                        }
                    }

                    /* loaded from: classes5.dex */
                    public class List extends GmailRequest<ListSmimeInfoResponse> {
                        @Key
                        private String sendAsEmail;
                        @Key
                        private String userId;

                        protected List(String str, String str2) {
                            super(Gmail.this, "GET", "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo", null, ListSmimeInfoResponse.class);
                            this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                            this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                        }

                        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                        public HttpRequest buildHttpRequestUsingHead() throws IOException {
                            return super.buildHttpRequestUsingHead();
                        }

                        @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                        public HttpResponse executeUsingHead() throws IOException {
                            return super.executeUsingHead();
                        }

                        public String getSendAsEmail() {
                            return this.sendAsEmail;
                        }

                        public String getUserId() {
                            return this.userId;
                        }

                        public List setSendAsEmail(String str) {
                            this.sendAsEmail = str;
                            return this;
                        }

                        public List setUserId(String str) {
                            this.userId = str;
                            return this;
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setAlt */
                        public GmailRequest<ListSmimeInfoResponse> setAlt2(String str) {
                            return (List) super.setAlt(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setFields */
                        public GmailRequest<ListSmimeInfoResponse> setFields2(String str) {
                            return (List) super.setFields(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setKey */
                        public GmailRequest<ListSmimeInfoResponse> setKey2(String str) {
                            return (List) super.setKey(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setOauthToken */
                        public GmailRequest<ListSmimeInfoResponse> setOauthToken2(String str) {
                            return (List) super.setOauthToken(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setPrettyPrint */
                        public GmailRequest<ListSmimeInfoResponse> setPrettyPrint2(Boolean bool) {
                            return (List) super.setPrettyPrint(bool);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setQuotaUser */
                        public GmailRequest<ListSmimeInfoResponse> setQuotaUser2(String str) {
                            return (List) super.setQuotaUser(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setUserIp */
                        public GmailRequest<ListSmimeInfoResponse> setUserIp2(String str) {
                            return (List) super.setUserIp(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                        public List set(String str, Object obj) {
                            return (List) super.set(str, obj);
                        }
                    }

                    /* loaded from: classes5.dex */
                    public class SetDefault extends GmailRequest<Void> {
                        @Key
                        private String id;
                        @Key
                        private String sendAsEmail;
                        @Key
                        private String userId;

                        protected SetDefault(String str, String str2, String str3) {
                            super(Gmail.this, "POST", "{userId}/settings/sendAs/{sendAsEmail}/smimeInfo/{id}/setDefault", null, Void.class);
                            this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                            this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                            this.id = (String) Preconditions.checkNotNull(str3, "Required parameter id must be specified.");
                        }

                        public String getId() {
                            return this.id;
                        }

                        public String getSendAsEmail() {
                            return this.sendAsEmail;
                        }

                        public String getUserId() {
                            return this.userId;
                        }

                        public SetDefault setId(String str) {
                            this.id = str;
                            return this;
                        }

                        public SetDefault setSendAsEmail(String str) {
                            this.sendAsEmail = str;
                            return this;
                        }

                        public SetDefault setUserId(String str) {
                            this.userId = str;
                            return this;
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setAlt */
                        public GmailRequest<Void> setAlt2(String str) {
                            return (SetDefault) super.setAlt(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setFields */
                        public GmailRequest<Void> setFields2(String str) {
                            return (SetDefault) super.setFields(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setKey */
                        public GmailRequest<Void> setKey2(String str) {
                            return (SetDefault) super.setKey(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setOauthToken */
                        public GmailRequest<Void> setOauthToken2(String str) {
                            return (SetDefault) super.setOauthToken(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setPrettyPrint */
                        public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                            return (SetDefault) super.setPrettyPrint(bool);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setQuotaUser */
                        public GmailRequest<Void> setQuotaUser2(String str) {
                            return (SetDefault) super.setQuotaUser(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest
                        /* renamed from: setUserIp */
                        public GmailRequest<Void> setUserIp2(String str) {
                            return (SetDefault) super.setUserIp(str);
                        }

                        @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                        public SetDefault set(String str, Object obj) {
                            return (SetDefault) super.set(str, obj);
                        }
                    }

                    public SmimeInfo() {
                    }

                    public Delete delete(String str, String str2, String str3) throws IOException {
                        Delete delete = new Delete(str, str2, str3);
                        Gmail.this.a(delete);
                        return delete;
                    }

                    public Get get(String str, String str2, String str3) throws IOException {
                        Get get = new Get(str, str2, str3);
                        Gmail.this.a(get);
                        return get;
                    }

                    public Insert insert(String str, String str2, com.google.api.services.gmail.model.SmimeInfo smimeInfo) throws IOException {
                        Insert insert = new Insert(str, str2, smimeInfo);
                        Gmail.this.a(insert);
                        return insert;
                    }

                    public List list(String str, String str2) throws IOException {
                        List list = new List(str, str2);
                        Gmail.this.a(list);
                        return list;
                    }

                    public SetDefault setDefault(String str, String str2, String str3) throws IOException {
                        SetDefault setDefault = new SetDefault(str, str2, str3);
                        Gmail.this.a(setDefault);
                        return setDefault;
                    }
                }

                /* loaded from: classes5.dex */
                public class Update extends GmailRequest<com.google.api.services.gmail.model.SendAs> {
                    @Key
                    private String sendAsEmail;
                    @Key
                    private String userId;

                    protected Update(String str, String str2, com.google.api.services.gmail.model.SendAs sendAs) {
                        super(Gmail.this, "PUT", "{userId}/settings/sendAs/{sendAsEmail}", sendAs, com.google.api.services.gmail.model.SendAs.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                    }

                    public String getSendAsEmail() {
                        return this.sendAsEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Update setSendAsEmail(String str) {
                        this.sendAsEmail = str;
                        return this;
                    }

                    public Update setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setAlt2(String str) {
                        return (Update) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setFields2(String str) {
                        return (Update) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setKey2(String str) {
                        return (Update) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setOauthToken2(String str) {
                        return (Update) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setPrettyPrint2(Boolean bool) {
                        return (Update) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setQuotaUser2(String str) {
                        return (Update) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<com.google.api.services.gmail.model.SendAs> setUserIp2(String str) {
                        return (Update) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Update set(String str, Object obj) {
                        return (Update) super.set(str, obj);
                    }
                }

                /* loaded from: classes5.dex */
                public class Verify extends GmailRequest<Void> {
                    @Key
                    private String sendAsEmail;
                    @Key
                    private String userId;

                    protected Verify(String str, String str2) {
                        super(Gmail.this, "POST", "{userId}/settings/sendAs/{sendAsEmail}/verify", null, Void.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.sendAsEmail = (String) Preconditions.checkNotNull(str2, "Required parameter sendAsEmail must be specified.");
                    }

                    public String getSendAsEmail() {
                        return this.sendAsEmail;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Verify setSendAsEmail(String str) {
                        this.sendAsEmail = str;
                        return this;
                    }

                    public Verify setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<Void> setAlt2(String str) {
                        return (Verify) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<Void> setFields2(String str) {
                        return (Verify) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<Void> setKey2(String str) {
                        return (Verify) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<Void> setOauthToken2(String str) {
                        return (Verify) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                        return (Verify) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<Void> setQuotaUser2(String str) {
                        return (Verify) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<Void> setUserIp2(String str) {
                        return (Verify) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Verify set(String str, Object obj) {
                        return (Verify) super.set(str, obj);
                    }
                }

                public SendAs() {
                }

                public Create create(String str, com.google.api.services.gmail.model.SendAs sendAs) throws IOException {
                    Create create = new Create(str, sendAs);
                    Gmail.this.a(create);
                    return create;
                }

                public Delete delete(String str, String str2) throws IOException {
                    Delete delete = new Delete(str, str2);
                    Gmail.this.a(delete);
                    return delete;
                }

                public Get get(String str, String str2) throws IOException {
                    Get get = new Get(str, str2);
                    Gmail.this.a(get);
                    return get;
                }

                public List list(String str) throws IOException {
                    List list = new List(str);
                    Gmail.this.a(list);
                    return list;
                }

                public Patch patch(String str, String str2, com.google.api.services.gmail.model.SendAs sendAs) throws IOException {
                    Patch patch = new Patch(str, str2, sendAs);
                    Gmail.this.a(patch);
                    return patch;
                }

                public SmimeInfo smimeInfo() {
                    return new SmimeInfo();
                }

                public Update update(String str, String str2, com.google.api.services.gmail.model.SendAs sendAs) throws IOException {
                    Update update = new Update(str, str2, sendAs);
                    Gmail.this.a(update);
                    return update;
                }

                public Verify verify(String str, String str2) throws IOException {
                    Verify verify = new Verify(str, str2);
                    Gmail.this.a(verify);
                    return verify;
                }
            }

            /* loaded from: classes5.dex */
            public class UpdateAutoForwarding extends GmailRequest<AutoForwarding> {
                @Key
                private String userId;

                protected UpdateAutoForwarding(String str, AutoForwarding autoForwarding) {
                    super(Gmail.this, "PUT", "{userId}/settings/autoForwarding", autoForwarding, AutoForwarding.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public UpdateAutoForwarding setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<AutoForwarding> setAlt2(String str) {
                    return (UpdateAutoForwarding) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<AutoForwarding> setFields2(String str) {
                    return (UpdateAutoForwarding) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<AutoForwarding> setKey2(String str) {
                    return (UpdateAutoForwarding) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<AutoForwarding> setOauthToken2(String str) {
                    return (UpdateAutoForwarding) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<AutoForwarding> setPrettyPrint2(Boolean bool) {
                    return (UpdateAutoForwarding) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<AutoForwarding> setQuotaUser2(String str) {
                    return (UpdateAutoForwarding) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<AutoForwarding> setUserIp2(String str) {
                    return (UpdateAutoForwarding) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public UpdateAutoForwarding set(String str, Object obj) {
                    return (UpdateAutoForwarding) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class UpdateImap extends GmailRequest<ImapSettings> {
                @Key
                private String userId;

                protected UpdateImap(String str, ImapSettings imapSettings) {
                    super(Gmail.this, "PUT", "{userId}/settings/imap", imapSettings, ImapSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public UpdateImap setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ImapSettings> setAlt2(String str) {
                    return (UpdateImap) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ImapSettings> setFields2(String str) {
                    return (UpdateImap) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ImapSettings> setKey2(String str) {
                    return (UpdateImap) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ImapSettings> setOauthToken2(String str) {
                    return (UpdateImap) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ImapSettings> setPrettyPrint2(Boolean bool) {
                    return (UpdateImap) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ImapSettings> setQuotaUser2(String str) {
                    return (UpdateImap) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ImapSettings> setUserIp2(String str) {
                    return (UpdateImap) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public UpdateImap set(String str, Object obj) {
                    return (UpdateImap) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class UpdatePop extends GmailRequest<PopSettings> {
                @Key
                private String userId;

                protected UpdatePop(String str, PopSettings popSettings) {
                    super(Gmail.this, "PUT", "{userId}/settings/pop", popSettings, PopSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public UpdatePop setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<PopSettings> setAlt2(String str) {
                    return (UpdatePop) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<PopSettings> setFields2(String str) {
                    return (UpdatePop) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<PopSettings> setKey2(String str) {
                    return (UpdatePop) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<PopSettings> setOauthToken2(String str) {
                    return (UpdatePop) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<PopSettings> setPrettyPrint2(Boolean bool) {
                    return (UpdatePop) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<PopSettings> setQuotaUser2(String str) {
                    return (UpdatePop) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<PopSettings> setUserIp2(String str) {
                    return (UpdatePop) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public UpdatePop set(String str, Object obj) {
                    return (UpdatePop) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class UpdateVacation extends GmailRequest<VacationSettings> {
                @Key
                private String userId;

                protected UpdateVacation(String str, VacationSettings vacationSettings) {
                    super(Gmail.this, "PUT", "{userId}/settings/vacation", vacationSettings, VacationSettings.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public UpdateVacation setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<VacationSettings> setAlt2(String str) {
                    return (UpdateVacation) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<VacationSettings> setFields2(String str) {
                    return (UpdateVacation) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<VacationSettings> setKey2(String str) {
                    return (UpdateVacation) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<VacationSettings> setOauthToken2(String str) {
                    return (UpdateVacation) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<VacationSettings> setPrettyPrint2(Boolean bool) {
                    return (UpdateVacation) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<VacationSettings> setQuotaUser2(String str) {
                    return (UpdateVacation) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<VacationSettings> setUserIp2(String str) {
                    return (UpdateVacation) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public UpdateVacation set(String str, Object obj) {
                    return (UpdateVacation) super.set(str, obj);
                }
            }

            public Settings() {
            }

            public Filters filters() {
                return new Filters();
            }

            public ForwardingAddresses forwardingAddresses() {
                return new ForwardingAddresses();
            }

            public GetAutoForwarding getAutoForwarding(String str) throws IOException {
                GetAutoForwarding getAutoForwarding = new GetAutoForwarding(str);
                Gmail.this.a(getAutoForwarding);
                return getAutoForwarding;
            }

            public GetImap getImap(String str) throws IOException {
                GetImap getImap = new GetImap(str);
                Gmail.this.a(getImap);
                return getImap;
            }

            public GetPop getPop(String str) throws IOException {
                GetPop getPop = new GetPop(str);
                Gmail.this.a(getPop);
                return getPop;
            }

            public GetVacation getVacation(String str) throws IOException {
                GetVacation getVacation = new GetVacation(str);
                Gmail.this.a(getVacation);
                return getVacation;
            }

            public SendAs sendAs() {
                return new SendAs();
            }

            public UpdateAutoForwarding updateAutoForwarding(String str, AutoForwarding autoForwarding) throws IOException {
                UpdateAutoForwarding updateAutoForwarding = new UpdateAutoForwarding(str, autoForwarding);
                Gmail.this.a(updateAutoForwarding);
                return updateAutoForwarding;
            }

            public UpdateImap updateImap(String str, ImapSettings imapSettings) throws IOException {
                UpdateImap updateImap = new UpdateImap(str, imapSettings);
                Gmail.this.a(updateImap);
                return updateImap;
            }

            public UpdatePop updatePop(String str, PopSettings popSettings) throws IOException {
                UpdatePop updatePop = new UpdatePop(str, popSettings);
                Gmail.this.a(updatePop);
                return updatePop;
            }

            public UpdateVacation updateVacation(String str, VacationSettings vacationSettings) throws IOException {
                UpdateVacation updateVacation = new UpdateVacation(str, vacationSettings);
                Gmail.this.a(updateVacation);
                return updateVacation;
            }
        }

        /* loaded from: classes5.dex */
        public class Stop extends GmailRequest<Void> {
            @Key
            private String userId;

            protected Stop(String str) {
                super(Gmail.this, "POST", "{userId}/stop", null, Void.class);
                this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
            }

            public String getUserId() {
                return this.userId;
            }

            public Stop setUserId(String str) {
                this.userId = str;
                return this;
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setAlt */
            public GmailRequest<Void> setAlt2(String str) {
                return (Stop) super.setAlt(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setFields */
            public GmailRequest<Void> setFields2(String str) {
                return (Stop) super.setFields(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setKey */
            public GmailRequest<Void> setKey2(String str) {
                return (Stop) super.setKey(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setOauthToken */
            public GmailRequest<Void> setOauthToken2(String str) {
                return (Stop) super.setOauthToken(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setPrettyPrint */
            public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                return (Stop) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setQuotaUser */
            public GmailRequest<Void> setQuotaUser2(String str) {
                return (Stop) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setUserIp */
            public GmailRequest<Void> setUserIp2(String str) {
                return (Stop) super.setUserIp(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Stop set(String str, Object obj) {
                return (Stop) super.set(str, obj);
            }
        }

        /* loaded from: classes5.dex */
        public class Threads {

            /* loaded from: classes5.dex */
            public class Delete extends GmailRequest<Void> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Delete(String str, String str2) {
                    super(Gmail.this, "DELETE", "{userId}/threads/{id}", null, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Delete setId(String str) {
                    this.id = str;
                    return this;
                }

                public Delete setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (Delete) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (Delete) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (Delete) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (Delete) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (Delete) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (Delete) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Get extends GmailRequest<Thread> {
                @Key
                private String format;
                @Key
                private String id;
                @Key
                private java.util.List<String> metadataHeaders;
                @Key
                private String userId;

                protected Get(String str, String str2) {
                    super(Gmail.this, "GET", "{userId}/threads/{id}", null, Thread.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getFormat() {
                    return this.format;
                }

                public String getId() {
                    return this.id;
                }

                public java.util.List<String> getMetadataHeaders() {
                    return this.metadataHeaders;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Get setFormat(String str) {
                    this.format = str;
                    return this;
                }

                public Get setId(String str) {
                    this.id = str;
                    return this;
                }

                public Get setMetadataHeaders(java.util.List<String> list) {
                    this.metadataHeaders = list;
                    return this;
                }

                public Get setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Thread> setAlt2(String str) {
                    return (Get) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Thread> setFields2(String str) {
                    return (Get) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Thread> setKey2(String str) {
                    return (Get) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Thread> setOauthToken2(String str) {
                    return (Get) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Thread> setPrettyPrint2(Boolean bool) {
                    return (Get) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Thread> setQuotaUser2(String str) {
                    return (Get) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Thread> setUserIp2(String str) {
                    return (Get) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Get set(String str, Object obj) {
                    return (Get) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class List extends GmailRequest<ListThreadsResponse> {
                @Key
                private Boolean includeSpamTrash;
                @Key
                private java.util.List<String> labelIds;
                @Key
                private Long maxResults;
                @Key
                private String pageToken;
                @Key

                /* renamed from: q  reason: collision with root package name */
                private String f26249q;
                @Key
                private String userId;

                protected List(String str) {
                    super(Gmail.this, "GET", "{userId}/threads", null, ListThreadsResponse.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public Boolean getIncludeSpamTrash() {
                    return this.includeSpamTrash;
                }

                public java.util.List<String> getLabelIds() {
                    return this.labelIds;
                }

                public Long getMaxResults() {
                    return this.maxResults;
                }

                public String getPageToken() {
                    return this.pageToken;
                }

                public String getQ() {
                    return this.f26249q;
                }

                public String getUserId() {
                    return this.userId;
                }

                public boolean isIncludeSpamTrash() {
                    Boolean bool = this.includeSpamTrash;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public List setIncludeSpamTrash(Boolean bool) {
                    this.includeSpamTrash = bool;
                    return this;
                }

                public List setLabelIds(java.util.List<String> list) {
                    this.labelIds = list;
                    return this;
                }

                public List setMaxResults(Long l4) {
                    this.maxResults = l4;
                    return this;
                }

                public List setPageToken(String str) {
                    this.pageToken = str;
                    return this;
                }

                public List setQ(String str) {
                    this.f26249q = str;
                    return this;
                }

                public List setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ListThreadsResponse> setAlt2(String str) {
                    return (List) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ListThreadsResponse> setFields2(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ListThreadsResponse> setKey2(String str) {
                    return (List) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ListThreadsResponse> setOauthToken2(String str) {
                    return (List) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ListThreadsResponse> setPrettyPrint2(Boolean bool) {
                    return (List) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ListThreadsResponse> setQuotaUser2(String str) {
                    return (List) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ListThreadsResponse> setUserIp2(String str) {
                    return (List) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Modify extends GmailRequest<Thread> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Modify(String str, String str2, ModifyThreadRequest modifyThreadRequest) {
                    super(Gmail.this, "POST", "{userId}/threads/{id}/modify", modifyThreadRequest, Thread.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Modify setId(String str) {
                    this.id = str;
                    return this;
                }

                public Modify setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Thread> setAlt2(String str) {
                    return (Modify) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Thread> setFields2(String str) {
                    return (Modify) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Thread> setKey2(String str) {
                    return (Modify) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Thread> setOauthToken2(String str) {
                    return (Modify) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Thread> setPrettyPrint2(Boolean bool) {
                    return (Modify) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Thread> setQuotaUser2(String str) {
                    return (Modify) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Thread> setUserIp2(String str) {
                    return (Modify) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Modify set(String str, Object obj) {
                    return (Modify) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Trash extends GmailRequest<Thread> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Trash(String str, String str2) {
                    super(Gmail.this, "POST", "{userId}/threads/{id}/trash", null, Thread.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Trash setId(String str) {
                    this.id = str;
                    return this;
                }

                public Trash setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Thread> setAlt2(String str) {
                    return (Trash) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Thread> setFields2(String str) {
                    return (Trash) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Thread> setKey2(String str) {
                    return (Trash) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Thread> setOauthToken2(String str) {
                    return (Trash) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Thread> setPrettyPrint2(Boolean bool) {
                    return (Trash) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Thread> setQuotaUser2(String str) {
                    return (Trash) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Thread> setUserIp2(String str) {
                    return (Trash) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Trash set(String str, Object obj) {
                    return (Trash) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Untrash extends GmailRequest<Thread> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Untrash(String str, String str2) {
                    super(Gmail.this, "POST", "{userId}/threads/{id}/untrash", null, Thread.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Untrash setId(String str) {
                    this.id = str;
                    return this;
                }

                public Untrash setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Thread> setAlt2(String str) {
                    return (Untrash) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Thread> setFields2(String str) {
                    return (Untrash) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Thread> setKey2(String str) {
                    return (Untrash) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Thread> setOauthToken2(String str) {
                    return (Untrash) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Thread> setPrettyPrint2(Boolean bool) {
                    return (Untrash) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Thread> setQuotaUser2(String str) {
                    return (Untrash) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Thread> setUserIp2(String str) {
                    return (Untrash) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Untrash set(String str, Object obj) {
                    return (Untrash) super.set(str, obj);
                }
            }

            public Threads() {
            }

            public Delete delete(String str, String str2) throws IOException {
                Delete delete = new Delete(str, str2);
                Gmail.this.a(delete);
                return delete;
            }

            public Get get(String str, String str2) throws IOException {
                Get get = new Get(str, str2);
                Gmail.this.a(get);
                return get;
            }

            public List list(String str) throws IOException {
                List list = new List(str);
                Gmail.this.a(list);
                return list;
            }

            public Modify modify(String str, String str2, ModifyThreadRequest modifyThreadRequest) throws IOException {
                Modify modify = new Modify(str, str2, modifyThreadRequest);
                Gmail.this.a(modify);
                return modify;
            }

            public Trash trash(String str, String str2) throws IOException {
                Trash trash = new Trash(str, str2);
                Gmail.this.a(trash);
                return trash;
            }

            public Untrash untrash(String str, String str2) throws IOException {
                Untrash untrash = new Untrash(str, str2);
                Gmail.this.a(untrash);
                return untrash;
            }
        }

        /* loaded from: classes5.dex */
        public class Watch extends GmailRequest<WatchResponse> {
            @Key
            private String userId;

            protected Watch(String str, WatchRequest watchRequest) {
                super(Gmail.this, "POST", "{userId}/watch", watchRequest, WatchResponse.class);
                this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
            }

            public String getUserId() {
                return this.userId;
            }

            public Watch setUserId(String str) {
                this.userId = str;
                return this;
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setAlt */
            public GmailRequest<WatchResponse> setAlt2(String str) {
                return (Watch) super.setAlt(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setFields */
            public GmailRequest<WatchResponse> setFields2(String str) {
                return (Watch) super.setFields(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setKey */
            public GmailRequest<WatchResponse> setKey2(String str) {
                return (Watch) super.setKey(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setOauthToken */
            public GmailRequest<WatchResponse> setOauthToken2(String str) {
                return (Watch) super.setOauthToken(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setPrettyPrint */
            public GmailRequest<WatchResponse> setPrettyPrint2(Boolean bool) {
                return (Watch) super.setPrettyPrint(bool);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setQuotaUser */
            public GmailRequest<WatchResponse> setQuotaUser2(String str) {
                return (Watch) super.setQuotaUser(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest
            /* renamed from: setUserIp */
            public GmailRequest<WatchResponse> setUserIp2(String str) {
                return (Watch) super.setUserIp(str);
            }

            @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
            public Watch set(String str, Object obj) {
                return (Watch) super.set(str, obj);
            }
        }

        public Users() {
        }

        public Drafts drafts() {
            return new Drafts();
        }

        public GetProfile getProfile(String str) throws IOException {
            GetProfile getProfile = new GetProfile(str);
            Gmail.this.a(getProfile);
            return getProfile;
        }

        public History history() {
            return new History();
        }

        public Labels labels() {
            return new Labels();
        }

        public Messages messages() {
            return new Messages();
        }

        public Settings settings() {
            return new Settings();
        }

        public Stop stop(String str) throws IOException {
            Stop stop = new Stop(str);
            Gmail.this.a(stop);
            return stop;
        }

        public Threads threads() {
            return new Threads();
        }

        public Watch watch(String str, WatchRequest watchRequest) throws IOException {
            Watch watch = new Watch(str, watchRequest);
            Gmail.this.a(watch);
            return watch;
        }

        /* loaded from: classes5.dex */
        public class Drafts {

            /* loaded from: classes5.dex */
            public class Create extends GmailRequest<Draft> {
                @Key
                private String userId;

                protected Create(String str, Draft draft) {
                    super(Gmail.this, "POST", "{userId}/drafts", draft, Draft.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public Create setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Draft> setAlt2(String str) {
                    return (Create) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Draft> setFields2(String str) {
                    return (Create) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Draft> setKey2(String str) {
                    return (Create) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Draft> setOauthToken2(String str) {
                    return (Create) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Draft> setPrettyPrint2(Boolean bool) {
                    return (Create) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Draft> setQuotaUser2(String str) {
                    return (Create) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Draft> setUserIp2(String str) {
                    return (Create) super.setUserIp(str);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected Create(java.lang.String r9, com.google.api.services.gmail.model.Draft r10, com.google.api.client.http.AbstractInputStreamContent r11) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Drafts.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "POST"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/drafts"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Draft> r6 = com.google.api.services.gmail.model.Draft.class
                        r1 = r7
                        r5 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        r7.e(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Drafts.Create.<init>(com.google.api.services.gmail.Gmail$Users$Drafts, java.lang.String, com.google.api.services.gmail.model.Draft, com.google.api.client.http.AbstractInputStreamContent):void");
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Create set(String str, Object obj) {
                    return (Create) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Delete extends GmailRequest<Void> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Delete(String str, String str2) {
                    super(Gmail.this, "DELETE", "{userId}/drafts/{id}", null, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Delete setId(String str) {
                    this.id = str;
                    return this;
                }

                public Delete setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (Delete) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (Delete) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (Delete) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (Delete) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (Delete) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (Delete) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Get extends GmailRequest<Draft> {
                @Key
                private String format;
                @Key
                private String id;
                @Key
                private String userId;

                protected Get(String str, String str2) {
                    super(Gmail.this, "GET", "{userId}/drafts/{id}", null, Draft.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getFormat() {
                    return this.format;
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Get setFormat(String str) {
                    this.format = str;
                    return this;
                }

                public Get setId(String str) {
                    this.id = str;
                    return this;
                }

                public Get setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Draft> setAlt2(String str) {
                    return (Get) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Draft> setFields2(String str) {
                    return (Get) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Draft> setKey2(String str) {
                    return (Get) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Draft> setOauthToken2(String str) {
                    return (Get) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Draft> setPrettyPrint2(Boolean bool) {
                    return (Get) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Draft> setQuotaUser2(String str) {
                    return (Get) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Draft> setUserIp2(String str) {
                    return (Get) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Get set(String str, Object obj) {
                    return (Get) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class List extends GmailRequest<ListDraftsResponse> {
                @Key
                private Boolean includeSpamTrash;
                @Key
                private Long maxResults;
                @Key
                private String pageToken;
                @Key

                /* renamed from: q  reason: collision with root package name */
                private String f26183q;
                @Key
                private String userId;

                protected List(String str) {
                    super(Gmail.this, "GET", "{userId}/drafts", null, ListDraftsResponse.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public Boolean getIncludeSpamTrash() {
                    return this.includeSpamTrash;
                }

                public Long getMaxResults() {
                    return this.maxResults;
                }

                public String getPageToken() {
                    return this.pageToken;
                }

                public String getQ() {
                    return this.f26183q;
                }

                public String getUserId() {
                    return this.userId;
                }

                public boolean isIncludeSpamTrash() {
                    Boolean bool = this.includeSpamTrash;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public List setIncludeSpamTrash(Boolean bool) {
                    this.includeSpamTrash = bool;
                    return this;
                }

                public List setMaxResults(Long l4) {
                    this.maxResults = l4;
                    return this;
                }

                public List setPageToken(String str) {
                    this.pageToken = str;
                    return this;
                }

                public List setQ(String str) {
                    this.f26183q = str;
                    return this;
                }

                public List setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ListDraftsResponse> setAlt2(String str) {
                    return (List) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ListDraftsResponse> setFields2(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ListDraftsResponse> setKey2(String str) {
                    return (List) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ListDraftsResponse> setOauthToken2(String str) {
                    return (List) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ListDraftsResponse> setPrettyPrint2(Boolean bool) {
                    return (List) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ListDraftsResponse> setQuotaUser2(String str) {
                    return (List) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ListDraftsResponse> setUserIp2(String str) {
                    return (List) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Send extends GmailRequest<Message> {
                @Key
                private String userId;

                protected Send(String str, Draft draft) {
                    super(Gmail.this, "POST", "{userId}/drafts/send", draft, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public Send setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Send) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Send) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Send) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Send) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Send) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Send) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Send) super.setUserIp(str);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected Send(java.lang.String r9, com.google.api.services.gmail.model.Draft r10, com.google.api.client.http.AbstractInputStreamContent r11) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Drafts.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "POST"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/drafts/send"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Message> r6 = com.google.api.services.gmail.model.Message.class
                        r1 = r7
                        r5 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        r7.e(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Drafts.Send.<init>(com.google.api.services.gmail.Gmail$Users$Drafts, java.lang.String, com.google.api.services.gmail.model.Draft, com.google.api.client.http.AbstractInputStreamContent):void");
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Send set(String str, Object obj) {
                    return (Send) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Update extends GmailRequest<Draft> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Update(String str, String str2, Draft draft) {
                    super(Gmail.this, "PUT", "{userId}/drafts/{id}", draft, Draft.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Update setId(String str) {
                    this.id = str;
                    return this;
                }

                public Update setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Draft> setAlt2(String str) {
                    return (Update) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Draft> setFields2(String str) {
                    return (Update) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Draft> setKey2(String str) {
                    return (Update) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Draft> setOauthToken2(String str) {
                    return (Update) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Draft> setPrettyPrint2(Boolean bool) {
                    return (Update) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Draft> setQuotaUser2(String str) {
                    return (Update) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Draft> setUserIp2(String str) {
                    return (Update) super.setUserIp(str);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected Update(java.lang.String r9, java.lang.String r10, com.google.api.services.gmail.model.Draft r11, com.google.api.client.http.AbstractInputStreamContent r12) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Drafts.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "PUT"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/drafts/{id}"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Draft> r6 = com.google.api.services.gmail.model.Draft.class
                        r1 = r7
                        r5 = r11
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        java.lang.String r8 = "Required parameter id must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r10, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.id = r8
                        r7.e(r12)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Drafts.Update.<init>(com.google.api.services.gmail.Gmail$Users$Drafts, java.lang.String, java.lang.String, com.google.api.services.gmail.model.Draft, com.google.api.client.http.AbstractInputStreamContent):void");
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Update set(String str, Object obj) {
                    return (Update) super.set(str, obj);
                }
            }

            public Drafts() {
            }

            public Create create(String str, Draft draft) throws IOException {
                Create create = new Create(str, draft);
                Gmail.this.a(create);
                return create;
            }

            public Delete delete(String str, String str2) throws IOException {
                Delete delete = new Delete(str, str2);
                Gmail.this.a(delete);
                return delete;
            }

            public Get get(String str, String str2) throws IOException {
                Get get = new Get(str, str2);
                Gmail.this.a(get);
                return get;
            }

            public List list(String str) throws IOException {
                List list = new List(str);
                Gmail.this.a(list);
                return list;
            }

            public Send send(String str, Draft draft) throws IOException {
                Send send = new Send(str, draft);
                Gmail.this.a(send);
                return send;
            }

            public Update update(String str, String str2, Draft draft) throws IOException {
                Update update = new Update(str, str2, draft);
                Gmail.this.a(update);
                return update;
            }

            public Create create(String str, Draft draft, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                Create create = new Create(str, draft, abstractInputStreamContent);
                Gmail.this.a(create);
                return create;
            }

            public Send send(String str, Draft draft, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                Send send = new Send(str, draft, abstractInputStreamContent);
                Gmail.this.a(send);
                return send;
            }

            public Update update(String str, String str2, Draft draft, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                Update update = new Update(str, str2, draft, abstractInputStreamContent);
                Gmail.this.a(update);
                return update;
            }
        }

        /* loaded from: classes5.dex */
        public class Messages {

            /* loaded from: classes5.dex */
            public class Attachments {

                /* loaded from: classes5.dex */
                public class Get extends GmailRequest<MessagePartBody> {
                    @Key
                    private String id;
                    @Key
                    private String messageId;
                    @Key
                    private String userId;

                    protected Get(String str, String str2, String str3) {
                        super(Gmail.this, "GET", "{userId}/messages/{messageId}/attachments/{id}", null, MessagePartBody.class);
                        this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                        this.messageId = (String) Preconditions.checkNotNull(str2, "Required parameter messageId must be specified.");
                        this.id = (String) Preconditions.checkNotNull(str3, "Required parameter id must be specified.");
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpRequest buildHttpRequestUsingHead() throws IOException {
                        return super.buildHttpRequestUsingHead();
                    }

                    @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                    public HttpResponse executeUsingHead() throws IOException {
                        return super.executeUsingHead();
                    }

                    public String getId() {
                        return this.id;
                    }

                    public String getMessageId() {
                        return this.messageId;
                    }

                    public String getUserId() {
                        return this.userId;
                    }

                    public Get setId(String str) {
                        this.id = str;
                        return this;
                    }

                    public Get setMessageId(String str) {
                        this.messageId = str;
                        return this;
                    }

                    public Get setUserId(String str) {
                        this.userId = str;
                        return this;
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setAlt */
                    public GmailRequest<MessagePartBody> setAlt2(String str) {
                        return (Get) super.setAlt(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setFields */
                    public GmailRequest<MessagePartBody> setFields2(String str) {
                        return (Get) super.setFields(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setKey */
                    public GmailRequest<MessagePartBody> setKey2(String str) {
                        return (Get) super.setKey(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setOauthToken */
                    public GmailRequest<MessagePartBody> setOauthToken2(String str) {
                        return (Get) super.setOauthToken(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setPrettyPrint */
                    public GmailRequest<MessagePartBody> setPrettyPrint2(Boolean bool) {
                        return (Get) super.setPrettyPrint(bool);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setQuotaUser */
                    public GmailRequest<MessagePartBody> setQuotaUser2(String str) {
                        return (Get) super.setQuotaUser(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest
                    /* renamed from: setUserIp */
                    public GmailRequest<MessagePartBody> setUserIp2(String str) {
                        return (Get) super.setUserIp(str);
                    }

                    @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                    public Get set(String str, Object obj) {
                        return (Get) super.set(str, obj);
                    }
                }

                public Attachments() {
                }

                public Get get(String str, String str2, String str3) throws IOException {
                    Get get = new Get(str, str2, str3);
                    Gmail.this.a(get);
                    return get;
                }
            }

            /* loaded from: classes5.dex */
            public class BatchDelete extends GmailRequest<Void> {
                @Key
                private String userId;

                protected BatchDelete(String str, BatchDeleteMessagesRequest batchDeleteMessagesRequest) {
                    super(Gmail.this, "POST", "{userId}/messages/batchDelete", batchDeleteMessagesRequest, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public BatchDelete setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (BatchDelete) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (BatchDelete) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (BatchDelete) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (BatchDelete) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (BatchDelete) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (BatchDelete) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (BatchDelete) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public BatchDelete set(String str, Object obj) {
                    return (BatchDelete) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class BatchModify extends GmailRequest<Void> {
                @Key
                private String userId;

                protected BatchModify(String str, BatchModifyMessagesRequest batchModifyMessagesRequest) {
                    super(Gmail.this, "POST", "{userId}/messages/batchModify", batchModifyMessagesRequest, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public String getUserId() {
                    return this.userId;
                }

                public BatchModify setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (BatchModify) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (BatchModify) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (BatchModify) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (BatchModify) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (BatchModify) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (BatchModify) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (BatchModify) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public BatchModify set(String str, Object obj) {
                    return (BatchModify) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Delete extends GmailRequest<Void> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Delete(String str, String str2) {
                    super(Gmail.this, "DELETE", "{userId}/messages/{id}", null, Void.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Delete setId(String str) {
                    this.id = str;
                    return this;
                }

                public Delete setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Void> setAlt2(String str) {
                    return (Delete) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Void> setFields2(String str) {
                    return (Delete) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Void> setKey2(String str) {
                    return (Delete) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Void> setOauthToken2(String str) {
                    return (Delete) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Void> setPrettyPrint2(Boolean bool) {
                    return (Delete) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Void> setQuotaUser2(String str) {
                    return (Delete) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Void> setUserIp2(String str) {
                    return (Delete) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Delete set(String str, Object obj) {
                    return (Delete) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Get extends GmailRequest<Message> {
                @Key
                private String format;
                @Key
                private String id;
                @Key
                private java.util.List<String> metadataHeaders;
                @Key
                private String userId;

                protected Get(String str, String str2) {
                    super(Gmail.this, "GET", "{userId}/messages/{id}", null, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public String getFormat() {
                    return this.format;
                }

                public String getId() {
                    return this.id;
                }

                public java.util.List<String> getMetadataHeaders() {
                    return this.metadataHeaders;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Get setFormat(String str) {
                    this.format = str;
                    return this;
                }

                public Get setId(String str) {
                    this.id = str;
                    return this;
                }

                public Get setMetadataHeaders(java.util.List<String> list) {
                    this.metadataHeaders = list;
                    return this;
                }

                public Get setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Get) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Get) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Get) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Get) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Get) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Get) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Get) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Get set(String str, Object obj) {
                    return (Get) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class GmailImport extends GmailRequest<Message> {
                @Key
                private Boolean deleted;
                @Key
                private String internalDateSource;
                @Key
                private Boolean neverMarkSpam;
                @Key
                private Boolean processForCalendar;
                @Key
                private String userId;

                protected GmailImport(String str, Message message) {
                    super(Gmail.this, "POST", "{userId}/messages/import", message, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                public Boolean getDeleted() {
                    return this.deleted;
                }

                public String getInternalDateSource() {
                    return this.internalDateSource;
                }

                public Boolean getNeverMarkSpam() {
                    return this.neverMarkSpam;
                }

                public Boolean getProcessForCalendar() {
                    return this.processForCalendar;
                }

                public String getUserId() {
                    return this.userId;
                }

                public boolean isDeleted() {
                    Boolean bool = this.deleted;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public boolean isNeverMarkSpam() {
                    Boolean bool = this.neverMarkSpam;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public boolean isProcessForCalendar() {
                    Boolean bool = this.processForCalendar;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public GmailImport setDeleted(Boolean bool) {
                    this.deleted = bool;
                    return this;
                }

                public GmailImport setInternalDateSource(String str) {
                    this.internalDateSource = str;
                    return this;
                }

                public GmailImport setNeverMarkSpam(Boolean bool) {
                    this.neverMarkSpam = bool;
                    return this;
                }

                public GmailImport setProcessForCalendar(Boolean bool) {
                    this.processForCalendar = bool;
                    return this;
                }

                public GmailImport setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (GmailImport) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (GmailImport) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (GmailImport) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (GmailImport) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (GmailImport) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (GmailImport) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (GmailImport) super.setUserIp(str);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected GmailImport(java.lang.String r9, com.google.api.services.gmail.model.Message r10, com.google.api.client.http.AbstractInputStreamContent r11) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Messages.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "POST"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/messages/import"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Message> r6 = com.google.api.services.gmail.model.Message.class
                        r1 = r7
                        r5 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        r7.e(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Messages.GmailImport.<init>(com.google.api.services.gmail.Gmail$Users$Messages, java.lang.String, com.google.api.services.gmail.model.Message, com.google.api.client.http.AbstractInputStreamContent):void");
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public GmailImport set(String str, Object obj) {
                    return (GmailImport) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Insert extends GmailRequest<Message> {
                @Key
                private Boolean deleted;
                @Key
                private String internalDateSource;
                @Key
                private String userId;

                protected Insert(String str, Message message) {
                    super(Gmail.this, "POST", "{userId}/messages", message, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    c(message, FirebaseAnalytics.Param.CONTENT);
                    c(message.getRaw(), "Message.getRaw()");
                }

                public Boolean getDeleted() {
                    return this.deleted;
                }

                public String getInternalDateSource() {
                    return this.internalDateSource;
                }

                public String getUserId() {
                    return this.userId;
                }

                public boolean isDeleted() {
                    Boolean bool = this.deleted;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public Insert setDeleted(Boolean bool) {
                    this.deleted = bool;
                    return this;
                }

                public Insert setInternalDateSource(String str) {
                    this.internalDateSource = str;
                    return this;
                }

                public Insert setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Insert) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Insert) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Insert) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Insert) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Insert) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Insert) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Insert) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Insert set(String str, Object obj) {
                    return (Insert) super.set(str, obj);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected Insert(java.lang.String r9, com.google.api.services.gmail.model.Message r10, com.google.api.client.http.AbstractInputStreamContent r11) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Messages.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "POST"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/messages"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Message> r6 = com.google.api.services.gmail.model.Message.class
                        r1 = r7
                        r5 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        r7.e(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Messages.Insert.<init>(com.google.api.services.gmail.Gmail$Users$Messages, java.lang.String, com.google.api.services.gmail.model.Message, com.google.api.client.http.AbstractInputStreamContent):void");
                }
            }

            /* loaded from: classes5.dex */
            public class List extends GmailRequest<ListMessagesResponse> {
                @Key
                private Boolean includeSpamTrash;
                @Key
                private java.util.List<String> labelIds;
                @Key
                private Long maxResults;
                @Key
                private String pageToken;
                @Key

                /* renamed from: q  reason: collision with root package name */
                private String f26206q;
                @Key
                private String userId;

                protected List(String str) {
                    super(Gmail.this, "GET", "{userId}/messages", null, ListMessagesResponse.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpRequest buildHttpRequestUsingHead() throws IOException {
                    return super.buildHttpRequestUsingHead();
                }

                @Override // com.google.api.client.googleapis.services.AbstractGoogleClientRequest
                public HttpResponse executeUsingHead() throws IOException {
                    return super.executeUsingHead();
                }

                public Boolean getIncludeSpamTrash() {
                    return this.includeSpamTrash;
                }

                public java.util.List<String> getLabelIds() {
                    return this.labelIds;
                }

                public Long getMaxResults() {
                    return this.maxResults;
                }

                public String getPageToken() {
                    return this.pageToken;
                }

                public String getQ() {
                    return this.f26206q;
                }

                public String getUserId() {
                    return this.userId;
                }

                public boolean isIncludeSpamTrash() {
                    Boolean bool = this.includeSpamTrash;
                    if (bool != null && bool != Data.NULL_BOOLEAN) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public List setIncludeSpamTrash(Boolean bool) {
                    this.includeSpamTrash = bool;
                    return this;
                }

                public List setLabelIds(java.util.List<String> list) {
                    this.labelIds = list;
                    return this;
                }

                public List setMaxResults(Long l4) {
                    this.maxResults = l4;
                    return this;
                }

                public List setPageToken(String str) {
                    this.pageToken = str;
                    return this;
                }

                public List setQ(String str) {
                    this.f26206q = str;
                    return this;
                }

                public List setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<ListMessagesResponse> setAlt2(String str) {
                    return (List) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<ListMessagesResponse> setFields2(String str) {
                    return (List) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<ListMessagesResponse> setKey2(String str) {
                    return (List) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<ListMessagesResponse> setOauthToken2(String str) {
                    return (List) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<ListMessagesResponse> setPrettyPrint2(Boolean bool) {
                    return (List) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<ListMessagesResponse> setQuotaUser2(String str) {
                    return (List) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<ListMessagesResponse> setUserIp2(String str) {
                    return (List) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public List set(String str, Object obj) {
                    return (List) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Modify extends GmailRequest<Message> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Modify(String str, String str2, ModifyMessageRequest modifyMessageRequest) {
                    super(Gmail.this, "POST", "{userId}/messages/{id}/modify", modifyMessageRequest, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Modify setId(String str) {
                    this.id = str;
                    return this;
                }

                public Modify setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Modify) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Modify) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Modify) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Modify) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Modify) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Modify) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Modify) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Modify set(String str, Object obj) {
                    return (Modify) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Send extends GmailRequest<Message> {
                @Key
                private String userId;

                protected Send(String str, Message message) {
                    super(Gmail.this, "POST", "{userId}/messages/send", message, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    c(message, FirebaseAnalytics.Param.CONTENT);
                    c(message.getRaw(), "Message.getRaw()");
                }

                public String getUserId() {
                    return this.userId;
                }

                public Send setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Send) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Send) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Send) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Send) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Send) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Send) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Send) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Send set(String str, Object obj) {
                    return (Send) super.set(str, obj);
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                protected Send(java.lang.String r9, com.google.api.services.gmail.model.Message r10, com.google.api.client.http.AbstractInputStreamContent r11) {
                    /*
                        r7 = this;
                        com.google.api.services.gmail.Gmail.Users.Messages.this = r8
                        com.google.api.services.gmail.Gmail$Users r0 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r2 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r3 = "POST"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "/upload/"
                        r0.append(r1)
                        com.google.api.services.gmail.Gmail$Users r8 = com.google.api.services.gmail.Gmail.Users.this
                        com.google.api.services.gmail.Gmail r8 = com.google.api.services.gmail.Gmail.this
                        java.lang.String r8 = r8.getServicePath()
                        r0.append(r8)
                        java.lang.String r8 = "{userId}/messages/send"
                        r0.append(r8)
                        java.lang.String r4 = r0.toString()
                        java.lang.Class<com.google.api.services.gmail.model.Message> r6 = com.google.api.services.gmail.model.Message.class
                        r1 = r7
                        r5 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        java.lang.String r8 = "Required parameter userId must be specified."
                        java.lang.Object r8 = com.google.api.client.util.Preconditions.checkNotNull(r9, r8)
                        java.lang.String r8 = (java.lang.String) r8
                        r7.userId = r8
                        r7.e(r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.services.gmail.Gmail.Users.Messages.Send.<init>(com.google.api.services.gmail.Gmail$Users$Messages, java.lang.String, com.google.api.services.gmail.model.Message, com.google.api.client.http.AbstractInputStreamContent):void");
                }
            }

            /* loaded from: classes5.dex */
            public class Trash extends GmailRequest<Message> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Trash(String str, String str2) {
                    super(Gmail.this, "POST", "{userId}/messages/{id}/trash", null, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Trash setId(String str) {
                    this.id = str;
                    return this;
                }

                public Trash setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Trash) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Trash) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Trash) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Trash) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Trash) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Trash) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Trash) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Trash set(String str, Object obj) {
                    return (Trash) super.set(str, obj);
                }
            }

            /* loaded from: classes5.dex */
            public class Untrash extends GmailRequest<Message> {
                @Key
                private String id;
                @Key
                private String userId;

                protected Untrash(String str, String str2) {
                    super(Gmail.this, "POST", "{userId}/messages/{id}/untrash", null, Message.class);
                    this.userId = (String) Preconditions.checkNotNull(str, "Required parameter userId must be specified.");
                    this.id = (String) Preconditions.checkNotNull(str2, "Required parameter id must be specified.");
                }

                public String getId() {
                    return this.id;
                }

                public String getUserId() {
                    return this.userId;
                }

                public Untrash setId(String str) {
                    this.id = str;
                    return this;
                }

                public Untrash setUserId(String str) {
                    this.userId = str;
                    return this;
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setAlt */
                public GmailRequest<Message> setAlt2(String str) {
                    return (Untrash) super.setAlt(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setFields */
                public GmailRequest<Message> setFields2(String str) {
                    return (Untrash) super.setFields(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setKey */
                public GmailRequest<Message> setKey2(String str) {
                    return (Untrash) super.setKey(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setOauthToken */
                public GmailRequest<Message> setOauthToken2(String str) {
                    return (Untrash) super.setOauthToken(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setPrettyPrint */
                public GmailRequest<Message> setPrettyPrint2(Boolean bool) {
                    return (Untrash) super.setPrettyPrint(bool);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setQuotaUser */
                public GmailRequest<Message> setQuotaUser2(String str) {
                    return (Untrash) super.setQuotaUser(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest
                /* renamed from: setUserIp */
                public GmailRequest<Message> setUserIp2(String str) {
                    return (Untrash) super.setUserIp(str);
                }

                @Override // com.google.api.services.gmail.GmailRequest, com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
                public Untrash set(String str, Object obj) {
                    return (Untrash) super.set(str, obj);
                }
            }

            public Messages() {
            }

            public Attachments attachments() {
                return new Attachments();
            }

            public BatchDelete batchDelete(String str, BatchDeleteMessagesRequest batchDeleteMessagesRequest) throws IOException {
                BatchDelete batchDelete = new BatchDelete(str, batchDeleteMessagesRequest);
                Gmail.this.a(batchDelete);
                return batchDelete;
            }

            public BatchModify batchModify(String str, BatchModifyMessagesRequest batchModifyMessagesRequest) throws IOException {
                BatchModify batchModify = new BatchModify(str, batchModifyMessagesRequest);
                Gmail.this.a(batchModify);
                return batchModify;
            }

            public Delete delete(String str, String str2) throws IOException {
                Delete delete = new Delete(str, str2);
                Gmail.this.a(delete);
                return delete;
            }

            public Get get(String str, String str2) throws IOException {
                Get get = new Get(str, str2);
                Gmail.this.a(get);
                return get;
            }

            public GmailImport gmailImport(String str, Message message) throws IOException {
                GmailImport gmailImport = new GmailImport(str, message);
                Gmail.this.a(gmailImport);
                return gmailImport;
            }

            public Insert insert(String str, Message message) throws IOException {
                Insert insert = new Insert(str, message);
                Gmail.this.a(insert);
                return insert;
            }

            public List list(String str) throws IOException {
                List list = new List(str);
                Gmail.this.a(list);
                return list;
            }

            public Modify modify(String str, String str2, ModifyMessageRequest modifyMessageRequest) throws IOException {
                Modify modify = new Modify(str, str2, modifyMessageRequest);
                Gmail.this.a(modify);
                return modify;
            }

            public Send send(String str, Message message) throws IOException {
                Send send = new Send(str, message);
                Gmail.this.a(send);
                return send;
            }

            public Trash trash(String str, String str2) throws IOException {
                Trash trash = new Trash(str, str2);
                Gmail.this.a(trash);
                return trash;
            }

            public Untrash untrash(String str, String str2) throws IOException {
                Untrash untrash = new Untrash(str, str2);
                Gmail.this.a(untrash);
                return untrash;
            }

            public GmailImport gmailImport(String str, Message message, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                GmailImport gmailImport = new GmailImport(str, message, abstractInputStreamContent);
                Gmail.this.a(gmailImport);
                return gmailImport;
            }

            public Insert insert(String str, Message message, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                Insert insert = new Insert(str, message, abstractInputStreamContent);
                Gmail.this.a(insert);
                return insert;
            }

            public Send send(String str, Message message, AbstractInputStreamContent abstractInputStreamContent) throws IOException {
                Send send = new Send(str, message, abstractInputStreamContent);
                Gmail.this.a(send);
                return send;
            }
        }
    }

    static {
        boolean z3;
        if (GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.23.0 of the Gmail API library.", GoogleUtils.VERSION);
    }

    public Gmail(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(httpTransport, jsonFactory, httpRequestInitializer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.googleapis.services.AbstractGoogleClient
    public void a(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        super.a(abstractGoogleClientRequest);
    }

    public Users users() {
        return new Users();
    }

    Gmail(Builder builder) {
        super(builder);
    }
}
