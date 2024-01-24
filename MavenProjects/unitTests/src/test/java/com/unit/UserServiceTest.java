package com.unit;

import com.unit.user.User;
import com.unit.user.UserCalculate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void getFullName() {
        User user = new User();
        user.setName("name");
        assertEquals("name name", new UserCalculate().calculateFullName(user.getName()));
    }

    @Test
    void getFullName_mock() {
        UserCalculate uc = mock(UserCalculate.class);
        User user = new User();
        user.setName("name");

        when(uc.calculateFullName(eq("name"))).thenReturn("mock name");
        when(uc.calculateFullName(eq("oleksandr"))).thenReturn("mock oleksandr");
        assertEquals("mock name", uc.calculateFullName(user.getName()));

        user.setName("oleksandr");
        assertEquals("mock oleksandr", uc.calculateFullName(user.getName()));

        when(uc.calculateFullName(any())).thenReturn("mock name").thenReturn("mock ivan");

        assertEquals("mock name", uc.calculateFullName(user.getName()));
        assertEquals("mock ivan", uc.calculateFullName(user.getName()));

        verify(uc, times(4)).calculateFullName(any());
        verify(uc, times(1)).calculateFullName("name");
        verify(uc, times(3)).calculateFullName("oleksandr");
    }
}
