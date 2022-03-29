package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.repositories.AppMessageRepository;
import com.globant.academy.project.Project.repositories.AppUserRepository;
import com.globant.academy.project.Project.services.MessageService;
import com.globant.academy.project.Project.services.MessageServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MessagesControllerTest {

    @Mock
    private AppMessageRepository appMessageRepository;
    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private MessageServiceImpl messageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void initUseCase() {
        List<AppUser> users = Arrays.asList(
                new AppUser().builder().nickname("candresortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616596).build(),
                new AppUser().builder().nickname("luisortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616445).build(),
                new AppUser().builder().nickname("luzortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616221).build()
        );
        appUserRepository.saveAll(users);
    }

    @AfterEach
    public void destroyAll(){
        appUserRepository.deleteAll();
    }

    @Test
    void testSendMessageOneReceiver() {
        String idSenderStr = "1";
        int idSender = Integer.parseInt(idSenderStr);
        AppUser sender = appUserRepository.findById(idSender).get();

        AppMessage appMessage = AppMessage.builder()
                .body("Prueba")
                .sender(sender)
                .subject("Este es el asunto")
                .build();

    }

}