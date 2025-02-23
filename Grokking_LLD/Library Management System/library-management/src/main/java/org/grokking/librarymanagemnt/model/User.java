package org.grokking.librarymanagemnt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class User {
    private String id;
    private Boolean isActive;
    private String username;
    private String password;
    private String name;
    private String address;

    public abstract Boolean resetPassword();
}
