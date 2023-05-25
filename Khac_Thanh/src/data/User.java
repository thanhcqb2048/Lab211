package data;
    class User {
    String userName;
    String passWord;
    String name;
    String phone;
    String email;
    String address;
    String dob;

    public User() {
    }

    public User(String userName, String passWord, String name, String phone, String email, String address, String dob) {
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    //HAM CHECK: XOA
    @Override
    public String toString() {
        return String.format("|%20s|%10s|%20s|%11s|%25s||%10s|%8s", 
                            userName, passWord, name, phone, email, address, dob);
    }
    
}
