package com.jms.services;


import javax.jms.Destination;

public interface SendDataServices {
   void  sendMessge( Destination destination,String Message);
}
