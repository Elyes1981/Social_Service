package com.sofrecom.authentifmou3ina.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Map;

@Data
public class NotificationMessage {
    private String recipientToken ;
    private  String title ;
    private  String body ;
    private String image ;
    private Map<String, String> data ;


}
