package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.repositories.AppMessageRepository;
import com.globant.academy.project.Project.repositories.AppUserRepository;
import com.globant.academy.project.Project.services.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessagesControllerTest {

    @Mock
    private AppMessageRepository appMessageRepository;

    @InjectMocks
    private MessageService messageService;

    @Autowired
    private AppUserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userRepository.save(new AppUser().builder().nickname("candresortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616596).build());
        userRepository.save(new AppUser().builder().nickname("luisortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616445).build());
        userRepository.save(new AppUser().builder().nickname("luzortizm").address("Calle 27 sur # 22 A - 05").country("Colombia").document(1013616221).build());

    }

    @Test
    void testSendMessageOneReceiver() {
        String hola = "Hola";
        //AppMessage appMessage = AppMessage.builder().body("Prueba").receiverMessages();

        /*Account account = Account.builder().id(1).balance(new BigDecimal(100_000))
                .firstName("Vivian").lastName("Bedoya").bankName("Globant")
                .bankId(5).type("AHORROS").documentNumber("101331659").build();
        Bill bill = Bill.builder().id("1").companyId(1)
                .dueDate(LocalDate.of(2014, 2, 14))
                .amount(new BigDecimal(100_001)).build();
        when(acGenerator.findAccountByBankTypeAndId(
                account.getId(),account.getBankId(),account.getType())).thenReturn(account);
        when(invoiceGenerator.findInvoiceByCompanyAndId(bill.getId(),bill.getCompanyId())).thenReturn(bill);

        InsufficientFundsException ex =
                Assertions.assertThrows(InsufficientFundsException.class,
                        () -> paymentService.pay(account.getId(),account.getBankId(),account.getType(),
                                bill.getCompanyId(),bill.getId()));

        Assertions.assertEquals(PaymentService.INSUFICIENT_FUNDS_MESSAGE,
                ex.getMessage());*/
    }

}