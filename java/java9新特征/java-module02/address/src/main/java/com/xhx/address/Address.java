package com.xhx.address;

import com.xhx.province.Province;

public class Address {
    private Province province;
    private String contry;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", contry='" + contry + '\'' +
                '}';
    }
}
