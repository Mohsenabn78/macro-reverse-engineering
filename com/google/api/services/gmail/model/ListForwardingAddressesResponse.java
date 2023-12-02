package com.google.api.services.gmail.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

/* loaded from: classes5.dex */
public final class ListForwardingAddressesResponse extends GenericJson {
    @Key
    private List<ForwardingAddress> forwardingAddresses;

    static {
        Data.nullOf(ForwardingAddress.class);
    }

    public List<ForwardingAddress> getForwardingAddresses() {
        return this.forwardingAddresses;
    }

    public ListForwardingAddressesResponse setForwardingAddresses(List<ForwardingAddress> list) {
        this.forwardingAddresses = list;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public ListForwardingAddressesResponse set(String str, Object obj) {
        return (ListForwardingAddressesResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public ListForwardingAddressesResponse clone() {
        return (ListForwardingAddressesResponse) super.clone();
    }
}
