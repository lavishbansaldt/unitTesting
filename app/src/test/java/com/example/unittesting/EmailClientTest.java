package com.example.unittesting;


import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmailClientTest {



    @Test
    public void sendEmailReturnsTheSentBody(){
        Email email = mock(Email.class);
        when(email.getBody()).thenReturn("Your email body");
        EmailClient emailClient = new EmailClient();
        String returnedBody= emailClient.sendEmail(email);


        assertEquals("Your email body", returnedBody);
    }


    @Test
    public void sendEmailReturnsSentBodyAndLogsAttachments(){
        EmailClient client = new EmailClient();
        Email email = mock(Email.class);
        client.sendEmail(email);


        verify(email,times(2)).getAttachedFiles();
        verify(email).getBody();
    }
}
