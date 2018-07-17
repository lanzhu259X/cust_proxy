package com.lanzhu.ssp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterBody {

    private String phone;
    private String password;
    private String companyName;
}
