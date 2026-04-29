package com.example.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {
    @InjectMocks
    private NotificationService notificationService;
    @Mock
    private TelegramSender telegramSender;
    @Mock
    private EmailSender emailSender;

    @Test
    void sendEmail() {
        when(emailSender.isAvailable()).thenReturn(true);
        doNothing().when(emailSender).sendEmail(any(),any(),any());
        doThrow(RuntimeException.class).when(emailSender).sendEmail(any(),any(),"");
        String userName = "Ivan";
        SentMessage msg = notificationService.sendEmail(userName);

        assertNotNull(msg);
        assertEquals("Notification", msg.getSubject());
        assertEquals("Hello " + userName, msg.getBody());
        assertEquals(userName + "@example.com", msg.getMail());
        assertNull(msg.getTgt());
        // assertTimes(1, emailSender.isAvalible())
        verify(emailSender, times(1)).isAvailable();
        InOrder inOrder = Mockito.inOrder(emailSender);
        inOrder.verify(emailSender).isAvailable();
        inOrder.verify(emailSender).sendEmail(any(),any(),any());
    }

    @Test
    void sesMessage() {
//        when(telegramSender.sendMessage(any())).thenThrow(new RuntimeException());

    }
}