package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.User;

/**
 * Created by Dante on 2/22/2018.
 */
public class UserDto implements BaseDto<User>{

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String username;
    private String password;

    @Override
    public User toData() {
        User user = new  User();
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        Credential credential = new Credential();
        credential.setPassword(this.password);
        credential.setUsername(this.username);
        user.setCredential(credential);
        return user;
    }

    @Override
    public void fromData(User data) {
        this.id  = data.getId();
        this.firstName = data.getFirstName();
        this.lastName = data.getLastName();
        this.phone = data.getPhone();
        this.email = data.getEmail();
        if(data.getCredential() != null) {
            this.username = data.getCredential().getUsername();
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }
}
