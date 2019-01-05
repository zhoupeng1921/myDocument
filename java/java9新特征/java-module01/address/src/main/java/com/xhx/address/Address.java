package com.xhx.address;

public class Address {
    private String province;
    private String contry;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
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
