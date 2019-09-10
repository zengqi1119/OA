package com.woniuxy.entity;

public class Relation {
    private Integer reid;

    private String mobilephone;

    private String telephone;

    private String email;

    private String address;

    private String contacts;
    
    private Integer uid;
    
    private Integer flag;
    
    private Userinfo userinfo;

	public Relation() {
		super();
	}

	public Relation(Integer reid, String mobilephone, String telephone, String email, String address, String contacts,
			Integer flag, Userinfo userinfo) {
		super();
		this.reid = reid;
		this.mobilephone = mobilephone;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.contacts = contacts;
		this.flag = flag;
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "Relation [reid=" + reid + ", mobilephone=" + mobilephone + ", telephone=" + telephone + ", email="
				+ email + ", address=" + address + ", contacts=" + contacts + ", flag=" + flag + ", userinfo="
				+ userinfo + "]";
	}


	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getReid() {
		return reid;
	}

	public void setReid(Integer reid) {
		this.reid = reid;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


}