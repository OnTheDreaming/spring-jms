package com.jms.services;


import javax.jms.Destination;
import java.io.Serializable;

public interface SendDataServices {
   void  sendMessge( Destination destination,Serializable obj);
}
