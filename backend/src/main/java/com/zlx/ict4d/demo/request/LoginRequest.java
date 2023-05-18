package com.zlx.ict4d.demo.request;

//import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    private String phone;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public String getPhoneNumber(){
        return this.phone;
    }
}
