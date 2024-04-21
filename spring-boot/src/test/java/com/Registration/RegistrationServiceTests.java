package com.Registration;

import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTests {

    @Mock
    private RegistrationRepository registrationRepository;

    private RegistrationService underTest;

    @BeforeEach
    void setUp() {
        underTest = new RegistrationService(registrationRepository);
    }

    @Test
    void canAddNewAccount() {
        Registration acc = new Registration(
                "Adam",
                "Yes");
        underTest.addNewAccount(acc);
        ArgumentCaptor<Registration> accArgumentCaptor = ArgumentCaptor.forClass(Registration.class);
        verify(registrationRepository).save(accArgumentCaptor.capture());
        Registration captured = accArgumentCaptor.getValue();
        Assertions.assertThat(captured).isEqualTo(acc);
    }

    @Test
    void usernameDoesNotExist() {
        String u = "Adam";
        underTest.checkUsername(u);
        verify(registrationRepository).findById(u);
    }

    @Test
    void checkIfSamePassword() {
        Registration acc = new Registration(
                "Adam",
                "Yes");
        underTest.checkPassword(acc);
        verify(registrationRepository).findById("Adam");
    }

}